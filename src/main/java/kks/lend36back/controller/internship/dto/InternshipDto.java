package kks.lend36back.controller.internship.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kks.lend36back.persistence.internship.Internship;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


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
    private String name;

    @NotNull
    @Size(max = 255)
    private String email;

    private String status;

}