package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import commonsteps.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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

    @Test
    void testRequiredFields() {

        Selenide.open(site);

        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setUserEmail(email);
        registrationPage.setGender();
        registrationPage.setUserNumber(mobile);
        registrationPage.setSubmit();

        //form contains text
        registrationPage.checkTable(firstName+" "+ lastName,
                email,
                gender,
                mobile);
    }

    @Test
    void testFullFields() {

        Selenide.open(site);

        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setUserEmail(email);
        registrationPage.setGender();
        registrationPage.setUserNumber(mobile);
        registrationPage.dateOfBirthInput(dayOfBirth, monthOfBirth, yearOfBirth);
        registrationPage.setSubjectsInput(subject1);
        registrationPage.setCheckbox1(hobby1);
        registrationPage.setCheckbox2(hobby2);
        registrationPage.setCheckbox3(hobby3);
        registrationPage.uploadFrom(picture);
        registrationPage.setAddress(currentAddress);
        registrationPage.setCountry(state) ;
        registrationPage.setCity(city);
        registrationPage.setSubmit();

        //form contains text
        registrationPage.checkFullTable(firstName+" "+ lastName,
                email,
                gender,
                mobile,
                dayOfBirth + " " + monthOfBirth + "," + yearOfBirth,
                subject1,
                hobby1 + ", " + hobby2 + ", " + hobby3,
                picture,
                currentAddress,
                state + " " + city);

    }
}
