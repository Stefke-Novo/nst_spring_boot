package fon.stefan.januarski_rok.service.impl;

import fon.stefan.januarski_rok.converter.impl.DepartmentSecretaryConverter;
import fon.stefan.januarski_rok.domain.Department;
import fon.stefan.januarski_rok.domain.DepartmentSecretary;
import fon.stefan.januarski_rok.domain.DepartmentSecretaryId;
import fon.stefan.januarski_rok.domain.Member;
import fon.stefan.januarski_rok.dto.DepartmentDto;
import fon.stefan.januarski_rok.dto.DepartmentSecretaryDto;
import fon.stefan.januarski_rok.dto.MemberDto;
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
        return departmentSecretaryRepository.findAll().stream().map(departmentSecretary -> new DepartmentSecretaryConverter().toDto(departmentSecretary)).toList();
    }

    @Override
    public DepartmentSecretaryDto deleteDepartmentSecretary(DepartmentSecretaryDto departmentSecretary) throws Exception {
        Optional<DepartmentSecretary> departmentSecretarySearch = departmentSecretaryRepository.findById(new DepartmentSecretaryId(departmentSecretary.getId(),new Member(departmentSecretary.getMemberDto().getId()),new Department(departmentSecretary.getDepartmentDto().getId())));
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
            throw new RuntimeException("Department doesn't have secretary list");
        if(departmentSecretaryList.get().isEmpty())
            throw new RuntimeException("Department secretary list is empty");
        DepartmentSecretary current = departmentSecretaryList.get().get(departmentSecretaryList.get().size()-1);
        return new DepartmentSecretaryConverter().toDto(current);
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
            throw new RuntimeException("Department secretary list doesn't exist.");
        if(departmentSecretarySearch.get().isEmpty())
            throw new RuntimeException("Department secretary list is empty.");
        return departmentSecretarySearch.get().stream().map(d->new DepartmentSecretaryConverter().toDto(d)).toList();
    }

    @Override
    public DepartmentSecretaryDto createDepartmentSecretary(DepartmentSecretaryDto departmentSecretaryDto) throws Exception {
        Optional<DepartmentSecretary> departmentSecretarySearch = departmentSecretaryRepository.findById(new DepartmentSecretaryId(departmentSecretaryDto.getId(),new Member(departmentSecretaryDto.getMemberDto().getId()),new Department(departmentSecretaryDto.getDepartmentDto().getId())));
        if(departmentSecretarySearch.isPresent())
            throw new RuntimeException("Department secretary already exist.");
        DepartmentSecretary departmentSecretary = departmentSecretaryRepository.save(new DepartmentSecretaryConverter().toEntity(departmentSecretaryDto));
        return new DepartmentSecretaryConverter().toDto(departmentSecretary);
    }
}
