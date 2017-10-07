package loboda.elementary.app.di.modules;

import dagger.Module;
import dagger.Provides;
import loboda.elementary.app.ui.task.ITaskPresenter;

/**
 * Created by Lobster on 07.09.17.
 */

@Module
public class TaskModule {

    private ITaskPresenter.View mView;

    public TaskModule(ITaskPresenter.View view) {
        mView = view;
    }

    @Provides
    public ITaskPresenter.View provideMainView() {
        return mView;
    }

}
