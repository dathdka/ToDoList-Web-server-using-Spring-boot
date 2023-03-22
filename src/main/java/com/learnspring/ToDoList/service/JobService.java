package com.learnspring.ToDoList.service;

import com.learnspring.ToDoList.data.models.Job;
import com.learnspring.ToDoList.data.payloads.request.JobRequest;
import com.learnspring.ToDoList.data.payloads.response.JobResponse;
import com.learnspring.ToDoList.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface JobService {
    JobResponse createJob(JobRequest jobRequest);
    Optional<Job> updateJob(Integer id, JobRequest jobRequest) throws ResourceNotFoundException;

    void deleteJob(Integer id) throws ResourceNotFoundException;

    Job getJob(Integer id) throws ResourceNotFoundException;

    List<Job> getAllJob();
}
