package loboda.elementary.app.ui.splash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import loboda.elementary.app.misc.AppSharedPreferences;
import loboda.elementary.app.ui.login.LoginActivity;
import loboda.elementary.app.ui.main.MainActivity;
import loboda.elementary.app.ui.registration.RegistrationActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            MainActivity.start(this);
        } else if (AppSharedPreferences.getInstance().isRegistered()) {
            LoginActivity.start(this);
        } else {
            RegistrationActivity.start(this);
        }

        finish();
    }

}
