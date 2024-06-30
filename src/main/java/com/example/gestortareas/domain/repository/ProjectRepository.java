package com.example.gestortareas.domain.repository;

import com.example.gestortareas.domain.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {

    //todos los usuarios
    public List<Project> getAllByProjects();
    //Buscar por nombre
    public Optional<Project>  getByName(String name);

    //Buscar por estado
    public List<Project>  getByEstate(int estate);

     public Optional<Project> getByProject(int projectId);

    //buscar proyectos de un user
    public  Optional<List<Project>> getByUser(int userId);

    //crear proyecto
    public Project createProject(Project project);

    //eliminar project
    public void deleteProject(int userId);

    //actualizar project
    public Project updateProject(Project project);


}
