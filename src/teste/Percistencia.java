/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import model.Entitys.Empresa;
import controller.ClienteController;
import model.dao.ClienteDAO;

/**
 *
 * @author Unknown
 */
public class Percistencia {
    public static void main(String[] args) {
         ClienteDAO dao = new ClienteController();
         Empresa cliente = new Empresa();        
          for (Empresa c : dao.getAll(Empresa.class)) {
              System.out.println("---"+c.getRazaosocial());
        }
    }
}
