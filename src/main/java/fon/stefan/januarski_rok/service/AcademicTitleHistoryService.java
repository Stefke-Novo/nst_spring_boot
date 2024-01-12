package fon.stefan.januarski_rok.service;

import fon.stefan.januarski_rok.domain.AcademicTitleHistory;
import fon.stefan.januarski_rok.dto.AcademicTitleDto;
import fon.stefan.januarski_rok.dto.AcademicTitleHistoryDto;
import fon.stefan.januarski_rok.dto.MemberDto;

import java.util.List;

public interface AcademicTitleHistoryService {
    List<AcademicTitleHistoryDto> getHistory(MemberDto memberDto) throws Exception;
    List<AcademicTitleHistoryDto> getAll();
    List<AcademicTitleHistoryDto> addHistory(MemberDto memberDto) throws  Exception;
    List<AcademicTitleHistoryDto> addAcademicTitle(AcademicTitleHistoryDto academicTitleHistoryDto) throws Exception;

}
