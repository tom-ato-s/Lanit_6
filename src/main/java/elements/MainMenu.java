package elements;

import io.qameta.allure.Step;
import model.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/** Элемент главного меню */
public class MainMenu {

    private WebDriver driver;
    // Поиск элементов без аннотации
    private WebElement logInBtn;
    // todo: остальные элементы меню
    private WebElement searchBtn;
    private WebElement searchText;
    private WebElement newTicketBtn;

    public MainMenu(WebDriver driver) {
        this.driver = driver;
        logInBtn = driver.findElement(By.xpath(".//input[@value='View Ticket']"));
        searchBtn = driver.findElement(By.xpath(".//a[@href='/login/?next=/']"));
        newTicketBtn= driver.findElement(By.xpath (".//a[@href='/tickets/submit/']"));
        searchText = driver.findElement(By.xpath("//input[@name='ticket']"));
    }
    @Step("Нажатие кнопки NewTicket")
    public void newTicket() {
        // todo: нажать кнопку создания нового тикета
        newTicketBtn.click();
    }

    public void logIn() {
        // todo: нажать кнопку авторизации
        logInBtn.click();
    }

    public void searchTicket(Ticket ticket) {
        setSearch(ticket.getTitle())
                .search();
    }

    /* Если после вызова void метода, может потребоваться вызов другого метода этого же класса,
        то можно вернуть сам класс и вызвать следующий метод через точку. */

    @Step ("Ввести значения в поле поиска")
    public MainMenu setSearch(String text) {
        // todo: ввести значение в поле поиска
        searchText.sendKeys(text);
        return this;
    }

    @Step ("Нажать кнопку поиска")
    public void search() {
        // todo: нажать кнопку поиска
        searchBtn.click();
    }

}
