package com.learnspring.ToDoList.exception;

public class ResourceNotFoundException extends java.lang.Exception{
    public String serviceName;
    public String inputType;

    public Integer id;

    public ResourceNotFoundException(String serviceName, String inputType, Integer id) {
        this.serviceName = serviceName;
        this.inputType = inputType;
        this.id = id;
    }

    ResourceNotFoundException (){}
}
