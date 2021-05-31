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

        $("[id=firstName]").setValue("Julia");
        $("[id=lastName]").setValue("Shu");
        $("[id=userEmail]").setValue("jull@mail.ru");
        $(".custom-control-label").click();
        $("[id=userNumber]").setValue("8903930999");
        $("[id=submit]").pressEnter();

        //form contains text
        $(".table-responsive").shouldHave(text("Julia Shu")
                , text("jull@mail.ru")
                , text("Male")
                , text("8903930999"));
        $("[id=closeLargeModal]").pressEscape();

    }

    @Test
    void testFullFields() {
        open("https://demoqa.com/automation-practice-form/");


        $("[id=firstName]").setValue("Юлия");
        $("[id=lastName]").setValue("Сергеевна");
        $("[id=userEmail]").setValue("12@mail.ru");
        $("[for=gender-radio-2]").click();
        $("[id=userNumber]").setValue("5555555555");

        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1991");
        $("[aria-label='Choose Sunday, April 14th, 1991']").click();

        $("[id=subjectsInput]").setValue("m").pressEnter();
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-2]").click();
        $("[for=hobbies-checkbox-3]").click();
        $("[id=currentAddress]").setValue("Siberia");
        $("[id=react-select-3-input]").setValue("NCR").pressEnter();
        $("[id=react-select-4-input]").setValue("Delhi").pressEnter();
        $("[id=submit]").pressEnter();

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
        $("[id=closeLargeModal]").pressEscape();
    }

}

//доп методы
//$(byName("q")).setValue("Selenide").pressEnter();
//$("").parent().click()
//Configuration.timeout = 600000;
