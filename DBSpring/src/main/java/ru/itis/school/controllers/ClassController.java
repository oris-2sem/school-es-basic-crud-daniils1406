package ru.itis.school.controllers;

import org.springframework.web.bind.annotation.*;
import ru.itis.school.dto.EntityId;
import ru.itis.school.dto.request.parent.ParentRequest;
import ru.itis.school.dto.request.parent.ParentUpdateRequest;
import ru.itis.school.dto.request.schoolclass.ClassRequest;
import ru.itis.school.dto.request.schoolclass.ClassUpdateRequest;
import ru.itis.school.dto.response.ClassCreateResponse;
import ru.itis.school.dto.response.ClassResponse;
import ru.itis.school.dto.response.ParentResponse;

import java.util.List;

@RequestMapping("/class")
public interface ClassController {

    @GetMapping
    List<ClassResponse> getAll();

    @PostMapping
    ClassCreateResponse create(@RequestBody ClassRequest parentRequest);

    @PutMapping
    ClassResponse updateById(@RequestBody ClassUpdateRequest newParent);

    @DeleteMapping
    void deleteById(@RequestBody EntityId entityId);

    @GetMapping("/byId")
    ClassResponse findById(@RequestBody EntityId entityId);
}
