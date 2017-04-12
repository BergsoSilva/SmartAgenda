package view.telefone;

import view.funcionario.*;
import view.empresa.*;
import controller.EmpresaController;
import controller.FuncionarioController;
import controller.TelefoneEmpresaController;
import controller.TelefoneFucionarioController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Entitys.Empresa;
import model.Entitys.Funcionario;
import model.Entitys.Telefone;
import model.Entitys.TelefoneEmpresa;
import model.Entitys.TelefoneFuncionario;
import util.BDMensagensPadrao;
import model.dao.EmpresaDAO;
import model.dao.FuncionarioDAO;
import model.dao.TelefoneEmpresaDAO;
import model.dao.TelefoneFuncionarioDAO;

public class CadastroTelefone extends javax.swing.JFrame {

    private String opcaoTela;
    private List<Telefone> telefones = new ArrayList<>();
    TelefoneFuncionario telefonefum;
    TelefoneEmpresa telefoneemp;

    public CadastroTelefone(TelefoneEmpresa telefoneemp) {
        initComponents();
        this.telefoneemp = telefoneemp;
        setResizable(false);
        setLocationRelativeTo(this);
        this.opcaoTela = "Alterar";
        btnSalavar1.setText(opcaoTela);
        preencherCombobox();
        mostrardados();
    }

    public CadastroTelefone(TelefoneFuncionario telefonefum) {
        initComponents();
        this.telefonefum = telefonefum;
        setResizable(false);
        setLocationRelativeTo(this);
        this.opcaoTela = "Alterar";
        btnSalavar1.setText(opcaoTela);
        preencherCombobox();
        mostrardados();
    }

    public CadastroTelefone() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        this.opcaoTela = "Salvar";
        btnSalavar1.setText(opcaoTela);
        setTitle(opcaoTela + " Funcionario");
        preencherCombobox();

    }

    private void mostrardados() {
        if (jRadioButtonEmpresa.isSelected()) {
            campoDescricao.setText(this.telefoneemp.getDescricao());
            campoNumero.setText(this.telefoneemp.getNumero());
            comboEmpresa.setSelectedItem(this.telefoneemp.getEmpresa());
        } else if (jRadioButtonFuncionario.isSelected()) {
            campoDescricao.setText(this.telefonefum.getDescricao());
            campoNumero.setText(this.telefonefum.getNumero());
            comboFucionario.setSelectedItem(this.telefonefum.getFuncionario());
        }
    }

    public void liparCampos() {
        campoDescricao.setText("");
        comboEmpresa.setSelectedIndex(0);
        comboFucionario.setSelectedIndex(0);
        campoNumero.setText("");
    }

    private void preencherCombobox() {

        comboEmpresa.removeAllItems();
        comboEmpresa.addItem("Selecione a empresa...");
        comboFucionario.removeAllItems();
        comboFucionario.addItem("Selecione o funcionario...");

        EmpresaDAO dao = new EmpresaController();
        FuncionarioDAO funcDao = new FuncionarioController();

        for (Empresa em : dao.getAll(Empresa.class)) {
            comboEmpresa.addItem(em);
        }

        for (Funcionario fum : funcDao.getAll(Funcionario.class)) {
            comboFucionario.addItem(fum);
        }
    }

    private void editar() {
        if (jRadioButtonEmpresa.isSelected()) {
            editarTelEmpresa(this.telefoneemp);
        } else {
            editarTelFuncionario(this.telefonefum);
        }
    }

    public void cadastrar() {

        

        if (jRadioButtonEmpresa.isSelected()) {
            TelefoneEmpresaDAO dao = new TelefoneEmpresaController();
            TelefoneEmpresa telempresa = new TelefoneEmpresa();
            telempresa.setDescricao(campoDescricao.getText());
            telempresa.setNumero(campoNumero.getText());
            telempresa.setEmpresa((Empresa) comboEmpresa.getSelectedItem());
            dao.save(telempresa);
            JOptionPane.showMessageDialog(this, BDMensagensPadrao.CADASTRADO_COM_SUCESSO);
            liparCampos();
        } else if (jRadioButtonFuncionario.isSelected()) {
            TelefoneFuncionarioDAO dao = new TelefoneFucionarioController();
            TelefoneFuncionario telFun = new TelefoneFuncionario();

            telFun.setDescricao(campoDescricao.getText());
            telFun.setNumero(campoNumero.getText());
            telFun.setFuncionario((Funcionario) comboFucionario.getSelectedItem());
            dao.save(telFun);
            JOptionPane.showMessageDialog(this, BDMensagensPadrao.CADASTRADO_COM_SUCESSO);
            liparCampos();
        }

    }

    public void editarTelEmpresa(TelefoneEmpresa em) {

        TelefoneEmpresaDAO dao = new TelefoneEmpresaController();

        em.setDescricao(campoDescricao.getText());
        em.setNumero(campoNumero.getText());
        em.setEmpresa((Empresa) comboEmpresa.getSelectedItem());
        dao.save(em);
        JOptionPane.showMessageDialog(this, BDMensagensPadrao.ALTERADO_COM_SUCESSO);
        liparCampos();
    }

    public void editarTelFuncionario(TelefoneFuncionario fun) {

        TelefoneFuncionarioDAO dao = new TelefoneFucionarioController();

        fun.setDescricao(campoDescricao.getText());
        fun.setNumero(campoNumero.getText());
        fun.setFuncionario((Funcionario) comboFucionario.getSelectedItem());
        dao.save(fun);
        JOptionPane.showMessageDialog(this, BDMensagensPadrao.ALTERADO_COM_SUCESSO);
        liparCampos();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        painelDados = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoDescricao = new javax.swing.JTextField();
        campoNumero = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jRadioButtonFuncionario = new javax.swing.JRadioButton();
        jRadioButtonEmpresa = new javax.swing.JRadioButton();
        painelCombo = new javax.swing.JPanel();
        comboFucionario = new javax.swing.JComboBox<>();
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
        jLabel1.setText("Descrição");

        campoDescricao.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N

        campoNumero.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Número");

        buttonGroup1.add(jRadioButtonFuncionario);
        jRadioButtonFuncionario.setText("Funcionario");
        jRadioButtonFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonFuncionarioMouseClicked(evt);
            }
        });

        buttonGroup1.add(jRadioButtonEmpresa);
        jRadioButtonEmpresa.setText("Empresa");
        jRadioButtonEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonEmpresaMouseClicked(evt);
            }
        });

        comboFucionario.setModel(new javax.swing.DefaultComboBoxModel<>(new Object[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboFucionario.setEnabled(false);

        comboEmpresa.setModel(new javax.swing.DefaultComboBoxModel<>(new Object[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboEmpresa.setEnabled(false);

        javax.swing.GroupLayout painelComboLayout = new javax.swing.GroupLayout(painelCombo);
        painelCombo.setLayout(painelComboLayout);
        painelComboLayout.setHorizontalGroup(
            painelComboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelComboLayout.createSequentialGroup()
                .addComponent(comboFucionario, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        painelComboLayout.setVerticalGroup(
            painelComboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelComboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(comboFucionario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(comboEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addComponent(jRadioButtonFuncionario)
                        .addGap(34, 34, 34)
                        .addComponent(jRadioButtonEmpresa))
                    .addComponent(jLabel1)
                    .addComponent(campoDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(campoNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                    .addComponent(painelCombo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonFuncionario)
                    .addComponent(jRadioButtonEmpresa))
                .addGap(38, 38, 38)
                .addComponent(painelCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
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
        } else if (opcaoTela.equals("Cadastrar")) {
            editar();
        }
    }//GEN-LAST:event_btnSalavar1MouseReleased

    private void btnCancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseReleased
        dispose();
    }//GEN-LAST:event_btnCancelarMouseReleased

    private void btnSalavar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalavar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalavar1ActionPerformed

    private void jRadioButtonFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonFuncionarioMouseClicked
        comboEmpresa.setEnabled(false);
        comboFucionario.setEnabled(true);
    }//GEN-LAST:event_jRadioButtonFuncionarioMouseClicked

    private void jRadioButtonEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonEmpresaMouseClicked
        comboEmpresa.setEnabled(true);
        comboFucionario.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonEmpresaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalavar1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField campoDescricao;
    private javax.swing.JTextField campoNumero;
    private javax.swing.JComboBox<Object> comboEmpresa;
    private javax.swing.JComboBox<Object> comboFucionario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButtonEmpresa;
    private javax.swing.JRadioButton jRadioButtonFuncionario;
    private javax.swing.JPanel painelButoes;
    private javax.swing.JPanel painelCombo;
    private javax.swing.JPanel painelDados;
    // End of variables declaration//GEN-END:variables
}
