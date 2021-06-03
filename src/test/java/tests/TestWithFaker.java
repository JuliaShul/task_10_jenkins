package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import commonsteps.OpenPage;
import commonsteps.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestWithFaker {

     Faker faker = new Faker();

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

    RegistrationPage registrationPage = new RegistrationPage();
    OpenPage openPage = new OpenPage();

    @BeforeAll
    static void setStartConfig() {
        Configuration.startMaximized = true;
    }

    @Test
    void testRequiredFields() {

        openPage.open(site);

        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeUserEmail(email);
        registrationPage.setGender();
        registrationPage.typeUserNumber(mobile);
        registrationPage.setSubmit();

        //form contains text
        registrationPage.checkTable(firstName+" "+ lastName,
                email,
                gender,
                mobile);

    }

    @Test
    void testFullFields() {

        openPage.open(site);

        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeUserEmail(email);
        registrationPage.setGender();
        registrationPage.typeUserNumber(mobile);

        registrationPage.dateOfBirthInput(dayOfBirth, monthOfBirth, yearOfBirth);
        registrationPage.setSubjectsInput(subject1);
        registrationPage.setCheckbox1(hobby1);
        registrationPage.setCheckbox2(hobby2);
        registrationPage.setCheckbox3(hobby3);
        registrationPage.uploadFrom(picture);
        registrationPage.typeAddress(currentAddress);
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
