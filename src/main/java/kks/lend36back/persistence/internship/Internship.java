package kks.lend36back.persistence.internship;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kks.lend36back.persistence.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"internship\"", schema = "lend")
public class Internship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_user_id", nullable = false)
    private User companyUser;

    @Size(max = 255)
    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @Size(max = 1000)
    @NotNull
    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    @Size(max = 255)
    @NotNull
    @Column(name = "coordinator_name", nullable = false)
    private String coordinatorName;

    @Size(max = 255)
    @NotNull
    @Column(name = "coordinator_email", nullable = false)
    private String coordinatorEmail;

    @Size(max = 1)
    @NotNull
    @Column(name = "status", nullable = false, length = 1)
    private String status;

}