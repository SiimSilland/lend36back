package kks.lend36back.controller.student.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentProfileDto implements Serializable {
    @NotNull
    @Size(max = 255)
    private String firstName;
    @NotNull
    @Size(max = 255)
    private String lastName;
    @Size(max = 255)
    private String address;
    @Size(max = 255)
    private String phone;
    @Size(max = 255)
    private String linkedin;
    @NotNull
    @Size(max = 255)
    private String email;
    @Size(max = 1000)
    private String intro;
}
