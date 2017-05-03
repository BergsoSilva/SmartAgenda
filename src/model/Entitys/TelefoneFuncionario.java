/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Entitys;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author pc
 */
@Entity
public class TelefoneFuncionario extends Telefone{
   
    @ManyToOne
    private Funcionario funcionario;

   
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

  
}
