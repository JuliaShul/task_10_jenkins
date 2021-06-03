package commonsteps;
import com.codeborne.selenide.Selenide;

public class OpenPage {

    public void open(String site) {
        Selenide.open(site);
    }
}
