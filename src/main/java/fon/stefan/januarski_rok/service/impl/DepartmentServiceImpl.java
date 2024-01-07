package fon.stefan.januarski_rok.service.impl;

import fon.stefan.januarski_rok.converter.impl.DepartmentConverter;
import fon.stefan.januarski_rok.domain.Department;
import fon.stefan.januarski_rok.dto.DepartmentDto;
import fon.stefan.januarski_rok.exception.DepartmentAlreadyExistException;
import fon.stefan.januarski_rok.repository.DepartmentRepository;
import fon.stefan.januarski_rok.service.DepartmentService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentConverter departmentConverter;
    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(
            DepartmentRepository departmentRepository,
            DepartmentConverter departmentConverter) {
        this.departmentRepository = departmentRepository;
        this.departmentConverter = departmentConverter;
    }

    @Override
    public DepartmentDto save(DepartmentDto departmentDto) throws Exception {
        Optional<Department> dept = departmentRepository.findByName(departmentDto.getName());
        if (dept.isPresent()) {
            throw new DepartmentAlreadyExistException("Department sa tim imenom postoji!");
        } else {
            //DTO - > Entity
            //Department department = new Department(departmentDto.getId(), departmentDto.getName());
            Department department = departmentConverter.toEntity(departmentDto);
            department = departmentRepository.save(department);
            return departmentConverter.toDto(department);
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        //proveri da li postoji department
        Optional<Department> dept = departmentRepository.findById(id);
        if (dept.isPresent()) {
            //postoji
            Department department = dept.get();
            departmentRepository.delete(department);
        } else {
            throw new Exception("Department does not exist!");
        }

    }

    @Override
    public void update(DepartmentDto department) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DepartmentDto findById(Long id) throws Exception {
        Optional<Department> dept = departmentRepository.findById(id);
        if (dept.isPresent()) {
            //postoji
            Department department = dept.get();
            return departmentConverter.toDto(department);
        } else {
            throw new Exception("Department does not exist!");
        }
    }

    @Override
    public List<DepartmentDto> getAll(Pageable pageable) {
        return departmentRepository
                .findAll(pageable).getContent()
                .stream().map(entity -> departmentConverter.toDto(entity))
                .collect(Collectors.toList());
    }
    @Override
    public List<DepartmentDto> getAll() {
        return departmentRepository
                .findAll()
                .stream().map(entity -> departmentConverter.toDto(entity))
                .collect(Collectors.toList());
    }
}
