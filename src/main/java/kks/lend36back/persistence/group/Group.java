package kks.lend36back.persistence.group;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"group\"", schema = "lend")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "number", nullable = false)
    private Integer number;

    @Size(max = 255)
    @NotNull
    @Column(name = "period", nullable = false)
    private String period;

    @Size(max = 255)
    @NotNull
    @Column(name = "lector_name", nullable = false)
    private String lectorName;

    @Size(max = 1)
    @NotNull
    @Column(name = "status", nullable = false, length = 1)
    private String status;

}