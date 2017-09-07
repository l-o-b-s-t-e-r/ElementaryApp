package loboda.elementary.app.ui.main;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import loboda.elementary.app.App;
import loboda.elementary.app.R;
import loboda.elementary.app.di.modules.MainModule;
import loboda.elementary.app.ui.base.BaseFragment;


public class MainFragment extends BaseFragment<MainPresenter> implements IMainPresenter.View {

    @Override
    public void inject() {
        App.getComponent()
                .plus(new MainModule(this))
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

}
