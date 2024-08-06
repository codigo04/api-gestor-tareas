package com.example.gestortareas.domain;

import com.example.gestortareas.domain.Enum.Estate;
import com.example.gestortareas.domain.Enum.Priority;
import com.example.gestortareas.persistencia.entity.Comentario;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;
import java.util.List;

public class Task {

    private int taskId;
    private String title;
    private String description;
    private LocalDateTime dateCreation;
    private LocalDateTime dateExperition;
    private int projectId;
    private int userId;


    @Enumerated(EnumType.STRING)
    private Priority priority ;

    @Enumerated(EnumType.STRING)
    private Estate estate = Estate.PENDIENTE;


    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDateExperition() {
        return dateExperition;
    }

    public void setDateExperition(LocalDateTime dateExperition) {
        this.dateExperition = dateExperition;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Estate getEstate() {
        return estate;
    }

    public void setEstate(Estate estate) {
        this.estate = estate;
    }
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


}
