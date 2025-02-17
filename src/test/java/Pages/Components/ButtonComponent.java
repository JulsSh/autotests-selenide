package Pages.Components;

import static com.codeborne.selenide.Selenide.$;

public class ButtonComponent {
    public void submitButton(){
        $("[type=submit]").click();
    }
}
