package shop.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import shop.service.rest.JSONMessageBodyWriter;
import shop.service.rest.ServiceExceptionMapper;
import shop.service.rest.TextPlainMessageBodyWriter;
import shop.service.rest.XMLItemMessageBodyWriter;

@ApplicationPath(Constants.APPLICATION_PATH)
public class App extends Application {

    @Override
    public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(MedicineServiceRestImpl.class);
		classes.add(XMLItemMessageBodyWriter.class);
		classes.add(TextPlainMessageBodyWriter.class);
		classes.add(JSONMessageBodyWriter.class);
		classes.add(ServiceExceptionMapper.class);
		return Collections.unmodifiableSet(classes);
    }
}
