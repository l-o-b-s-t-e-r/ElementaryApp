package loboda.elementary.app.di.components;

import javax.inject.Singleton;

import dagger.Component;
import loboda.elementary.app.di.modules.AppModule;
import loboda.elementary.app.di.modules.MainModule;

/**
 * Created by Lobster on 19.08.17.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    MainComponent plus(MainModule module);

}
