package loboda.elementary.app.ui.map;

import javax.inject.Inject;

import loboda.elementary.app.manager.IRepository;
import loboda.elementary.app.ui.base.BasePresenter;

/**
 * Created by Lobster on 08.09.17.
 */

public class MapPresenter extends BasePresenter<IMapPresenter.View> implements IMapPresenter.Actions {

    @Inject
    public MapPresenter(IMapPresenter.View view, IRepository repository) {
        super(view, repository);
    }

}
