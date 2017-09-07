package loboda.elementary.app.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import loboda.elementary.app.manager.DataManager;
import loboda.elementary.app.manager.IDataManager;

/**
 * Created by Lobster on 19.08.17.
 */

@Module
public class AppModule {

    @Provides
    @Singleton
    public IDataManager provideDataManager() {
        return new DataManager();
    }

}
