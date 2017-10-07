package loboda.elementary.app.di.modules;

import dagger.Module;
import dagger.Provides;
import loboda.elementary.app.ui.map.IMapPresenter;

/**
 * Created by Lobster on 07.09.17.
 */

@Module
public class MapModule {

    private IMapPresenter.View mView;

    public MapModule(IMapPresenter.View view) {
        mView = view;
    }

    @Provides
    public IMapPresenter.View provideMainView() {
        return mView;
    }

}
