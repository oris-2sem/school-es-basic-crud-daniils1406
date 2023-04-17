package ru.itis.school.controllers;

import org.springframework.web.bind.annotation.*;
import ru.itis.school.dto.EntityId;
import ru.itis.school.dto.request.timetable.TimetableRequest;
import ru.itis.school.dto.request.timetable.TimetableUpdateRequest;
import ru.itis.school.dto.response.TimetableCreateResponse;
import ru.itis.school.dto.response.TimetableResponse;

import java.util.List;

@RequestMapping("/timetable")
public interface TimetableController {

    @GetMapping
    List<TimetableResponse> getAll();

    @PostMapping
    TimetableCreateResponse create(@RequestBody TimetableRequest parentRequest);

    @PutMapping
    TimetableResponse updateById(@RequestBody TimetableUpdateRequest newParent);

    @DeleteMapping
    void deleteById(@RequestBody EntityId entityId);

    @GetMapping("/byId")
    TimetableResponse findById(@RequestBody EntityId entityId);

}
