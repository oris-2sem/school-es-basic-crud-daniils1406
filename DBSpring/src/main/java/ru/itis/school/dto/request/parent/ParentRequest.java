package ru.itis.school.dto.request.parent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.school.dto.response.StudentResponse;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParentRequest {
    private String firstName;
    private String lastName;
    private int age;
}
