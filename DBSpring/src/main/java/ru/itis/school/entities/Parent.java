package ru.itis.school.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PreRemove;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Parent extends User{
    @JsonManagedReference
    @OneToMany(mappedBy = "parent",fetch = FetchType.EAGER)
    private List<Student> children;

    @PreRemove
    private void preRemove(){
        for(Student student:children){
            student.setParent(null);
        }
    }
}
