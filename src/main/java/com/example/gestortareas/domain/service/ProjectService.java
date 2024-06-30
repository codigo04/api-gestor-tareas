package com.example.gestortareas.domain.service;

import com.example.gestortareas.domain.Project;
import com.example.gestortareas.domain.User;
import com.example.gestortareas.domain.repository.ProjectRepository;
import com.example.gestortareas.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {


    @Autowired
    ProjectRepository projectRepository;



    @Autowired
    UserRepository userRepository;

    //buscar proyectos
    public List<Project> getAllByProjects() {

        return projectRepository.getAllByProjects();
    }

    //buscar por nombre
    public Optional<Project> getByName(String name) {

        if (name.isEmpty()) {
            return null;
        } else {
            return projectRepository.getByName(name);
        }
    }

    //Buscar por estado
    public List<Project> getByEstate(int estate) {

        return projectRepository.getByEstate(estate);
    }

    //buscar proyectos de un user
    public Optional<List<Project>> getByUser(int userId) {

        return projectRepository.getByUser(userId);
    }

    //crear proyectos
    public Project createProject(Project project) {
        Optional<User> user = userRepository.getUser(project.getUserId());


        if(user.isPresent()){
            return projectRepository.createProject(project);
        }else{
            return null;
        }


    }

    //eliminar proyecto
    public void deleteProjext(int userId) {
        projectRepository.deleteProject(userId);
    }

    //Actualizar proyecto
    public Project updateProject(int projectId, Project project) {
        Optional<Project> projectExist = projectRepository.getByProject(projectId);

        if (projectExist.isPresent()) {
            Project projecActualizado = projectExist.get();
            projecActualizado.setName(project.getName());
            projecActualizado.setDescription(project.getDescription());

            return projectRepository.updateProject(projecActualizado);
        } else return null;

    }

    //actualizar estado
    public Project updateEstate(int projectId, Project project){
        Optional<Project> projectExist = projectRepository.getByProject(projectId);

        if (projectExist.isPresent()) {
            Project projecActualizado = projectExist.get();

            projecActualizado.setEstate(project.getEstate());

            return projectRepository.updateProject(projecActualizado);
        } else {
            return null;
        }
    }


}
