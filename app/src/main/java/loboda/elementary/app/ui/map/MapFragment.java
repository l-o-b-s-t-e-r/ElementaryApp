package loboda.elementary.app.ui.map;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import loboda.elementary.app.App;
import loboda.elementary.app.R;
import loboda.elementary.app.databinding.FragmentMapBinding;
import loboda.elementary.app.di.modules.MapModule;
import loboda.elementary.app.ui.base.BaseFragment;

public class MapFragment extends BaseFragment<MapPresenter, FragmentMapBinding> implements IMapPresenter.View, OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ((SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map))
                .getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

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
