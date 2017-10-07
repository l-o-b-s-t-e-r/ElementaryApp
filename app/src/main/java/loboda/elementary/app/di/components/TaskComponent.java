package loboda.elementary.app.di.components;

import dagger.Subcomponent;
import loboda.elementary.app.di.modules.TaskModule;
import loboda.elementary.app.ui.task.TaskFragment;

/**
 * Created by Lobster on 07.09.17.
 */

@Subcomponent(modules = {TaskModule.class})
public interface TaskComponent {

    void inject(TaskFragment fragment);

}
