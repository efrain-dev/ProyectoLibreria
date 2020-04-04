/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author efrai
 */
@Stateless
public class VentapFacade extends AbstractFacade<Ventap> {

    @PersistenceContext(unitName = "LibreriaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentapFacade() {
        super(Ventap.class);
    }
    
}
