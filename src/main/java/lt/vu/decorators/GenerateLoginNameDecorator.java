package lt.vu.decorators;

import lt.vu.entities.Employee;
import lt.vu.services.interfaces.ILoginNameGenerator;
import lt.vu.services.LoginNameGenerator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public class GenerateLoginNameDecorator implements ILoginNameGenerator {
    @Delegate
    @Any
    @Inject
    public LoginNameGenerator loginNameGenerator;

    @Override
    public String generateLoginName(Employee employee) {
        if (employee.getLoginName() != null) {
            throw new IllegalArgumentException("This user already has login name");
        }

        return loginNameGenerator.generateLoginName(employee);
    }
}
