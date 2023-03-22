package com.learnspring.ToDoList.data.repository;

import com.learnspring.ToDoList.data.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job,Integer> {
}
