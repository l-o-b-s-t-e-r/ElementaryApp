package loboda.elementary.app.di.modules;

import dagger.Module;
import dagger.Provides;
import loboda.elementary.app.ui.main.IMainPresenter;

/**
 * Created by Lobster on 07.09.17.
 */

@Module
public class MainModule {

    private IMainPresenter.View mView;

    public MainModule(IMainPresenter.View view) {
        mView = view;
    }

    @Provides
    public IMainPresenter.View provideMainView() {
        return mView;
    }

}
