package loboda.elementary.app.di.components;

import dagger.Subcomponent;
import loboda.elementary.app.di.modules.MainModule;
import loboda.elementary.app.ui.main.MainFragment;

/**
 * Created by Lobster on 07.09.17.
 */

@Subcomponent(modules = {MainModule.class})
public interface MainComponent {

    void inject(MainFragment fragment);

}
