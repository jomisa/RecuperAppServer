/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBFacades;

import Entities.Pacientes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jmss1
 */
@Stateless
@Path("pacientes")
public class PacientesFacadeREST extends AbstractFacade<Pacientes> {

    @PersistenceContext(unitName = "RecuperAppServerPU")
    private EntityManager em;

    public PacientesFacadeREST() {
        super(Pacientes.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Pacientes create(Pacientes entity) {
        return super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Pacientes entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pacientes find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("findPaciente/{cedula}/{contrasena}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pacientes findPaciente(@PathParam("cedula") Integer cedula, @PathParam("contrasena") String contrasena) {
        try{
            TypedQuery<Pacientes> queryFindCedula = em.createNamedQuery("verificarPaciente",Pacientes.class);
            queryFindCedula.setParameter(1, cedula);
            queryFindCedula.setParameter(2, contrasena);
            return queryFindCedula.getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pacientes> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pacientes> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
}
