package loboda.elementary.app.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import javax.inject.Inject;

import loboda.elementary.app.App;
import loboda.elementary.app.R;
import loboda.elementary.app.databinding.ActivityLoginBinding;
import loboda.elementary.app.di.modules.LoginModule;
import loboda.elementary.app.models.LoginModel;
import loboda.elementary.app.ui.base.BaseActivity;
import loboda.elementary.app.ui.main.MainActivity;
import loboda.elementary.app.ui.registration.RegistrationActivity;

public class LoginActivity extends BaseActivity<LoginPresenter, ActivityLoginBinding> implements ILoginPresenter.View {

    public static void start(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }

    @Inject
    LoginModel loginModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verifyInputInfo()) {
                    presenter.logIn(loginModel);
                }
            }
        });

        binding.signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrationActivity.start(LoginActivity.this);
            }
        });

        binding.recovery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show dialog
            }
        });
    }

    private boolean verifyInputInfo() {
        boolean verified = true;

        String email = binding.email.getEditText().getText().toString();
        if (!TextUtils.isEmpty(email)) {
            loginModel.setEmail(email);
            binding.email.setError(null);
        } else {
            verified = false;
            binding.email.setError(getString(R.string.email_empty));
        }

        String password = binding.password.getEditText().getText().toString();
        if (!TextUtils.isEmpty(password)) {
            loginModel.setPassword(password);
            binding.password.setError(null);
        } else {
            verified = false;
            binding.password.setError(getString(R.string.password_empty));
        }

        return verified;
    }

    @Override
    public void inject() {
        App.getComponent()
                .plus(new LoginModule(this))
                .inject(this);
    }

    @Override
    public void startMainActivity() {
        MainActivity.start(this);
    }

    @Override
    public int layoutId() {
        return R.layout.activity_login;
    }
}
