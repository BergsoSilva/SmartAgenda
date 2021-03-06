package view.empresa;

import controller.EmpresaController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenuItem;
import model.Entitys.Empresa;
import model.dao.EmpresaDAO;
import view.funcionario.Pesquisa;

import view.telefone.PesquisaTelefone;

public class EmpresaPesquisa extends javax.swing.JFrame {

    private List<Empresa> clientes = new ArrayList<>();
    private Empresa cliente = new Empresa();

    public EmpresaPesquisa() {
        initComponents();
        prencherTabela();
        carregarMenuFlutuante();
        setLocationRelativeTo(this);

    }

    private void pesquisar() {
        pegarPesquisa();
        try {
            EmpresaDAO dao = new EmpresaController();
            this.clientes = dao.getAll(Empresa.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void prencherTabela() {
        pesquisar();
        tabelaClientes.setModel(new TabelaModeloEmpresa(clientes));
    }

    private void pegarPesquisa() {
        this.cliente.setRazaosocial(camoPesquisa.getText());
    }

    private void carregarMenuFlutuante() {
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

    private void verDetalhes() {
        EmpresaDetahes detalhes = new EmpresaDetahes(this.cliente);
        detalhes.setVisible(true);
    }

    private void alterar() {
        //ClienteDetahes detalhes= new EmpresaDetahes();
        //detalhes.setVisi voidle(true);
    }

    private void selecionarLinha(MouseEvent evt) {
        int linha = tabelaClientes.rowAtPoint(evt.getPoint());
        if (linha > -1) {
            tabelaClientes.setRowSelectionInterval(linha, linha);
            linha = tabelaClientes.getSelectedRow();
            this.cliente = clientes.get(linha);
        }
    }

    private void realizarAcao(MouseEvent evt) {
        if (evt.getButton() == evt.BUTTON1) {

            if (evt.getClickCount() > 1) {
                verDetalhes();
            }
        } else if (evt.getButton() == evt.BUTTON3) {
            popupOperacoes.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupOperacoes = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        camoPesquisa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        painelButoes = new javax.swing.JPanel();
        botaSair = new javax.swing.JButton();
        botaoNovo = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemFuncinario = new javax.swing.JMenuItem();
        jMenuItemTelefone = new javax.swing.JMenuItem();
        jMenuItemEmpresa = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaClientes);

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(camoPesquisa, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(painelButoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(camoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelButoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

        jMenu1.setText("File");

        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItemFuncinario.setText("Fucionario");
        jMenuItemFuncinario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFuncinarioActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemFuncinario);

        jMenuItemTelefone.setText("Telefone");
        jMenuItemTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTelefoneActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemTelefone);

        jMenuItemEmpresa.setText("Empresa");
        jMenuItemEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEmpresaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemEmpresa);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaSairMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaSairMouseReleased
        System.exit(0);
    }//GEN-LAST:event_botaSairMouseReleased

    private void camoPesquisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camoPesquisaKeyTyped
        //ssss
    }//GEN-LAST:event_camoPesquisaKeyTyped

    private void camoPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camoPesquisaKeyReleased

    }//GEN-LAST:event_camoPesquisaKeyReleased

    private void camoPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camoPesquisaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            prencherTabela();
        }
    }//GEN-LAST:event_camoPesquisaKeyPressed

    private void botaoNovoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoNovoMouseReleased
        EmpresaCadastro cadasro = new EmpresaCadastro();
        cadasro.setVisible(true);
    }//GEN-LAST:event_botaoNovoMouseReleased

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        prencherTabela();
    }//GEN-LAST:event_formWindowGainedFocus

    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMouseClicked
        selecionarLinha(evt);
        realizarAcao(evt);
    }//GEN-LAST:event_tabelaClientesMouseClicked

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
       
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItemFuncinarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFuncinarioActionPerformed
        Pesquisa pesfuncionario = new Pesquisa();
        pesfuncionario.setVisible(true);

    }//GEN-LAST:event_jMenuItemFuncinarioActionPerformed

    private void jMenuItemTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTelefoneActionPerformed
        PesquisaTelefone telefone = new PesquisaTelefone();
      telefone.setVisible(true);
    }//GEN-LAST:event_jMenuItemTelefoneActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jMenuItemEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEmpresaActionPerformed
         EmpresaCadastro empresa = new EmpresaCadastro();
        empresa.setVisible(true);
    }//GEN-LAST:event_jMenuItemEmpresaActionPerformed

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
            java.util.logging.Logger.getLogger(EmpresaPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpresaPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpresaPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpresaPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpresaPesquisa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaSair;
    private javax.swing.JButton botaoNovo;
    private javax.swing.JTextField camoPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemEmpresa;
    private javax.swing.JMenuItem jMenuItemFuncinario;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenuItem jMenuItemTelefone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelButoes;
    private javax.swing.JPopupMenu popupOperacoes;
    private javax.swing.JTable tabelaClientes;
    // End of variables declaration//GEN-END:variables
}
