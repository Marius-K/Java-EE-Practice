package lt.vu.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EmployeeDto {
    private String firstName;

    private String lastName;

    private String loginName;

    private Integer departmentId;
}
