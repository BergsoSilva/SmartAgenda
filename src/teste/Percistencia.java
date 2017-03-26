/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import controller.EmpresaController;
import controller.FuncionarioController;
import controller.TelefoneControle;
import model.Entitys.Empresa;
import model.Entitys.Funcionario;
import model.Entitys.Telefone;
import model.dao.EmpresaDAO;
import model.dao.FuncionarioDAO;
import model.dao.TelefoneDAO;


/**
 *
 * @author Unknown
 */
public class Percistencia {
    public static void main(String[] args) {
       Funcionario fun = new Funcionario();
       EmpresaDAO emdao= new EmpresaController();
       TelefoneDAO teldao= new TelefoneControle();
       FuncionarioDAO  fundao = new FuncionarioController();
       Telefone tel= new Telefone();
       
       fun= fundao.getById(Funcionario.class, 1l);
       Empresa em = emdao.getById(Empresa.class,2l);
      
       tel.setDescricao("Fixo");
       tel.setEmpresa(em);
       tel.setFuncionario(fun);
       tel.setNumero("111111111111111");
       
       teldao.save(tel);
        
    }
}
