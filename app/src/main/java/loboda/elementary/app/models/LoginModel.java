package loboda.elementary.app.models;

import javax.inject.Inject;

/**
 * Created by Lobster on 08.09.17.
 */

public class LoginModel {

    private String email;

    private String password;

    @Inject
    public LoginModel() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
