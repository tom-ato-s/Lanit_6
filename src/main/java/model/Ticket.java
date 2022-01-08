package model;

import io.qameta.allure.Step;

import java.util.Objects;

/** Объект тикета */
public class Ticket {

    /** Название проблемы */
    private String title;

    // todo: остальные поля необходимые для заполнения тикета
    private String queueValue;
    private String descriptionValue;
    private int priorityValue;
    private String mailValue;

    public String getTitle() {
        return title;
    }
    @Step("Установка Title, значение: {title}")
    public void setTitle(String title) {
        this.title = title;
    }
    // todo: методы get и set для остальных полей
    public String getQueueValue() {
        return queueValue;
    }
    @Step("Установка QueueValue, значение: {queueValue}")
    public void setQueueValue(String queueValue) {
        this.queueValue = queueValue;
    }

    public String getDescriptionValue() {
        return descriptionValue;
    }
    @Step("Установка DescriptionValue, значение: {descriptionValue}")
    public void setDescriptionValue(String descriptionValue) {
        this.descriptionValue = descriptionValue;
    }

    public int getPriorityValue() {
        return priorityValue;
    }
    @Step("Установка PriorityValue, значение: {priorityValue}")
    public void setPriorityValue(int priorityValue) {
        this.priorityValue = priorityValue;
    }

    public String getMailValue() {
        return mailValue;
    }
    @Step("Установка MailValue, значение: {mailValue}")
    public void setMailValue(String mailValue) {
        this.mailValue = mailValue;
    }
    // todo: equals и hashCode
    @Step("Проверка эквивалентности двух объектов Title")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return priorityValue == ticket.priorityValue && Objects.equals(title, ticket.title) && Objects.equals(queueValue, ticket.queueValue) && Objects.equals(descriptionValue, ticket.descriptionValue) && Objects.equals(mailValue, ticket.mailValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, queueValue, descriptionValue, priorityValue, mailValue);
    }
}
