package loboda.elementary.app.di.modules;

import dagger.Module;
import dagger.Provides;
import loboda.elementary.app.ui.registration.IRegistrationPresenter;

/**
 * Created by Lobster on 08.09.17.
 */

@Module
public class RegistrationModule {

    private IRegistrationPresenter.View mView;

    public RegistrationModule(IRegistrationPresenter.View view) {
        mView = view;
    }

    @Provides
    public IRegistrationPresenter.View provideMainView() {
        return mView;
    }

}
