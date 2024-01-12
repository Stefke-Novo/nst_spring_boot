package fon.stefan.januarski_rok.service.impl;

import fon.stefan.januarski_rok.domain.*;
import fon.stefan.januarski_rok.dto.*;
import fon.stefan.januarski_rok.repository.*;
import fon.stefan.januarski_rok.service.AcademicTitleHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicTitleHistoryServiceImpl implements AcademicTitleHistoryService {

    private final AcademicTitleHistoryRepository academicTitleHistoryRepository;
    private final MemberRepository memberRepository;
    private final ScientificFieldRepository scientificFieldRepository;
    private final DepartmentRepository departmentRepository;
    private final AcademicTitleRepository academicTitleRepository;
    public AcademicTitleHistoryServiceImpl(AcademicTitleHistoryRepository academicTitleHistoryRepository,MemberRepository memberRepository, ScientificFieldRepository scientificFieldRepository, DepartmentRepository departmentRepository, AcademicTitleRepository academicTitleRepository){
        this.memberRepository=memberRepository;
        this.academicTitleHistoryRepository = academicTitleHistoryRepository;
        this.departmentRepository=departmentRepository;
        this.academicTitleRepository=academicTitleRepository;
        this.scientificFieldRepository=scientificFieldRepository;
    }
    @Override
    public List<AcademicTitleHistoryDto> getHistory(MemberDto memberDto) throws Exception {
        checkMember(memberDto);
        Optional<List<AcademicTitleHistory>> list = academicTitleHistoryRepository.findByDepartmentIdAndMemberId(memberDto.getDepartmentId(),memberDto.getId());
        if(list.isEmpty())
            throw new RuntimeException("Member entity can't receive academic title history.");
        return list.get().stream().map(AcademicTitleHistoryServiceImpl::ConvertToAcademicTitleHistoryDto).toList();
    }

    private static AcademicTitleHistoryDto ConvertToAcademicTitleHistoryDto(AcademicTitleHistory a) {
        return new AcademicTitleHistoryDto(
                new MemberDto(
                        a.getMember().getDepartment().getId(),
                        a.getMember().getId(),
                        a.getMember().getFirstName(),
                        a.getMember().getLastName(),
                        a.getMember().getEducationTitle().getTitle(),
                        a.getAcademicTitle().getTitle(),
                        a.getScientificField().getName()
                ),
                new DepartmentDto(
                        a.getMember().getDepartment().getId(),
                        a.getMember().getDepartment().getName()
                ),
                new AcademicTitleDto(
                        a.getAcademicTitle().getId(),
                        a.getAcademicTitle().getTitle()
                ),
                new ScientificFieldDto(
                        a.getScientificField().getId(),
                        a.getScientificField().getName()
                ),
                AcademicTitleHistoryDto.toString(a.getStartDate()),
                AcademicTitleHistoryDto.toString(a.getEndDate())
        );
    }

    private Member checkMember(MemberDto memberDto) {
        Optional<Member> memberSearch = memberRepository.findById(new MemberId(memberDto.getId(),new Department(memberDto.getDepartmentId())));
        if(memberSearch.isEmpty())
            throw new RuntimeException("Member with id "+ memberDto.getId()+" and department id "+ memberDto.getDepartmentId()+" doesn't exist.");
        return memberSearch.get();
    }

    @Override
    public List<AcademicTitleHistoryDto> getAll() {
        return academicTitleHistoryRepository.
                findAll().stream().map(AcademicTitleHistoryServiceImpl::ConvertToAcademicTitleHistoryDto).toList();
    }

    @Override
    public List<AcademicTitleHistoryDto> addHistory(List<AcademicTitleHistoryDto> history) throws Exception {
        MemberDto memberDto = history.getFirst().getMemberDto();
        Member member = checkMember(memberDto);
        academicTitleHistoryRepository.saveAll(member.getAcademicTitles());
        Optional<List<AcademicTitleHistory>> list = academicTitleHistoryRepository.findByDepartmentIdAndMemberId(memberDto.getDepartmentId(),memberDto.getId());
        if(list.isEmpty())
            throw new RuntimeException("Member with id "+ memberDto.getId()+" in departemnt "+member.getDepartment().getId()+" doesn't exist");

        return list.get().stream().map(AcademicTitleHistoryServiceImpl::ConvertToAcademicTitleHistoryDto).toList();
    }

    @Override
    public List<AcademicTitleHistoryDto> addAcademicTitle(AcademicTitleHistoryDto academicTitleHistoryDto) throws Exception {
        Optional<Department> department = departmentRepository.findById(academicTitleHistoryDto.getDepartmentDto().getId());
        if(department.isEmpty())
            throw new RuntimeException("Department with id "+academicTitleHistoryDto.getDepartmentDto().getId()+" doesn't exist");
        Optional<Member> member = memberRepository.findById(new MemberId(academicTitleHistoryDto.getMemberDto().getId(),department.get()));
        if(member.isEmpty())
            throw new RuntimeException("Member with id "+academicTitleHistoryDto.getMemberDto().getId()+" in department with id "+academicTitleHistoryDto.getDepartmentDto().getId()+" doesn't exist");
        Optional<AcademicTitle> academicTitle = academicTitleRepository.findById(academicTitleHistoryDto.getAcademicTitleDto().getId());
        if(academicTitle.isEmpty())
            throw new RuntimeException("Academic title with id "+academicTitleHistoryDto.getAcademicTitleDto().getId()+" doesn't exist.");
        Optional<ScientificField> scientificField = scientificFieldRepository.findById(academicTitleHistoryDto.getScientificFieldDto().getId());
        if(scientificField.isEmpty())
            throw new Exception("Scientific field with id "+academicTitleHistoryDto.getScientificFieldDto().getId()+" doesn't exist.");

        AcademicTitleHistory academicTitleHistory = new AcademicTitleHistory(
                member.get(),
                academicTitle.get(),
                scientificField.get(),
                AcademicTitleHistoryDto.toDate(academicTitleHistoryDto.getStartDate()),
                AcademicTitleHistoryDto.toDate(academicTitleHistoryDto.getEndDate())
        );
        if(academicTitleHistoryRepository.existsById(new AcademicTitleHistoryId(academicTitleHistory.getMember(),academicTitleHistory.getAcademicTitle())))
            throw new RuntimeException("Entity is already created.");
        academicTitleHistoryRepository.save(academicTitleHistory);
        Optional<List<AcademicTitleHistory>> list = academicTitleHistoryRepository.findByDepartmentIdAndMemberId(academicTitleHistoryDto.getDepartmentDto().getId(),academicTitleHistoryDto.getMemberDto().getId());
        if(list.isEmpty())
            throw new RuntimeException("Member and department don't exist");
        return list.get().stream().map(AcademicTitleHistoryServiceImpl::ConvertToAcademicTitleHistoryDto).toList();
    }
}
