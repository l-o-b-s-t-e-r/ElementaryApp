package loboda.elementary.app.misc;

import android.content.Context;
import android.content.SharedPreferences;

import loboda.elementary.app.App;

/**
 * Created by Lobster on 07.09.17.
 */

public class AppSharedPreferences {

    private final String ELEMENTARY_PREFERENCES = "elementary_preferences";
    private static AppSharedPreferences mAppSharedPreferences;

    private final String LOGGED_IN = "logged_in";

    private SharedPreferences mPreferences;

    private AppSharedPreferences() {
        mPreferences = App.getInstance().getSharedPreferences(ELEMENTARY_PREFERENCES, Context.MODE_PRIVATE);
    }

    public static AppSharedPreferences getInstance() {
        if (mAppSharedPreferences == null) {
            mAppSharedPreferences = new AppSharedPreferences();
        }

        return mAppSharedPreferences;
    }

    public boolean isLoggedIn() {
        return mPreferences.getBoolean(LOGGED_IN, false);
    }

    public void setLoggedIn(boolean status) {
        mPreferences.edit()
                .putBoolean(LOGGED_IN, status)
                .apply();
    }
}
