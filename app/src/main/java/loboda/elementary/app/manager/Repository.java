package loboda.elementary.app.manager;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import loboda.elementary.app.models.User;

/**
 * Created by Lobster on 19.08.17.
 */

public class Repository implements IRepository {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private DatabaseReference mFirebaseData = FirebaseDatabase.getInstance().getReference();

    @Override
    public Task<AuthResult> registerUser(String email, String password) {
        return mAuth.createUserWithEmailAndPassword(email, password);
    }

    @Override
    public Task<AuthResult> logInUser(String email, String password) {
        return mAuth.signInWithEmailAndPassword(email, password);
    }

    @Override
    public Task<Void> saveUser(String uid, User user) {
        return mFirebaseData.child("users").child(uid).setValue(user);
    }
}
