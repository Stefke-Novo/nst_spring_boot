package fon.stefan.januarski_rok.service;

import fon.stefan.januarski_rok.dto.SubjectDto;

import java.util.List;

public interface SubjectService {
    SubjectDto save(SubjectDto subjectDto)throws Exception;
    List<SubjectDto> getAll();
    void delete(Long id) throws Exception;
    void update(SubjectDto subjectDto)throws Exception;
    SubjectDto findById(Long id)throws Exception;
}
