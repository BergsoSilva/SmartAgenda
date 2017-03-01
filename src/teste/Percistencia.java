/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.util.List;
import model.Entitys.Cliente;
import model.Entitys.Funcionario;
import model.Entitys.Telefone;
import model.Impl.ClienteDAOImpl;
import model.Impl.FuncionarioDAOImpl;
import model.dao.TelefoneDAO;
import model.Impl.TelefoneDAOImpl;
import model.dao.ClienteDAO;
import model.dao.FuncionarioDAO;

/**
 *
 * @author Unknown
 */
public class Percistencia {
    public static void main(String[] args) {
        
           TelefoneDAO t = new TelefoneDAOImpl();
           
           Telefone fone = new Telefone();
           fone.setId(Long.parseLong("1"));
           
           t.remove(fone);
           
          
    }
}
