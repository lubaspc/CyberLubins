/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author lubas
 */
@Stateless
public class TrabajosFacade extends AbstractFacade<Trabajos> {

    @PersistenceContext(unitName = "CyberLubinPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrabajosFacade() {
        super(Trabajos.class);
    }
    
    public Boolean Cambia_status(int nuevo,int Id){
        Query consulta = em.createNamedQuery("Trabajos.cambiar",Trabajos.class)
                .setParameter("status", nuevo)
                .setParameter("idTrabajos", Id);
        consulta.executeUpdate();
        return true;
    }
    
}
