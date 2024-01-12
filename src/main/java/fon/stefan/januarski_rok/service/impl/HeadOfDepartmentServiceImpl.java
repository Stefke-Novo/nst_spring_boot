package fon.stefan.januarski_rok.service.impl;

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
        HeadOfDepartment result = listSearch.get().getLast();
        Department department = result.getMember().getDepartment();
        return new HeadOfDepartmentDto(new DepartmentDto(department.getId(),department.getName()),result.getMember().getId(),result.getId(),result.getMember().getFirstName(),result.getMember().getLastName(),result.getMember().getEducationTitle().getTitle());
    }

    @Override
    public List<HeadOfDepartmentDto> getAllHadOfDepartments() {
        return headOfDepartmentRepository.findAll().stream().map(h->new HeadOfDepartmentDto(new DepartmentDto(h.getMember().getDepartment().getId(),h.getMember().getDepartment().getName()),h.getMember().getId(),h.getId(),h.getMember().getFirstName(),h.getMember().getLastName(),h.getMember().getEducationTitle().getTitle())).toList();

    }

    @Override
    public List<HeadOfDepartmentDto> getHeadOfDepartmentHistory(DepartmentDto departmentDto) throws Exception {
        Optional<List<HeadOfDepartment>> listSearch = headOfDepartmentRepository.findByDepartmentId(departmentDto.getId());
        if(listSearch.isEmpty())
            throw new RuntimeException("Department with id "+ departmentDto.getId()+ "doesn't exist.");
        return listSearch.get().stream().map(h->new HeadOfDepartmentDto(new DepartmentDto(h.getMember().getDepartment().getId(),h.getMember().getDepartment().getName()),h.getMember().getId(),h.getId(),h.getMember().getFirstName(),h.getMember().getLastName(),h.getMember().getEducationTitle().getTitle())).toList();
    }

    @Override
    public HeadOfDepartmentDto createHeadOfDepartment(HeadOfDepartmentDto headOfDepartmentDto) throws Exception {
        Optional<Member> memberSearch = checkMember(headOfDepartmentDto);
        HeadOfDepartment headOfDepartment = new HeadOfDepartment(headOfDepartmentDto.getId(),memberSearch.get());
        headOfDepartment =headOfDepartmentRepository.save(headOfDepartment);
        return new HeadOfDepartmentDto(new DepartmentDto(headOfDepartment.getMember().getDepartment().getId(),headOfDepartment.getMember().getDepartment().getName()),headOfDepartment.getMember().getId(),headOfDepartment.getId(),headOfDepartment.getMember().getFirstName(),headOfDepartment.getMember().getLastName(),headOfDepartment.getMember().getEducationTitle().getTitle());
    }

    private Optional<Member> checkMember(HeadOfDepartmentDto headOfDepartmentDto) {
        Optional<Member> memberSearch = memberRepository.findById(new MemberId(headOfDepartmentDto.getMemberId(),new Department(headOfDepartmentDto.getDepartment().getId())));
        if(memberSearch.isEmpty())
            throw new RuntimeException("Member with id"+ headOfDepartmentDto.getMemberId()+" and department id "+ headOfDepartmentDto.getDepartment().getId()+" doesn't exist");
        return memberSearch;
    }

    @Override
    public HeadOfDepartmentDto deleteHeadOfDepartment(HeadOfDepartmentDto headOfDepartmentDto) throws Exception {
        Optional<Member> memberSearch = checkMember(headOfDepartmentDto);
        HeadOfDepartment headOfDepartment = new HeadOfDepartment(headOfDepartmentDto.getId(),memberSearch.get());
        headOfDepartmentRepository.delete(headOfDepartment);
        return headOfDepartmentDto;
    }
}
