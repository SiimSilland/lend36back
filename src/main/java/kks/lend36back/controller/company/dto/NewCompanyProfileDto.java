package kks.lend36back.controller.company.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewCompanyProfileDto implements Serializable {

    private String name;
    private String registrationNumber;
    private String description;
    private String www;
    private String address;
    private String phone;
    private Integer id;
}