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
import loboda.elementary.app.ui.main.MainActivity;

public class RegistrationActivity extends BaseActivity<RegistrationPresenter, ActivityRegistrationBinding> implements IRegistrationPresenter.View {

    @Inject
    RegistrationModel registeringModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.completeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verifyInputInfo()) {
                    presenter.registerUser(registeringModel);
                }
            }
        });
    }

    private boolean verifyInputInfo() {
        boolean verified = true;

        String email = binding.email.getText().toString();
        if (!TextUtils.isEmpty(email) || Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            registeringModel.setEmail(email);
        } else {
            verified = false;
            binding.email.setError("Invalid Email");
        }

        String name = binding.name.getText().toString();
        if (!TextUtils.isEmpty(email)) {
            registeringModel.setName(name);
        } else {
            verified = false;
            binding.name.setError("Username cannot be empty");
        }

        return verified;
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
