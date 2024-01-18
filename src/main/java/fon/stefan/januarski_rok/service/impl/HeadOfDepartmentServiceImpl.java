package fon.stefan.januarski_rok.service.impl;

import fon.stefan.januarski_rok.converter.impl.HeadOfDepartmentConverter;
import fon.stefan.januarski_rok.domain.Department;
import fon.stefan.januarski_rok.domain.HeadOfDepartment;
import fon.stefan.januarski_rok.domain.Member;
import fon.stefan.januarski_rok.domain.MemberId;
import fon.stefan.januarski_rok.dto.DepartmentDto;
import fon.stefan.januarski_rok.dto.HeadOfDepartmentDto;
import fon.stefan.januarski_rok.repository.HeadOfDepartmentRepository;
import fon.stefan.januarski_rok.repository.MemberRepository;
import fon.stefan.januarski_rok.service.HeadOfDepartmentService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class HeadOfDepartmentServiceImpl implements HeadOfDepartmentService {

    private final HeadOfDepartmentRepository headOfDepartmentRepository;
    private final MemberRepository memberRepository;

    public HeadOfDepartmentServiceImpl(HeadOfDepartmentRepository headOfDepartmentRepository, MemberRepository memberRepository){
        this.headOfDepartmentRepository = headOfDepartmentRepository;
        this.memberRepository=memberRepository;
    }
    @Override
    public HeadOfDepartmentDto getCurrentHeadOfDepartment(DepartmentDto departmentDto) throws Exception {
        Optional<List<HeadOfDepartment>> listSearch = headOfDepartmentRepository.findByDepartmentId(departmentDto.getId());
        if(listSearch.isEmpty())
            throw new RuntimeException("List is not geenrated.");
        if(listSearch.get().isEmpty())
            throw new RuntimeException("List for department with id "+departmentDto.getId()+" is empty.");
        HeadOfDepartment result = listSearch.get().get(listSearch.get().size()-1);
        return new HeadOfDepartmentConverter().toDto(result);

    }

    @Override
    public List<HeadOfDepartmentDto> getAllHadOfDepartments() {
        return headOfDepartmentRepository.findAll().stream().map(h->new HeadOfDepartmentConverter().toDto(h)).toList();
    }

    @Override
    public List<HeadOfDepartmentDto> getHeadOfDepartmentHistory(DepartmentDto departmentDto) throws Exception {
        Optional<List<HeadOfDepartment>> listSearch = headOfDepartmentRepository.findByDepartmentId(departmentDto.getId());
        if(listSearch.isEmpty())
            throw new RuntimeException("Department with id "+ departmentDto.getId()+ "doesn't exist.");
        return listSearch.get().stream().map(h->new HeadOfDepartmentConverter().toDto(h)).toList();
    }

    @Override
    public HeadOfDepartmentDto createHeadOfDepartment(HeadOfDepartmentDto headOfDepartmentDto) throws Exception {
        Optional<Member> memberSearch = checkMember(headOfDepartmentDto);
        HeadOfDepartment headOfDepartment = new HeadOfDepartmentConverter().toEntity(headOfDepartmentDto);
        headOfDepartment =headOfDepartmentRepository.save(headOfDepartment);
        return new HeadOfDepartmentConverter().toDto(headOfDepartment);
    }

    private Optional<Member> checkMember(HeadOfDepartmentDto headOfDepartmentDto) {
        Optional<Member> memberSearch = memberRepository.findById(headOfDepartmentDto.getMember().getId());
        if(memberSearch.isEmpty())
            throw new RuntimeException("Member with id"+ headOfDepartmentDto.getMember().getId()+" doesn't exist");
        return memberSearch;
    }

    @Override
    public HeadOfDepartmentDto deleteHeadOfDepartment(HeadOfDepartmentDto headOfDepartmentDto) throws Exception {
        Optional<Member> memberSearch = checkMember(headOfDepartmentDto);
        HeadOfDepartment headOfDepartment = new HeadOfDepartmentConverter().toEntity(headOfDepartmentDto);
        headOfDepartmentRepository.delete(headOfDepartment);
        return headOfDepartmentDto;
    }
}
