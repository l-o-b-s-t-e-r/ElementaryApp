package loboda.elementary.app.ui.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

import io.realm.Realm;

/**
 * Created by Lobster on 08.09.17.
 */

public abstract class BaseActivity<T extends IBasePresenter.Actions, E extends ViewDataBinding> extends AppCompatActivity implements IBasePresenter.View {

    @Inject
    public T presenter;

    protected E binding;

    private Realm mRealm;

    public abstract void inject();

    public abstract int layoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();

        binding = DataBindingUtil.setContentView(this, layoutId());

        if (mRealm == null || mRealm.isClosed()) {
            presenter.setRealm(mRealm = Realm.getDefaultInstance());
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void log(String message) {
        Log.i("INFO", message);
    }

    @Override
    public void log(String message, Throwable throwable) {
        Log.e("ERROR", message);
        throwable.printStackTrace();
    }

    @Override
    public void onDestroy() {
        if (mRealm != null && !mRealm.isClosed()) {
            mRealm.close();
        }

        super.onDestroy();
    }
}
