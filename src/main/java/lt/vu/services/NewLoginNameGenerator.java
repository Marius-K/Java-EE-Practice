package lt.vu.services;

import lt.vu.entities.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Specializes;
import java.nio.charset.StandardCharsets;
import java.util.Random;

//@Specializes
@Alternative
@ApplicationScoped
public class NewLoginNameGenerator extends LoginNameGenerator {
    public String generateLoginName(Employee employee) {
        byte[] array = new byte[8];
        new Random().nextBytes(array);

        return new String(array, StandardCharsets.ISO_8859_1);
    }
}
