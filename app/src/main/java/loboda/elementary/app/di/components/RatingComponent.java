package loboda.elementary.app.di.components;

import dagger.Subcomponent;
import loboda.elementary.app.di.modules.RatingModule;
import loboda.elementary.app.ui.rating.RatingActivity;

/**
 * Created by Lobster on 08.09.17.
 */

@Subcomponent(modules = {RatingModule.class})
public interface RatingComponent {

    void inject(RatingActivity activity);


}
