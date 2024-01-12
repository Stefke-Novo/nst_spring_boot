package fon.stefan.januarski_rok.service.impl;

import fon.stefan.januarski_rok.domain.*;
import fon.stefan.januarski_rok.dto.*;
import fon.stefan.januarski_rok.repository.AcademicTitleHistoryRepository;
import fon.stefan.januarski_rok.repository.EducationTitleRepository;
import fon.stefan.januarski_rok.repository.MemberRepository;
import fon.stefan.januarski_rok.service.AcademicTitleHistoryService;

import java.util.List;
import java.util.Optional;

public class AcademicTitleHistoryServiceImpl implements AcademicTitleHistoryService {

    private final AcademicTitleHistoryRepository academicTitleHistoryRepository;
    private final MemberRepository memberRepository;
    private final EducationTitleRepository educationTitleRepository;
    public AcademicTitleHistoryServiceImpl(AcademicTitleHistoryRepository academicTitleHistoryRepository,MemberRepository memberRepository, EducationTitleRepository educationTitleRepository){
        this.memberRepository=memberRepository;
        this.academicTitleHistoryRepository = academicTitleHistoryRepository;
        this.educationTitleRepository = educationTitleRepository;
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
                a.getStartDate(),
                a.getEndDate()
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
    public List<AcademicTitleHistoryDto> addHistory(MemberDto memberDto) throws Exception {
        Member member = checkMember(memberDto);
        academicTitleHistoryRepository.saveAll(member.getAcademicTitles());
        Optional<List<AcademicTitleHistory>> list = academicTitleHistoryRepository.findByDepartmentIdAndMemberId(memberDto.getDepartmentId(),memberDto.getId());
        if(list.isEmpty())
            throw new RuntimeException("Member with id "+ memberDto.getId()+" in departemnt "+member.getDepartment().getId()+" doesn't exist");

        return list.get().stream().map(AcademicTitleHistoryServiceImpl::ConvertToAcademicTitleHistoryDto).toList();
    }

    @Override
    public List<AcademicTitleHistoryDto> addAcademicTitle(AcademicTitleHistoryDto academicTitleHistoryDto) throws Exception {
        AcademicTitleHistory academicTitleHistory = new AcademicTitleHistory();
        academicTitleHistoryRepository.save(academicTitleHistory);
        Optional<List<AcademicTitleHistory>> list = academicTitleHistoryRepository.findByDepartmentIdAndMemberId(academicTitleHistoryDto.getDepartmentDto().getId(),academicTitleHistoryDto.getMemberDto().getId());
        if(list.isEmpty())
            throw new RuntimeException("Member and department don't exist");
        return list.get().stream().map(AcademicTitleHistoryServiceImpl::ConvertToAcademicTitleHistoryDto).toList();
    }
}
