package com.example.schoolmanagement.DTO;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer teacher_teacher_id;
    @NotEmpty(message = "should not be empty")
    private String street;
    @NotEmpty(message = "should not be empty")
    private String area;
    @NotNull(message = "should not be null")
    private Integer buildingNumber;

}
