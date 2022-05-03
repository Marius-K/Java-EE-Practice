package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.DepartmentMapper;
import lt.vu.mybatis.model.Department;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class DepartmentsMyBatis {
    @Inject
    private DepartmentMapper departmentMapper;

    @Getter
    private List<Department> departmentList;

    @Getter @Setter
    private Department newDepartment = new Department();

    @PostConstruct
    public void init() {
        this.departmentList = this.departmentMapper.selectAll();
    }

    @Transactional
    public String createDepartment() {
        departmentMapper.insert(newDepartment);
        return "/index?faces-redirect=true";
    }
}
