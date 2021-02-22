package be.heh.app.utils;

public enum EnumEmail {
    ACCOUNT_CONFIRMATION("Action Required: Email Confirmation"),
    DELETE_CONFIRMATION("Action Required: Account Deletion Confirmation"),
    RESET_PASSWORD("Action Required: Change Password"),
    AUTH_CODE("Success: There Your 2-factor Login Code"),
    ;

    public final String subject;

    EnumEmail(String subject) {
        this.subject = subject;
    }

}
