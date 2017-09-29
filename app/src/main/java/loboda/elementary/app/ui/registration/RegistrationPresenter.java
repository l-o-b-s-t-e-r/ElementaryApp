package loboda.elementary.app.ui.registration;

import android.util.Base64;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import loboda.elementary.app.manager.IDataManager;
import loboda.elementary.app.models.RegistrationModel;
import loboda.elementary.app.models.User;
import loboda.elementary.app.ui.base.BasePresenter;

/**
 * Created by Lobster on 08.09.17.
 */

public class RegistrationPresenter extends BasePresenter<IRegistrationPresenter.View> implements IRegistrationPresenter.Actions {

    @Inject
    public RegistrationPresenter(IRegistrationPresenter.View view, IDataManager data) {
        super(view, data);
    }

    @Override
    public void registerUser(RegistrationModel model) {
        mView.showProgress();
        mData.registerUser(model.getEmail(), generatePassword())
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        mView.log(String.format("User %s has been registered", model.getEmail()));
                        mData.saveUser(task.getResult().getUser().getUid(), new User(model.getName()))
                                .addOnCompleteListener(task1 -> {
                                    if (task1.isSuccessful()) {
                                        mView.log(String.format("User %s has been saved", model.getEmail()));
                                        mView.startMainActivity();
                                    } else {
                                        mView.log(String.format("User %s has NOT been saved", model.getEmail()), task1.getException());
                                    }

                                    mView.hideProgress();
                                });
                    } else {
                        mView.log(String.format("User %s has NOT been registered", model.getEmail()), task.getException());
                        mView.hideProgress();
                    }
                });
    }

    private String generatePassword() {
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmssSSS");
        Date currentDate = new Date(System.currentTimeMillis());
        return Base64.encodeToString(sdf.format(currentDate).getBytes(), Base64.DEFAULT);
    }

}
