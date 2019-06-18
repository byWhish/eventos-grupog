package unq.tpi.desapp.request;

import com.sun.istack.NotNull;

public class ProfileRequest {

    @NotNull
    String family_name;

    @NotNull
    String given_name;

    @NotNull
    String locale;

    @NotNull
    String email;

    public ProfileRequest() {}

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
