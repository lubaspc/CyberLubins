/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}