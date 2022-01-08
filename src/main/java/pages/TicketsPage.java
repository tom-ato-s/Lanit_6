package pages;

import io.qameta.allure.Step;
import model.Ticket;
import org.openqa.selenium.By;

import static allure.MyTestListener.saveScreenshotPNG;

/** Страница со списком тикетов */
public class TicketsPage extends HelpdeskBasePage {

    // todo: элементы страницы поиска тикетов

    public TicketsPage() {
    }

    /** Ищем строку с тикетом и нажимаем на нее */
    @Step("Ищем строку с тикетом, значение {ticket}, и нажимаем на нее")
    public void openTicket(Ticket ticket) {
        // todo: найти и открыть тикет
        setTicket(ticket); // ввод имени тикета при создании
        clickButtonSearch();  // нажатие кнопки поиска
        searchInPage(ticket); // поиск на странице с отсортированными тикетами нужный тикет
        saveScreenshotPNG(driver);// скриншот
    }
    @Step("Вводим имя тикета при создании, значение {ticket}")
    private void setTicket(Ticket ticket) {
        driver.findElement(By.xpath("//input[@id='search_query']")).sendKeys(ticket.getTitle());
        saveScreenshotPNG(driver);// скриншот
    }
    @Step ("Нажатие кнопки поиска в разделе тикетов")
    private void clickButtonSearch() {
        driver.findElement(By.xpath(".//button[@class='btn btn-primary']")).click();
        saveScreenshotPNG(driver);// скриншот
    }
    @Step ("Нажатие кнопки поиска тикета на странице с отсортированными тикетами. {ticket}")
    public void searchInPage(Ticket ticket) {
        String s = ticket.getTitle();
        driver.findElement(By.xpath(String.format("//a[contains(.,'%s')]", s))).click();
    }

}