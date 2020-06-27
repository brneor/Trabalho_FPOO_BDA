/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.trabalho_fpoo_bda.view.collect;

import br.edu.vianna.trabalho_fpoo_bda.view.patient.PatientSearch;
import javax.swing.JFrame;

/**
 *
 * @author breno
 */
public class CollectNew extends javax.swing.JDialog {

    /**
     * Creates new form CollectNew
     */
    public CollectNew(java.awt.Frame parent, boolean modal) {
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

        jlblPaciente = new javax.swing.JLabel();
        jtxtPaciente = new javax.swing.JTextField();
        jbtnBuscaPaciente = new javax.swing.JButton();
        jlvlProfissional = new javax.swing.JLabel();
        jtxtProfissional = new javax.swing.JTextField();
        jbtnBuscaProfissional = new javax.swing.JButton();
        jlblCidade = new javax.swing.JLabel();
        jtxtCidade = new javax.swing.JTextField();
        jlblMaterial = new javax.swing.JLabel();
        jcmbMaterial = new javax.swing.JComboBox<>();
        jbtnSalvar = new javax.swing.JButton();
        jbtnCancel = new javax.swing.JButton();
        jlblDataColeta = new javax.swing.JLabel();
        jftxtDataColeta = new javax.swing.JFormattedTextField();
        jftxtHoraColeta = new javax.swing.JFormattedTextField();
        jlblHoraColeta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 380));
        setPreferredSize(new java.awt.Dimension(300, 380));
        setResizable(false);
        setSize(new java.awt.Dimension(300, 380));

        jlblPaciente.setText("Paciente");

        jbtnBuscaPaciente.setText("Buscar");
        jbtnBuscaPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscaPacienteActionPerformed(evt);
            }
        });

        jlvlProfissional.setText("Profissional coletor");

        jbtnBuscaProfissional.setText("Buscar");

        jlblCidade.setText("Cidade");

        jlblMaterial.setText("Material coletado");

        jbtnSalvar.setText("Salvar");

        jbtnCancel.setText("Cancelar");
        jbtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelActionPerformed(evt);
            }
        });

        jlblDataColeta.setText("Data");

        jftxtDataColeta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        jftxtHoraColeta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("HH:mm"))));

        jlblHoraColeta.setText("Hora");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtxtPaciente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnBuscaPaciente))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtxtProfissional)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnBuscaProfissional))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 122, Short.MAX_VALUE)
                        .addComponent(jbtnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jftxtDataColeta, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblPaciente)
                            .addComponent(jlvlProfissional)
                            .addComponent(jlblDataColeta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlblHoraColeta)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jftxtHoraColeta)))
                    .addComponent(jtxtCidade)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblCidade)
                            .addComponent(jlblMaterial))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jcmbMaterial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblPaciente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnBuscaPaciente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlvlProfissional)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnBuscaProfissional))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblDataColeta)
                    .addComponent(jlblHoraColeta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jftxtDataColeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jftxtHoraColeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblCidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblMaterial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcmbMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnSalvar)
                    .addComponent(jbtnCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnBuscaPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscaPacienteActionPerformed
        PatientSearch psearch = new PatientSearch((JFrame)this.getParent(), true);
        psearch.setLocationRelativeTo(this);
        String retorno = psearch.getPatient();
        System.out.println(retorno);
    }//GEN-LAST:event_jbtnBuscaPacienteActionPerformed

    private void jbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(CollectNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CollectNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CollectNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CollectNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CollectNew dialog = new CollectNew(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jbtnBuscaPaciente;
    private javax.swing.JButton jbtnBuscaProfissional;
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnSalvar;
    private javax.swing.JComboBox<String> jcmbMaterial;
    private javax.swing.JFormattedTextField jftxtDataColeta;
    private javax.swing.JFormattedTextField jftxtHoraColeta;
    private javax.swing.JLabel jlblCidade;
    private javax.swing.JLabel jlblDataColeta;
    private javax.swing.JLabel jlblHoraColeta;
    private javax.swing.JLabel jlblMaterial;
    private javax.swing.JLabel jlblPaciente;
    private javax.swing.JLabel jlvlProfissional;
    private javax.swing.JTextField jtxtCidade;
    private javax.swing.JTextField jtxtPaciente;
    private javax.swing.JTextField jtxtProfissional;
    // End of variables declaration//GEN-END:variables
}
