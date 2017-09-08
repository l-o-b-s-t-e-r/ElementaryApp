package loboda.elementary.app.ui.login;

import loboda.elementary.app.models.LoginModel;
import loboda.elementary.app.ui.base.IBasePresenter;

/**
 * Created by Lobster on 08.09.17.
 */

public interface ILoginPresenter extends IBasePresenter {

    interface Actions extends IBasePresenter.Actions {

        void login(LoginModel model);

        void remindPassword(String email);

    }

    interface View extends IBasePresenter.View {

        void startMainActivity();

    }

}
