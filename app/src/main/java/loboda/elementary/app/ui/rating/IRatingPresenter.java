package loboda.elementary.app.ui.rating;

import java.util.List;
import java.util.Objects;

import loboda.elementary.app.ui.base.IBasePresenter;

/**
 * Created by Lobster on 08.09.17.
 */

public interface IRatingPresenter extends IBasePresenter {

    interface Actions extends IBasePresenter.Actions {

        void loadRating();

    }

    interface View extends IBasePresenter.View {

        void showRating(List<Objects> list);

    }

}
