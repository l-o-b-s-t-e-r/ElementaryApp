package loboda.elementary.app.ui.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import io.realm.Realm;

/**
 * Created by Lobster on 07.09.17.
 */

public abstract class BaseFragment<T extends IBasePresenter.Actions, E extends ViewDataBinding> extends Fragment implements IBasePresenter.View {

    @Inject
    public T presenter;

    protected E binding;

    private Realm mRealm;

    abstract public void inject();

    abstract public int layoutId();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        inject();

        if (mRealm == null || mRealm.isClosed()) {
            presenter.setRealm(mRealm = Realm.getDefaultInstance());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, layoutId(), container, false);
        return binding.getRoot();
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
