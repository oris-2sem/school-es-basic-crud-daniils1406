package ru.itis.school.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.itis.school.dto.request.parent.ParentRequest;
import ru.itis.school.dto.request.parent.ParentUpdateRequest;
import ru.itis.school.dto.response.ParentCreateResponse;
import ru.itis.school.dto.response.ParentResponse;
import ru.itis.school.dto.response.StudentResponse;
import ru.itis.school.dto.response.TaskResponse;
import ru.itis.school.entities.Parent;
import ru.itis.school.entities.Student;
import ru.itis.school.entities.Task;
import ru.itis.school.entities.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-16T13:20:37+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class ParentMapperImpl implements ParentMapper {

    @Override
    public Parent fromRequestToEntity(ParentRequest request) {
        if ( request == null ) {
            return null;
        }

        Parent.ParentBuilder<?, ?> parent = Parent.builder();

        parent.firstName( request.getFirstName() );
        parent.lastName( request.getLastName() );
        parent.age( request.getAge() );

        return parent.build();
    }

    @Override
    public Parent fromUpdateRequestToEntity(ParentUpdateRequest request) {
        if ( request == null ) {
            return null;
        }

        Parent.ParentBuilder<?, ?> parent = Parent.builder();

        parent.id( request.getId() );
        parent.firstName( request.getFirstName() );
        parent.lastName( request.getLastName() );
        parent.age( request.getAge() );

        return parent.build();
    }

    @Override
    public ParentResponse fromEntityToResponse(Parent parent) {
        if ( parent == null ) {
            return null;
        }

        ParentResponse.ParentResponseBuilder parentResponse = ParentResponse.builder();

        parentResponse.id( parent.getId() );
        parentResponse.firstName( parent.getFirstName() );
        parentResponse.lastName( parent.getLastName() );
        parentResponse.age( parent.getAge() );
        parentResponse.children( fromEntityToResponseListStudent( parent.getChildren() ) );

        return parentResponse.build();
    }

    @Override
    public ParentCreateResponse fromEntityToCreateResponse(Parent parent) {
        if ( parent == null ) {
            return null;
        }

        ParentCreateResponse.ParentCreateResponseBuilder parentCreateResponse = ParentCreateResponse.builder();

        parentCreateResponse.id( parent.getId() );
        parentCreateResponse.firstName( parent.getFirstName() );
        parentCreateResponse.lastName( parent.getLastName() );
        parentCreateResponse.age( parent.getAge() );

        return parentCreateResponse.build();
    }

    @Override
    public List<ParentResponse> fromEntityToResponseList(List<Parent> parent) {
        if ( parent == null ) {
            return null;
        }

        List<ParentResponse> list = new ArrayList<ParentResponse>( parent.size() );
        for ( Parent parent1 : parent ) {
            list.add( fromEntityToResponse( parent1 ) );
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
