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
public class TelefoneEmpresa extends Telefone{
   
    @ManyToOne
    private Empresa empresa;

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    
    
}
