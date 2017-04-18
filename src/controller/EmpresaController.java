/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAcessObjectInterface.DAOImpl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Entitys.Empresa;
import model.dao.EmpresaDAO;

/**
 *
 * @author Unknown
 */
public class EmpresaController extends DAOImpl<Empresa, Long> implements EmpresaDAO{
    EntityManager em;
    public EmpresaController() {
    this.em=getEntitymanager();
    }
    
     
    
    public List<Empresa> getAllJoin(){
        Query qry = em.createNamedQuery("SELECT e FROM empresa e ");
        return qry.getResultList();
    }
}
