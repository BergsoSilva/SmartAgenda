package view;


import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Entitys.Cliente;


public class TabelaModeloCliente extends AbstractTableModel{
    
    private String colunas[] = {"Razãoo Social"}; 
    private List<Cliente> clientes;

    public TabelaModeloCliente(List<Cliente> clientes) {
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
        Cliente cliente = clientes.get(rowIndex);
        
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
