package com.learnspring.ToDoList.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.Objects;

@Entity
public class Job {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer priority;
    private Date    expiredDate;

    public Job(){};
    public Job(Integer id, String name, Integer priority, Date expiredDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.expiredDate = expiredDate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPriority() {
        return priority;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Override
    public String toString() {
        return "job{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priority=" + priority +
                ", expiredDate=" + expiredDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId().equals(job.getId()) && getName().equals(job.getName()) && getPriority().equals(job.getPriority()) && getExpiredDate().equals(job.getExpiredDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPriority(), getExpiredDate());
    }
}
