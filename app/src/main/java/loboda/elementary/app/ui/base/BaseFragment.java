package loboda.elementary.app.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import io.realm.Realm;

/**
 * Created by Lobster on 07.09.17.
 */

public abstract class BaseFragment<T extends IBasePresenter.Actions> extends Fragment implements IBasePresenter.View {

    @Inject
    public T presenter;

    private Realm mRealm;

    abstract public void inject();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
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
