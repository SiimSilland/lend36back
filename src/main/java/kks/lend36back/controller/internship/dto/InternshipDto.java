package kks.lend36back.controller.internship.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InternshipDto implements Serializable {


    @NotNull
    @Size(max = 1000)
    private String title;

    @NotNull
    @Size(max = 1000)
    private String description;

    @NotNull
    @Size(max = 255)
    private String coordinatorName;

    @NotNull
    @Size(max = 255)
    private String coordinatorEmail;

    private String status;
}