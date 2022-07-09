package pages;

import io.qameta.allure.Step;
import models.Dictionaries;
import models.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/** Страница отдельного тикета (авторизированный пользователь) */
public class TicketPage extends HelpdeskBasePage {

    /* Верстка страницы может измениться, поэтому для таблиц вместо индексов строк и столбцов лучше использовать
       более универсальные локаторы, например поиск по тексту + parent, following-sibling и другие.

       Текст тоже может измениться, но в этом случае элемент не будет найден и тест упадет,
       а ошибку можно будет легко локализовать и исправить.
       В случае изменений ячеек таблицы, локатор будет продолжать работать, но будет указывать на другой элемент,
       поведение теста при этом изменится непредсказуемым образом и ошибку будет сложно найти. */

    private WebElement dueDate = driver.findElement(By.xpath("//th[text()='Due Date']/following-sibling::td[1]"));
    // todo: проинициализировать элементы через driver.findElement
    private WebElement title = driver.findElement(By.xpath("//th[contains(text(), 'Queue')]"));
    private WebElement queue = driver.findElement(By.xpath("//th[contains(text(), 'Queue')]"));
    private WebElement email = driver.findElement(By.xpath("//td[contains(text(), '@')]"));
    private WebElement priority = driver.findElement(By.xpath("//th[text()='Priority']/following-sibling::td[1]"));
    private WebElement description = driver.findElement(By.xpath("//td[@id='ticket-description']/p"));

    @Step("Проверить значение полей на странице тикета")
    public void checkTicket(Ticket ticket) {
        // todo: добавить реализацию метода
        Assert.assertEquals(getTitle(), ticket.getTitle(), "Имя тикета не соответствует");
        Assert.assertEquals(getQueue(), Dictionaries.getQueue(ticket.getQueue()),"Queue не соответствует");
        Assert.assertEquals(getEmail(), ticket.getSubmitter_email(), "Submitter_email не соответствует");
        Assert.assertEquals(getPriority(), Dictionaries.getPriority(ticket.getPriority()), "Priority не соответствует");
        Assert.assertEquals(getDescription(), ticket.getDescription(), "Description не соответствует");
    }

    private String getTitle() {
        return this.title.getText()
                .replaceAll("^.+\\.\\s", "")
                .replaceAll("(\\s\\[.+)?\\n.+", "");
    }

    private String getQueue() {
        String queue = this.queue.getText()
                .replaceAll(".+\\n?Queue:\\s", "")
                .replaceAll("\\sEdit.+", "");
        return queue;
    }

    private String getEmail() {
        return this.email.getText();
    }

    private String getPriority() {
        return this.priority.getText();
    }

    private String getDescription() {
        String description = this.description.getText();
        return description;
    }
}
