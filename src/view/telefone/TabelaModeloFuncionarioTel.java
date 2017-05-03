package view.telefone;


import view.empresa.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Entitys.Empresa;
import model.Entitys.TelefoneFuncionario;


public class TabelaModeloFuncionarioTel extends AbstractTableModel{
    
    private String colunas[] = {"Tipo","Número"}; 
    private List<TelefoneFuncionario> funTelefones;

    public TabelaModeloFuncionarioTel(List<TelefoneFuncionario> funTelefones) {
        this.funTelefones = funTelefones;
    }
    
    @Override
    public int getRowCount() {
        return funTelefones.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TelefoneFuncionario telFuncionario = funTelefones.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return telFuncionario.getDescricao();
            case 1: 
                return telFuncionario.getNumero();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {            
        return colunas[column];       
    }
}
