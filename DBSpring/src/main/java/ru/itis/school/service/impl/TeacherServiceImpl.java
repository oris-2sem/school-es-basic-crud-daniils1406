package ru.itis.school.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.school.dto.request.teacher.TeacherRequest;
import ru.itis.school.dto.request.teacher.TeacherUpdateRequest;
import ru.itis.school.dto.response.TeacherResponse;
import ru.itis.school.entities.Teacher;
import ru.itis.school.mapper.TeacherMapper;
import ru.itis.school.repository.TeacherRepository;
import ru.itis.school.service.TeacherService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    private final TeacherMapper mapper;

    @Override
    public List<TeacherResponse> getAll() {
        List<Teacher> teachers=teacherRepository.findAll();
        for(Teacher teacher:teachers){
            System.out.println(teacher.toString());
        }
        List<TeacherResponse> teacherResponseList=mapper.fromEntityListToResponseList(teachers);
        return teacherResponseList;
    }

    @Override
    public TeacherResponse save(TeacherRequest teacherRequest) {
        return mapper.fromEntityToResponse(teacherRepository.save(mapper.fromRequestToEntity(teacherRequest)));
    }

    @Override
    public TeacherResponse updateById(TeacherUpdateRequest newTeacher) {
        teacherRepository.save(mapper.fromUpdateRequestToEntity(newTeacher));
        return mapper.fromEntityToResponse(teacherRepository.findTeacherById(newTeacher.getId()));
    }

    @Override
    public void deleteById(UUID id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public TeacherResponse findById(UUID id) {
        return mapper.fromEntityToResponse(teacherRepository.findTeacherById(id));
    }
}
