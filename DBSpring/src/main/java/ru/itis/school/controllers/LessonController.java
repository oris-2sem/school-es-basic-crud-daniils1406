package ru.itis.school.controllers;

import org.springframework.web.bind.annotation.*;
import ru.itis.school.dto.EntityId;
import ru.itis.school.dto.request.lesson.LessonRequest;
import ru.itis.school.dto.request.lesson.LessonUpdateRequest;
import ru.itis.school.dto.request.parent.ParentRequest;
import ru.itis.school.dto.request.parent.ParentUpdateRequest;
import ru.itis.school.dto.response.LessonCreateResponse;
import ru.itis.school.dto.response.LessonResponse;
import ru.itis.school.dto.response.ParentResponse;

import java.util.List;

@RequestMapping("/lesson")
public interface LessonController {
    @GetMapping
    List<LessonResponse> getAll();

    @PostMapping
    LessonCreateResponse create(@RequestBody LessonRequest lessonRequest);

    @PutMapping
    LessonResponse updateById(@RequestBody LessonUpdateRequest newLesson);

    @DeleteMapping
    void deleteById(@RequestBody EntityId entityId);

    @GetMapping("/byId")
    LessonResponse findById(@RequestBody EntityId entityId);
}
