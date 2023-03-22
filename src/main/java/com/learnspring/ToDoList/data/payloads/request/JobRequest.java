package com.learnspring.ToDoList.data.payloads.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class JobRequest {
    @NotBlank
    @NotNull
    private Integer id;

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private Integer priority;

    @NotBlank
    @NotNull
    private Date expiredDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }
}
