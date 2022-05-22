package lt.vu.rest;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Department;
import lt.vu.entities.Employee;
import lt.vu.persistence.DepartmentsDAO;
import lt.vu.persistence.EmployeesDAO;
import lt.vu.rest.dto.EmployeeDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/employees")
public class EmployeeController {

    @Inject
    @Getter @Setter
    private EmployeesDAO employeesDAO;

    @Inject
    @Getter @Setter
    private DepartmentsDAO departmentsDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response show(@PathParam("id") final Integer id) {
        Employee employee = employeesDAO.find(id);
        if (employee == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setLoginName(employee.getLoginName());
        employeeDto.setDepartmentId(employee.getDepartment().getId());

        return Response.ok(employeeDto).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response store(EmployeeDto employeeDto) {
        try {
            Employee employee = new Employee();

            Department department = departmentsDAO.find(employeeDto.getDepartmentId());

            if (department == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            employee.setFirstName(employeeDto.getFirstName());
            employee.setLastName(employeeDto.getLastName());
            employee.setLoginName(employeeDto.getLoginName());
            employee.setDepartment(department);
            employeesDAO.create(employee);

            return Response.status(Response.Status.CREATED).build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer id,
            EmployeeDto employeeDto) {
        try {
            Employee employee = employeesDAO.find(id);

            if (employee == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            Department department = departmentsDAO.find(employeeDto.getDepartmentId());

            if (department == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException exception) {

            }
            employee.setFirstName(employeeDto.getFirstName());
            employee.setLastName(employeeDto.getLastName());
            employee.setLoginName(employeeDto.getLoginName());
            employee.setDepartment(department);
            employeesDAO.update(employee);

            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
