package loboda.elementary.app.ui.base;

import io.realm.Realm;

/**
 * Created by Lobster on 07.09.17.
 */

public interface IBasePresenter {

    interface Actions {

        void setRealm(Realm realm);

        void clear();

    }

    interface View {

        void showProgress();

        void hideProgress();

        void log(String message);

        void log(String message, Throwable throwable);

    }

}
