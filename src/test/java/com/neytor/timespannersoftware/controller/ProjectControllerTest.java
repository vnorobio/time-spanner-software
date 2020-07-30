package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.dto.Project;
import com.neytor.timespannersoftware.model.ProjectEntity;
import com.neytor.timespannersoftware.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ProjectController.class)
public class ProjectControllerTest {

    private final MockMvc mockMvc;

    private static final String PROJECT_JSON = "{ \"id\": 1, \"code\": \"codigo1\", \"description\": \"descripcion1\"}";

    @InjectMocks
    private ProjectController controller;

    @MockBean
    private ProjectService service;

    @Autowired
    public ProjectControllerTest(MockMvc mockMvc, ProjectController controller) {
        this.mockMvc = mockMvc;
        this.controller = controller;
    }

    @Test
    void findAll() throws Exception{
        // given
        ProjectEntity entity1 = new ProjectEntity();
        ProjectEntity entity2 = new ProjectEntity();
        List entities = Arrays.asList(entity1,entity2);

        given(service.findAll()).willReturn(entities);

        // when
        ResponseEntity<List<Project>> responseEntity = controller.findAll();

        // then
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/catalogs/v1/project/all"))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    void finById() throws Exception{
        ProjectEntity entity1 = new ProjectEntity(1L,"codigo","descripcion" );
        given(service.findById(2L)).willReturn(Optional.of(entity1));

        ResponseEntity<Project> responseEntity = controller.finById(2L);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/catalogs/v1/project/id/{id}",2))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());

    }

    @Test
    void findByDescription() throws Exception{
        ProjectEntity entity1 = new ProjectEntity(1L,"codigo1","descripcion1" );
        ProjectEntity entity2 = new ProjectEntity(2L,"codigo2","descripcion2" );
        List entities = Arrays.asList(entity1,entity2);
        given(service.findByDescriptionContaining("descripcion")).willReturn(entities);

        ResponseEntity<List<Project>> response = (controller.findByDescription("descripcion"));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/catalogs/v1/project/description/{description}","descripcion"))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    void create() throws Exception{
        ProjectEntity entity1 = new ProjectEntity(1L,"codigo1","descripcion1" );
        given(service.create(any(ProjectEntity.class))).willReturn(entity1);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/catalogs/v1/project/").content(PROJECT_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    void update() throws Exception {
        ProjectEntity entity1 = new ProjectEntity(1L,"codigo1","descripcion1" );
        Project projectDto = new Project(1L,"codigo1","descripcion1" );
        given(service.findById(1L)).willReturn(Optional.of(entity1));
        given(service.update(entity1)).willReturn(entity1);

        ResponseEntity<Project> responseEntity = controller.update(projectDto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/catalogs/v1/project/").content(PROJECT_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());

    }

    @Test
    void delete() throws Exception  {
        given(service.existsById(1L)).willReturn(Boolean.TRUE);
        doNothing().when(service).delete(1L);

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/catalogs/v1/project/{id}",1))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

    }
}
