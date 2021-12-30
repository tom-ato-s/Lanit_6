package pages;

import model.Ticket;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/** Страница создания тикета */
public class CreateTicketPage extends HelpdeskBasePage {

    // Способ объявления элементы страницы, через аннотацию
    @FindBy(xpath = "//input[@id='id_title']")
    private WebElement inputProblemTitle;

    // todo: остальные элементы
    @FindBy(xpath = "//select[@id='id_queue']") //
    private WebElement inputQueue;

    @FindBy(xpath = "//textarea[@id='id_body']")
    private WebElement inputDescription;

    @FindBy(xpath = "//select[@id='id_priority']")
    private WebElement inputPriority;

    @FindBy(xpath = "//input[@id='id_submitter_email']")
    private WebElement inputMail;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg btn-block']")
    private WebElement buttonSubmitTicket;

    @FindBy(xpath = "//input[@class='form-control form-control hasDatepicker']")
    private WebElement inputDueOn;

    @FindBy(xpath = "//input[@class='form-control-file']")
    private WebElement inputAttachFile;


    public CreateTicketPage() {
        // Необходимо инициализировать элементы класса, лучше всего это делать в конструкторе
        PageFactory.initElements(driver, this);
    }

    /** Создание тикета */
    public void createTicket(Ticket ticket) {
        setProblemTitle(ticket.getTitle());
        // todo: заполнение остальных полей
        setQueue(ticket.getQueueValue());
        setDescription(ticket.getDescriptionValue());
        setPriority(ticket.getPriorityValue());
        setMail(ticket.getMailValue());
        createTicket();
    }

    /** Заполнение поля "Summary of the problem" */
    public void setProblemTitle(String text) {
        // todo: заполнить поле\
        inputProblemTitle.sendKeys(text);
    }

    // todo: методы заполнения остальных полей
    /** Заполнение поля "Queue"*/
    public void setQueue(String queueValue) {
        Select queueSelect = new Select(inputQueue);
        if(queueValue.equals("Django Helpdesk"))
            queueSelect.getOptions().get(1).click();
        if(queueValue.equals("Some Product"))
            queueSelect.getOptions().get(2).click();
    }

    /** Заполнение поля "Description of your issue" */
    public void setDescription(String descriptionValue) {
        // todo: заполнить поле\
        inputDescription.sendKeys(descriptionValue);
    }

    /** Заполнение поля "Priority"*/
    public void setPriority(int priorityValue) {
        Select prioritySelect = new Select(inputPriority);
        prioritySelect.getOptions().get(priorityValue).click();
    }

    /** Заполнение поля "Your E-Mail Address" */
    public void setMail(String mailValue) {
        // todo: заполнить поле\
        inputMail.sendKeys(mailValue);
    }

    /** Зажатие кнопки "Submit Ticket" */
    public void createTicket() {
        // todo: нажать кнопку создания задания
        buttonSubmitTicket.click();
    }

}