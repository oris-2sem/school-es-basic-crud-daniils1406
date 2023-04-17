package ru.itis.school.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.itis.school.dto.request.lesson.LessonRequest;
import ru.itis.school.dto.request.lesson.LessonUpdateRequest;
import ru.itis.school.dto.response.LessonCreateResponse;
import ru.itis.school.dto.response.LessonResponse;
import ru.itis.school.dto.response.TaskResponse;
import ru.itis.school.entities.Lesson;
import ru.itis.school.entities.Task;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-16T13:20:36+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class LessonMapperImpl implements LessonMapper {

    @Override
    public Lesson fromRequestToEntity(LessonRequest lessonRequest) {
        if ( lessonRequest == null ) {
            return null;
        }

        Lesson.LessonBuilder lesson = Lesson.builder();

        lesson.theme( lessonRequest.getTheme() );
        lesson.subject( lessonRequest.getSubject() );

        return lesson.build();
    }

    @Override
    public Lesson fromUpdateRequestToEntity(LessonUpdateRequest lessonRequest) {
        if ( lessonRequest == null ) {
            return null;
        }

        Lesson.LessonBuilder lesson = Lesson.builder();

        lesson.id( lessonRequest.getId() );
        lesson.theme( lessonRequest.getTheme() );
        lesson.subject( lessonRequest.getSubject() );

        return lesson.build();
    }

    @Override
    public LessonResponse fromEntityToResponse(Lesson lesson) {
        if ( lesson == null ) {
            return null;
        }

        LessonResponse.LessonResponseBuilder lessonResponse = LessonResponse.builder();

        lessonResponse.id( lesson.getId() );
        lessonResponse.theme( lesson.getTheme() );
        lessonResponse.subject( lesson.getSubject() );
        lessonResponse.timeTable( lesson.getTimeTable() );
        lessonResponse.taskList( fromEntityToResponseListTask( lesson.getTaskList() ) );

        return lessonResponse.build();
    }

    @Override
    public LessonCreateResponse fromEntityToCreateResponse(Lesson lesson) {
        if ( lesson == null ) {
            return null;
        }

        LessonCreateResponse.LessonCreateResponseBuilder lessonCreateResponse = LessonCreateResponse.builder();

        lessonCreateResponse.id( lesson.getId() );
        lessonCreateResponse.theme( lesson.getTheme() );
        lessonCreateResponse.subject( lesson.getSubject() );
        lessonCreateResponse.timeTable( lesson.getTimeTable() );

        return lessonCreateResponse.build();
    }

    @Override
    public List<LessonResponse> fromEntityToResponseList(List<Lesson> lesson) {
        if ( lesson == null ) {
            return null;
        }

        List<LessonResponse> list = new ArrayList<LessonResponse>( lesson.size() );
        for ( Lesson lesson1 : lesson ) {
            list.add( fromEntityToResponse( lesson1 ) );
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
}
