package loboda.elementary.app.manager;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import loboda.elementary.app.models.User;

/**
 * Created by Lobster on 07.09.17.
 */

public interface IDataManager {

    Task<AuthResult> registerUser(String email, String password);

    Task<Void> saveUser(String uid, User user);

}
