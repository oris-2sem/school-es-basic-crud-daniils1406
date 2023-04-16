package ru.itis.school.controllers;

import org.springframework.web.bind.annotation.*;
import ru.itis.school.dto.EntityId;
import ru.itis.school.dto.request.parent.ParentRequest;
import ru.itis.school.dto.request.parent.ParentUpdateRequest;
import ru.itis.school.dto.request.task.TaskRequest;
import ru.itis.school.dto.request.task.TaskUpdateRequest;
import ru.itis.school.dto.response.ParentResponse;
import ru.itis.school.dto.response.TaskResponse;

import java.util.List;

@RequestMapping("/task")
public interface TaskController {
    @GetMapping
    List<TaskResponse> getAll();

    @PostMapping
    TaskResponse create(@RequestBody TaskRequest taskRequest);

    @PutMapping
    TaskResponse updateById(@RequestBody TaskUpdateRequest newTask);

    @DeleteMapping
    void deleteById(@RequestBody EntityId entityId);

    @GetMapping("/byId")
    TaskResponse findById(@RequestBody EntityId entityId);
}
