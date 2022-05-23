package lt.vu.services;

import lt.vu.entities.Employee;
import lt.vu.services.interfaces.ILoginNameGenerator;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.io.Serializable;

@Alternative
@ApplicationScoped
public class DisabledLoginNameGenerator implements ILoginNameGenerator, Serializable {
    public String generateLoginName(Employee employee) {
        return "Currently not working";
    }
}
