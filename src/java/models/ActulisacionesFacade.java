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
public class ActulisacionesFacade extends AbstractFacade<Actulisaciones> {

    @PersistenceContext(unitName = "CyberLubinPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActulisacionesFacade() {
        super(Actulisaciones.class);
    }
    
    public List<Actulisaciones> updates(Trabajos tr){
        System.out.println(tr.getIdTrabajos());
       Query update =em.createNamedQuery("Actulisaciones.findByTrabajos")
                .setParameter("idTrabajos", tr.getIdTrabajos());
                
        System.out.println(update);
        
        return update.getResultList();
    }

    public List<Actulisaciones> buscar(Trabajos idTrabajos) {
        Query consulta = em.createNamedQuery("Actulisaciones.findByTrabajos",Actulisaciones.class)
                .setParameter("idTrabajos", idTrabajos);
        List<Actulisaciones> lista = consulta.getResultList();
        
        return lista;
    }
    
}
