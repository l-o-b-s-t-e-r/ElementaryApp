package loboda.elementary.app.ui.registration;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import javax.inject.Inject;

import loboda.elementary.app.App;
import loboda.elementary.app.R;
import loboda.elementary.app.databinding.ActivityRegistrationBinding;
import loboda.elementary.app.di.modules.RegistrationModule;
import loboda.elementary.app.models.RegistrationModel;
import loboda.elementary.app.ui.base.BaseActivity;
import loboda.elementary.app.ui.login.LoginActivity;
import loboda.elementary.app.ui.main.MainActivity;

public class RegistrationActivity extends BaseActivity<RegistrationPresenter, ActivityRegistrationBinding> implements IRegistrationPresenter.View {

    @Inject
    RegistrationModel registeringModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.completeBtn.setOnClickListener(view -> {
            if (verifyInputInfo()) {
                presenter.registerUser(registeringModel);
            }
        });

        binding.signIn.setOnClickListener(view -> startActivity(new Intent(RegistrationActivity.this, LoginActivity.class)));
    }

    private boolean verifyInputInfo() {
        boolean verified = true;

        String email = binding.email.getEditText().getText().toString();
        if (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            registeringModel.setEmail(email);
            binding.email.setError(null);
        } else {
            verified = false;
            binding.email.setError(getString(R.string.invalid_email));
        }

        String name = binding.username.getEditText().getText().toString();
        if (!TextUtils.isEmpty(name)) {
            registeringModel.setName(name);
            binding.username.setError(null);
        } else {
            verified = false;
            binding.username.setError(getString(R.string.username_empty));
        }

        return verified;
    }

    @Override
    public void showProgress() {
        binding.progress.setVisibility(View.VISIBLE);
        binding.completeBtn.setEnabled(false);
    }

    @Override
    public void hideProgress() {
        binding.progress.setVisibility(View.INVISIBLE);
        binding.completeBtn.setEnabled(true);
    }

    @Override
    public void inject() {
        App.getComponent()
                .plus(new RegistrationModule(this))
                .inject(this);
    }

    @Override
    public int layoutId() {
        return R.layout.activity_registration;
    }

    @Override
    public void startMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
