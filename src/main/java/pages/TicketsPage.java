package pages;

import model.Ticket;
import org.openqa.selenium.By;

/** Страница со списком тикетов */
public class TicketsPage extends HelpdeskBasePage {

    // todo: элементы страницы поиска тикетов

    public TicketsPage() {
    }

    /** Ищем строку с тикетом и нажимаем на нее */
    public void openTicket(Ticket ticket) {
        // todo: найти и открыть тикет
        setTicket(ticket); // ввод имени тикета при создании
        clickButtonSearch();  // нажатие кнопки поиска
        searchInPage(ticket);
    }

    private void setTicket(Ticket ticket) {
        driver.findElement(By.xpath("//input[@id='search_query']")).sendKeys(ticket.getTitle()); //    WebElement inputSearch =
    }

    private void clickButtonSearch() {
        driver.findElement(By.xpath(".//button[@class='btn btn-primary']")).click();  // WebElement buttonSearch =
    }

    public void searchInPage(Ticket ticket) {
        String s = ticket.getTitle();
        driver.findElement(By.xpath(String.format("//a[contains(.,'%s')]", s))).click();
    }

}