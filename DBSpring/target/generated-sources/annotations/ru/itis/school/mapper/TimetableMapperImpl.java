package ru.itis.school.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.itis.school.dto.request.timetable.TimetableRequest;
import ru.itis.school.dto.request.timetable.TimetableUpdateRequest;
import ru.itis.school.dto.response.ClassResponse;
import ru.itis.school.dto.response.LessonResponse;
import ru.itis.school.dto.response.StudentResponse;
import ru.itis.school.dto.response.TaskResponse;
import ru.itis.school.dto.response.TeacherResponse;
import ru.itis.school.dto.response.TimetableCreateResponse;
import ru.itis.school.dto.response.TimetableResponse;
import ru.itis.school.entities.Lesson;
import ru.itis.school.entities.Parent;
import ru.itis.school.entities.SchoolClass;
import ru.itis.school.entities.Student;
import ru.itis.school.entities.Task;
import ru.itis.school.entities.Teacher;
import ru.itis.school.entities.Timetable;
import ru.itis.school.entities.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-16T13:20:36+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class TimetableMapperImpl implements TimetableMapper {

    @Override
    public Timetable fromRequestToEntity(TimetableRequest request) {
        if ( request == null ) {
            return null;
        }

        Timetable.TimetableBuilder timetable = Timetable.builder();

        timetable.dateTime( request.getDateTime() );
        timetable.room( request.getRoom() );

        return timetable.build();
    }

    @Override
    public Timetable fromUpdateRequestToEntity(TimetableUpdateRequest request) {
        if ( request == null ) {
            return null;
        }

        Timetable.TimetableBuilder timetable = Timetable.builder();

        timetable.id( request.getId() );
        timetable.dateTime( request.getDateTime() );
        timetable.room( request.getRoom() );

        return timetable.build();
    }

    @Override
    public TimetableResponse fromEntityToResponse(Timetable timetable) {
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
    public TimetableCreateResponse fromEntityToCreateResponse(Timetable timetable) {
        if ( timetable == null ) {
            return null;
        }

        TimetableCreateResponse.TimetableCreateResponseBuilder timetableCreateResponse = TimetableCreateResponse.builder();

        timetableCreateResponse.id( timetable.getId() );
        timetableCreateResponse.dateTime( timetable.getDateTime() );
        timetableCreateResponse.room( timetable.getRoom() );
        timetableCreateResponse.schoolClassOfTimetable( timetable.getSchoolClassOfTimetable() );
        timetableCreateResponse.teacher( timetable.getTeacher() );

        return timetableCreateResponse.build();
    }

    @Override
    public List<TimetableResponse> fromEntityToResponseList(List<Timetable> timetable) {
        if ( timetable == null ) {
            return null;
        }

        List<TimetableResponse> list = new ArrayList<TimetableResponse>( timetable.size() );
        for ( Timetable timetable1 : timetable ) {
            list.add( fromEntityToResponse( timetable1 ) );
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
        lessonResponse.taskList( taskListToTaskResponseList( lesson.getTaskList() ) );

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
        teacherResponse.timeTableList( fromEntityToResponseList( teacher.getTimeTableList() ) );
        teacherResponse.schoolClassList( schoolClassListToClassResponseList( teacher.getSchoolClassList() ) );

        return teacherResponse.build();
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

    protected ClassResponse schoolClassToClassResponse(SchoolClass schoolClass) {
        if ( schoolClass == null ) {
            return null;
        }

        ClassResponse.ClassResponseBuilder classResponse = ClassResponse.builder();

        classResponse.id( schoolClass.getId() );
        classResponse.lead( schoolClass.getLead() );
        classResponse.letter( schoolClass.getLetter() );
        classResponse.studentsNumber( schoolClass.getStudentsNumber() );
        classResponse.studentList( studentListToStudentResponseList( schoolClass.getStudentList() ) );
        classResponse.timetableList( fromEntityToResponseList( schoolClass.getTimetableList() ) );

        return classResponse.build();
    }

    protected List<ClassResponse> schoolClassListToClassResponseList(List<SchoolClass> list) {
        if ( list == null ) {
            return null;
        }

        List<ClassResponse> list1 = new ArrayList<ClassResponse>( list.size() );
        for ( SchoolClass schoolClass : list ) {
            list1.add( schoolClassToClassResponse( schoolClass ) );
        }

        return list1;
    }
}
