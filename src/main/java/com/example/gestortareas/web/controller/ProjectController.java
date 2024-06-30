
package com.example.gestortareas.web.controller;

import com.example.gestortareas.domain.Project;
import com.example.gestortareas.domain.service.ProjectService;
import com.example.gestortareas.persistencia.entity.Proyecto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
@Tag(
        name = "Projects API",
        description = "Este controlador tiene todos los edpoint para realizar un crud"
)
public class ProjectController {


    @Autowired
    private ProjectService projectService;


    //todo los projects
    @Operation(summary = "Retorna proyectos", description = "Retorna todos los productos")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Proyectos recuperados con exito", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Project.class))
                    }),
                    @ApiResponse(responseCode ="404", description = "Proyectos no encontrados", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Project.class))
                    })
            }
    )
    @GetMapping("/v1/Projects")
    public List<Project> getAllByProjects() {

        return projectService.getAllByProjects();
    }

    //buscar por nombre
    @GetMapping("/V1/project/{name}")
    public Optional<Project> getByName(@PathVariable("name") String name) {
        projectService.getByName(name);

        return projectService.getByName(name);
    }

    //crear proyecto
    @PostMapping("/v1/project/create")
    public Project createProject(@RequestBody Project project) {

        return projectService.createProject(project);
    }

    //actualizar proyecto
    @PutMapping("/v1/project/update/{id}")
    public Project updateProject(@PathVariable("id") int projectId, @RequestBody Project project) {

        return projectService.updateProject(projectId, project);
    }

    //actualizar estado

    @PutMapping("/v1/project/update/estate/{id}")
    public Project updateEstate(@PathVariable("id") int projectId, @RequestBody Project project) {


        return projectService.updateEstate(projectId, project);
    }
}
