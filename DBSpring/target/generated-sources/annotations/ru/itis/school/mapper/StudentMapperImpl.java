package ru.itis.school.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.itis.school.dto.request.student.StudentRequest;
import ru.itis.school.dto.request.student.StudentUpdateRequest;
import ru.itis.school.dto.response.StudentCreateResponse;
import ru.itis.school.dto.response.StudentResponse;
import ru.itis.school.dto.response.TaskResponse;
import ru.itis.school.entities.Parent;
import ru.itis.school.entities.Student;
import ru.itis.school.entities.Task;
import ru.itis.school.entities.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-16T13:20:36+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student fromRequestToEntity(StudentRequest request) {
        if ( request == null ) {
            return null;
        }

        Student.StudentBuilder<?, ?> student = Student.builder();

        student.firstName( request.getFirstName() );
        student.lastName( request.getLastName() );
        student.age( request.getAge() );

        return student.build();
    }

    @Override
    public Student fromUpdateRequestToEntity(StudentUpdateRequest request) {
        if ( request == null ) {
            return null;
        }

        Student.StudentBuilder<?, ?> student = Student.builder();

        student.id( request.getId() );
        student.firstName( request.getFirstName() );
        student.lastName( request.getLastName() );
        student.age( request.getAge() );

        return student.build();
    }

    @Override
    public StudentResponse fromEntityToResponse(Student student) {
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
        studentResponse.taskList( fromEntityToResponseListTask( student.getTaskList() ) );

        return studentResponse.build();
    }

    @Override
    public StudentCreateResponse fromEntityToCreateResponse(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentCreateResponse.StudentCreateResponseBuilder studentCreateResponse = StudentCreateResponse.builder();

        studentCreateResponse.id( student.getId() );
        studentCreateResponse.firstName( student.getFirstName() );
        studentCreateResponse.lastName( student.getLastName() );
        studentCreateResponse.age( student.getAge() );
        studentCreateResponse.schoolClassOfStudent( student.getSchoolClassOfStudent() );
        studentCreateResponse.parent( userToParent( student.getParent() ) );

        return studentCreateResponse.build();
    }

    @Override
    public List<StudentResponse> fromEntityToResponseList(List<Student> request) {
        if ( request == null ) {
            return null;
        }

        List<StudentResponse> list = new ArrayList<StudentResponse>( request.size() );
        for ( Student student : request ) {
            list.add( fromEntityToResponse( student ) );
        }

        return list;
    }

    @Override
    public TaskResponse fromEntityToResponseTask(Task task) {
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

    @Override
    public List<TaskResponse> fromEntityToResponseListTask(List<Task> task) {
        if ( task == null ) {
            return null;
        }

        List<TaskResponse> list = new ArrayList<TaskResponse>( task.size() );
        for ( Task task1 : task ) {
            list.add( fromEntityToResponseTask( task1 ) );
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
}
