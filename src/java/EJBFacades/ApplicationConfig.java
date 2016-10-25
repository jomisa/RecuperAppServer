/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBFacades;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author jmss1
 */
@javax.ws.rs.ApplicationPath("WebServices")
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
        resources.add(EJBFacades.AnimoFacadeREST.class);
        resources.add(EJBFacades.CaminatasFacadeREST.class);
        resources.add(EJBFacades.CitasFacadeREST.class);
        resources.add(EJBFacades.EstadosAnimoFacadeREST.class);
        resources.add(EJBFacades.FisiologicosFacadeREST.class);
        resources.add(EJBFacades.ListaMedicamentosFacadeREST.class);
        resources.add(EJBFacades.ListaSintomasCaminataFacadeREST.class);
        resources.add(EJBFacades.ListaSintomasFacadeREST.class);
        resources.add(EJBFacades.ListaSintomasMedicamentosFacadeREST.class);
        resources.add(EJBFacades.MedicamentosFacadeREST.class);
        resources.add(EJBFacades.PacientesFacadeREST.class);
        resources.add(EJBFacades.SintomasFacadeREST.class);
        resources.add(Util.FiltroRecursos.class);
    }
    
}
