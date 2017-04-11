package view.telefone;

import view.funcionario.*;
import view.empresa.*;
import controller.EmpresaController;
import controller.FuncionarioController;
import controller.TelefoneFucionarioController;
import javax.swing.JOptionPane;
import model.Entitys.Empresa;
import model.Entitys.Funcionario;
import model.Entitys.Telefone;
import util.BDMensagensPadrao;
import model.dao.FuncionarioDAO;
import model.dao.TelefoneFuncionarioDAO;

public class DetahesTelefone extends javax.swing.JFrame {
    private Telefone telefone;

    public DetahesTelefone( Telefone telefone) {
        initComponents();
        this.telefone=telefone;
        mortrarDados();
        setResizable(false);
        setLocationRelativeTo(this);
    }

    
    private void mortrarDados() {
            labelDescricao.setText(this.telefone.getDescricao());
            labelNumero.setText(this.telefone.getNumero());
          
    }
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        painelDados = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelDescricao = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelNumero = new javax.swing.JLabel();
        painelButoes = new javax.swing.JPanel();
        btnAlterar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Descriçãp");

        labelDescricao.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        labelDescricao.setText("...");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Numero");

        labelNumero.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        labelNumero.setText("...");

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(512, 512, 512))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addComponent(labelDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(203, Short.MAX_VALUE))
        );

        painelButoes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAlterar.setText("Editar");
        btnAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAlterarMouseReleased(evt);
            }
        });
        painelButoes.add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 11, 79, 54));

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnCancelarMouseReleased(evt);
            }
        });
        painelButoes.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 11, -1, 54));

        btnExcluir.setText("Excluir");
        btnExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnExcluirMouseReleased(evt);
            }
        });
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        painelButoes.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 79, 54));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelButoes, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, 563, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(painelButoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseReleased
   //    CadastroTelefone alterar = new CadastroTelefone(this.telefone);
      // alterar.setVisible(true);
    }//GEN-LAST:event_btnAlterarMouseReleased

    private void btnCancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseReleased
      dispose();
    }//GEN-LAST:event_btnCancelarMouseReleased

    private void btnExcluirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirMouseReleased

    public boolean excluir (){
         TelefoneFuncionarioDAO dao = new TelefoneFucionarioController();
        try{
            dao.remove(telefone);
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
       int mensagem = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir ", null, JOptionPane.YES_NO_OPTION);
        if(mensagem == JOptionPane.YES_OPTION){
            if (excluir())
                JOptionPane.showMessageDialog(null,BDMensagensPadrao.EXCLUIDO_COM_SUCESSO);
            else
              new Exception(BDMensagensPadrao.INSTRUCAO_ERRO);
        }else {
            JOptionPane.showConfirmDialog(null,"Operação cencelada");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JPanel painelButoes;
    private javax.swing.JPanel painelDados;
    // End of variables declaration//GEN-END:variables
}
