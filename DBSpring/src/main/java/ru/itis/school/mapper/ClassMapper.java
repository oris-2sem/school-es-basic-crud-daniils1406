package ru.itis.school.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.school.dto.request.schoolclass.ClassRequest;
import ru.itis.school.dto.request.schoolclass.ClassUpdateRequest;
import ru.itis.school.dto.response.ClassCreateResponse;
import ru.itis.school.dto.response.ClassResponse;
import ru.itis.school.dto.response.StudentResponse;
import ru.itis.school.dto.response.TimetableResponse;
import ru.itis.school.entities.SchoolClass;
import ru.itis.school.entities.Student;
import ru.itis.school.entities.Teacher;
import ru.itis.school.entities.Timetable;
import ru.itis.school.repository.TeacherRepository;
import ru.itis.school.repository.TimetableRepository;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ClassMapper {

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "studentList",ignore = true)
    @Mapping(target = "timetableList",ignore = true)
    @Mapping(target = "lead",ignore = true)
    SchoolClass fromRequestToEntity(ClassRequest classRequest);

    @Mapping(target = "studentList",ignore = true)
    @Mapping(target = "timetableList",ignore = true)
    @Mapping(target = "lead",ignore = true)
    SchoolClass fromUpdateRequestToEntity(ClassUpdateRequest classUpdateRequest);


    ClassResponse fromEntityToResponse(SchoolClass classEntity);

    ClassCreateResponse fromEntityToCreateResponse(SchoolClass classEntity);


    List<ClassResponse> fromEntityToResponseList(List<SchoolClass> classEntity);

    StudentResponse fromEntityToResponseStudent(Student student);

    List<StudentResponse> fromEntityToResponseListStudent(List<Student> request);

    TimetableResponse fromEntityToResponseTimetable(Timetable timetable);


    List<TimetableResponse> fromEntityToResponseListTimetable(List<Timetable> timetable);


}
