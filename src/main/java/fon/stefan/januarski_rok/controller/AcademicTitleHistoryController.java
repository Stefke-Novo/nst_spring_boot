package fon.stefan.januarski_rok.controller;

import fon.stefan.januarski_rok.domain.AcademicTitleHistory;
import fon.stefan.januarski_rok.dto.AcademicTitleDto;
import fon.stefan.januarski_rok.dto.AcademicTitleHistoryDto;
import fon.stefan.januarski_rok.dto.MemberDto;
import fon.stefan.januarski_rok.service.AcademicTitleHistoryService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "academic-title-history")
public class AcademicTitleHistoryController {
    private final AcademicTitleHistoryService academicTitleHistoryService;
    public AcademicTitleHistoryController(AcademicTitleHistoryService academicTitleHistoryService){
        this.academicTitleHistoryService=academicTitleHistoryService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<AcademicTitleHistoryDto>> getAll(){
        return new ResponseEntity<>(academicTitleHistoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/history/get")
    public ResponseEntity<List<AcademicTitleHistoryDto>> getAcademicTitleHistory(MemberDto memberDto) throws Exception {
        return ResponseEntity.ok(academicTitleHistoryService.getHistory(memberDto));
    }
    @PostMapping(path = "/history/add")
    public ResponseEntity<List<AcademicTitleHistoryDto>> addAcademicTitleHistory(MemberDto memberDto) throws Exception {
        return ResponseEntity.ok(academicTitleHistoryService.addHistory(memberDto));
    }
    @PostMapping(path = "/add")
    public ResponseEntity<List<AcademicTitleHistoryDto>> addAcademicTitle(AcademicTitleHistoryDto academicTitleHistoryDto) throws Exception {
        return ResponseEntity.ok(academicTitleHistoryService.addAcademicTitle(academicTitleHistoryDto));
    }
}
