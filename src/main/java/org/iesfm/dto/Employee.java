package org.iesfm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String nif;
    private String name;
    private String surname;
    private String role;
    private int departmentId;

}