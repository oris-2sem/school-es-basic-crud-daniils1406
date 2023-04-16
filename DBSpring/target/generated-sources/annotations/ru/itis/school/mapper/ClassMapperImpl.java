package ru.itis.school.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.itis.school.dto.request.schoolclass.ClassRequest;
import ru.itis.school.dto.request.schoolclass.ClassUpdateRequest;
import ru.itis.school.dto.response.ClassCreateResponse;
import ru.itis.school.dto.response.ClassResponse;
import ru.itis.school.dto.response.StudentResponse;
import ru.itis.school.dto.response.TaskResponse;
import ru.itis.school.dto.response.TimetableResponse;
import ru.itis.school.entities.Parent;
import ru.itis.school.entities.SchoolClass;
import ru.itis.school.entities.Student;
import ru.itis.school.entities.Task;
import ru.itis.school.entities.Timetable;
import ru.itis.school.entities.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-16T13:20:37+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class ClassMapperImpl implements ClassMapper {

    @Override
    public SchoolClass fromRequestToEntity(ClassRequest classRequest) {
        if ( classRequest == null ) {
            return null;
        }

        SchoolClass.SchoolClassBuilder schoolClass = SchoolClass.builder();

        schoolClass.letter( classRequest.getLetter() );
        schoolClass.studentsNumber( classRequest.getStudentsNumber() );

        return schoolClass.build();
    }

    @Override
    public SchoolClass fromUpdateRequestToEntity(ClassUpdateRequest classUpdateRequest) {
        if ( classUpdateRequest == null ) {
            return null;
        }

        SchoolClass.SchoolClassBuilder schoolClass = SchoolClass.builder();

        schoolClass.id( classUpdateRequest.getId() );
        schoolClass.letter( classUpdateRequest.getLetter() );
        schoolClass.studentsNumber( classUpdateRequest.getStudentsNumber() );

        return schoolClass.build();
    }

    @Override
    public ClassResponse fromEntityToResponse(SchoolClass classEntity) {
        if ( classEntity == null ) {
            return null;
        }

        ClassResponse.ClassResponseBuilder classResponse = ClassResponse.builder();

        classResponse.id( classEntity.getId() );
        classResponse.lead( classEntity.getLead() );
        classResponse.letter( classEntity.getLetter() );
        classResponse.studentsNumber( classEntity.getStudentsNumber() );
        classResponse.studentList( fromEntityToResponseListStudent( classEntity.getStudentList() ) );
        classResponse.timetableList( fromEntityToResponseListTimetable( classEntity.getTimetableList() ) );

        return classResponse.build();
    }

    @Override
    public ClassCreateResponse fromEntityToCreateResponse(SchoolClass classEntity) {
        if ( classEntity == null ) {
            return null;
        }

        ClassCreateResponse.ClassCreateResponseBuilder classCreateResponse = ClassCreateResponse.builder();

        classCreateResponse.id( classEntity.getId() );
        classCreateResponse.lead( classEntity.getLead() );
        classCreateResponse.letter( classEntity.getLetter() );
        classCreateResponse.studentsNumber( classEntity.getStudentsNumber() );

        return classCreateResponse.build();
    }

    @Override
    public List<ClassResponse> fromEntityToResponseList(List<SchoolClass> classEntity) {
        if ( classEntity == null ) {
            return null;
        }

        List<ClassResponse> list = new ArrayList<ClassResponse>( classEntity.size() );
        for ( SchoolClass schoolClass : classEntity ) {
            list.add( fromEntityToResponse( schoolClass ) );
        }

        return list;
    }

    @Override
    public StudentResponse fromEntityToResponseStudent(Student student) {
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

    @Override
    public List<StudentResponse> fromEntityToResponseListStudent(List<Student> request) {
        if ( request == null ) {
            return null;
        }

        List<StudentResponse> list = new ArrayList<StudentResponse>( request.size() );
        for ( Student student : request ) {
            list.add( fromEntityToResponseStudent( student ) );
        }

        return list;
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
    public List<TimetableResponse> fromEntityToResponseListTimetable(List<Timetable> timetable) {
        if ( timetable == null ) {
            return null;
        }

        List<TimetableResponse> list = new ArrayList<TimetableResponse>( timetable.size() );
        for ( Timetable timetable1 : timetable ) {
            list.add( fromEntityToResponseTimetable( timetable1 ) );
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
}
