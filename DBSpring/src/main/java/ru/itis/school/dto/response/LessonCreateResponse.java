package ru.itis.school.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.school.dto.response.TaskResponse;
import ru.itis.school.entities.Timetable;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonCreateResponse {
    private UUID id;
    private String theme;
    private String subject;
    private Timetable timeTable;
}
