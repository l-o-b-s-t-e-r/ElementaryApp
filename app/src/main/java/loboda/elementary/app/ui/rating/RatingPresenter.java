package loboda.elementary.app.ui.rating;

import javax.inject.Inject;

import loboda.elementary.app.manager.IDataManager;
import loboda.elementary.app.ui.base.BasePresenter;

/**
 * Created by Lobster on 08.09.17.
 */

public class RatingPresenter extends BasePresenter implements IRatingPresenter.Actions {

    @Inject
    public RatingPresenter(IRatingPresenter.View view, IDataManager data) {
        super(view, data);
    }

    @Override
    public void loadRating() {

    }

}
