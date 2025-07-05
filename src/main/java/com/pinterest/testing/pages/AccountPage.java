package com.pinterest.testing.pages;
import com.pinterest.testing.elements.Button;
import com.pinterest.testing.elements.Input;

/**
 * Страница аккаунта пользователя в Pinterest.
 * Предоставляет методы для взаимодействия с элементами профиля,
 * включая управление досками, пинами, избранным и комментариями.
 */
public class AccountPage extends BasePage {

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
    private final Button chooseOtherActionsButton = Button.byAriaLabelCreate("Другие действия");
    private final Button chooseCorrectPinButton = Button.byButtonIdCreate("pin-action-dropdown-edit-pin");
    private final Input editDescriptionButton = Input.byDivAriaCreate("Опишите ваш пин");
    private final Button saveDescriptionButton = Button.byButtonIdCreate("save-pin-button");
    private final Button checkSavedDescriptionButton = Button.byIdAndContainsCreate("truncated-description", "Этот пин красивый!");
    private final Input commentInput = Input.byIdAndContentCreate("dweb-comment-editor-container", "true");
    private final Button chooseEmojiButton = Button.byAriaLabelCreate("Выбрать эмодзи");
    private final Button emojiButton = Button.byAriaLabelCreate("smiley");
    private final Button sendCommentButton = Button.byAriaLabelCreate("Опубликовать");
    private final Button checkComment = Button.byDivIdCreate("commentThread-comment");

    /**
     * Конструктор страницы аккаунта.
     * Инициализирует страницу с использованием локатора заголовка профиля.
     */
    public AccountPage() {super(byDataTestId("header-profile"));}

    /**
     * Выбирает раздел "Доски" в профиле пользователя.
     */
    public void chooseBoards() {
        chooseBoardsButton.click("Доски");
    }

    /**
     * Выбирает первую доску в списке досок пользователя.
     */
    public void chooseFirstBoards() {
        chooseFirstBoardsButton.click("Первая доска");
    }

    /**
     * Выбирает первый пин в списке пинов.
     */
    public void chooseFirstPinBoards() {
        chooseFirstPinButton.click("Первый пин");
    }

    /**
     * Добавляет текущий пин в избранное.
     */
    public void makePinFavourite() {
        makePinFavouriteButton.click("Добавить в избранное");
    }

    /**
     * Проверяет, добавлен ли пин в избранное.
     * @return true если кнопка "Удалить из избранного" отображается, иначе false
     */
    public boolean checkFavourites(){
        return(FavouritesButton.isDisplayed("Удалить из избранного"));
    }

    /**
     * Выбирает раздел "Пины" в профиле пользователя.
     */
    public void choosePins() {
        choosePinsButton.click("Пины");
    }

    /**
     * Выбирает раздел "Избранное" в профиле пользователя.
     */
    public void chooseFavourites() {
        chooseFavouritesButton.click("Избранное");
    }

    /**
     * Выбирает раздел "Созданные мной" в профиле пользователя.
     */
    public void chooseMadeByMe() {
        chooseMadeByMeButton.click("Созданные мной");
    }

    /**
     * Выбирает первый пин в текущем разделе.
     */
    public void choosePin() {
        choosePinButton.click("Первый пин");
    }

    /**
     * Нажимает кнопку реакции на пин.
     */
    public void chooseLikePin() {
        chooseLikePinButton.click("Отреагировать");
    }

    /**
     * Проверяет, отображается ли кнопка "Мне нравится".
     * @return true если кнопка отображается, иначе false
     */
    public boolean checkLikePin() {
        return LikeButton.isDisplayed("Мне нравится!");
    }

    /**
     * Выбирает указанную доску.
     */
    public void chooseBoard() {
        chooseBoardButton.click("Выбираем вторую доску");
    }

    /**
     * Выбирает первый пин на текущей доске.
     */
    public void chooseFirstPinOnBoard() {
        chooseFirstPinOnBoardButton.click("Выбираем первый пин на доске");
    }

    /**
     * Открывает выбор доски для сохранения.
     */
    public void profile() {
        profileButton.click("выбор доски для сохранения");
    }

    /**
     * Выбирает первую доску в списке.
     */
    public void chooseFirstBoard() {
        chooseFirstBoardButton.click("сохраняем на первую доску");
    }

    /**
     * Нажимает кнопку редактирования пина.
     */
    public void chooseEdit() {
        EditButton.click("Изменяем пин");
    }

    /**
     * Нажимает кнопку редактирования пина на доске.
     */
    public void chooseBoardEdit() {
        EditBoardButton.click("Изменяем пин на доске");
    }

    /**
     * Нажимает кнопку удаления пина.
     */
    public void chooseDelete() {
        DeleteButton.click("Удаляем пин с доски");
    }

    /**
     * Проверяет подтверждение удаления пина.
     * @return true если сообщение "Пин удален" отображается, иначе false
     */
    public boolean checkConfirmDeletePin() {
        return ConfirmDelete.isDisplayed("Пин удален");
    }

    /**
     * Проверяет, сохранен ли пин.
     * @return true если кнопка "Сохранено" отображается, иначе false
     */
    public boolean checkSavedPin() {
        return SavedPinButton.isDisplayed("Сохранено");
    }

    /**
     * Выбирает меню "Другие действия" для пина.
     */
    public void chooseOtherActions() {
        chooseOtherActionsButton.click("Другие действия");
    }

    /**
     * Выбирает пункт "Изменить" в меню действий.
     */
    public void chooseCorrectPin() {
        chooseCorrectPinButton.click("Изменить");
    }

    /**
     * Редактирует описание пина.
     * @param title новое описание пина
     */
    public void editDescription(String title) {
        editDescriptionButton.setValue("Описание", title);
    }

    /**
     * Сохраняет изменения в описании пина.
     */
    public void saveDescription() {
        saveDescriptionButton.click("Сохранить");
    }

    /**
     * Проверяет сохраненное описание пина.
     * @param title ожидаемое описание
     * @return true если описание отображается корректно, иначе false
     */
    public boolean checkSavedDescriptionDescription(String title) {
        return checkSavedDescriptionButton.isDisplayed(title);
    }

    /**
     * Добавляет комментарий к пину.
     * @param comment текст комментария
     */
    public void writeComment(String comment) {
        commentInput.setValue("Добавить комментарий", comment);
    }

    /**
     * Открывает меню выбора эмодзи.
     */
    public void clickChooseEmoji(){
        chooseEmojiButton.click("Выбрать эмодзи");
    }

    /**
     * Выбирает смайлик в меню эмодзи.
     */
    public void chooseEmoji(){
        emojiButton.click("Улыбающийся смайлик");
    }

    /**
     * Отправляет комментарий.
     */
    public void sendComment() {
        sendCommentButton.click("Опубликовать");
    }

    /**
     * Проверяет отправленный комментарий.
     * @param title ожидаемый текст комментария
     * @return true если комментарий отображается, иначе false
     */
    public boolean checkCommentSend(String title) {
        return checkComment.isDisplayed(title);
    }

}