package tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import commonsteps.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;

public class TestWithFaker {

     Faker faker = new Faker();
     RegistrationPage registrationPage = new RegistrationPage();

     String site = "https://demoqa.com/automation-practice-form/",
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Male",
            mobile = faker.phoneNumber().subscriberNumber(10),
            monthOfBirth = "April",
            yearOfBirth = String.valueOf(faker.number().numberBetween(1991, 2006)),
            dayOfBirth = String.valueOf(faker.number().numberBetween(1, 30)),
            subject1 = "Maths",
            hobby1 = "Sports",
            hobby2 = "Reading",
            hobby3 = "Music",
            picture = "1.png",
            currentAddress = faker.address().fullAddress(),
            state = "NCR",
            city = "Delhi";

    @BeforeAll
    static void setStartConfig() {
        Configuration.startMaximized = true;
    }

//    @Test
//    void testRequiredFields() {
//
//
//        step("Open students registration form", () -> {
//            Selenide.open(site);
//        });
//
//        step("Fill students registration form", () -> {
//            registrationPage.setFirstName(firstName);
//            registrationPage.setLastName(lastName);
//            registrationPage.setUserEmail(email);
//            registrationPage.setGender();
//            registrationPage.setUserNumber(mobile);
//            registrationPage.setSubmit();
//        });
//
//
//        step("Verify successful form submit", () -> registrationPage.checkTable(firstName+" "+ lastName,
//                email,
//                gender,
//                mobile));
//    }

    @Test
    void testFullFields() {

        step("Open students registration form", () -> {
            Selenide.open(site);
        });

        step("Fill students registration form", () -> {
            step("Fill common data", () -> {
                registrationPage.setFirstName(firstName);
                registrationPage.setLastName(lastName);
                registrationPage.setUserEmail(email);
                registrationPage.setGender();
                registrationPage.setUserNumber(mobile);
            });
            step("Set date", () -> registrationPage.dateOfBirthInput(dayOfBirth, monthOfBirth, yearOfBirth));
            step("Set subjects", () -> registrationPage.setSubjectsInput(subject1));
            step("Set hobbies", () -> {
                registrationPage.setCheckbox1(hobby1);
                registrationPage.setCheckbox2(hobby2);
                registrationPage.setCheckbox3(hobby3);
            });
            step("Upload image", () ->
                registrationPage.uploadFrom(picture));
            step("Set address", () -> {
                registrationPage.setAddress(currentAddress);
                registrationPage.setCountry(state) ;
                registrationPage.setCity(city);
            });
            step("Submit form", () ->
                registrationPage.setSubmit());
        });

        step("Verify successful form submit", () -> registrationPage.checkFullTable(firstName+" "+ lastName,
                email,
                gender,
                mobile,
                dayOfBirth + " " + monthOfBirth + "," + yearOfBirth,
                subject1,
                hobby1 + ", " + hobby2 + ", " + hobby3,
                picture,
                currentAddress,
                state + " " + city));
    }
}
