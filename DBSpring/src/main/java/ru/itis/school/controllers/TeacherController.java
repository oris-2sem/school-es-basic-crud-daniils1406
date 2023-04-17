package ru.itis.school.controllers;


import org.springframework.web.bind.annotation.*;
import ru.itis.school.dto.EntityId;
import ru.itis.school.dto.request.teacher.TeacherRequest;
import ru.itis.school.dto.request.teacher.TeacherUpdateRequest;
import ru.itis.school.dto.response.TeacherResponse;

import java.util.List;

@RequestMapping("/teacher")
public interface TeacherController {
    @GetMapping
    List<TeacherResponse> getAll();

    @PostMapping
    TeacherResponse create(@RequestBody TeacherRequest teacherRequest);

    @PutMapping
    TeacherResponse updateById(@RequestBody TeacherUpdateRequest newTeacher);

    @DeleteMapping
    void deleteById(@RequestBody EntityId entityId);

    @GetMapping("/byId")
    TeacherResponse findById(@RequestBody EntityId entityId);
}
