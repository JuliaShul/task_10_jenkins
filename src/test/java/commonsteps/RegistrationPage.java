package commonsteps;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmail = $("#userEmail"),
            gender = $(".custom-control-label"),
            userNumber = $("#userNumber"),
            submit = $("#submit"),
            table = $(".table-responsive"),
            subjectsInput = $("#subjectsInput"),
            checkbox1 = $("[for=hobbies-checkbox-1]"),
            checkbox2 = $("[for=hobbies-checkbox-2]"),
            checkbox3 = $("[for=hobbies-checkbox-3]"),
            currentAddress = $("#currentAddress"),
            country = $("#react-select-3-input"),
            city = $("#react-select-4-input"),
            uploadPicture = $("#uploadPicture");

    public void setFirstName( String value ) {
        firstNameInput.val(value);
    }

    public void setLastName( String value ) {
        lastNameInput.val(value);
    }

    public void dateOfBirthInput( String dayOfBirth, String monthOfBirth, String yearOfBirth ) {
        new Calendar().setDate(dayOfBirth, monthOfBirth, yearOfBirth);
    }

    public void setUserEmail( String value ) {
        userEmail.val(value);
    }

    public void setUserNumber( String value ) {
        userNumber.val(value);
    }

    public void setSubmit( ) {
        submit.pressEnter();
    }

    public void setGender( ) {
        gender.click();
    }

    public void setSubjectsInput( String value ) {
        subjectsInput.setValue(value).pressEnter();
    }

    public void setCheckbox1( String value ) {
        checkbox1.click();
    }

    public void setCheckbox2( String value ) {
        checkbox2.click();
    }

    public void setCheckbox3( String value ) {
        checkbox3.click();
    }

    public void setAddress( String value ) {
        currentAddress.setValue(value).pressEnter();
    }

    public void setCountry( String value ) {
        country.setValue(value).pressEnter();
    }

    public void setCity( String value ) {
        city.setValue(value).pressEnter();
    }

    public void uploadFrom( String picture ) {
        uploadPicture.uploadFromClasspath("img/" + picture);
    }

    public void checkTable( String fullname,
                                String email,
                                String gender,
                                String mobile) {
        table.shouldHave(text(fullname));
        table.shouldHave(text(email));
        table.shouldHave(text(gender));
        table.shouldHave(text(mobile));

    }
    public void checkFullTable( String fullname,
                            String email,
                            String gender,
                            String mobile,
                            String birthday,
                            String subject1,
                            String hobby,
                            String picture,
                            String currentAddress,
                            String state) {
        table.shouldHave(text(fullname));
        table.shouldHave(text(email));
        table.shouldHave(text(gender));
        table.shouldHave(text(mobile));
        table.shouldHave(text(birthday));
        table.shouldHave(text(subject1));
        table.shouldHave(text(hobby));
        table.shouldHave(text(picture));
        table.shouldHave(text(currentAddress));
        table.shouldHave(text(state));

    }

}
