package ru.itis.school.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.itis.school.dto.request.teacher.TeacherRequest;
import ru.itis.school.dto.request.teacher.TeacherUpdateRequest;
import ru.itis.school.dto.response.ClassResponse;
import ru.itis.school.dto.response.StudentResponse;
import ru.itis.school.dto.response.TaskResponse;
import ru.itis.school.dto.response.TeacherResponse;
import ru.itis.school.dto.response.TimetableResponse;
import ru.itis.school.entities.Parent;
import ru.itis.school.entities.SchoolClass;
import ru.itis.school.entities.Student;
import ru.itis.school.entities.Task;
import ru.itis.school.entities.Teacher;
import ru.itis.school.entities.Timetable;
import ru.itis.school.entities.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-16T13:20:37+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class TeacherMapperImpl implements TeacherMapper {

    @Override
    public TeacherResponse fromEntityToResponse(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherResponse.TeacherResponseBuilder teacherResponse = TeacherResponse.builder();

        teacherResponse.id( teacher.getId() );
        teacherResponse.firstName( teacher.getFirstName() );
        teacherResponse.lastName( teacher.getLastName() );
        teacherResponse.age( teacher.getAge() );
        teacherResponse.merits( teacher.getMerits() );
        teacherResponse.experience( teacher.getExperience() );
        teacherResponse.earn( teacher.getEarn() );
        teacherResponse.timeTableList( fromEntityToResponseTimetableList( teacher.getTimeTableList() ) );
        teacherResponse.schoolClassList( fromEntityToResponseSchoolClass( teacher.getSchoolClassList() ) );

        return teacherResponse.build();
    }

    @Override
    public TimetableResponse fromEntityToResponseTimetable(Timetable timetable) {
        if ( timetable == null ) {
            return null;
        }

        TimetableResponse.TimetableResponseBuilder timetableResponse = TimetableResponse.builder();

        timetableResponse.id( timetable.getId() );
        timetableResponse.dateTime( timetable.getDateTime() );
        timetableResponse.room( timetable.getRoom() );
        timetableResponse.schoolClassOfTimetable( timetable.getSchoolClassOfTimetable() );
        timetableResponse.teacher( timetable.getTeacher() );

        return timetableResponse.build();
    }

    @Override
    public List<TimetableResponse> fromEntityToResponseTimetableList(List<Timetable> timetables) {
        if ( timetables == null ) {
            return null;
        }

        List<TimetableResponse> list = new ArrayList<TimetableResponse>( timetables.size() );
        for ( Timetable timetable : timetables ) {
            list.add( fromEntityToResponseTimetable( timetable ) );
        }

        return list;
    }

    @Override
    public ClassResponse fromEntityToResponseSchoolClass(SchoolClass schoolClass) {
        if ( schoolClass == null ) {
            return null;
        }

        ClassResponse.ClassResponseBuilder classResponse = ClassResponse.builder();

        classResponse.id( schoolClass.getId() );
        classResponse.lead( schoolClass.getLead() );
        classResponse.letter( schoolClass.getLetter() );
        classResponse.studentsNumber( schoolClass.getStudentsNumber() );
        classResponse.studentList( studentListToStudentResponseList( schoolClass.getStudentList() ) );
        classResponse.timetableList( fromEntityToResponseTimetableList( schoolClass.getTimetableList() ) );

        return classResponse.build();
    }

    @Override
    public List<ClassResponse> fromEntityToResponseSchoolClass(List<SchoolClass> schoolClasses) {
        if ( schoolClasses == null ) {
            return null;
        }

        List<ClassResponse> list = new ArrayList<ClassResponse>( schoolClasses.size() );
        for ( SchoolClass schoolClass : schoolClasses ) {
            list.add( fromEntityToResponseSchoolClass( schoolClass ) );
        }

        return list;
    }

    @Override
    public Teacher fromRequestToEntity(TeacherRequest teacherRequest) {
        if ( teacherRequest == null ) {
            return null;
        }

        Teacher.TeacherBuilder<?, ?> teacher = Teacher.builder();

        teacher.firstName( teacherRequest.getFirstName() );
        teacher.lastName( teacherRequest.getLastName() );
        teacher.age( teacherRequest.getAge() );
        teacher.merits( teacherRequest.getMerits() );
        teacher.experience( teacherRequest.getExperience() );
        teacher.earn( teacherRequest.getEarn() );

        return teacher.build();
    }

    @Override
    public Teacher fromUpdateRequestToEntity(TeacherUpdateRequest teacherRequest) {
        if ( teacherRequest == null ) {
            return null;
        }

        Teacher.TeacherBuilder<?, ?> teacher = Teacher.builder();

        teacher.id( teacherRequest.getId() );
        teacher.firstName( teacherRequest.getFirstName() );
        teacher.lastName( teacherRequest.getLastName() );
        teacher.age( teacherRequest.getAge() );
        teacher.merits( teacherRequest.getMerits() );
        teacher.experience( teacherRequest.getExperience() );
        teacher.earn( teacherRequest.getEarn() );

        return teacher.build();
    }

    @Override
    public List<TeacherResponse> fromEntityListToResponseList(List<Teacher> teachers) {
        if ( teachers == null ) {
            return null;
        }

        List<TeacherResponse> list = new ArrayList<TeacherResponse>( teachers.size() );
        for ( Teacher teacher : teachers ) {
            list.add( fromEntityToResponse( teacher ) );
        }

        return list;
    }

    protected Parent userToParent(User user) {
        if ( user == null ) {
            return null;
        }

        Parent.ParentBuilder<?, ?> parent = Parent.builder();

        parent.id( user.getId() );
        parent.firstName( user.getFirstName() );
        parent.lastName( user.getLastName() );
        parent.age( user.getAge() );

        return parent.build();
    }

    protected TaskResponse taskToTaskResponse(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskResponse.TaskResponseBuilder taskResponse = TaskResponse.builder();

        taskResponse.id( task.getId() );
        taskResponse.commentary( task.getCommentary() );
        taskResponse.description( task.getDescription() );
        taskResponse.mark( task.getMark() );
        taskResponse.type( task.getType() );
        taskResponse.lesson( task.getLesson() );
        taskResponse.student( task.getStudent() );

        return taskResponse.build();
    }

    protected List<TaskResponse> taskListToTaskResponseList(List<Task> list) {
        if ( list == null ) {
            return null;
        }

        List<TaskResponse> list1 = new ArrayList<TaskResponse>( list.size() );
        for ( Task task : list ) {
            list1.add( taskToTaskResponse( task ) );
        }

        return list1;
    }

    protected StudentResponse studentToStudentResponse(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentResponse.StudentResponseBuilder studentResponse = StudentResponse.builder();

        studentResponse.id( student.getId() );
        studentResponse.firstName( student.getFirstName() );
        studentResponse.lastName( student.getLastName() );
        studentResponse.age( student.getAge() );
        studentResponse.schoolClassOfStudent( student.getSchoolClassOfStudent() );
        studentResponse.parent( userToParent( student.getParent() ) );
        studentResponse.taskList( taskListToTaskResponseList( student.getTaskList() ) );

        return studentResponse.build();
    }

    protected List<StudentResponse> studentListToStudentResponseList(List<Student> list) {
        if ( list == null ) {
            return null;
        }

        List<StudentResponse> list1 = new ArrayList<StudentResponse>( list.size() );
        for ( Student student : list ) {
            list1.add( studentToStudentResponse( student ) );
        }

        return list1;
    }
}
