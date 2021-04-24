package data;

import net.bytebuddy.utility.RandomString;

public class AccountFactory {

    private static final String LOGIN_EMAIL = "testuser@test.mail";
    private static final String LOGIN_PASSWORD = "qwerty";
    private static final String PHONE_NUMBER = "1234567890";
    private static final String PASSWORD = "qwerty";
    private static RandomString random = new RandomString();
    private static final String FIRST_NAME = random.make(7);
    private static final String LAST_NAME = random.make(7);
    private static final String EMAIL = random.make(7) + "@mail.mail";

    public static Account getAccountForRegistration() {
        Account account = new Account(FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, PASSWORD);
        return account;
    }

    public static Account getAccountForLogin() {
        Account account = new Account(LOGIN_EMAIL, LOGIN_PASSWORD);
        return account;
    }


}

