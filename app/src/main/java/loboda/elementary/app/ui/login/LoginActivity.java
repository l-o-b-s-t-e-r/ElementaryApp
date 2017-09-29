package loboda.elementary.app.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import javax.inject.Inject;

import loboda.elementary.app.App;
import loboda.elementary.app.R;
import loboda.elementary.app.databinding.ActivityLoginBinding;
import loboda.elementary.app.di.modules.LoginModule;
import loboda.elementary.app.models.LoginModel;
import loboda.elementary.app.ui.base.BaseActivity;
import loboda.elementary.app.ui.main.MainActivity;

public class LoginActivity extends BaseActivity<LoginPresenter, ActivityLoginBinding> implements ILoginPresenter.View {

    @Inject
    LoginModel loginModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verifyInputInfo()) {
                    presenter.login(loginModel);
                }
            }
        });

        binding.remindPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show dialog
            }
        });
    }

    private boolean verifyInputInfo() {
        boolean verified = true;

        String email = binding.email.getText().toString();
        if (!TextUtils.isEmpty(email) || Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            loginModel.setEmail(email);
        } else {
            verified = false;
            binding.email.setError("Invalid Email");
        }

        String password = binding.password.getText().toString();
        if (!TextUtils.isEmpty(password)) {
            loginModel.setPassword(password);
        } else {
            verified = false;
            binding.password.setError("Password cannot be empty");
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
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public int layoutId() {
        return R.layout.activity_login;
    }
}
