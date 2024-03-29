/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceRessourceH;

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
import services.ServiceRHLocal;
import com.google.gson.Gson;

/**
 * REST Web Service
 *
 * @author alban
 */
@Path("modifSupr")
@RequestScoped
public class ModifSuprResource {

    ServiceRHLocal serviceRH = lookupServiceRHLocal();

    private Gson gson;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ModifSuprResource
     */
    public ModifSuprResource() {
        this.gson = new Gson();
    }

    /**
     * Retrieves representation of an instance of serviceRessourceH.ModifSuprResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(int id) {
        //TODO return proper representation object
        return "test";
    }

    /**
     * PUT method for updating or creating an instance of ModifSuprResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @Path("Suppr")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String supprimerForma(@QueryParam("idFrom") int id) {
        return this.gson.toJson(this.serviceRH.supprimerForma(id));      
    }
    
    @Path("modif")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String modifierForma(String content) {
        return this.gson.toJson(serviceRH.changerStatut(content));        
    }

    private ServiceRHLocal lookupServiceRHLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (ServiceRHLocal) c.lookup("java:global/serviceRessourceH-ear/serviceRessourceH-ejb-1.0-SNAPSHOT/ServiceRH!services.ServiceRHLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
