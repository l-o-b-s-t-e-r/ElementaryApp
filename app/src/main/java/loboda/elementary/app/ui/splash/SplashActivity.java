package loboda.elementary.app.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import loboda.elementary.app.misc.AppSharedPreferences;
import loboda.elementary.app.ui.main.MainActivity;
import loboda.elementary.app.ui.registration.RegistrationActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (AppSharedPreferences.getInstance().isLoggedIn()) {
            startActivity(new Intent(this, MainActivity.class));
        } else {
            startActivity(new Intent(this, RegistrationActivity.class));
        }
    }

}
