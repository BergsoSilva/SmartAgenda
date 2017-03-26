package view.empresa;


import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Entitys.Empresa;


public class TabelaModeloEmpresa extends AbstractTableModel{
    
    private String colunas[] = {"Razãoo Social"}; 
    private List<Empresa> clientes;

    public TabelaModeloEmpresa(List<Empresa> clientes) {
        this.clientes = clientes;
    }
    
    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Empresa cliente = clientes.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return cliente.getRazaosocial();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {            
        return colunas[column];       
    }
}
