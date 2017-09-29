package loboda.elementary.app.ui.base;

import io.realm.Realm;
import loboda.elementary.app.manager.IDataManager;

/**
 * Created by Lobster on 07.09.17.
 */

public class BasePresenter<T extends IBasePresenter.View> implements IBasePresenter.Actions {

    protected T mView;
    protected IDataManager mData;
    private Realm mRealm;

    public BasePresenter(T view, IDataManager data) {
        mView = view;
        mData = data;
    }

    @Override
    public void setRealm(Realm realm) {
        mRealm = realm;
    }

    public Realm getRealm() {
        return mRealm;
    }

    @Override
    public void clear() {

    }
}
