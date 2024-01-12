package fon.stefan.januarski_rok.service.impl;

import fon.stefan.januarski_rok.domain.*;
import fon.stefan.januarski_rok.dto.MemberDto;
import fon.stefan.januarski_rok.repository.*;
import fon.stefan.januarski_rok.service.MemberService;
import org.hibernate.SessionFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final DepartmentRepository departmentRepository;
    private final AcademicTitleRepository academicTitleRepository;
    private final ScientificFieldRepository scientificFieldRepository;
    private final AcademicTitleHistoryRepository academicTitleHistoryRepository;
    private SessionFactory hibernateFactory;
    private final EducationTitleRepository educationTitleRepository;
    public MemberServiceImpl(MemberRepository memberRepository,
                             DepartmentRepository departmentRepository,
                             AcademicTitleRepository academicTitleRepository,
                             ScientificFieldRepository scientificFieldRepository,
                             AcademicTitleHistoryRepository academicTitleHistoryRepository,
                             EducationTitleRepository educationTitleRepository){
        this.memberRepository=memberRepository;
        this.departmentRepository = departmentRepository;
        this.academicTitleRepository=academicTitleRepository;
        this.scientificFieldRepository = scientificFieldRepository;
        this.academicTitleHistoryRepository = academicTitleHistoryRepository;
        this.educationTitleRepository = educationTitleRepository;
    }
    @Override
    public MemberDto createMember(MemberDto member) throws Exception {
        Member result = new Member(member.getDepartmentId(),member.getId(),member.getFirstName(),member.getLastName(),member.getAcademicTitle(),member.getEducationTitle(),member.getScientificField());

        checkEducationTitle(member, result);
        ckeckDepartment(member, result);
        //TO DO : popuniti stari date za Member-a
        savingAcademicTitle(result);
        savingMember(result);
        savingScientificField(result);
        result.setId(result.getAcademicTitles().getFirst().getMember().getId());
        academicTitleHistoryRepository.save(result.getAcademicTitles().getFirst());
        MemberDto resultDto = new MemberDto(result.getDepartment().getId(),result.getId(),result.getFirstName(),result.getLastName(),result.getEducationTitle(),result.getAcademicTitles().getFirst(),result.getAcademicTitles().getFirst().getAcademicTitle(),result.getAcademicTitles().getFirst().getScientificField());
        resultDto.setFirstName(result.getFirstName());
        resultDto.setLastName(result.getLastName());
        resultDto.setEducationTitle(result.getEducationTitle().getTitle());
        return resultDto;
    }

    @Override
    public MemberDto getMember(MemberDto member) throws Exception {
        Optional<Member> memberSearch = memberRepository.findById(new MemberId(member.getId(),new Department(member.getDepartmentId())));
        if(memberSearch.isEmpty())
            throw new RuntimeException("Member with department id "+member.getDepartmentId()+" and id "+member.getId()+" doesn't exist.");
        Member result = memberSearch.get();
        return new MemberDto(result.getDepartment().getId(),result.getId(),result.getFirstName(),result.getLastName(),result.getEducationTitle());
    }

    @Override
    public List<MemberDto> getAllMembers() {
        return memberRepository.findAll().stream().map(member->new MemberDto(member.getDepartment().getId(),member.getId(),member.getFirstName(),member.getLastName(),member.getEducationTitle())).toList();
    }

    @Override
    public MemberDto updateMember(MemberDto member) throws Exception {
        Optional<Member> memberSearch = memberRepository.findById(new MemberId(member.getId(),new Department(member.getId())));
        if(memberSearch.isEmpty())
            throw new RuntimeException("Member with id "+member.getId()+"and department id"+member.getDepartmentId()+" doesn't exist.");
        Member result = memberSearch.get();
        checkEducationTitle(member,result);
        result.setFirstName(member.getFirstName());
        result.setLastName(member.getLastName());
        result = memberRepository.save(result);
        return new MemberDto(result.getDepartment().getId(),result.getId(),result.getFirstName(),result.getLastName(),result.getEducationTitle());
    }

    @Override
    public MemberDto deleteMember(MemberDto member) throws Exception {
        Member result = new Member();
        findMember(member,result);
        memberRepository.delete(result);
        Optional<Member> memberSearch = memberRepository.findById(new MemberId(member.getId(),new Department(member.getDepartmentId())));
        if(memberSearch.isPresent())
            throw new RuntimeException("Member data must be deleted first.");
        return member;
    }


    private void ckeckDepartment(MemberDto member, Member result) {
        findMember(member, result);
    }

    private void findMember(MemberDto member, Member result) {
        Optional<Department> departmentSearch = departmentRepository.findById(member.getDepartmentId());
        if(departmentSearch.isEmpty())
            throw new RuntimeException("Department with given id "+ member.getDepartmentId()+" doesn't exist.");
        result.setDepartment(departmentSearch.get());
    }

    private void checkEducationTitle(MemberDto member, Member result) throws Exception {
        Optional<EducationTitle> educationTitleSearch = educationTitleRepository.findByTitle(member.getEducationTitle());
        if(educationTitleSearch.isEmpty())
            throw new Exception("No existing education title with the name.");
        result.setEducationTitle(educationTitleSearch.get());
    }

    private void savingAcademicTitle(Member result) {
        AcademicTitle academicTitle = academicTitleRepository.saveAndFlush(result.getAcademicTitles().getFirst().getAcademicTitle());
        result.getAcademicTitles().getFirst().setAcademicTitle(academicTitle);
    }
    private void savingMember(Member result){
        Member memberReference = memberRepository.saveAndFlush(result.getAcademicTitles().getFirst().getMember());
        result.getAcademicTitles().getFirst().setMember(memberReference);
    }

    private void savingScientificField(Member result){
        ScientificField scientificFieldReference = scientificFieldRepository.saveAndFlush(result.getAcademicTitles().getFirst().getScientificField());
        result.getAcademicTitles().getFirst().setScientificField(scientificFieldReference);
    }


}
