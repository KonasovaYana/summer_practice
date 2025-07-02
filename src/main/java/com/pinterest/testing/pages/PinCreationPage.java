package com.pinterest.testing.pages;
import com.pinterest.testing.elements.Button;
import com.pinterest.testing.elements.Input;
import com.pinterest.testing.elements.FileInput;

public class PinCreationPage extends BasePage {

    public PinCreationPage() {super(byDataTestId("pin-creation"));}

    private final FileInput imageUploadInput = FileInput.byFileInputTypeCreate("file");
    private final Input titleInput = Input.byIdCreate("storyboard-selector-title");
    private final Button publishButton = Button.byButtonPhraseInXpathCreate("Опубликовать");
    private final Button viewPublishedPinButton = Button.byTextContainCreate("Ваш пин опубликован");

    public void uploadImage(String imagePath) {
        imageUploadInput.upload(imagePath);
    }

    public void setTitle(String title) {
        titleInput.setValue("Название", title);
    }

    public void publish() {
        publishButton.click("Опубликовать");
    }

    public boolean isPublished(){
        return(viewPublishedPinButton.isDisplayed("Ваш пин опубликован"));
    }

    public void goToPublishedPin() {
        viewPublishedPinButton.click("Ваш пин опубликован");
        com.codeborne.selenide.Selenide.sleep(3000);
    }
}
