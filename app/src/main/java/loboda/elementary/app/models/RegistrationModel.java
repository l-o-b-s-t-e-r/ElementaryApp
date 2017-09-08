package loboda.elementary.app.models;

import javax.inject.Inject;

/**
 * Created by Lobster on 08.09.17.
 */

public class RegistrationModel {

    private String email;

    private String name;

    @Inject
    public RegistrationModel() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
