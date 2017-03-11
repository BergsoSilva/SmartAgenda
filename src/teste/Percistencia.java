/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import model.Entitys.Cliente;
import controller.ClienteController;
import model.dao.ClienteDAO;

/**
 *
 * @author Unknown
 */
public class Percistencia {
    public static void main(String[] args) {
         ClienteDAO dao = new ClienteController();
         Cliente cliente = new Cliente();        
          for (Cliente c : dao.getAll(Cliente.class)) {
              System.out.println("---"+c.getRazaosocial());
        }
    }
}
