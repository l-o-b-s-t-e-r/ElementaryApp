package loboda.elementary.app.ui.main;

import javax.inject.Inject;

import loboda.elementary.app.manager.IRepository;
import loboda.elementary.app.ui.base.BasePresenter;

/**
 * Created by Lobster on 07.09.17.
 */

public class MainPresenter extends BasePresenter implements IMainPresenter.Actions {

    @Inject
    public MainPresenter(IMainPresenter.View view, IRepository data) {
        super(view, data);
    }

}
