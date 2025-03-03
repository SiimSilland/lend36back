package kks.lend36back.persistence.student_preference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import kks.lend36back.persistence.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student_preference", schema = "lend")
public class StudentPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @Column(name = "from_date", nullable = false)
    private Integer fromDate;

}