package loboda.elementary.app.ui.registration;

import loboda.elementary.app.models.RegistrationModel;
import loboda.elementary.app.ui.base.IBasePresenter;

/**
 * Created by Lobster on 08.09.17.
 */

public interface IRegistrationPresenter extends IBasePresenter {

    interface Actions extends IBasePresenter.Actions {

        void registerUser(RegistrationModel model);

    }

    interface View extends IBasePresenter.View {

        void startMainActivity();

    }

}
