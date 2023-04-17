package ru.itis.school.controllers;

import org.springframework.web.bind.annotation.*;
import ru.itis.school.dto.EntityId;
import ru.itis.school.dto.request.parent.ParentRequest;
import ru.itis.school.dto.request.parent.ParentUpdateRequest;
import ru.itis.school.dto.response.ParentCreateResponse;
import ru.itis.school.dto.response.ParentResponse;

import java.util.List;

@RequestMapping("/parent")
public interface ParentController {

    @GetMapping
    List<ParentResponse> getAll();

    @PostMapping
    ParentCreateResponse create(@RequestBody ParentRequest parentRequest);

    @PutMapping
    ParentResponse updateById(@RequestBody ParentUpdateRequest newParent);

    @DeleteMapping
    void deleteById(@RequestBody EntityId entityId);

    @GetMapping("/byId")
    ParentResponse findById(@RequestBody EntityId entityId);
}
