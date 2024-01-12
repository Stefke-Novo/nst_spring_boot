package fon.stefan.januarski_rok.service.impl;

import fon.stefan.januarski_rok.domain.Department;
import fon.stefan.januarski_rok.domain.DepartmentSecretary;
import fon.stefan.januarski_rok.domain.DepartmentSecretaryId;
import fon.stefan.januarski_rok.domain.Member;
import fon.stefan.januarski_rok.dto.DepartmentDto;
import fon.stefan.januarski_rok.dto.DepartmentSecretaryDto;
import fon.stefan.januarski_rok.repository.DepartmentRepository;
import fon.stefan.januarski_rok.repository.DepartmentSecretaryRepository;
import fon.stefan.januarski_rok.service.DepartmentSecretaryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentSecretaryServiceImpl implements DepartmentSecretaryService {

    private final DepartmentSecretaryRepository departmentSecretaryRepository;
    private final DepartmentRepository departmentRepository;
    public DepartmentSecretaryServiceImpl(DepartmentSecretaryRepository departmentSecretaryRepository, DepartmentRepository departmentRepository){
        this.departmentSecretaryRepository=departmentSecretaryRepository;
        this.departmentRepository = departmentRepository;
    }
    @Override
    public List<DepartmentSecretaryDto> getAllDepartmentSecretaries() {
        return departmentSecretaryRepository.findAll().stream().map(
                departmentSecretary -> new DepartmentSecretaryDto(
                        new DepartmentDto(
                                departmentSecretary.getMember().getDepartment().getId(),
                                departmentSecretary.getMember().getDepartment().getName()),departmentSecretary.getId(),departmentSecretary.getMember().getFirstName(),departmentSecretary.getMember().getLastName(),departmentSecretary.getMember().getEducationTitle().getTitle())).toList();
    }

    @Override
    public DepartmentSecretaryDto deleteDepartmentSecretary(DepartmentSecretaryDto departmentSecretary) throws Exception {
        Optional<DepartmentSecretary> departmentSecretarySearch = departmentSecretaryRepository.findById(new DepartmentSecretaryId(departmentSecretary.getMemberId(),new Member(departmentSecretary.getDepartmentDto().getId(),departmentSecretary.getMemberId())));
        if(departmentSecretarySearch.isEmpty())
            throw new RuntimeException("Department secretary doesn't exist.");
        DepartmentSecretary result = departmentSecretarySearch.get();
        departmentSecretaryRepository.delete(result);
        return departmentSecretary;
    }

    @Override
    public DepartmentSecretaryDto currentDepartmentSecretary(DepartmentDto departmentDto) throws Exception {
        Optional<List<DepartmentSecretary>> departmentSecretaryList = getDepartmentSecretariesByDepartment(departmentDto);
        if(departmentSecretaryList.isEmpty())
            throw new RuntimeException("Department doesn't have secretary");
        DepartmentSecretary current = departmentSecretaryList.get().getLast();
        Department department = current.getMember().getDepartment();
        return new DepartmentSecretaryDto(new DepartmentDto(department.getId(),department.getName()),current.getMember().getId(),current.getMember().getFirstName(),current.getMember().getLastName(),current.getMember().getEducationTitle().getTitle());
    }

    private Optional<List<DepartmentSecretary>> getDepartmentSecretariesByDepartment(DepartmentDto departmentDto) {
        findDepartment(departmentDto);
        return departmentSecretaryRepository.findByDepartmentId(departmentDto.getId());
    }

    private void findDepartment(DepartmentDto departmentDto) {
        Optional<Department> departmentSearch = departmentRepository.findById(departmentDto.getId());
        if(departmentSearch.isEmpty())
            throw new RuntimeException("Department with id "+ departmentDto.getId() +" doesn't exist.");
    }

    @Override
    public List<DepartmentSecretaryDto> getDepartmentSecretaryHistory(DepartmentDto departmentDto) throws Exception {
        Optional<List<DepartmentSecretary>> departmentSecretarySearch = getDepartmentSecretariesByDepartment(departmentDto);
        if(departmentSecretarySearch.isEmpty())
            throw new RuntimeException("Department secretary list doesn't exist");
        return departmentSecretarySearch.get().stream().map(d->new DepartmentSecretaryDto(new DepartmentDto(d.getMember().getDepartment().getId(),d.getMember().getDepartment().getName()),d.getMember().getId(),d.getMember().getFirstName(),d.getMember().getLastName(),d.getMember().getEducationTitle().getTitle())).toList();
    }

    @Override
    public DepartmentSecretaryDto createDepartemntSecretary(DepartmentSecretaryDto departmentSecretaryDto) throws Exception {
        Optional<DepartmentSecretary> departmentSecretarySearch = departmentSecretaryRepository.findById(new DepartmentSecretaryId(departmentSecretaryDto.getMemberId(),new Member(departmentSecretaryDto.getDepartmentDto().getId(),departmentSecretaryDto.getMemberId())));
        if(departmentSecretarySearch.isPresent())
            throw new RuntimeException("Department secretary already exist.");
        DepartmentSecretary departmentSecretary = departmentSecretaryRepository.save(new DepartmentSecretary(departmentSecretaryDto.getId(),departmentSecretaryDto.getDepartmentDto().getId(),departmentSecretaryDto.getMemberId()));
        Department department = departmentSecretary.getMember().getDepartment();

        return new DepartmentSecretaryDto(new DepartmentDto(department.getId(),department.getName()),departmentSecretary.getMember().getId(),departmentSecretary.getMember().getFirstName(),departmentSecretary.getMember().getLastName(),departmentSecretary.getMember().getEducationTitle().getTitle());
    }
}
