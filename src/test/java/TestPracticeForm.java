import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestPracticeForm {
    @BeforeAll
    static void setStartConfig() {
        Configuration.startMaximized = true;
    }

    @Test
    void testRequiredFields() {
        open("https://demoqa.com/automation-practice-form/");

        $("#firstName").setValue("Julia");
        $("#lastName").setValue("Shu");
        $("#userEmail").setValue("jull@mail.ru");
        $(".custom-control-label").click();
        $("#userNumber").setValue("8903930999");
        $("#submit").pressEnter();

        //form contains text
        $(".table-responsive").shouldHave(text("Julia Shu")
                , text("jull@mail.ru")
                , text("Male")
                , text("8903930999"));


    }

    @Test
    void testFullFields() {
        open("https://demoqa.com/automation-practice-form/");


        $("#firstName").setValue("Юлия");
        $("#lastName").setValue("Сергеевна");
        $("#userEmail").setValue("12@mail.ru");
        $("[for=gender-radio-2]").click();
        $("#userNumber").setValue("5555555555");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1991");
        $("[aria-label='Choose Sunday, April 14th, 1991']").click();

        $("#subjectsInput").setValue("m").pressEnter();
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-2]").click();
        $("[for=hobbies-checkbox-3]").click();
        $("#currentAddress").setValue("Siberia");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").pressEnter();

        //form contains text
        $(".table-responsive").shouldHave(text("Юлия Сергеевна")
                , text("12@mail.ru")
                , text("Female")
                , text("5555555555")
                , text("14 April,1991")
                , text("Maths")
                , text("Sports, Reading, Music")
                , text("Siberia")
                , text("NCR Delhi")
                );

    }

}

//доп методы
//$(byName("q")).setValue("Selenide").pressEnter();
//$("").parent().click()
//Configuration.timeout = 600000;
//Selenide.sleep(5000);
