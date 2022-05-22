package lt.vu.services.interfaces;

import lt.vu.entities.Employee;

public interface ILoginNameGenerator {
    String generateLoginName(Employee employee);
}
