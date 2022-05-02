package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Employee;
import lt.vu.entities.Position;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.EmployeesDAO;
import lt.vu.persistence.PositionsDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class EmployeeInfo implements Serializable {
    @Inject
    private EmployeesDAO employeesDAO;

    @Inject
    private PositionsDAO positionsDAO;

    private Employee employee;

    private List<Position> positionList;

    @PostConstruct
    private void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer employeeId = Integer.parseInt(requestParameters.get("employeeId"));
        employee = employeesDAO.find(employeeId);
        positionList = positionsDAO.getAll();
        System.out.println(positionList);
        System.out.println(positionList.isEmpty());
    }

    @Transactional
    @LoggedInvocation
    public String updateLoginName() {
        try{
            employeesDAO.update(employee);
        } catch (OptimisticLockException e) {
            return "/employeeInfo.xhtml?faces-redirect=true&employeeId=" + employee.getId() + "&error=optimistic-lock-exception";
        }
        return "employees.xhtml?departmentId=" + employee.getDepartment().getId() + "&faces-redirect=true";
    }
}
