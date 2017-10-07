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

    private final String REGISTERED = "registered";

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

    public boolean isRegistered() {
        return mPreferences.getBoolean(REGISTERED, false);
    }

    public void setRegistered(boolean status) {
        mPreferences.edit()
                .putBoolean(REGISTERED, status)
                .apply();
    }
}
