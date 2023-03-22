package com.learnspring.ToDoList.web;

import com.learnspring.ToDoList.data.models.Job;
import com.learnspring.ToDoList.data.payloads.request.JobRequest;
import com.learnspring.ToDoList.data.payloads.response.JobResponse;
import com.learnspring.ToDoList.data.repository.JobRepository;
import com.learnspring.ToDoList.exception.ResourceNotFoundException;
import com.learnspring.ToDoList.service.JobService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    JobService jobService;

    @GetMapping("/all")
    public ResponseEntity<List<Job>> getAllJob (){
        List<Job> job = jobService.getAllJob();
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Job> getJobById (@PathVariable("id") Integer id) throws ResourceNotFoundException {
        Job job = jobService.getJob(id);
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<JobResponse> addJob (@RequestBody JobRequest job){
        JobResponse newJob = jobService.createJob(job);
        return new ResponseEntity<>(newJob, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<Job>> updateJob(@PathVariable Integer id, @RequestBody JobRequest job) throws ResourceNotFoundException {
        Optional<Job> jobResponse = jobService.updateJob(id, job);
        return new ResponseEntity<Optional<Job>>(jobResponse,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        jobService.deleteJob(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
