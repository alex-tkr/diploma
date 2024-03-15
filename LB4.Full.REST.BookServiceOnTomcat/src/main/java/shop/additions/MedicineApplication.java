package shop.additions;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.core.Application;
import shop.service.MedicineServiceRestImpl;

public class MedicineApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();

        classes.add(MedicineServiceRestImpl.class);

        return classes;
    }
}