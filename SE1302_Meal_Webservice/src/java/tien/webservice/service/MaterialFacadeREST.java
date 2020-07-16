/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.webservice.service;

import java.time.LocalDateTime;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import tien.webservice.Material;

/**
 *
 * @author Admin
 */
@Stateless
@Path("tien.webservice.material")
public class MaterialFacadeREST extends AbstractFacade<Material> {

    @PersistenceContext(unitName = "SE1302_Meal_WebservicePU")
    private EntityManager em;

    public MaterialFacadeREST() {
        super(Material.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Material entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Material entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML + "; charset=UTF-8", MediaType.APPLICATION_JSON + "; charset=UTF-8"})
    public Material find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML + "; charset=UTF-8", MediaType.APPLICATION_JSON + "; charset=UTF-8"})
    public List<Material> findAll() {
        LocalDateTime now = LocalDateTime.now();
        int first = now.getMinute();
        int second = now.getSecond();
        for (int i = 0; i < 50000; i++) {
super.findAll();
        }
        now = LocalDateTime.now();
        int first1 = now.getMinute();
        int second2 = now.getSecond();
        System.out.println("Minute: " + (first - first1) + "\nSecond: " + (second - second2));
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML + "; charset=UTF-8", MediaType.APPLICATION_JSON + "; charset=UTF-8"})
    public List<Material> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN + "; charset=UTF-8")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Path("/searchFoodByLikeName")
    @GET
    @Produces({MediaType.APPLICATION_XML + "; charset=UTF-8", MediaType.APPLICATION_JSON + "; charset=UTF-8"})
    public List<Material> searchFoodByLikeName(@QueryParam("txtSearch") String txtSearch) {
        System.out.println(txtSearch);
        if (txtSearch.equalsIgnoreCase("empty")) {
            return super.findRange(new int[]{0, 99});
        }
        List<Material> result = (List<Material>) getEntityManager()
                .createQuery("SELECT m FROM Material m Where m.foodname LIKE :search")
                .setParameter("search", "%" + txtSearch + "%")
                .getResultList();
        return result;
    }

    @Path("/searchFoodByLikeName/{txtSearch}")
    @GET
    @Produces({MediaType.APPLICATION_XML + "; charset=UTF-8", MediaType.APPLICATION_JSON + "; charset=UTF-8"})
    public List<Material> searchFoodByLikeNameWithParameter(@PathParam("txtSearch") String txtSearch) {
        System.out.println(txtSearch);
        if (txtSearch.equalsIgnoreCase("empty")) {
            return super.findRange(new int[]{0, 99});
        }
        List<Material> result = (List<Material>) getEntityManager()
                .createQuery("SELECT m FROM Material m Where m.foodname LIKE :search")
                .setParameter("search", "%" + txtSearch + "%")
                .getResultList();
        return result;
    }
}
