package com.cgsc.task.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(properties = {
        "spring.flyway.enabled=false",
        "spring.jpa.properties.hibernate.default_schema=",
        "spring.jpa.hibernate.ddl-auto=create-drop",
})
class GithubRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getProjects() throws Exception {

        mockMvc.perform(get("/api/search/projects")
                .contentType(MediaType.APPLICATION_JSON)
                .queryParam("publicProject", "true")
                .queryParam("page", "2")
                .queryParam("perPage", "10")
        ).andExpect(status().isOk());

    }

    @Test
    void getProjectsShouldReturn400WhenPageGreaterThan100() throws Exception {

        mockMvc.perform(get("/api/search/projects")
                .contentType(MediaType.APPLICATION_JSON)
                .queryParam("publicProject", "true")
                .queryParam("page", "2")
                .queryParam("perPage", "200")
        ).andExpect(status().isBadRequest());

    }

    @Test
    void getContributors() throws Exception {

        mockMvc.perform(get("/api/search/repos/{}/{}/contributors", "dodola", "WeexOne")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

    }

    @Test
    void getProjectCommits() {
    }
}
