/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBFacades;
import Entities.Medicamentos;
import Entities.MisMedicamentos;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
@Path("medicamentos")
public class MedicamentosFacadeREST extends AbstractFacade<Medicamentos> {

    @PersistenceContext(unitName = "RecuperAppServerPU")
    private EntityManager em;

    public MedicamentosFacadeREST() {
        super(Medicamentos.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Medicamentos create(Medicamentos entity) {
        return super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Medicamentos entity) {
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
    public Medicamentos find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Medicamentos> findAll() {
        return super.findAll();
    }

    @GET
    @Path("misMedicamentos/{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MisMedicamentos> misMedicamentos(@PathParam("cedula") Integer c) {
        
        System.out.println(c);
        
        TypedQuery<MisMedicamentos> misMedicamentosquery = em.createNamedQuery("misMedicamentos", MisMedicamentos.class);
        List<MisMedicamentos> misMedicamentos = misMedicamentosquery.getResultList();
        
        return misMedicamentos;
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Medicamentos> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
