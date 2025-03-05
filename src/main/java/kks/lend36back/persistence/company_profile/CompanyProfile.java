package kks.lend36back.persistence.company_profile;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kks.lend36back.persistence.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "company_profile", schema = "lend")
public class CompanyProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 30)
    @NotNull
    @Column(name = "registration_number", nullable = false, length = 30)
    private String registrationNumber;

    @Size(max = 1000)
    @Column(name = "description", length = 1000)
    private String description;

    @Size(max = 255)
    @Column(name = "www")
    private String www;

    @Size(max = 225)
    @Column(name = "address", length = 225)
    private String address;

    @Size(max = 25)
    @NotNull
    @Column(name = "phone", nullable = false, length = 25)
    private String phone;

    public void setCompanyProfile(CompanyProfile companyProfile) {

    }
}