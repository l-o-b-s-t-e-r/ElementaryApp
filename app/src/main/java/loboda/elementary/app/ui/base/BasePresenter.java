package loboda.elementary.app.ui.base;

import io.realm.Realm;
import loboda.elementary.app.manager.IDataManager;

/**
 * Created by Lobster on 07.09.17.
 */

public class BasePresenter implements IBasePresenter.Actions {

    private IBasePresenter.View mView;
    private IDataManager mData;
    private Realm mRealm;

    public BasePresenter(IBasePresenter.View view, IDataManager data) {
        mView = view;
        mData = data;
    }

    @Override
    public void setRealm(Realm realm) {
        mRealm = realm;
    }

    @Override
    public void clear() {

    }
}
