package loboda.elementary.app.ui.registration;

import javax.inject.Inject;

import loboda.elementary.app.manager.IDataManager;
import loboda.elementary.app.models.RegistrationModel;
import loboda.elementary.app.ui.base.BasePresenter;

/**
 * Created by Lobster on 08.09.17.
 */

public class RegistrationPresenter extends BasePresenter implements IRegistrationPresenter.Actions {

    @Inject
    public RegistrationPresenter(IRegistrationPresenter.View view, IDataManager data) {
        super(view, data);
    }

    @Override
    public void registerUser(RegistrationModel model) {

    }

}
