package loboda.elementary.app.models;

/**
 * Created by Lobster on 07.09.17.
 */


public class User {

    private String name;

    private Long score = 0L;

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }
}
