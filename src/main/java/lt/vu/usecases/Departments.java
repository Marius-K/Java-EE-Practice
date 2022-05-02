package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Department;
import lt.vu.persistence.DepartmentsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Departments {
    @Inject
    private DepartmentsDAO departmentsDAO;

    @Getter @Setter
    private Department newDepartment = new Department();

    @Getter
    private List<Department> departmentList;

    @PostConstruct
    public void init() {
        loadDepartments();
    }

    @Transactional
    public void createDepartment(){
        this.departmentsDAO.save(newDepartment);
    }

    private void loadDepartments(){
        this.departmentList = departmentsDAO.getAll();
    }
}
