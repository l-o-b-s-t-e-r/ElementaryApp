package loboda.elementary.app.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import loboda.elementary.app.manager.IRepository;
import loboda.elementary.app.manager.Repository;

/**
 * Created by Lobster on 19.08.17.
 */

@Module
public class AppModule {

    @Provides
    @Singleton
    public IRepository provideDataManager() {
        return new Repository();
    }

}
