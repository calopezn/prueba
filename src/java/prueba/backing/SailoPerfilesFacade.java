/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.backing;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import prueba.entidadess.SailoPerfiles;

/**
 *
 * @author CALopezN
 */
@Stateless
public class SailoPerfilesFacade extends AbstractFacade<SailoPerfiles> {

    @PersistenceContext(unitName = "Prueba4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SailoPerfilesFacade() {
        super(SailoPerfiles.class);
    }
    
}
