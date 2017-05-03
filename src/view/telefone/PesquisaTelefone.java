package view.telefone;

import view.funcionario.*;

import controller.TelefoneEmpresaController;
import controller.TelefoneFucionarioController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenuItem;
import model.Entitys.TelefoneEmpresa;
import model.Entitys.TelefoneFuncionario;
import model.dao.TelefoneEmpresaDAO;
import model.dao.TelefoneFuncionarioDAO;

public class PesquisaTelefone extends javax.swing.JFrame {
    
    private List<TelefoneEmpresa> telefoneEmpresa  = new ArrayList<>();
    private List<TelefoneFuncionario> telefoneFuncinario  = new ArrayList<>();
    
    private TelefoneFuncionario telfuncionario= new TelefoneFuncionario();
    private TelefoneEmpresa telempresa= new TelefoneEmpresa();
    
    

    public PesquisaTelefone() {
        initComponents();
        prencherTabela();
        carregarMenuFlutuante();
        setLocationRelativeTo(this);
       
    }
    
    private void pesquisar(){        
        pegarPesquisa();
        try { 
            if (radioEmp.isSelected()){
                TelefoneEmpresaDAO daoemp = new TelefoneEmpresaController();
                this.telefoneEmpresa = daoemp.getAll(TelefoneEmpresa.class);
                this.telefoneFuncinario.clear();
            }else if (radioFun.isSelected()){
                TelefoneFuncionarioDAO daofun = new TelefoneFucionarioController();
                this.telefoneFuncinario=daofun.getAll(TelefoneFuncionario.class);
                this.telefoneEmpresa.clear();
            }
     
        }catch(Exception e){
            e.printStackTrace();
        }           
        
    }
     
    private void prencherTabela(){
         pesquisar();
         tabelaTelEmpresa.setModel(new TabelaModeloEmpresaTel(telefoneEmpresa));
         tabelaTelfuncionario.setModel(new TabelaModeloFuncionarioTel(telefoneFuncinario));
     }
    
    private void pegarPesquisa(){
        
       //tring pesquisa =camoPesquisa.getText();
       //his.telfuncionario.set
    }
    
    private void carregarMenuFlutuante(){
        JMenuItem menuItem[] = {new JMenuItem("Ver detalhes"), new JMenuItem("Alterar")};
        
        menuItem[0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               verDetalhes();
            }
        });
        
        menuItem[1].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    alterar();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        for (JMenuItem menuItem1 : menuItem) {
            popupOperacoes.add(menuItem1);
        }
    }
    
    private void verDetalhes(){
        
     // Detahes detalhes= new Detahes(this.funcionario);
     // detalhes.setVisible(true);
    }
    private void alterar(){
        if(radioEmp.isSelected()){
            CadastroTelefone editar= new CadastroTelefone(this.telempresa);
            editar.setVisible(true);
        }else if (radioFun.isSelected()){
            CadastroTelefone editar= new CadastroTelefone(this.telfuncionario);
            editar.setVisible(true);
        }
        
    }
    
    private void selecionarLinha( MouseEvent evt){
        int linha= tabelaTelEmpresa.rowAtPoint(evt.getPoint());
        if(linha > -1){
            tabelaTelEmpresa.setRowSelectionInterval(linha,linha);
            linha= tabelaTelEmpresa.getSelectedRow();
          this.telempresa= telefoneEmpresa.get(linha);
        }
    }
    private void realizarAcao(MouseEvent evt){
        
        if (evt.getButton() == evt.BUTTON1){
            
            if(evt.getClickCount() > 1){
                verDetalhes();
            }
        }else{
            if(evt.getButton() == evt.BUTTON3){
                popupOperacoes.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupOperacoes = new javax.swing.JPopupMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaTelEmpresa = new javax.swing.JTable();
        painelButoes = new javax.swing.JPanel();
        botaSair = new javax.swing.JButton();
        botaoNovo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaTelfuncionario = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        camoPesquisa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        radioEmp = new javax.swing.JRadioButton();
        radioFun = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        tabelaTelEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelaTelEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaTelEmpresaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaTelEmpresa);

        botaSair.setText("Sair");
        botaSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botaSairMouseReleased(evt);
            }
        });

        botaoNovo.setText("Novo");
        botaoNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botaoNovoMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout painelButoesLayout = new javax.swing.GroupLayout(painelButoes);
        painelButoes.setLayout(painelButoesLayout);
        painelButoesLayout.setHorizontalGroup(
            painelButoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelButoesLayout.createSequentialGroup()
                .addContainerGap(546, Short.MAX_VALUE)
                .addComponent(botaSair, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(painelButoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelButoesLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(botaoNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(537, Short.MAX_VALUE)))
        );
        painelButoesLayout.setVerticalGroup(
            painelButoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelButoesLayout.createSequentialGroup()
                .addComponent(botaSair, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(painelButoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelButoesLayout.createSequentialGroup()
                    .addComponent(botaoNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        tabelaTelfuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelaTelfuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaTelfuncionarioMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaTelfuncionario);

        camoPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                camoPesquisaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                camoPesquisaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                camoPesquisaKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Pesquisar");

        buttonGroup1.add(radioEmp);
        radioEmp.setText("Empresa");

        buttonGroup1.add(radioFun);
        radioFun.setText("Funcionario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(camoPesquisa)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(radioEmp)
                                .addGap(18, 18, 18)
                                .addComponent(radioFun)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioEmp)
                    .addComponent(radioFun))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(camoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelButoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(330, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelButoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(130, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(93, 93, 93)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaSairMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaSairMouseReleased
      dispose();
    }//GEN-LAST:event_botaSairMouseReleased

    private void camoPesquisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camoPesquisaKeyTyped
       //ssss
    }//GEN-LAST:event_camoPesquisaKeyTyped

    private void camoPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camoPesquisaKeyReleased

    }//GEN-LAST:event_camoPesquisaKeyReleased

    private void camoPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camoPesquisaKeyPressed
       if(evt.getKeyCode()== KeyEvent.VK_ENTER){
           prencherTabela();
       }
    }//GEN-LAST:event_camoPesquisaKeyPressed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
       prencherTabela();
    }//GEN-LAST:event_formWindowGainedFocus

    private void tabelaTelEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaTelEmpresaMouseClicked
        selecionarLinha(evt);
        realizarAcao(evt);
    }//GEN-LAST:event_tabelaTelEmpresaMouseClicked

    private void tabelaTelfuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaTelfuncionarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaTelfuncionarioMouseClicked

    private void botaoNovoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoNovoMouseReleased
        CadastroTelefone cadasro = new CadastroTelefone();
        cadasro.setVisible(true);
    }//GEN-LAST:event_botaoNovoMouseReleased

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PesquisaTelefone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaTelefone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaTelefone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaTelefone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaTelefone().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaSair;
    private javax.swing.JButton botaoNovo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField camoPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel painelButoes;
    private javax.swing.JPopupMenu popupOperacoes;
    private javax.swing.JRadioButton radioEmp;
    private javax.swing.JRadioButton radioFun;
    private javax.swing.JTable tabelaTelEmpresa;
    private javax.swing.JTable tabelaTelfuncionario;
    // End of variables declaration//GEN-END:variables
}
