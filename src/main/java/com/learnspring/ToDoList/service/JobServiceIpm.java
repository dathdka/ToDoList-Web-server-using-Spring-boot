package com.learnspring.ToDoList.service;

import com.learnspring.ToDoList.data.models.Job;
import com.learnspring.ToDoList.data.payloads.request.JobRequest;
import com.learnspring.ToDoList.data.payloads.response.JobResponse;
import com.learnspring.ToDoList.data.repository.JobRepository;
import com.learnspring.ToDoList.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceIpm implements JobService{

    @Autowired
    JobRepository jobRepository;

    @Override
    public JobResponse createJob(JobRequest jobRequest) {
        Job newJob = new Job();
        newJob.setId(jobRequest.getId());
        newJob.setName(jobRequest.getName());
        newJob.setPriority(jobRequest.getPriority());
        newJob.setExpiredDate(jobRequest.getExpiredDate());
        jobRepository.save(newJob);
        return new JobResponse("new job has been added");
    }

    @Override
    public Optional<Job> updateJob(Integer id, JobRequest jobRequest) throws ResourceNotFoundException {
        Optional<Job> job = jobRepository.findById(id);
        if(job.isEmpty()){
            throw new ResourceNotFoundException("Job", "id", id);
        }else {
            job.get().setName(jobRequest.getName());
            job.get().setPriority(jobRequest.getPriority());
            job.get().setExpiredDate(jobRequest.getExpiredDate());
            jobRepository.save(job.get());
            return job;
        }
    }

    @Override
    public void deleteJob(Integer id) throws ResourceNotFoundException {
        if(jobRepository.findById(id).isEmpty()){
            jobRepository.deleteById(id);
        }else {
            throw new ResourceNotFoundException("Job", "id", id);
        }
    }

    @Override
    public Job getJob(Integer id) throws ResourceNotFoundException {
        return jobRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Job", "id", id));
    }

    @Override
    public List<Job> getAllJob() {
        return jobRepository.findAll();
    }
}
