package ru.itis.school.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Timetable {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    private Date dateTime;

    private int room;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "classOfTimetable")
    private SchoolClass schoolClassOfTimetable;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    @JsonManagedReference
    @OneToMany(mappedBy = "timeTable",fetch = FetchType.EAGER)
    private List<Lesson> lessonList;

    @PreRemove
    private void preRemove(){
        for(Lesson lesson:lessonList){
            lesson.setTimeTable(null);
        }
    }
}
