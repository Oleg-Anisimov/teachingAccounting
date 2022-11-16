package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.Department;
import me.anisimov.teachingAccounting.dto.DepartmentDto;
import me.anisimov.teachingAccounting.repository.DepartmentRepository;
import org.dozer.DozerBeanMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ModelMapper mapper;

    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setId(departmentDto.getId());
        department.setName(departmentDto.getName());
        departmentRepository.save(department);
        return mapper.map(department, DepartmentDto.class);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    public void updateDepartment(Department department) {
        departmentRepository.save(department);
    }

    public Department getById(Long id) {
        return departmentRepository.getReferenceById(id);
    }

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }
}
