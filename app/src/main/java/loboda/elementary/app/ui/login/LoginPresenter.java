package loboda.elementary.app.ui.login;

import javax.inject.Inject;

import loboda.elementary.app.manager.IDataManager;
import loboda.elementary.app.models.LoginModel;
import loboda.elementary.app.ui.base.BasePresenter;

/**
 * Created by Lobster on 08.09.17.
 */

public class LoginPresenter extends BasePresenter implements ILoginPresenter.Actions {

    @Inject
    public LoginPresenter(ILoginPresenter.View view, IDataManager data) {
        super(view, data);
    }

    @Override
    public void login(LoginModel model) {

    }

    @Override
    public void remindPassword(String email) {

    }
}
