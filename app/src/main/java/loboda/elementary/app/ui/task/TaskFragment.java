package loboda.elementary.app.ui.task;


import loboda.elementary.app.App;
import loboda.elementary.app.R;
import loboda.elementary.app.databinding.FragmentTaskBinding;
import loboda.elementary.app.di.modules.TaskModule;
import loboda.elementary.app.ui.base.BaseFragment;


public class TaskFragment extends BaseFragment<TaskPresenter, FragmentTaskBinding> implements ITaskPresenter.View {

    @Override
    public void inject() {
        App.getComponent()
                .plus(new TaskModule(this))
                .inject(this);
    }

    @Override
    public int layoutId() {
        return R.layout.fragment_task;
    }
}
