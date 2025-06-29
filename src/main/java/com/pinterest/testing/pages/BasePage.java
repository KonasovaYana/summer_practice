package com.pinterest.testing.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.refresh;

public abstract class BasePage {
    protected final SelenideElement baseType;

    public BasePage(SelenideElement baseType) {
        this.baseType = baseType;
    }

    @SuppressWarnings("unchecked")
    public <T extends BasePage> T refresh() {
        refresh();
        return (T) this;
    }
}
