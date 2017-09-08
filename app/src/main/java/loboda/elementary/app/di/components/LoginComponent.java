package loboda.elementary.app.di.components;

import dagger.Subcomponent;
import loboda.elementary.app.di.modules.LoginModule;
import loboda.elementary.app.ui.login.LoginActivity;

/**
 * Created by Lobster on 08.09.17.
 */

@Subcomponent(modules = {LoginModule.class})
public interface LoginComponent {

    void inject(LoginActivity activity);


}
