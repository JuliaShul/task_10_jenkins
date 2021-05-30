import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestPracticeForm {

    @Test
    void testRequiredFields() {
        Configuration.timeout = 600000;
        open("https://demoqa.com/automation-practice-form/");


        $("[id=firstName]").setValue("Julia");
        $("[id=lastName]").setValue("Shu");
        $("[id=userEmail]").setValue("jull@mail.ru");
        $("[.custom-control-label]").click();
        $("[id=userNumber]").setValue("8903930999");
        $("[id=Submit]").click();


        $("[.table-responsive]").shouldHave(text("Julia")
                , text("Julia Shu")
                , text("jull@mail.ru")
                , text("Male")
                , text("8903930999"));
        $("[id=closeLargeModal]").click();

    }

    @Test
    void testFullFields() {

        open("https://demoqa.com/automation-practice-form/");

        $("[id=firstName]").setValue("Юлия");
        $("[id=lastName]").setValue("Сергеевна");
        $("[id=userEmail]").setValue("12@mail.ru");
        $(".custom-control-label, 1").click();
        $("[id=userNumber]").setValue("8903930999");
        //$("[id=subjectsContainer]").setValue("Maths");
        $("[id=hobbies-checkbox-1]").click();
        $("[id=hobbies-checkbox-2]").click();
        $("[id=hobbies-checkbox-3]").click();
       // ("images.jpg")
        $("[id=currentAddress]").setValue("Siberia");
        //("NCR Delhi")
        $("[id=Submit]").click();


        $("[.table-responsive]").shouldHave(text("Julia")
                , text("Юлия Сергеевна")
                , text("12@mail.ru")
                , text("Female")
                , text("5555555555")
               // , text("Maths")
                , text("Reading, Music, Sports")
               // , text("images.jpg")
                , text("Siberia")
               // , text("NCR Delhi")
                );
        $("[id=closeLargeModal]").click();
    }
}

//доп методы
//$(byName("q")).setValue("Selenide").pressEnter();
//$("").parent().click()
