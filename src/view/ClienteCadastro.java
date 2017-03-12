package view;

import controller.ClienteController;
import javax.swing.JOptionPane;
import model.Entitys.Cliente;
import model.dao.ClienteDAO;
import util.BDMensagensPadrao;

public class ClienteCadastro extends javax.swing.JFrame {
    private Cliente cliente;
    private String opcaoTela;

   
    public ClienteCadastro() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        this.opcaoTela="Cadastro";
    }
    public ClienteCadastro(Cliente  cliente){
        this.opcaoTela="Alterar";
        prepararCampos(cliente);
    }

   
    @SuppressWarnings("unchecked")
    
    private void pegarDado() {
            this.cliente = new Cliente();
            this.cliente.setRazaosocial(campoRazaoSocial.getText());
         
    }
    
    public void liparCampos (){
        campoRazaoSocial.setText("");
        
    }
   private void prepararCampos(Cliente c){
       campoRazaoSocial.setText(c.getRazaosocial());
   }
    
   private void preparaNomes(){
        setTitle(opcaoTela + "Clientes");
        btnSalavar1.setText(opcaoTela);
    }
    
    public void cadastrar(){
        ClienteDAO dao = new ClienteController();
        try{
            pegarDado();
            dao.save(cliente);
            JOptionPane.showMessageDialog(this,cliente.getRazaosocial()+BDMensagensPadrao.CADASTRADO_COM_SUCESSO);
            liparCampos();
        }catch(Exception e){
            e.printStackTrace();
        } 
        
    }
    public void editar(){
        pegarDado();
        ClienteDAO dao = new ClienteController();
        try{
           // dao.
        }catch(Exception  ex ){
            ex.printStackTrace();
        }
            
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        painelDados = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoRazaoSocial = new javax.swing.JTextField();
        painelButoes = new javax.swing.JPanel();
        btnSalavar1 = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Razao Social");

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(campoRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(245, Short.MAX_VALUE))
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
                .addContainerGap()
                .addComponent(painelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46)
                .addComponent(painelButoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalavar1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalavar1MouseReleased
        if (opcaoTela.endsWith("Cadastrar"))
            cadastrar();
            
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
    private javax.swing.JTextField campoRazaoSocial;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel painelButoes;
    private javax.swing.JPanel painelDados;
    // End of variables declaration//GEN-END:variables
}
