package com.pinterest.testing.pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.io.File;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage {
    public HomePage() {
        super($x("//div[contains(@data-test-id, 'header')]"));
    }
    public void openPinCreation() {
        $x("//*[@id=\"VerticalNavContent\"]/div/div/div[1]/div[4]/div/div/div/a").shouldBe(Condition.enabled).click();
        SelenideElement uploadInput = $x("//*[@id='storyboard-upload-input']");
        uploadInput.uploadFile(new File("C:\\Users\\Konas\\github\\summer_practice\\src\\test\\resources\\flower.jpg"));
    }
}
