package loboda.elementary.app.di.components;

import javax.inject.Singleton;

import dagger.Component;
import loboda.elementary.app.di.modules.AppModule;
import loboda.elementary.app.di.modules.LoginModule;
import loboda.elementary.app.di.modules.MainModule;
import loboda.elementary.app.di.modules.MapModule;
import loboda.elementary.app.di.modules.RatingModule;
import loboda.elementary.app.di.modules.RegistrationModule;
import loboda.elementary.app.di.modules.TaskModule;

/**
 * Created by Lobster on 19.08.17.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    MainComponent plus(MainModule module);

    RegistrationComponent plus(RegistrationModule module);

    LoginComponent plus(LoginModule module);

    RatingComponent plus(RatingModule module);

    TaskComponent plus(TaskModule module);

    MapComponent plus(MapModule module);

}
