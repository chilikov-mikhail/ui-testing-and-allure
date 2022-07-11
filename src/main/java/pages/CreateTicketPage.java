package pages;

import io.qameta.allure.Step;
import models.Dictionaries;
import models.Ticket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDateTime;

/** Страница создания тикета */
public class CreateTicketPage extends HelpdeskBasePage {

    @FindBy(name = "queue")
    private WebElement selectQueue;

    @FindBy(id = "id_title")
    private WebElement inputProblem;

//    @FindBy(className = "btn btn-primary btn-lg btn-block")
    @FindBy(css = "[class='btn btn-primary btn-lg btn-block']")
    private WebElement submitTicketButton;

    @FindBy(id = "id_body")
    private WebElement inputDescription;

    @FindBy(id = "id_priority")
    private WebElement selectPriority;

    @FindBy(id = "id_due_date")
    private WebElement inputDueDate;

    @FindBy(id = "id_submitter_email")
    private WebElement inputSubmitterEmail;

    // проинициализировать элементы
    public CreateTicketPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Создать тикет")
    public CreateTicketPage createTicket(Ticket ticket) {
        setInputProblem(ticket.getTitle());
        setInputDescription(ticket.getDescription());
        setSelectQueue(ticket.getQueue());
        setSelectPriority(ticket.getPriority());
        setInputDueDate(ticket.getDue_date());
        setInputSubmitterEmail(ticket.getSubmitter_email());
        clickOnSubmitButton();
        return this;
    }

    @Step("Ввести имя проблемы: {text}")
    public void setInputProblem(String text) {
        inputProblem.sendKeys(text);
        AbstractPage.makeScreenshot();
    }

    @Step("Нажать на кнопку создания тикета")
    public void clickOnSubmitButton() {
        submitTicketButton.click();
        AbstractPage.makeScreenshot();
    }

    @Step("в выпадающем списке “Queue” выбрать значение")
    public void setSelectQueue(int queue) {
        selectQueue.sendKeys(Dictionaries.getQueue(queue));
        AbstractPage.makeScreenshot();
    }

    @Step("заполнить поле “Description of your issue”")
    public void setInputDescription(String text) {
        inputDescription.sendKeys(text);
        AbstractPage.makeScreenshot();
    }

    @Step("в выпадающем списке “Priority” выбрать значение")
    public void setSelectPriority(int priority) {
        selectPriority.sendKeys(Dictionaries.getPriority(priority));
        AbstractPage.makeScreenshot();
    }

    @Step("ввести дату в поле “Due on”")
    public void setInputDueDate(String due_date) {
        inputDueDate.sendKeys(due_date);
        AbstractPage.makeScreenshot();
    }

    @Step("ввести электронную почту в поле “Your E-Mail Address”")
    public void setInputSubmitterEmail(String email) {
        inputSubmitterEmail.sendKeys(email);
        AbstractPage.makeScreenshot();
    }
}
