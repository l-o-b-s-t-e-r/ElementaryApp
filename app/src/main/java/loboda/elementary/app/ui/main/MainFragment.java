package loboda.elementary.app.ui.main;


import loboda.elementary.app.App;
import loboda.elementary.app.R;
import loboda.elementary.app.databinding.FragmentMainBinding;
import loboda.elementary.app.di.modules.MainModule;
import loboda.elementary.app.ui.base.BaseFragment;


public class MainFragment extends BaseFragment<MainPresenter, FragmentMainBinding> implements IMainPresenter.View {

    @Override
    public void inject() {
        App.getComponent()
                .plus(new MainModule(this))
                .inject(this);
    }

    @Override
    public int layoutId() {
        return R.layout.fragment_main;
    }
}
