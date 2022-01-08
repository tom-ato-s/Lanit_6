package web;

import allure.MyTestListener;
import elements.MainMenu;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import model.Ticket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static allure.MyTestListener.saveScreenshotPNG;

@Epic("Тестирование сайта")
public class HelpdeskUITest {

    private WebDriver driver;
    private Ticket ticket;
    private Ticket ticketOfPage;

    @BeforeClass
    public void setup() throws IOException {
        // Читаем конфигурационные файлы в System.properties
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));
        // Создание экземпляра драйвера
        driver = new ChromeDriver();
        // Устанавливаем размер окна браузера, как максимально возможный
        driver.manage().window().maximize();
        // Установим время ожидания для поиска элементов
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // Установить созданный драйвер для поиска в веб-страницах
        AbstractPage.setDriver(driver);
    }

    @Test
    public void createTicketTest() {

        // todo: открыть главную страницу
        driver.get(System.getProperty("site.url"));
        // Заполняем объект класс Ticket необходимыми тестовыми данными
        ticket = buildNewTicket();
        // todo: создать объект главной страницы и выполнить шаги по созданию тикета
        MainMenu mainMenu = new MainMenu(driver); // создает объекта меню
        mainMenu.newTicket();
        CreateTicketPage createTicketPage = new CreateTicketPage(); //создание объекта для создания тикета
        createTicketPage.createTicket(ticket); // заполнение полей станицы CreateTicket и нажатие кнопки сохранения тикета
        TicketPage ticketPage = new TicketPage(); // создали страницу объекта Тикета
        ticketPage.GoTologin(); // нажатие кнопики Логированния
        // todo: перейти к странице авторизации и выполнить вход
        LoginPage loginPage = new LoginPage();
        loginPage.login(System.getProperty("user"),System.getProperty("password") );
        TicketsPage ticketsPage = new TicketsPage();
        // todo: найти созданный тикет и проверить поля
        ticketsPage.openTicket(ticket); //найти и открыть тикет
        ticketOfPage = buildNewTicket(ticketPage); // создание объекта тикет из данных окна TicketPage

        Assert.assertTrue(ticket.equals(ticketOfPage), "Объекты эквивалентны"); //сравнение тикетов: созданного в начале и полученного из окна

        // Закрываем текущее окно браузера
        driver.close();
    }

    @Step("Создание и заполнение объекта Ticket, созданного изначально вручную")
    /**
     * Создаём и заполняем объект тикета
     *
     * @return заполненный объект тикета
     */
    protected Ticket buildNewTicket() {
        Ticket ticket = new Ticket();

        ticket.setTitle(randomTitle());
        // todo: заполнить остальные необходимые поля тикета
        ticket.setQueueValue("Django Helpdesk");
        ticket.setDescriptionValue("We hava a few problem");
        ticket.setPriorityValue(4);
        ticket.setMailValue("firstl@mail.ru");
        return ticket;
    }

    public static String randomTitle() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return  buffer.toString();
    }

    @Step("Создание и заполение объекта Ticket из страницы сайта")
    /**
     * Создаём и заполняем объект тикета
     *
     * @return заполненный объект тикета
     */
    protected Ticket buildNewTicket(TicketPage ticketPage) {
        Ticket ticketOfPage = new Ticket();
        ticketOfPage.setTitle(ticketPage.getNameTitle());
        ticketOfPage.setQueueValue(ticketPage.getQueue());
        ticketOfPage.setDescriptionValue(ticketPage.getDescription());
        ticketOfPage.setPriorityValue(ticketPage.getPriority());
        ticketOfPage.setMailValue(ticketPage.getEmail());
        return ticket;
    }

    @AfterTest
    public void close() {
        // Закрываем все окна браузера и освобождаем ресурсы
        driver.quit();
    }

}
