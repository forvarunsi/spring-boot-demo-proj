package com.wf.springbootProj.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.wf.springbootProj.entity.Department;
import com.wf.springbootProj.repository.DepartmentRepository;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DepartmentServiceImpl.class})
@ExtendWith(SpringExtension.class)
class DepartmentServiceImplTest {
    @MockBean
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentServiceImpl departmentServiceImpl;

    /**
     * Method under test: {@link DepartmentServiceImpl#saveDepartment(Department)}
     */
    @Test
    void testSaveDepartment() {
        Department department = new Department();
        department.setDepartmentAddress("42 Main St");
        department.setDepartmentCode("Department Code");
        department.setDepartmentId(123L);
        department.setDepartmentName("Department Name");
        when(this.departmentRepository.save((Department) any())).thenReturn(department);

        Department department1 = new Department();
        department1.setDepartmentAddress("42 Main St");
        department1.setDepartmentCode("Department Code");
        department1.setDepartmentId(123L);
        department1.setDepartmentName("Department Name");
        assertSame(department, this.departmentServiceImpl.saveDepartment(department1));
        verify(this.departmentRepository).save((Department) any());
    }

    /**
     * Method under test: {@link DepartmentServiceImpl#fetchDepartmentList()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFetchDepartmentList() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.wf.springbootProj.service.DepartmentServiceImpl.fetchDepartmentList(DepartmentServiceImpl.java:32)
        //   In order to prevent fetchDepartmentList()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   fetchDepartmentList().
        //   See https://diff.blue/R013 to resolve this issue.

        (new DepartmentServiceImpl()).fetchDepartmentList();
    }

    /**
     * Method under test: {@link DepartmentServiceImpl#updateDepartment(Department, Long)}
     */
    @Test
    void testUpdateDepartment() {
        Department department = new Department();
        department.setDepartmentAddress("42 Main St");
        department.setDepartmentCode("Department Code");
        department.setDepartmentId(123L);
        department.setDepartmentName("Department Name");
        Optional<Department> ofResult = Optional.of(department);

        Department department1 = new Department();
        department1.setDepartmentAddress("42 Main St");
        department1.setDepartmentCode("Department Code");
        department1.setDepartmentId(123L);
        department1.setDepartmentName("Department Name");
        when(this.departmentRepository.save((Department) any())).thenReturn(department1);
        when(this.departmentRepository.findById((Long) any())).thenReturn(ofResult);

        Department department2 = new Department();
        department2.setDepartmentAddress("42 Main St");
        department2.setDepartmentCode("Department Code");
        department2.setDepartmentId(123L);
        department2.setDepartmentName("Department Name");
        assertSame(department1, this.departmentServiceImpl.updateDepartment(department2, 123L));
        verify(this.departmentRepository).save((Department) any());
        verify(this.departmentRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link DepartmentServiceImpl#updateDepartment(Department, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateDepartment2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.wf.springbootProj.service.DepartmentServiceImpl.updateDepartment(DepartmentServiceImpl.java:44)
        //   In order to prevent updateDepartment(Department, Long)
        //   from throwing NoSuchElementException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateDepartment(Department, Long).
        //   See https://diff.blue/R013 to resolve this issue.

        Department department = new Department();
        department.setDepartmentAddress("42 Main St");
        department.setDepartmentCode("Department Code");
        department.setDepartmentId(123L);
        department.setDepartmentName("Department Name");
        when(this.departmentRepository.save((Department) any())).thenReturn(department);
        when(this.departmentRepository.findById((Long) any())).thenReturn(Optional.empty());

        Department department1 = new Department();
        department1.setDepartmentAddress("42 Main St");
        department1.setDepartmentCode("Department Code");
        department1.setDepartmentId(123L);
        department1.setDepartmentName("Department Name");
        this.departmentServiceImpl.updateDepartment(department1, 123L);
    }

    /**
     * Method under test: {@link DepartmentServiceImpl#updateDepartment(Department, Long)}
     */
    @Test
    void testUpdateDepartment3() {
        Department department = new Department();
        department.setDepartmentAddress("42 Main St");
        department.setDepartmentCode("Department Code");
        department.setDepartmentId(123L);
        department.setDepartmentName("Department Name");
        Optional<Department> ofResult = Optional.of(department);

        Department department1 = new Department();
        department1.setDepartmentAddress("42 Main St");
        department1.setDepartmentCode("Department Code");
        department1.setDepartmentId(123L);
        department1.setDepartmentName("Department Name");
        when(this.departmentRepository.save((Department) any())).thenReturn(department1);
        when(this.departmentRepository.findById((Long) any())).thenReturn(ofResult);
        Department department2 = mock(Department.class);
        when(department2.getDepartmentAddress()).thenReturn("");
        when(department2.getDepartmentCode()).thenReturn("Department Code");
        when(department2.getDepartmentName()).thenReturn("Department Name");
        doNothing().when(department2).setDepartmentAddress((String) any());
        doNothing().when(department2).setDepartmentCode((String) any());
        doNothing().when(department2).setDepartmentId((Long) any());
        doNothing().when(department2).setDepartmentName((String) any());
        department2.setDepartmentAddress("42 Main St");
        department2.setDepartmentCode("Department Code");
        department2.setDepartmentId(123L);
        department2.setDepartmentName("Department Name");
        assertSame(department1, this.departmentServiceImpl.updateDepartment(department2, 123L));
        verify(this.departmentRepository).save((Department) any());
        verify(this.departmentRepository).findById((Long) any());
        verify(department2, atLeast(1)).getDepartmentAddress();
        verify(department2, atLeast(1)).getDepartmentCode();
        verify(department2, atLeast(1)).getDepartmentName();
        verify(department2).setDepartmentAddress((String) any());
        verify(department2).setDepartmentCode((String) any());
        verify(department2).setDepartmentId((Long) any());
        verify(department2).setDepartmentName((String) any());
    }

    /**
     * Method under test: {@link DepartmentServiceImpl#updateDepartment(Department, Long)}
     */
    @Test
    void testUpdateDepartment4() {
        Department department = new Department();
        department.setDepartmentAddress("42 Main St");
        department.setDepartmentCode("Department Code");
        department.setDepartmentId(123L);
        department.setDepartmentName("Department Name");
        Optional<Department> ofResult = Optional.of(department);

        Department department1 = new Department();
        department1.setDepartmentAddress("42 Main St");
        department1.setDepartmentCode("Department Code");
        department1.setDepartmentId(123L);
        department1.setDepartmentName("Department Name");
        when(this.departmentRepository.save((Department) any())).thenReturn(department1);
        when(this.departmentRepository.findById((Long) any())).thenReturn(ofResult);
        Department department2 = mock(Department.class);
        when(department2.getDepartmentAddress()).thenReturn("42 Main St");
        when(department2.getDepartmentCode()).thenReturn("");
        when(department2.getDepartmentName()).thenReturn("Department Name");
        doNothing().when(department2).setDepartmentAddress((String) any());
        doNothing().when(department2).setDepartmentCode((String) any());
        doNothing().when(department2).setDepartmentId((Long) any());
        doNothing().when(department2).setDepartmentName((String) any());
        department2.setDepartmentAddress("42 Main St");
        department2.setDepartmentCode("Department Code");
        department2.setDepartmentId(123L);
        department2.setDepartmentName("Department Name");
        assertSame(department1, this.departmentServiceImpl.updateDepartment(department2, 123L));
        verify(this.departmentRepository).save((Department) any());
        verify(this.departmentRepository).findById((Long) any());
        verify(department2, atLeast(1)).getDepartmentAddress();
        verify(department2, atLeast(1)).getDepartmentCode();
        verify(department2, atLeast(1)).getDepartmentName();
        verify(department2).setDepartmentAddress((String) any());
        verify(department2).setDepartmentCode((String) any());
        verify(department2).setDepartmentId((Long) any());
        verify(department2).setDepartmentName((String) any());
    }

    /**
     * Method under test: {@link DepartmentServiceImpl#updateDepartment(Department, Long)}
     */
    @Test
    void testUpdateDepartment5() {
        Department department = new Department();
        department.setDepartmentAddress("42 Main St");
        department.setDepartmentCode("Department Code");
        department.setDepartmentId(123L);
        department.setDepartmentName("Department Name");
        Optional<Department> ofResult = Optional.of(department);

        Department department1 = new Department();
        department1.setDepartmentAddress("42 Main St");
        department1.setDepartmentCode("Department Code");
        department1.setDepartmentId(123L);
        department1.setDepartmentName("Department Name");
        when(this.departmentRepository.save((Department) any())).thenReturn(department1);
        when(this.departmentRepository.findById((Long) any())).thenReturn(ofResult);
        Department department2 = mock(Department.class);
        when(department2.getDepartmentAddress()).thenReturn("42 Main St");
        when(department2.getDepartmentCode()).thenReturn("Department Code");
        when(department2.getDepartmentName()).thenReturn("");
        doNothing().when(department2).setDepartmentAddress((String) any());
        doNothing().when(department2).setDepartmentCode((String) any());
        doNothing().when(department2).setDepartmentId((Long) any());
        doNothing().when(department2).setDepartmentName((String) any());
        department2.setDepartmentAddress("42 Main St");
        department2.setDepartmentCode("Department Code");
        department2.setDepartmentId(123L);
        department2.setDepartmentName("Department Name");
        assertSame(department1, this.departmentServiceImpl.updateDepartment(department2, 123L));
        verify(this.departmentRepository).save((Department) any());
        verify(this.departmentRepository).findById((Long) any());
        verify(department2, atLeast(1)).getDepartmentAddress();
        verify(department2, atLeast(1)).getDepartmentCode();
        verify(department2, atLeast(1)).getDepartmentName();
        verify(department2).setDepartmentAddress((String) any());
        verify(department2).setDepartmentCode((String) any());
        verify(department2).setDepartmentId((Long) any());
        verify(department2).setDepartmentName((String) any());
    }

    /**
     * Method under test: {@link DepartmentServiceImpl#deleteDepartmentById(Long)}
     */
    @Test
    void testDeleteDepartmentById() {
        doNothing().when(this.departmentRepository).deleteById((Long) any());
        this.departmentServiceImpl.deleteDepartmentById(123L);
        verify(this.departmentRepository).deleteById((Long) any());
    }
}

