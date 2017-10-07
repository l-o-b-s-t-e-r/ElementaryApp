package loboda.elementary.app.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import loboda.elementary.app.App;
import loboda.elementary.app.R;
import loboda.elementary.app.databinding.ActivityMainBinding;
import loboda.elementary.app.di.modules.MainModule;
import loboda.elementary.app.ui.base.BaseActivity;
import loboda.elementary.app.ui.map.MapFragment;
import loboda.elementary.app.ui.task.TaskFragment;

public class MainActivity extends BaseActivity<MainPresenter, ActivityMainBinding> implements IMainPresenter.View {

    public static void start(Context context) {
        context.startActivity(
                new Intent(context, MainActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.setFragments(new TaskFragment(), new MapFragment());
        adapter.setTitles(getResources().getStringArray(R.array.tabs_title));

        binding.viewpager.setAdapter(adapter);
        binding.tablayout.setupWithViewPager(binding.viewpager);
    }

    @Override
    public void inject() {
        App.getComponent()
                .plus(new MainModule(this))
                .inject(this);
    }

    @Override
    public int layoutId() {
        return R.layout.activity_main;
    }

}
