package loboda.elementary.app.di.components;

import dagger.Subcomponent;
import loboda.elementary.app.di.modules.MapModule;
import loboda.elementary.app.ui.map.MapFragment;

/**
 * Created by Lobster on 07.09.17.
 */

@Subcomponent(modules = {MapModule.class})
public interface MapComponent {

    void inject(MapFragment fragment);

}
