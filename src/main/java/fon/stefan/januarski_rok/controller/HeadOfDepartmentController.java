package fon.stefan.januarski_rok.controller;

import fon.stefan.januarski_rok.dto.DepartmentDto;
import fon.stefan.januarski_rok.dto.HeadOfDepartmentDto;
import fon.stefan.januarski_rok.service.HeadOfDepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/head-of-department")
public class HeadOfDepartmentController {

    private final HeadOfDepartmentService headOfDepartmentService;
    public HeadOfDepartmentController(HeadOfDepartmentService headOfDepartmentService){
        this.headOfDepartmentService=headOfDepartmentService;
    }
    @GetMapping(path = "/current")
    public ResponseEntity<HeadOfDepartmentDto> getCurrentHeadOfDepartment(@RequestBody DepartmentDto departmentDto) throws Exception {
        return new ResponseEntity<>(headOfDepartmentService.getCurrentHeadOfDepartment(departmentDto), HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<HeadOfDepartmentDto>> getAllHeadOfDepartments(){
        return ResponseEntity.ok(headOfDepartmentService.getAllHadOfDepartments());
    }
    @DeleteMapping(path = "/delete")
    public ResponseEntity<HeadOfDepartmentDto> deleteHeadOfDepartment(@RequestBody HeadOfDepartmentDto headOfDepartmentDto) throws Exception {
        return ResponseEntity.ok(headOfDepartmentService.deleteHeadOfDepartment(headOfDepartmentDto));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<HeadOfDepartmentDto> createHeadOfDepartment(@RequestBody HeadOfDepartmentDto headOfDepartmentDto) throws Exception {
        return ResponseEntity.ok(headOfDepartmentService.createHeadOfDepartment(headOfDepartmentDto));
    }
    @GetMapping(path = "/history")
    public ResponseEntity<List<HeadOfDepartmentDto>> getHeadOfDepartmentHistory(@RequestBody DepartmentDto departmentDto) throws Exception {
        return ResponseEntity.ok(headOfDepartmentService.getHeadOfDepartmentHistory(departmentDto));
    }

}
