package fon.stefan.januarski_rok.service.impl;

import fon.stefan.januarski_rok.domain.*;
import fon.stefan.januarski_rok.dto.MemberDto;
import fon.stefan.januarski_rok.repository.*;
import fon.stefan.januarski_rok.service.MemberService;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

        Optional<EducationTitle> educationTitleSearch = educationTitleRepository.findByTitle(member.getEducationTitle());
        if(educationTitleSearch.isEmpty())
            throw new Exception("No existing education title with the name.");
        Optional<Department> departmentSearch = departmentRepository.findById(member.getDepartmentId());
        if(departmentSearch.isEmpty())
            throw new RuntimeException("Department with given id "+ member.getDepartmentId()+" doesn't exist.");
        result.setDepartment(departmentSearch.get());
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
