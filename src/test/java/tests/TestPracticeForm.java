package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import commonsteps.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestPracticeForm extends TestBase {

    String site = "https://demoqa.com/automation-practice-form/",
            firstName = "Julia",
            lastName = "Shu",
            email = "jull@mail.ru",
            gender = "Male",
            mobile = "8903930999",
            monthOfBirth = "April",
            yearOfBirth = "2004",
            dayOfBirth = "14",
            subject1 = "Maths",
            hobby1 = "Sports",
            hobby2 = "Reading",
            hobby3 = "Music",
            picture = "1.png",
            currentAddress = "Siberia",
            state = "NCR",
            city = "Delhi";

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setStartConfig() {
        Configuration.startMaximized = true;
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