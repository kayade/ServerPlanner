package sPlanner;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Kayode
 */
@javax.ws.rs.ApplicationPath("webresource")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(sPlanner.SPlanner.class);
    }
    
}
