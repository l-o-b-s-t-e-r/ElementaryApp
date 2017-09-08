package loboda.elementary.app.ui.registration;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import loboda.elementary.app.App;
import loboda.elementary.app.R;
import loboda.elementary.app.databinding.ActivityRegistrationBinding;
import loboda.elementary.app.di.modules.RegistrationModule;
import loboda.elementary.app.models.User;
import loboda.elementary.app.ui.base.BaseActivity;
import loboda.elementary.app.ui.main.MainActivity;

public class RegistrationActivity extends BaseActivity<RegistrationPresenter> implements IRegistrationPresenter.View {

    private ActivityRegistrationBinding mBinding;
    private User mUser = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_registration);
        mBinding.completeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verifyInputInfo()) {
                    presenter.registerUser(mUser);
                }
            }
        });
    }

    private boolean verifyInputInfo() {
        boolean verified = true;

        String email = mBinding.email.getText().toString();
        if (!TextUtils.isEmpty(email) || Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mUser.setEmail(email);
        } else {
            verified = false;
            mBinding.email.setError("Invalid Email");
        }

        String name = mBinding.name.getText().toString();
        if (!TextUtils.isEmpty(email)) {
            mUser.setName(name);
        } else {
            verified = false;
            mBinding.email.setError("Username cannot be empty");
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
    public void startMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
