package ru.itis.school.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.itis.school.dto.request.task.TaskRequest;
import ru.itis.school.dto.request.task.TaskUpdateRequest;
import ru.itis.school.dto.response.LessonResponse;
import ru.itis.school.dto.response.TaskResponse;
import ru.itis.school.entities.Lesson;
import ru.itis.school.entities.Task;
import ru.itis.school.entities.enums.Mark;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-16T13:20:36+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task fromRequestToEntity(TaskRequest request) {
        if ( request == null ) {
            return null;
        }

        Task.TaskBuilder task = Task.builder();

        task.commentary( request.getCommentary() );
        task.description( request.getDescription() );
        if ( request.getMark() != null ) {
            task.mark( Enum.valueOf( Mark.class, request.getMark() ) );
        }
        task.type( request.getType() );

        return task.build();
    }

    @Override
    public Task fromUpdateRequestToEntity(TaskUpdateRequest request) {
        if ( request == null ) {
            return null;
        }

        Task.TaskBuilder task = Task.builder();

        task.id( request.getId() );
        task.commentary( request.getCommentary() );
        task.description( request.getDescription() );
        task.mark( request.getMark() );
        task.type( request.getType() );

        return task.build();
    }

    @Override
    public TaskResponse fromEntityToResponse(Task task) {
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
    public List<TaskResponse> fromEntityToResponseList(List<Task> task) {
        if ( task == null ) {
            return null;
        }

        List<TaskResponse> list = new ArrayList<TaskResponse>( task.size() );
        for ( Task task1 : task ) {
            list.add( fromEntityToResponse( task1 ) );
        }

        return list;
    }

    @Override
    public LessonResponse fromEntityToResponseLesson(Lesson lesson) {
        if ( lesson == null ) {
            return null;
        }

        LessonResponse.LessonResponseBuilder lessonResponse = LessonResponse.builder();

        lessonResponse.id( lesson.getId() );
        lessonResponse.theme( lesson.getTheme() );
        lessonResponse.subject( lesson.getSubject() );
        lessonResponse.timeTable( lesson.getTimeTable() );
        lessonResponse.taskList( fromEntityToResponseList( lesson.getTaskList() ) );

        return lessonResponse.build();
    }

    @Override
    public List<LessonResponse> fromEntityToResponseListLesson(List<Lesson> lesson) {
        if ( lesson == null ) {
            return null;
        }

        List<LessonResponse> list = new ArrayList<LessonResponse>( lesson.size() );
        for ( Lesson lesson1 : lesson ) {
            list.add( fromEntityToResponseLesson( lesson1 ) );
        }

        return list;
    }
}
