package loboda.elementary.app.ui.rating;

import javax.inject.Inject;

import loboda.elementary.app.manager.IRepository;
import loboda.elementary.app.ui.base.BasePresenter;

/**
 * Created by Lobster on 08.09.17.
 */

public class RatingPresenter extends BasePresenter implements IRatingPresenter.Actions {

    @Inject
    public RatingPresenter(IRatingPresenter.View view, IRepository data) {
        super(view, data);
    }

    @Override
    public void loadRating() {

    }

}
