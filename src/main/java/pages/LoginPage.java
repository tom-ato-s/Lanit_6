package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Страница авторизации */
public class LoginPage extends HelpdeskBasePage {

    // todo: элементы страницы
    @FindBy(xpath = "//input[@id='username']")
    WebElement loginName;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//input[@class='btn btn-lg btn-primary btn-block']")
    WebElement loginBtn;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Авторизация пользователя
     *
     * @param user     логин пользователя
     * @param password пароль пользователя
     */
    @Step("Авторизация пользователя, user: {user}, password: {password}")
    public void login(String user, String password) {
        // todo: заполнить поля и нажать кнопку авторизации
        setLogin(user);
        setPassword(password);
        clickLoginBtn();
    }

    // todo: методы работы с элементами
    @Step ("Ввод логина логина в поле авторизации, значение {login}")
    private void setLogin(String login) {
        this.loginName.sendKeys(login);
    }
    @Step ("Ввод почты, значение {password}")
    private void setPassword(String password) {
        this.password.sendKeys(password);
    }
    @Step ("Нажатие кнопки авторизации, ввода данных для авторизации")
    private void clickLoginBtn() {
        loginBtn.click();
    }
}
