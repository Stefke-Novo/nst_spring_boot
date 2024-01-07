package fon.stefan.januarski_rok.controller;

import fon.stefan.januarski_rok.dto.SubjectDto;
import fon.stefan.januarski_rok.service.SubjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    //dodaj novi department
    @PostMapping
    public ResponseEntity<SubjectDto> save(@Valid @RequestBody SubjectDto subject) throws Exception {
        //ResponseEntity
        SubjectDto subjectDto = subjectService.save(subject);
        return new ResponseEntity<>(subjectDto, HttpStatus.CREATED);
    }

    //vrati sve
    @GetMapping
    public ResponseEntity<List<SubjectDto>> getAll() {
        List<SubjectDto> subjects = subjectService.getAll();
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    //pronadji na osnovu ID/a
    //localhost:8080/department/1
    @GetMapping("/{id}")
    public SubjectDto findById(@PathVariable("id") Long id) throws Exception {
        return subjectService.findById(id);
    }

    //pronadji na osnovu ID/a
    //localhost:8080/department/query?id=1
    @GetMapping("/query")
    public SubjectDto queryById(@RequestParam("id") Long id) throws Exception {
        return subjectService.findById(id);
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

        subjectService.delete(id);
        return new ResponseEntity<>("Department removed!", HttpStatus.OK);

    }


}
