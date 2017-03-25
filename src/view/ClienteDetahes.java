package view;

import controller.ClienteController;
import javax.swing.JOptionPane;
import model.Entitys.Empresa;
import model.dao.ClienteDAO;
import util.BDMensagensPadrao;

public class ClienteDetahes extends javax.swing.JFrame {
    private Empresa cliente;

    public ClienteDetahes( Empresa cliente) {
        initComponents();
        this.cliente=cliente;
        mortrarDados();
        setResizable(false);
        setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    
    private void mortrarDados() {
            
            jLabelRazaoSosial.setText(this.cliente.getRazaosocial());
         
    }
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        painelDados = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelRazaoSosial = new javax.swing.JLabel();
        painelButoes = new javax.swing.JPanel();
        btnAlterar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Razao Social");

        jLabelRazaoSosial.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelRazaoSosial.setText("...");

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabelRazaoSosial))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelRazaoSosial)
                .addContainerGap(268, Short.MAX_VALUE))
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
            .addComponent(painelButoes, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
            .addComponent(painelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46)
                .addComponent(painelButoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseReleased
       // salvarDados();
    }//GEN-LAST:event_btnAlterarMouseReleased

    private void btnCancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseReleased
      dispose();
    }//GEN-LAST:event_btnCancelarMouseReleased

    private void btnExcluirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirMouseReleased

    public boolean excluir (){
        ClienteDAO dao = new ClienteController();
        try{
            dao.remove(cliente);
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
       int mensagem = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir " +
                       cliente.getRazaosocial()+ "?", null, JOptionPane.YES_NO_OPTION);
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
    private javax.swing.JLabel jLabelRazaoSosial;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel painelButoes;
    private javax.swing.JPanel painelDados;
    // End of variables declaration//GEN-END:variables
}
