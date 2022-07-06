package models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {

    /* Класс Ticket пакета models содержит набор полей, необходимый для заполнения формы создания тикета.
       Тип данных для каждого поля соответствует документации swagger (см. раздел Models в документации). */

    private String title;
    private String due_date;
    @JsonIgnore
    private File file;
    private Integer id;
    private String submitter_email;
    private Integer status;
    private String description;
    private Integer priority;
    private Integer queue;
    @JsonIgnore
    private String assigned_to;
    @JsonIgnore
    private String created;
    @JsonIgnore
    private String modified;
    @JsonIgnore
    private Boolean on_hold;
    @JsonIgnore
    private String resolution;
    @JsonIgnore
    private String secret_key;
    @JsonIgnore
    private Integer kbitem;
    @JsonIgnore
    private Integer merged_to;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDue_date() {
        return due_date;
    }

    // обычный сеттер
    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    // перегруженный сеттер, который принимает дату и форматирует её в строку по шаблону
    public void setDue_date(LocalDateTime due_date) {
        this.due_date = due_date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubmitter_email() {
        return submitter_email;
    }

    public void setSubmitter_email(String submitter_email) {
        this.submitter_email = submitter_email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getQueue() {
        return queue;
    }

    public void setQueue(Integer queue) {
        this.queue = queue;
    }

    public String getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(String assigned_to) {
        this.assigned_to = assigned_to;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Boolean getOn_hold() {
        return on_hold;
    }

    public void setOn_hold(Boolean on_hold) {
        this.on_hold = on_hold;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getSecret_key() {
        return secret_key;
    }

    public void setSecret_key(String secret_key) {
        this.secret_key = secret_key;
    }

    public Integer getKbitem() {
        return kbitem;
    }

    public void setKbitem(Integer kbitem) {
        this.kbitem = kbitem;
    }

    public Integer getMerged_to() {
        return merged_to;
    }

    public void setMerged_to(Integer merged_to) {
        this.merged_to = merged_to;
    }
}
