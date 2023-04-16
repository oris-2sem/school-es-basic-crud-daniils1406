package ru.itis.school.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lesson {
    @Id
    @GeneratedValue
    @UuidGenerator
    public UUID id;

    public String theme;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "time_table")
    public Timetable timeTable;

    public String subject;

    @JsonManagedReference
    @OneToMany(mappedBy = "lesson",fetch = FetchType.EAGER)
    public List<Task> taskList;

    @PreRemove
    private void preRemove(){
        for(Task task: taskList){
            task.setLesson(null);
        }
    }
}
