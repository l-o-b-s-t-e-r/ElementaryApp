package loboda.elementary.app;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import loboda.elementary.app.di.components.AppComponent;
import loboda.elementary.app.di.components.DaggerAppComponent;

/**
 * Created by Lobster on 19.08.17.
 */

public class App extends Application {

    private static App instance;

    private static AppComponent component;

    public static AppComponent getComponent() {
        return component;
    }

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        Realm.init(this);
        Realm.setDefaultConfiguration(
                new RealmConfiguration.Builder()
                        .deleteRealmIfMigrationNeeded()
                        .build());

        component = DaggerAppComponent.builder()
                .build();
    }
}
