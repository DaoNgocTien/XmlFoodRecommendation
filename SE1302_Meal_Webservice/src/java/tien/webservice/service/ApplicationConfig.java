/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.webservice.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Admin
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(tien.webservice.service.CustomerCommentFacadeREST.class);
        resources.add(tien.webservice.service.CustomerFacadeREST.class);
        resources.add(tien.webservice.service.CustomerRecommendationFoodFacadeREST.class);
        resources.add(tien.webservice.service.FoodFacadeREST.class);
        resources.add(tien.webservice.service.FoodMaterialFacadeREST.class);
        resources.add(tien.webservice.service.MaterialFacadeREST.class);
    }
    
}
