package lt.vu.usecases;

import lt.vu.entities.Employee;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.EmployeesDAO;
import lt.vu.services.LoginNameGenerator;
import lt.vu.services.interfaces.ILoginNameGenerator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateLoginName implements Serializable {
    @Inject
    private ILoginNameGenerator loginNameGenerator;

    @Inject
    private EmployeesDAO employeesDAO;

    private CompletableFuture<String> loginNameGenerationTask = null;

    @LoggedInvocation
    public String generate() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Integer employeeId = Integer.parseInt(requestParameters.get("employeeId"));

        Employee employee = employeesDAO.find(employeeId);

        loginNameGenerationTask = CompletableFuture.supplyAsync(() -> loginNameGenerator.generateLoginName(employee))
                .exceptionally(Throwable::getMessage);

        return "/employeeInfo.xhtml?faces-redirect=true&employeeId=" + employeeId;
    }

    public boolean isLoginNameGeneratorRunning() {
        return loginNameGenerationTask != null && !loginNameGenerationTask.isDone();
    }

    public String getLoginGenerationStatus() throws ExecutionException, InterruptedException {
        if (loginNameGenerationTask == null) {
            return null;
        }

        if (isLoginNameGeneratorRunning()) {
            return "Generating login name, please wait...";
        }

        return "Suggested login name: " + loginNameGenerationTask.get();
    }
}
