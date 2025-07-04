package com.pinterest.testing.pages;
import com.pinterest.testing.elements.Button;
import com.pinterest.testing.elements.Input;

public class AccountPage extends BasePage {

    public AccountPage() {super(byDataTestId("header-profile"));}

    private final Button chooseBoardsButton = Button.byIdCreate("_boards-profile-tab");
    private final Button chooseFirstBoardsButton = Button.byRoleCreate("listitem");
    private final Button chooseFirstPinButton = Button.byXpathCreate("(//div[@data-test-id='pinrep-image']//img[contains(@class, 'hCL')])[1]\n");
    private final Button makePinFavouriteButton = Button.byButtonIdCreate("favorite-button-star");
    private final Button FavouritesButton = Button.byPhraseInXpathCreate("Удалить из избранного");
    private final Button choosePinsButton = Button.byIdCreate("_pins-profile-tab");
    private final Button chooseFavouritesButton = Button.byButtonIdCreate("favorites_pins_button");
    private final Button chooseMadeByMeButton = Button.byButtonIdCreate("created_by_you_button");
    private final Button choosePinButton = Button.byGridIdCreate("0");
    private final Button chooseLikePinButton = Button.byAriaLabelCreate("Отреагировать");
    private final Button LikeButton = Button.byPhraseInXpathCreate("Мне нравится!");
    private final Button chooseBoardButton = Button.byHTitleCreate("Вторая доска");
    private final Button chooseFirstPinOnBoardButton = Button.byRoleContainsCreate("group", "XiG zI7 iyn Hsu");
    private final Button profileButton = Button.byButtonIdCreate("PinBetterSaveDropdown");
    private final Button chooseFirstBoardButton = Button.byDivIdCreate("board-row-Первая доска");
    private final Button EditButton = Button.byAriaLabelCreate("Другие действия");
    private final Button EditBoardButton = Button.bySpanTextCreate("Изменить пин");
    private final Button DeleteButton = Button.byButtonPhraseInXpathCreate("Удалить");
    private final Button ConfirmDelete = Button.byTextContainCreate("Пин удален");
    private final Button SavedPinButton = Button.byPhraseInXpathCreate("Сохранено");
    private final Button chooseOtherActionsButton = Button.byAriaLabelCreate("Другие действия");private final Button chooseCorrectPinButton = Button.byButtonIdCreate("pin-action-dropdown-edit-pin");
    private final Input editDescriptionButton = Input.byDivAriaCreate("Опишите ваш пин");private final Button saveDescriptionButton = Button.byButtonIdCreate("save-pin-button");
    private final Button checkSavedDescriptionButton = Button.byIdAndContainsCreate("truncated-description", "Этот пин красивый!");
    private final Input commentInput = Input.byIdAndContentCreate("dweb-comment-editor-container", "true");
    private final Button chooseEmojiButton = Button.byAriaLabelCreate("Выбрать эмодзи");
    private final Button emojiButton = Button.byAriaLabelCreate("smiley");
    private final Button sendCommentButton = Button.byAriaLabelCreate("Опубликовать");
    private final Button checkComment = Button.byDivIdCreate("commentThread-comment");

    public void chooseBoards() {
        chooseBoardsButton.click("Доски");
    }

    public void chooseFirstBoards() {
        chooseFirstBoardsButton.click("Первая доска");
    }

    public void chooseFirstPinBoards() {
        chooseFirstPinButton.click("Первый пин");
    }

    public void makePinFavourite() {
        makePinFavouriteButton.click("Добавить в избранное");
    }

    public boolean checkFavourites(){
        return(FavouritesButton.isDisplayed("Удалить из избранного"));
    }

    public void choosePins() {
        choosePinsButton.click("Пины");
    }

    public void chooseFavourites() {
        chooseFavouritesButton.click("Избранное");
    }

    public void chooseMadeByMe() {
        chooseMadeByMeButton.click("Созданные мной");
    }

    public void choosePin() {
        choosePinButton.click("Первый пин");
    }

    public void chooseLikePin() {
        chooseLikePinButton.click("Отреагировать");
    }

    public boolean checkLikePin() {
        return LikeButton.isDisplayed("Мне нравится!");
    }

    public void chooseBoard() {
        chooseBoardButton.click("Выбираем вторую доску");
    }

    public void chooseFirstPinOnBoard() {
        chooseFirstPinOnBoardButton.click("Выбираем первый пин на доске");
    }

    public void profile() {
        profileButton.click("выбор доски для сохранения");
    }

    public void chooseFirstBoard() {
        chooseFirstBoardButton.click("сохраняем на первую доску");
    }

    public void chooseEdit() {
        EditButton.click("Изменяем пин");
    }

    public void chooseBoardEdit() {
        EditBoardButton.click("Изменяем пин на доске");
    }

    public void chooseDelete() {
        DeleteButton.click("Удаляем пин с доски");
    }

    public boolean checkConfirmDeletePin() {
        return ConfirmDelete.isDisplayed("Пин удален");
    }

    public boolean checkSavedPin() {
        return SavedPinButton.isDisplayed("Сохранено");
    }

    public void chooseOtherActions() {
        chooseOtherActionsButton.click("Другие действия");
    }

    public void chooseCorrectPin() {
        chooseCorrectPinButton.click("Изменить");
    }

    public void editDescription(String title) {
        editDescriptionButton.setValue("Описание", title);
    }

    public void saveDescription() {
        saveDescriptionButton.click("Сохранить");
    }

    public boolean checkSavedDescriptionDescription(String title) {
        return checkSavedDescriptionButton.isDisplayed(title);
    }

    public void writeComment(String comment) {
        commentInput.setValue("Добавить комментарий", comment);
    }

    public void clickChooseEmoji(){
        chooseEmojiButton.click("Выбрать эмодзи");
    }

    public void chooseEmoji(){
        emojiButton.click("Улыбающийся смайлик");
    }

    public void sendComment() {
        sendCommentButton.click("Опубликовать");
    }

    public boolean checkCommentSend(String title) {
        return checkComment.isDisplayed(title);
    }
}