package com.example.schoolmanagement.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;
    @NotEmpty(message = "should not be empty")
    @Column(columnDefinition = "varchar(20) not null ")
    private String teacherName;
    @NotNull(message = "should not be null")
    @Column(columnDefinition = "int not null ")
    private Integer teacherAge;
    @NotEmpty(message = "should not be empty")
    @Column(columnDefinition = "varchar(20) not null ")
    private String teacherEmail;
    @NotNull(message = "should not be null")
    @Column(columnDefinition = "int not null ")
    private Integer teacherSalary;

    @OneToOne(cascade = CascadeType.DETACH , mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;
}
