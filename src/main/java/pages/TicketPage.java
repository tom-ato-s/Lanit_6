package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Страница отдельного тикета */
public class TicketPage extends HelpdeskBasePage {

    @FindBy(xpath = "//h3")
    WebElement ticketTitle;


    // todo: остальные поля тикета
    @FindBy(xpath ="//th[contains(.,\"Queue\")]")
    WebElement queue;

    @FindBy(xpath = "//th[text()='Priority']")
    WebElement priority;

    @FindBy(xpath = "//h4[text()='Description']")
    WebElement description;

    @FindBy(xpath = "//th[text()='Submitter E-Mail']")
    WebElement email;

    public TicketPage() {
        PageFactory.initElements(driver, this);
    }

    /** Получить имя тикета */
    public String getTicketTitle() {
        return ticketTitle.getText();
    }

    /** Получить адрес почты */
    public String getEmail() {
        // Получаем значение адреса почты
        return getValue(email);
    }

    @FindBy(xpath = "//a[@href='/login/?next=/']")  // ссылка на кнопку регистрации на странице TicketPage при создании тикета без регистации.
    private WebElement buttonGoTologin;

    // todo: остальные методы получения значений полей

    /** Получить значение имени тикета */
    public String getNameTitle() {
        boolean flag=true;
        StringBuilder sb = new StringBuilder();
        String temp;
        temp = ticketTitle.getText();
        //  String temp =ticketTitle.getText().trim();
        int l = temp.length();
        // цикл от 4 индекса строки - это начало номера тикета
        for(int i=4; i<l; i++) {
            if(flag){
                if(temp.charAt(i) == '.'){
                    i++;
                    flag= false;
                    continue;
                }
            }else
            if((temp.charAt(i) == ' ')&&(temp.charAt(i+1) == '[')) {
                break;
            } else {
                sb.append(temp.charAt(i));
            }
        }
        return sb.toString();
    }

    /** Получить значение Queue */
    public String getQueue() {
        // Получаем значение
        return queue.getText().substring(7).trim();
    }

    /** Получить значение Priority */
    public int getPriority() {
        // Получаем значение адреса почты
        return Integer.parseInt(getValue(priority).substring(0,1));
    }

    public String getDescription() {
        return description
                // Находи следующий элемент находящийся в том же теге
                .findElement(By.xpath("./following-sibling::p[1]"))
                // Получаем текст
                .getText()
                // Обрезаем лишние пробелы
                .trim();
    }


    /** Зажатие кнопки "Login In" */
    public void GoTologin() {
        buttonGoTologin.click();
    }




    /**
     * Получить значение элемента таблицы
     *
     * @param columnElem элемент ячейки для которой нужно вернуть значение
     * @return текстовое значение ячейки рядом
     */
    private String getValue(WebElement columnElem) {
        return columnElem
                // Находи следующий элемент находящийся в том же теге
                .findElement(By.xpath("./following-sibling::td[1]"))
                // Получаем текст
                .getText()
                // Обрезаем лишние пробелы
                .trim();
    }

}
