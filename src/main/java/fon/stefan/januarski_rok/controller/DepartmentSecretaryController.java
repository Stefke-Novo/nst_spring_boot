package fon.stefan.januarski_rok.controller;

import fon.stefan.januarski_rok.dto.DepartmentDto;
import fon.stefan.januarski_rok.dto.DepartmentSecretaryDto;
import fon.stefan.januarski_rok.service.DepartmentSecretaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/department-secretary")
public class DepartmentSecretaryController {

    private final DepartmentSecretaryService departmentSecretaryService;

    public DepartmentSecretaryController(DepartmentSecretaryService departmentSecretaryService){
        this.departmentSecretaryService = departmentSecretaryService;
    }
    @GetMapping(path = "/all")
    public ResponseEntity<List<DepartmentSecretaryDto>> getAllDepartmentSecretaries(){
        return new ResponseEntity<>(departmentSecretaryService.getAllDepartmentSecretaries(), HttpStatus.OK);
    }
    @PostMapping(path = "/delete")
    public ResponseEntity<DepartmentSecretaryDto> deleteDepartmentSecretary(@RequestBody DepartmentSecretaryDto departmentSecretaryDto) throws Exception {
        return new ResponseEntity<>(departmentSecretaryService.deleteDepartmentSecretary(departmentSecretaryDto),HttpStatus.OK);
    }
    @PostMapping(path = "/current")
    public ResponseEntity<DepartmentSecretaryDto> getCurrentDepartmentSecretary(@RequestBody DepartmentDto departmentDto) throws Exception {
        return new ResponseEntity<>(departmentSecretaryService.currentDepartmentSecretary(departmentDto),HttpStatus.OK);
    }
    @PostMapping(path = "/history")
    public ResponseEntity<List<DepartmentSecretaryDto>> getDepartmentSecretaryHistoryByDepartment(@RequestBody DepartmentDto departmentDto) throws Exception {
        return new ResponseEntity<>(departmentSecretaryService.getDepartmentSecretaryHistory(departmentDto), HttpStatus.OK);
    }
    @PostMapping(path = "/create")
    public ResponseEntity<DepartmentSecretaryDto> createDepartmentSecretary(@RequestBody DepartmentSecretaryDto departmentSecretaryDto) throws Exception {
        return new ResponseEntity<>(departmentSecretaryService.createDepartemntSecretary(departmentSecretaryDto),HttpStatus.OK);
    }

}
