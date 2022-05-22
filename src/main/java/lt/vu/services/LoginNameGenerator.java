package lt.vu.services;

import lt.vu.entities.Employee;
import lt.vu.services.interfaces.ILoginNameGenerator;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Locale;
import java.util.Random;

@ApplicationScoped
public class LoginNameGenerator implements ILoginNameGenerator, Serializable {
    public String generateLoginName(Employee employee) {
        try {
            String loginName = employee.getFirstName().substring(0, 3);
            loginName += employee.getLastName().substring(0, 3);
            loginName += new Random().nextInt(9999);

            Thread.sleep(3000);

            return loginName.toLowerCase(Locale.ROOT);
        } catch (InterruptedException e) {
            return null;
        }
    }
}
