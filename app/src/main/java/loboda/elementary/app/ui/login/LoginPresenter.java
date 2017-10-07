package loboda.elementary.app.ui.login;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import javax.inject.Inject;

import loboda.elementary.app.App;
import loboda.elementary.app.R;
import loboda.elementary.app.manager.IRepository;
import loboda.elementary.app.misc.AppSharedPreferences;
import loboda.elementary.app.models.LoginModel;
import loboda.elementary.app.ui.base.BasePresenter;

/**
 * Created by Lobster on 08.09.17.
 */

public class LoginPresenter extends BasePresenter<ILoginPresenter.View> implements ILoginPresenter.Actions {

    @Inject
    public LoginPresenter(ILoginPresenter.View view, IRepository repository) {
        super(view, repository);
    }

    @Override
    public void logIn(LoginModel model) {
        mView.showProgress();
        mRepository.logInUser(model.getEmail(), model.getPassword())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            AppSharedPreferences.getInstance().setRegistered(true);
                            mView.startMainActivity();
                        } else {
                            mView.showToast(App.getInstance().getString(R.string.error_login));
                            mView.log(String.format("User %s with password %s has NOT been logged in", model.getEmail(), model.getPassword()), task.getException());
                        }

                        mView.hideProgress();
                    }
                });
    }

    @Override
    public void recoverPassword(String email) {

    }
}
