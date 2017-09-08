package loboda.elementary.app.di.modules;

import dagger.Module;
import dagger.Provides;
import loboda.elementary.app.ui.rating.IRatingPresenter;

/**
 * Created by Lobster on 08.09.17.
 */

@Module
public class RatingModule {

    private IRatingPresenter.View mView;

    public RatingModule(IRatingPresenter.View view) {
        mView = view;
    }

    @Provides
    public IRatingPresenter.View provideMainView() {
        return mView;
    }

}
