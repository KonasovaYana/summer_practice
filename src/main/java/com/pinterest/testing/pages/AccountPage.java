package com.pinterest.testing.pages;

import static com.codeborne.selenide.Selenide.$x;

public class AccountPage extends BasePage {

    public AccountPage() {
        super($x("//div[contains(@data-test-id,'sellithu')]"));
    }

}