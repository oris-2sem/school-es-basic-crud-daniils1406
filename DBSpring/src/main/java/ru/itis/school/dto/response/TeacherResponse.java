package ru.itis.school.dto.response;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import ru.itis.school.entities.SchoolClass;
import ru.itis.school.entities.Timetable;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherResponse {
    private UUID id;

    private String firstName;

    private String lastName;

    private int age;

    private String merits;

    private String experience;

    private int earn;

    private List<TimetableResponse> timeTableList;

    private List<ClassResponse> schoolClassList;
}
