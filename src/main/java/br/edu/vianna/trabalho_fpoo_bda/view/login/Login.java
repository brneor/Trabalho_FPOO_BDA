/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.trabalho_fpoo_bda.view.login;

import br.edu.vianna.trabalho_fpoo_bda.exception.NotConnectionException;
import br.edu.vianna.trabalho_fpoo_bda.model.User;
import br.edu.vianna.trabalho_fpoo_bda.model.database.dao.UserDAO;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author breno
 */
public class Login extends javax.swing.JDialog {

    private User loggedUser;

    /**
     * Creates new form Login
     */
    public Login(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblUsuario = new javax.swing.JLabel();
        jlblSenha = new javax.swing.JLabel();
        jtxtUsuario = new javax.swing.JTextField();
        jbtnLogin = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();
        jtxtSenha = new javax.swing.JPasswordField();
        jlblPrimeiroAcesso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Entrar");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jlblUsuario.setText("Usuário");

        jlblSenha.setText("Senha");

        jbtnLogin.setText("Entrar");
        jbtnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLoginActionPerformed(evt);
            }
        });

        jbtnCancelar.setText("Cancel");
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        jlblPrimeiroAcesso.setForeground(new java.awt.Color(46, 144, 232));
        jlblPrimeiroAcesso.setText("Paciente, é seu primeiro acesso? Clique aqui");
        jlblPrimeiroAcesso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlblSenha)
                            .addComponent(jlblUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtUsuario)
                            .addComponent(jtxtSenha)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlblPrimeiroAcesso)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnLogin)))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblUsuario)
                    .addComponent(jtxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblSenha)
                    .addComponent(jtxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblPrimeiroAcesso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnLogin)
                    .addComponent(jbtnCancelar))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLoginActionPerformed
        // Checa se os campos de usuário e senha foram preenchidos
        if (jtxtUsuario.getText().equals("") || jtxtSenha.getText().equals("")) {
            emptyLoginField();
            return;
        }

        // Checa as informações do usuário na base, 
        // atualiza o loggedUser e fecha a tela.
        UserDAO usuarioDao = new UserDAO();
        User usuario = null;
        try {
            usuario = usuarioDao.buscarPeloId(jtxtUsuario.getText());
        } catch (NotConnectionException ex) {
            System.out.println("No connection");
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("outro erro");
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (usuario == null) {
            // Usuário não encontrado.
            invalidLoginInfo();
        } else {
            System.out.println("Conferindo informações para o usuário " + usuario.getLogin());
            if (jtxtSenha.getText().equals(usuario.getSenha())) {
                // Login bem sucedido! Informa o usuário que vai ser
                // retornado para a tela principal.
                System.out.println("Login bem sucedido!");
                this.loggedUser = usuario;
                this.dispose();
            } else {
                // Senha incorreta.
                invalidLoginInfo();
            }
        }
    }//GEN-LAST:event_jbtnLoginActionPerformed

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        // Se cancela o login, finaliza a aplicação.
//        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // Seta o botão de login como default
        // (é acionado com a tecla enter)
        this.getRootPane().setDefaultButton(jbtnLogin);
        
        // Sublina o label de primeiro acesso para o paciente
        Font font = jlblPrimeiroAcesso.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        jlblPrimeiroAcesso.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_formWindowOpened

    // Loga e retorna o usuário para a tela principal
    public User getLoggedUser() {
        this.setVisible(true);
        return loggedUser;
    }
    
    // Alerta que algum dado informado no login é inválido
    private void invalidLoginInfo() {
        JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
    }
    
    // Alerta que algum dado não foi informado
    private void emptyLoginField() {
        JOptionPane.showMessageDialog(null, "Informe usuário e senha!");
    }
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login dialog = new Login(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnLogin;
    private javax.swing.JLabel jlblPrimeiroAcesso;
    private javax.swing.JLabel jlblSenha;
    private javax.swing.JLabel jlblUsuario;
    private javax.swing.JPasswordField jtxtSenha;
    private javax.swing.JTextField jtxtUsuario;
    // End of variables declaration//GEN-END:variables
}
