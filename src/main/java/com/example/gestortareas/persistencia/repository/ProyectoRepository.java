package com.example.gestortareas.persistencia.repository;

import com.example.gestortareas.domain.Project;
import com.example.gestortareas.domain.repository.ProjectRepository;
import com.example.gestortareas.persistencia.crud.ProyectoCrudRepository;
import com.example.gestortareas.persistencia.entity.Proyecto;
import com.example.gestortareas.persistencia.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProyectoRepository implements ProjectRepository {

    @Autowired
    private ProyectoCrudRepository proyectoCrudRepository;
    @Autowired
    private ProjectMapper mapper;

    @Override
    public List<Project> getAllByProjects() {

        List<Proyecto> proyectos = (List<Proyecto>) proyectoCrudRepository.findAll();

        return mapper.toProjects(proyectos);
    }

    @Override
    public Optional<Project> getByName(String name) {
        Optional<Proyecto> proyecto = proyectoCrudRepository.findByNombre(name);

        return proyecto.map(pro -> mapper.toProject(pro));
    }

    @Override
    public List<Project> getByEstate(int estate) {
        List<Proyecto> projects = proyectoCrudRepository.findAllByEstado(estate);

        return mapper.toProjects(projects);
    }

    @Override
    public Optional<Project> getByProject(int projectId) {
        Optional<Proyecto> proyecto = proyectoCrudRepository.findById(projectId);

        return proyecto.map(pro -> mapper.toProject(pro));

    }

    @Override
    public Optional<List<Project>> getByUser(int userId) {
        Optional<List<Proyecto>> proyectos = proyectoCrudRepository.findAllByIdUsuario(userId);


        return proyectos.map(pro -> mapper.toProjects(pro));
    }

    @Override
    public Project createProject(Project project) {

        Proyecto proyecto = mapper.toProyecto(project);

        return mapper.toProject(proyectoCrudRepository.save(proyecto));
    }

    @Override
    public void deleteProject(int userId) {
        proyectoCrudRepository.deleteById(userId);
    }

    @Override
    public Project updateProject(Project project) {
        Proyecto proyecto = mapper.toProyecto(project);
        return mapper.toProject(proyectoCrudRepository.save(proyecto));

    }
}
