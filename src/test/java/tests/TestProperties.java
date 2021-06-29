package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TestProperties {

    @Test
    void readWithGradleProperty() {
        String value = System.getProperty("browser", "chrome");
        System.out.println(value);
    }

    @Test
    @Tag("terminal")
    void readWithTagTerminalProperty() {
        String value = System.getProperty("browser", "chrome");
        System.out.println(value);
    }
}
