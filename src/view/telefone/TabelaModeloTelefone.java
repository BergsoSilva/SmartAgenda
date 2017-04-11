package view.telefone;


import java.util.List;
import javax.swing.table.AbstractTableModel;

import model.Entitys.Telefone;


public class TabelaModeloTelefone extends AbstractTableModel{
    
    private String colunas[] = {"Numero"}; 
    private List<Telefone> telefones;

    public TabelaModeloTelefone(List<Telefone> telefones) {
        this.telefones = telefones;
    }
    
    @Override
    public int getRowCount() {
        return telefones.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Telefone tefefone = telefones.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return tefefone.getNumero();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {            
        return colunas[column];       
    }
}
