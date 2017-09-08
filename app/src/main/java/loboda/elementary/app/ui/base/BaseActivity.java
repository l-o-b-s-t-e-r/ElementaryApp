package loboda.elementary.app.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import io.realm.Realm;

/**
 * Created by Lobster on 08.09.17.
 */

public abstract class BaseActivity<T extends IBasePresenter.Actions> extends AppCompatActivity implements IBasePresenter.View {

    @Inject
    public T presenter;

    private Realm mRealm;

    public abstract void inject();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();

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
    public void showError(Throwable throwable) {
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
