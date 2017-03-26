package view.funcionario;

import view.empresa.*;
import controller.EmpresaController;
import controller.FuncionarioController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Entitys.Empresa;
import model.Entitys.Funcionario;
import model.Entitys.Telefone;
import util.BDMensagensPadrao;
import model.dao.EmpresaDAO;
import model.dao.FuncionarioDAO;

public class Cadastro extends javax.swing.JFrame {

    private String opcaoTela;
    private List<Telefone> telefones = new ArrayList<>();
    private Funcionario funcionario;

    public Cadastro(Funcionario funcionario) {
        initComponents();
        this.funcionario=funcionario;
        setResizable(false);
        setLocationRelativeTo(this);
        this.opcaoTela = "Alterar";
        btnSalavar1.setText(opcaoTela);
        preencherCombobox();
        preparaNomes();
        
    }

    public Cadastro() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        this.opcaoTela = "Cadastrar";
        btnSalavar1.setText(opcaoTela);
        setTitle(opcaoTela + " Funcionario");
        //preparaNomes();
        preencherCombobox();
        funcionario = new Funcionario();

    }

    public void liparCampos() {
        campoNome.setText("");
        comboEmpresa.setSelectedIndex(0);
    }

    private void preparaNomes() {
        setTitle(opcaoTela + " Funcinario");
        btnSalavar1.setText(opcaoTela);
        campoNome.setText(this.funcionario.getNome());
        comboEmpresa.setSelectedItem(this.funcionario.getEmpresa());
    }

    private void preencherCombobox() {

        comboEmpresa.removeAllItems();
        comboEmpresa.addItem("Selecione a empresa..");
        EmpresaDAO dao = new EmpresaController();
        for (Empresa em : dao.getAll(Empresa.class)) {
            comboEmpresa.addItem(em);
        }
    }

    private void pegarDados() {

        funcionario.setNome(campoNome.getText());
        funcionario.setEmpresa((Empresa) comboEmpresa.getSelectedItem());

    }

    public void cadastrar() {
        pegarDados();
        FuncionarioDAO dao = new FuncionarioController();

        try {
            dao.save(this.funcionario);
            JOptionPane.showMessageDialog(this, funcionario.getNome() + BDMensagensPadrao.CADASTRADO_COM_SUCESSO);
            liparCampos();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void editar() {
        pegarDados();
        FuncionarioDAO dao = new FuncionarioController();
        try {
            dao.save(this.funcionario);
            JOptionPane.showMessageDialog(this, funcionario.getNome() + BDMensagensPadrao.ALTERADO_COM_SUCESSO);
            liparCampos();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        painelDados = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        comboEmpresa = new javax.swing.JComboBox<>();
        painelButoes = new javax.swing.JPanel();
        btnSalavar1 = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jLabel2.setText("jLabel2");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Empresa"));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nome");

        campoNome.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N

        comboEmpresa.setModel(new javax.swing.DefaultComboBoxModel<>(new Object[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(comboEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        btnSalavar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSalavar1MouseReleased(evt);
            }
        });
        btnSalavar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalavar1ActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnCancelarMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout painelButoesLayout = new javax.swing.GroupLayout(painelButoes);
        painelButoes.setLayout(painelButoesLayout);
        painelButoesLayout.setHorizontalGroup(
            painelButoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelButoesLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnSalavar1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(23, 23, 23))
        );
        painelButoesLayout.setVerticalGroup(
            painelButoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelButoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelButoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalavar1, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelButoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(painelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(58, 58, 58)
                .addComponent(painelButoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalavar1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalavar1MouseReleased
        if (opcaoTela.equals("Cadastrar")) {
            cadastrar();
        } else if (opcaoTela.equals("Alterar")) {
            editar();
        } else {
            JOptionPane.showMessageDialog(this, "Opção invalida....");
        }

    }//GEN-LAST:event_btnSalavar1MouseReleased

    private void btnCancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseReleased
        dispose();
    }//GEN-LAST:event_btnCancelarMouseReleased

    private void btnSalavar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalavar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalavar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalavar1;
    private javax.swing.JTextField campoNome;
    private javax.swing.JComboBox<Object> comboEmpresa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel painelButoes;
    private javax.swing.JPanel painelDados;
    // End of variables declaration//GEN-END:variables
}
