package view.funcionario;


import view.empresa.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Entitys.Empresa;
import model.Entitys.Funcionario;


public class TabelaModelo extends AbstractTableModel{
    
    private String colunas[] = {"Nome"}; 
    private List<Funcionario> funcionarios;

    public TabelaModelo(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    @Override
    public int getRowCount() {
        return funcionarios.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Funcionario funcionario = funcionarios.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return funcionario.getNome();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {            
        return colunas[column];       
    }
}
