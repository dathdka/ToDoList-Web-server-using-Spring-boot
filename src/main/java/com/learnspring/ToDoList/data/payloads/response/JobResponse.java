package com.learnspring.ToDoList.data.payloads.response;

public class JobResponse {
    private String name;

    public JobResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
