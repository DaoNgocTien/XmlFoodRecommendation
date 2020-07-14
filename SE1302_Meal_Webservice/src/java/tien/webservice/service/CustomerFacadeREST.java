/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.webservice.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import tien.daos.CustomerCommentDAO;
import tien.daos.CustomerDAO;
import tien.webservice.Customer;

/**
 *
 * @author Admin
 */
@Stateless
@Path("tien.webservice.customer")
public class CustomerFacadeREST extends AbstractFacade<Customer> {

    @PersistenceContext(unitName = "SE1302_Meal_WebservicePU")
    private EntityManager em;

    public CustomerFacadeREST() {
        super(Customer.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Customer entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Customer entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Customer find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Customer> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Customer> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Path("/createNewCustomer")
    @POST
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(MediaType.TEXT_PLAIN)
    public String createNewCustomer(@FormParam("txtName") String txtName,
            @FormParam("txtEmail") String txtEmail,
            @FormParam("txtDate") String txtDate,
            @FormParam("txtMessage") String txtMessage) {
        System.out.println(txtName);
        System.out.println(txtEmail);
        System.out.println(txtDate);
        System.out.println(txtMessage);

        try {
            List<Customer> list = (List<Customer>) getEntityManager()
                    .createQuery("SELECT c FROM Customer c WHERE c.email = :email")
                    .setParameter("email", txtEmail)
                    .getResultList();
            System.out.println(list.size());
            if (!list.isEmpty()) {
                return "Email exist";
            } else {
                CustomerDAO dao = new CustomerDAO();
                dao.insert(txtName, txtEmail, txtDate, txtMessage);
                Customer newCustomer = (Customer) getEntityManager()
                        .createQuery("SELECT c FROM Customer c WHERE c.email = :email")
                        .setParameter("email", txtEmail)
                        .getSingleResult();
                CustomerCommentDAO ccDAO = new CustomerCommentDAO();
                ccDAO.insert(newCustomer.getId(), txtMessage);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Creat Customer Successfully";
    }
}
