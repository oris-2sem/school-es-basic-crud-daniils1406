package ru.itis.school.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PreRemove;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Fetch;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Teacher extends User {
    private String merits;

    private String experience;

    private int earn;

    @JsonManagedReference
    @OneToMany(mappedBy = "teacher",fetch = FetchType.EAGER)
    private List<Timetable> timeTableList;
    @JsonManagedReference
    @OneToMany(mappedBy = "lead",fetch = FetchType.EAGER)
    private List<SchoolClass> schoolClassList;

    @PreRemove
    private void preRemove(){
        for(Timetable timetable:timeTableList){
            timetable.setTeacher(null);
        }
        for(SchoolClass lead:schoolClassList){
            lead.setLead(null);
        }
    }
}
