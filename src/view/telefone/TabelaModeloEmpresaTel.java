package view.telefone;


import view.empresa.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Entitys.Empresa;
import model.Entitys.TelefoneEmpresa;


public class TabelaModeloEmpresaTel extends AbstractTableModel{
    
    private String colunas[] = {"Tipo","Numero"}; 
    private List<TelefoneEmpresa> tels;

    public TabelaModeloEmpresaTel(List<TelefoneEmpresa> tels) {
        this.tels = tels;
    }
    
    @Override
    public int getRowCount() {
        return tels.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TelefoneEmpresa telEmpresa = tels.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return telEmpresa.getDescricao();
            case 1:
                return telEmpresa.getNumero();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {            
        return colunas[column];       
    }
}
