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
import model.dao.TelefoneDAO;
import model.Impl.TelefoneDAOImpl;

/**
 *
 * @author Unknown
 */
public class Percistencia {
    public static void main(String[] args) {
        Telefone telefone = new Telefone();
        Cliente cl= new Cliente();
        cl.setId(Long.parseLong("1"));
        Funcionario f = new Funcionario();
        f.setId(Long.parseLong("1"));
        telefone.setDescricao("Fixo");
        telefone.setNumero("1111-1111");
        telefone.setCliente(cl);
        telefone.setFuncionario(f);
        
        TelefoneDAO telefoneDao = new TelefoneDAOImpl();
        
        telefoneDao.save(telefone);
        
        
        System.out.println("----------------------------");
        
        
        List<Telefone> listaTelefones = telefoneDao.getAll(Telefone.class);
        
        for (Telefone listaTelefone : listaTelefones) {
            System.out.println("-" + listaTelefone.getDescricao());
        }

        
    }
}
