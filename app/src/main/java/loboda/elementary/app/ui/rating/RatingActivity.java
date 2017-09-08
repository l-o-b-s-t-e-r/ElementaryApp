package loboda.elementary.app.ui.rating;

import java.util.List;
import java.util.Objects;

import loboda.elementary.app.App;
import loboda.elementary.app.R;
import loboda.elementary.app.databinding.ActivityRatingBinding;
import loboda.elementary.app.di.modules.RatingModule;
import loboda.elementary.app.ui.base.BaseActivity;

public class RatingActivity extends BaseActivity<RatingPresenter, ActivityRatingBinding> implements IRatingPresenter.View {

    @Override
    public void inject() {
        App.getComponent()
                .plus(new RatingModule(this))
                .inject(this);
    }

    @Override
    public int layoutId() {
        return R.layout.activity_rating;
    }

    @Override
    public void showRating(List<Objects> list) {

    }
}
