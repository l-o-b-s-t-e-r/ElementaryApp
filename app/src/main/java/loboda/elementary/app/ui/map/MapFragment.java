package loboda.elementary.app.ui.map;


import loboda.elementary.app.App;
import loboda.elementary.app.R;
import loboda.elementary.app.databinding.FragmentMapBinding;
import loboda.elementary.app.di.modules.MapModule;
import loboda.elementary.app.ui.base.BaseFragment;

public class MapFragment extends BaseFragment<MapPresenter, FragmentMapBinding> implements IMapPresenter.View {

    @Override
    public void inject() {
        App.getComponent()
                .plus(new MapModule(this))
                .inject(this);
    }

    @Override
    public int layoutId() {
        return R.layout.fragment_map;
    }
}
