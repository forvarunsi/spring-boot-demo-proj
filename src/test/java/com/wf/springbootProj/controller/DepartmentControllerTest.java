package com.wf.springbootProj.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wf.springbootProj.entity.Department;
import com.wf.springbootProj.service.DepartmentService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {DepartmentController.class})
@ExtendWith(SpringExtension.class)
class DepartmentControllerTest {
    @Autowired
    private DepartmentController departmentController;

    @MockBean
    private DepartmentService departmentService;

    /**
     * Method under test: {@link DepartmentController#saveDepartment(Department)}
     */
    @Test
    void testSaveDepartment() throws Exception {
        Department department = new Department();
        department.setDepartmentAddress("42 Main St");
        department.setDepartmentCode("Department Code");
        department.setDepartmentId(123L);
        department.setDepartmentName("Department Name");
        when(this.departmentService.saveDepartment((Department) any())).thenReturn(department);

        Department department1 = new Department();
        department1.setDepartmentAddress("42 Main St");
        department1.setDepartmentCode("Department Code");
        department1.setDepartmentId(123L);
        department1.setDepartmentName("Department Name");
        String content = (new ObjectMapper()).writeValueAsString(department1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.departmentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"departmentId\":123,\"departmentName\":\"Department Name\",\"departmentAddress\":\"42 Main St\",\"departmentCode"
                                        + "\":\"Department Code\"}"));
    }

    /**
     * Method under test: {@link DepartmentController#fetchDepartmentList()}
     */
    @Test
    void testFetchDepartmentList() throws Exception {
        when(this.departmentService.fetchDepartmentList()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/departments");
        MockMvcBuilders.standaloneSetup(this.departmentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link DepartmentController#fetchDepartmentList()}
     */
    @Test
    void testFetchDepartmentList2() throws Exception {
        when(this.departmentService.fetchDepartmentList()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/departments");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.departmentController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link DepartmentController#updateDepartment(Department, Long)}
     */
    @Test
    void testUpdateDepartment() throws Exception {
        Department department = new Department();
        department.setDepartmentAddress("42 Main St");
        department.setDepartmentCode("Department Code");
        department.setDepartmentId(123L);
        department.setDepartmentName("Department Name");
        when(this.departmentService.updateDepartment((Department) any(), (Long) any())).thenReturn(department);

        Department department1 = new Department();
        department1.setDepartmentAddress("42 Main St");
        department1.setDepartmentCode("Department Code");
        department1.setDepartmentId(123L);
        department1.setDepartmentName("Department Name");
        String content = (new ObjectMapper()).writeValueAsString(department1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/departments/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.departmentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"departmentId\":123,\"departmentName\":\"Department Name\",\"departmentAddress\":\"42 Main St\",\"departmentCode"
                                        + "\":\"Department Code\"}"));
    }

    /**
     * Method under test: {@link DepartmentController#deleteDepartmentById(Long)}
     */
    @Test
    void testDeleteDepartmentById() throws Exception {
        doNothing().when(this.departmentService).deleteDepartmentById((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/departments/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.departmentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Deleted Successfully"));
    }

    /**
     * Method under test: {@link DepartmentController#deleteDepartmentById(Long)}
     */
    @Test
    void testDeleteDepartmentById2() throws Exception {
        doNothing().when(this.departmentService).deleteDepartmentById((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/departments/{id}", 123L);
        deleteResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.departmentController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Deleted Successfully"));
    }
}

