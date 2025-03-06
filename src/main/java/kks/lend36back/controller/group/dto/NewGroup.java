package kks.lend36back.controller.group.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewGroup implements Serializable {
    @NotNull
    private Integer number;

    @NotNull
    @Size(max = 255)
    private String period;

    @NotNull
    @Size(max = 255)
    private String lectorName;
}