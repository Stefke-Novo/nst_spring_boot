package fon.stefan.januarski_rok.controller;

import fon.stefan.januarski_rok.domain.Department;
import fon.stefan.januarski_rok.dto.DepartmentDto;
import fon.stefan.januarski_rok.exception.DepartmentAlreadyExistException;
import fon.stefan.januarski_rok.exception.MyErrorDetails;
import fon.stefan.januarski_rok.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
        System.out.println("nst.springboot.restexample01.controller.DepartmentController.<init>()");
        System.out.println("kreiran je konroller!");
    }

    //dodaj novi department
    @PostMapping
    public ResponseEntity<DepartmentDto> save(@Valid @RequestBody DepartmentDto departmentDto) throws Exception {
        //ResponseEntity
        DepartmentDto deptDto = departmentService.save(departmentDto);
        return new ResponseEntity<>(deptDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAll() {
        List<DepartmentDto> departments = departmentService.getAll();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/paging")
    public ResponseEntity<List<DepartmentDto>> getAllByPage(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "pageSize", defaultValue = "2") int pageSize,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(name = "sortDirection", defaultValue = "asc") String sortDirection) {

        Pageable pageable;
        if (sortDirection.equals("asc")) {
            pageable = PageRequest.of(page, pageSize, Sort.by(sortBy).ascending());
        } else {
            pageable = PageRequest.of(page, pageSize, Sort.by(sortBy).descending());
        }
        List<DepartmentDto> departments = departmentService.getAll(pageable);
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    //pronadji na osnovu ID/a
    //localhost:8080/department/1
    @GetMapping("/{id}")
    public DepartmentDto findById(@PathVariable("id") Long id) throws Exception {
        System.out.println("Controller: " + id);
        return departmentService.findById(id);
    }

    //pronadji na osnovu ID/a
    //localhost:8080/department/query?id=1
    @GetMapping("/query")
    public Department queryById(@RequestParam("id") Long id) throws Exception {
        //return departmentService.findById(id);
        throw new Exception("Nije implementirana.");
    }

    //azuriraj
    //obrisi
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {
        /*
        try {
            departmentService.delete(id);
            return new ResponseEntity<>("Department removed!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(">>" + e.getMessage(), HttpStatus.NOT_FOUND);
        }*/

        departmentService.delete(id);
        return new ResponseEntity<>("Department removed!", HttpStatus.OK);

    }

    /*
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> handleException(Exception e){
        System.out.println("nst.springboot.restexample01.controller.DepartmentController.handleException()");
        System.out.println("-----------pozvana metoda za obradu izuzetka u kontroleru -------------");

        MyErrorDetails myErrorDetails = new MyErrorDetails(e.getMessage());

        return new ResponseEntity<>(myErrorDetails, HttpStatus.NOT_FOUND);

    }*/
    @ExceptionHandler(DepartmentAlreadyExistException.class)
    public ResponseEntity<MyErrorDetails> handleException(DepartmentAlreadyExistException e) {
        System.out.println("nst.springboot.restexample01.controller.DepartmentController.handleException()");
        System.out.println("-----------pozvana metoda za obradu izuzetka u kontroleru -------------");

        MyErrorDetails myErrorDetails = new MyErrorDetails(e.getMessage());

        return new ResponseEntity<>(myErrorDetails, HttpStatus.BAD_REQUEST);

    }
    @GetMapping(path = "/with_members/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentWithMembers(@PathVariable long id) throws Exception {
        return new ResponseEntity<>(departmentService.getDepartmentWithMembers(id),HttpStatus.OK);
    }
//    @GetMapping(path = "/department/{id}")
//    public ResponseEntity<DepartmentDto> getDepartmentWithMembers(long id) throws Exception {
//        return ResponseEntity.ok(departmentService.getDepartmentWithMembers(id));
//    }
}
