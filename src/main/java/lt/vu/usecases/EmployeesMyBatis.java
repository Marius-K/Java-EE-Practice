package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.DepartmentMapper;
import lt.vu.mybatis.dao.EmployeeMapper;
import lt.vu.mybatis.model.Department;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.Map;

@Model
public class EmployeesMyBatis {
    @Inject
    private EmployeeMapper employeeMapper;

    @Inject
    private DepartmentMapper departmentMapper;

    @Getter @Setter
    private Department department;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer departmentId = Integer.parseInt(requestParameters.get("departmentId"));
        department = departmentMapper.selectByPrimaryKey(departmentId);
        System.out.println(department);
    }
}
