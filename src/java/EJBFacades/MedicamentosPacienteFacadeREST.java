/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBFacades;

import Entities.MedicamentosPaciente;
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
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jmss1
 */
@Stateless
@Path("medicamentosPaciente")
public class MedicamentosPacienteFacadeREST {

    @PersistenceContext(unitName = "RecuperAppServerPU")
    private EntityManager em;

    public MedicamentosPacienteFacadeREST() {
        //super(MedicamentosPaciente.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(MedicamentosPaciente entity) {
        //super.create(entity);
        getEntityManager().persist(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, MedicamentosPaciente entity) {
        //super.edit(entity);
        getEntityManager().merge(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        //super.remove(super.find(id));
        //getEntityManager().remove(getEntityManager().merge(getEntityManager().find(entityClass, id)));
    }

    @GET
    @Path("{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MedicamentosPaciente> misMedicamentos(@PathParam("cedula") Integer c) {
        //getEntityManager().find(entityClass, id);
        //return super.find(id);
        System.out.println(c);
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
