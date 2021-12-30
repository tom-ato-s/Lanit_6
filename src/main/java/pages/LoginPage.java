package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Страница авторизации */
public class LoginPage extends HelpdeskBasePage {

    // todo: элементы страницы
    @FindBy(xpath = "//input[@id='username']")
    WebElement loginName;

    @FindBy(xpath = "//input[@id='password']")
    WebElement email;

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
    public void login(String user, String password) {
        // todo: заполнить поля и нажать кнопку авторизации
        setLogin(user);
        setEmail(password);
        clickLoginBtn();
    }

    // todo: методы работы с элементами
    private void setLogin(String login) {
        this.loginName.sendKeys(login);
    }

    private void setEmail(String email) {
        this.email.sendKeys(email);
    }

    private void clickLoginBtn() {
        loginBtn.click();
    }
}
