package example.mn;

import java.net.http.HttpClient;

public class TeamAdmin {
    private String manager;
    private String coach;
    private String president;

    // setting constructor to private to follow builder pattern
    private TeamAdmin(){}

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    //
    public static Builder builder() {
        return new Builder();
    }

    // public builder class which will allow tp access team admin objects
    public static class Builder {
        private String manager;
        private String coach;
        private String president;

        public Builder withManager(String manager) {
            this.manager = manager;
            return this;
        }

        public Builder withCoach(String coach) {
            this.coach = coach;
            return this;
        }

        public Builder withPresident(String president) {
            this.president = president;
            return this;
        }

        // creates a new instance of TeamAdmin and returns them when called
        public TeamAdmin build() {
            TeamAdmin teamAdmin = new TeamAdmin();
            teamAdmin.manager = this.manager;
            teamAdmin.coach = this.coach;
            teamAdmin.president = this.president;
            return teamAdmin;
        }

        public String getCoach() {
            return coach;
        }

        public String getManager() {
            return manager;
        }

        public String getPresident() {
            return president;
        }
    }
}
