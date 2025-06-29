package com.pinterest.testing.elements;

import com.codeborne.selenide.SelenideElement;

public class FileInput extends BaseElement {
    public FileInput(SelenideElement element) {
        super(element);
    }

    public void upload(String pathInClasspath) {
        getElement().uploadFromClasspath(pathInClasspath);
    }
}
