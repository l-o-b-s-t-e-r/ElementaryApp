package loboda.elementary.app.ui.registration;

import javax.inject.Inject;

import loboda.elementary.app.App;
import loboda.elementary.app.R;
import loboda.elementary.app.manager.IRepository;
import loboda.elementary.app.misc.AppSharedPreferences;
import loboda.elementary.app.models.RegistrationModel;
import loboda.elementary.app.models.User;
import loboda.elementary.app.ui.base.BasePresenter;

/**
 * Created by Lobster on 08.09.17.
 */

public class RegistrationPresenter extends BasePresenter<IRegistrationPresenter.View> implements IRegistrationPresenter.Actions {

    @Inject
    public RegistrationPresenter(IRegistrationPresenter.View view, IRepository repository) {
        super(view, repository);
    }

    @Override
    public void registerUser(RegistrationModel model) {
        mView.showProgress();
        mRepository.registerUser(model.getEmail(), generatePassword())
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        mView.log(String.format("User %s has been registered", model.getEmail()));
                        mRepository.saveUser(task.getResult().getUser().getUid(), new User(model.getName()))
                                .addOnCompleteListener(task1 -> {
                                    if (task1.isSuccessful()) {
                                        mView.log(String.format("User %s has been saved", model.getEmail()));
                                        AppSharedPreferences.getInstance().setRegistered(true);
                                        mView.startMainActivity();
                                    } else {
                                        mView.showToast(App.getInstance().getString(R.string.error_registration));
                                        mView.log(String.format("User %s has NOT been saved", model.getEmail()), task1.getException());
                                    }

                                    mView.hideProgress();
                                });
                    } else {
                        mView.showToast(App.getInstance().getString(R.string.error_registration));
                        mView.log(String.format("User %s has NOT been registered", model.getEmail()), task.getException());
                        mView.hideProgress();
                    }
                });
    }

    private String generatePassword() {
        return "123456";
        //SimpleDateFormat sdf = new SimpleDateFormat("HHmmssSSS");
        //Date currentDate = new Date(System.currentTimeMillis());
        //return Base64.encodeToString(sdf.format(currentDate).getBytes(), Base64.DEFAULT);
    }

}
