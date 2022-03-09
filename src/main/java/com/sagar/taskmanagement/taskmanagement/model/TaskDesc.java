package com.sagar.taskmanagement.taskmanagement.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import lombok.Data;

@Entity
@Data
public class TaskDesc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long taskId;

    private String solution;

    private String description;

    @CreationTimestamp
    private Date CreatedDate;
}
