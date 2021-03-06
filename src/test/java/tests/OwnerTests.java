package tests;

import configuration.Credentials;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class OwnerTests {
    @Test
    @Tag("owner")
    void readFromPropertiesTest() {
        String login = Credentials.credentials.login();
        String password = Credentials.credentials.password();

        System.out.println(login);
        System.out.println(password);

        String message = String.format("I try to login as %s with password %s", login, password);

        System.out.println(message);

        // gradle clean owner_test
        //    qaguru
        //    secret$password
        //    I try to login as qaguru with password secret$password

        // gradle clean owner_test -Dlogin=github
        //    github
        //    secret$password
        //    I try to login as github with password secret$password
    }
}
