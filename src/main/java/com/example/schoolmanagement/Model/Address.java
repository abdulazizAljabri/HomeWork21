package com.example.schoolmanagement.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Address {
    @Id
    private Integer addressId;
    @NotEmpty(message = "should not be empty")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String street;
    @NotEmpty(message = "should not be empty")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String area;
    @NotNull(message = "should not be empty")
    @Column(columnDefinition = "int not null unique")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;


}
