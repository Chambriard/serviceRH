/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceRessourceH;

import com.google.gson.Gson;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author alban
 */
@Path("RH")
@RequestScoped
public class RHResource {

    services.ServiceRHLocal serviceRH = lookupServiceRHLocal();

    @Context
    private UriInfo context;
    private Gson gson;

    /**
     * Creates a new instance of RHResource
     */
    public RHResource() {
        this.gson = new Gson();
    }

    /**
     * Retrieves representation of an instance of serviceRessourceH.RHResource
     * @return an instance of java.lang.String
     */
    @Path("afficherPlan")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String afficherPlan() {
        return this.gson.toJson(serviceRH.renvoiPlan());
    }
    
    @Path("afficherForm")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String afficherForma() {
        //TODO return proper representation object
        return this.gson.toJson(serviceRH.renvoiForma());
    }
    
    @Path("afficherFormateurs")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String afficherFormateurs() {
        return this.gson.toJson(serviceRH.renvoiFormateurs());
    }

    /**
     * PUT method for updating or creating an instance of RHResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @Path("SupprimerForma")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String supprimerForma(@QueryParam("idForm") int id) {
        return serviceRH.supprimerForma(id);        
    }
    
    @Path("SupprimerFormaPlan")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String supprimerFormaPlan(@QueryParam("idPlan") int id) {
        return serviceRH.supprimerFormaPlan(id);        
    }
    
    @Path("AjoutFormaPlan")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String ajoutFormaPlan(String content) {
        return this.gson.toJson(serviceRH.ajouterFormaPlan(content));        
    }
    
    @Path("AjoutForma")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String ajoutForma(String content) {     
        return this.gson.toJson(serviceRH.ajouterForma(content));        
    }
    
    @Path("changerDate")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String changerDate(String content) {
        return this.gson.toJson(serviceRH.changerDate(content));        
    }

    private services.ServiceRHLocal lookupServiceRHLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (services.ServiceRHLocal) c.lookup("java:global/serviceRessourceH-ear/serviceRessourceH-ejb-1.0-SNAPSHOT/ServiceRH!services.ServiceRHLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
}
