package loboda.elementary.app.di.modules;

import dagger.Module;
import dagger.Provides;
import loboda.elementary.app.ui.login.ILoginPresenter;

/**
 * Created by Lobster on 08.09.17.
 */

@Module
public class LoginModule {

    private ILoginPresenter.View mView;

    public LoginModule(ILoginPresenter.View view) {
        mView = view;
    }

    @Provides
    public ILoginPresenter.View provideMainView() {
        return mView;
    }

}
