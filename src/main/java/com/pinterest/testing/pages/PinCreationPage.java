package com.pinterest.testing.pages;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.*;

public class PinCreationPage extends BasePage {

    public PinCreationPage() {
        super($x("//div[contains(@data-test-id,'pin-creation')]"));
    }

    public void uploadImage(String imagePath) {
        $x("//input[@type='file']").uploadFromClasspath(imagePath);
    }

    public void setTitle(String title) {
        $x("//*[@id=\"storyboard-selector-title\"]").setValue(title);
    }
    public void publish() {
        $x("//button[.//div[text()='Опубликовать']]").click();

    }
}
