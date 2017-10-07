package loboda.elementary.app.ui.task;

import javax.inject.Inject;

import loboda.elementary.app.manager.IRepository;
import loboda.elementary.app.ui.base.BasePresenter;
import loboda.elementary.app.ui.map.IMapPresenter;

/**
 * Created by Lobster on 08.09.17.
 */

public class TaskPresenter extends BasePresenter<ITaskPresenter.View> implements IMapPresenter.Actions {

    @Inject
    public TaskPresenter(ITaskPresenter.View view, IRepository repository) {
        super(view, repository);
    }

}
