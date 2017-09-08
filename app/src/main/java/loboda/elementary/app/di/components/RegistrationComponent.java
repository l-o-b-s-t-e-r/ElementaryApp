package loboda.elementary.app.di.components;

import dagger.Subcomponent;
import loboda.elementary.app.di.modules.RegistrationModule;
import loboda.elementary.app.ui.registration.RegistrationActivity;

/**
 * Created by Lobster on 08.09.17.
 */

@Subcomponent(modules = {RegistrationModule.class})
public interface RegistrationComponent {

    void inject(RegistrationActivity activity);


}
