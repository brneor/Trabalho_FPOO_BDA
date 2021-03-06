/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.trabalho_fpoo_bda.view.exam;

import br.edu.vianna.trabalho_fpoo_bda.exception.NotConnectionException;
import br.edu.vianna.trabalho_fpoo_bda.model.Collect;
import br.edu.vianna.trabalho_fpoo_bda.model.Exam;
import br.edu.vianna.trabalho_fpoo_bda.model.ExamResult;
import br.edu.vianna.trabalho_fpoo_bda.model.Test;
import br.edu.vianna.trabalho_fpoo_bda.model.database.dao.CollectDAO;
import br.edu.vianna.trabalho_fpoo_bda.model.database.dao.ExamDAO;
import br.edu.vianna.trabalho_fpoo_bda.model.database.dao.ExamResultDAO;
import br.edu.vianna.trabalho_fpoo_bda.view.collect.CollectSearch;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author breno
 */
public class ExamNew extends javax.swing.JDialog {
    private Boolean refazer = false;
    private Collect coleta = new Collect();
    private Exam exame = new Exam();
    private ExamResult resultado = new ExamResult();
    private Test teste = new Test();
    
    /**
     * Creates new form ExamNew
     */
    public ExamNew(java.awt.Frame parent, boolean modal) {
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

        jlblTeste = new javax.swing.JLabel();
        jtxtTeste = new javax.swing.JTextField();
        jtxtColeta = new javax.swing.JTextField();
        jlblColeta = new javax.swing.JLabel();
        jlblResultado = new javax.swing.JLabel();
        jcmbResultado = new javax.swing.JComboBox<>();
        jbtnSalvar = new javax.swing.JButton();
        jbtnRefazer = new javax.swing.JButton();
        jbtnBuscar = new javax.swing.JButton();
        jftxtData = new javax.swing.JFormattedTextField();
        jlblData = new javax.swing.JLabel();
        jbtnAudit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Exame");
        setSize(new java.awt.Dimension(360, 170));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jlblTeste.setText("Nro. Teste");

        jlblColeta.setText("Coleta");

        jlblResultado.setText("Resultado");

        jcmbResultado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jbtnSalvar.setText("Salvar");
        jbtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalvarActionPerformed(evt);
            }
        });

        jbtnRefazer.setText("Refazer");
        jbtnRefazer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRefazerActionPerformed(evt);
            }
        });

        jbtnBuscar.setText("Buscar");
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });

        try {
            jftxtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jlblData.setText("Data");

        jbtnAudit.setText("Auditar");
        jbtnAudit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAuditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtTeste, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblTeste))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlblColeta)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtxtColeta, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnBuscar))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnAudit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnRefazer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnSalvar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcmbResultado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlblResultado)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblData)
                            .addComponent(jftxtData, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblTeste)
                    .addComponent(jlblColeta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtTeste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtColeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblResultado)
                    .addComponent(jlblData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcmbResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jftxtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnSalvar)
                    .addComponent(jbtnRefazer)
                    .addComponent(jbtnAudit))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnRefazerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRefazerActionPerformed
        // Limpa as informações com exceção da coleta para lançar um novo
        // exame.
    }//GEN-LAST:event_jbtnRefazerActionPerformed

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        CollectSearch csearch = new CollectSearch((JFrame)this.getParent(), true);
        csearch.setLocationRelativeTo(this);
        coleta = csearch.getCollect();
        
        System.out.println("id da coleta: " + coleta.getId());
        jtxtColeta.setText(String.valueOf(coleta.getId()));
        
    }//GEN-LAST:event_jbtnBuscarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // Esconde o botão "Refazer" se não veio de busca.
        if (!refazer) {
            jbtnRefazer.setVisible(false);
        }
        
        populaResultados();
    }//GEN-LAST:event_formWindowOpened

    private void jbtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalvarActionPerformed
        resultado.setId(jcmbResultado.getSelectedIndex());
        resultado.setDescricao(jcmbResultado.getSelectedItem().toString());
        
        teste.setId(Integer.parseInt(jtxtTeste.getText()));
        teste.setExame(exame);
        
        Date dExame = new Date();
        try {
            dExame = new SimpleDateFormat("dd/MM/yyyy").parse(jftxtData.getText());
        } catch (ParseException ex) {
            Logger.getLogger(ExamNew.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        exame.setPaciente(coleta.getPaciente());
        exame.setTeste(teste);
        exame.setResultadoExame(resultado);
        exame.setCollect(coleta);
        exame.setData(dExame);
        
        try {
            new ExamDAO().inserir(exame);
            
            // Tem que setar a coleta como exameRealizado
            new CollectDAO().setRealizado(exame.getCollect().getId());
            JOptionPane.showMessageDialog(null, "Exame salvo com sucesso!");
            this.dispose();
        } catch (NotConnectionException ex) {
            Logger.getLogger(ExamNew.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ExamNew.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnSalvarActionPerformed

    private void jbtnAuditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAuditActionPerformed
        ExamAudit ea = new ExamAudit((JFrame) this.getParent(), true);
        ea.setLocationRelativeTo(this);
        
        ea.auditarExame(exame);
        this.dispose();
    }//GEN-LAST:event_jbtnAuditActionPerformed

    public void refazerExam() {
        this.refazer = true;
        this.setVisible(true);
    }
    
    public void editaExame(Exam exame) {
        this.jbtnSalvar.setEnabled(false);
        populaResultados();
        SimpleDateFormat sdfShort = new SimpleDateFormat("dd/MM/yyyy");
        this.exame = exame;
        
        jtxtTeste.setText(String.valueOf(exame.getTeste().getId()));
        jtxtColeta.setText(String.valueOf(exame.getCollect().getId()));
        jcmbResultado.setSelectedIndex(exame.getResultadoExame().getId());
        jftxtData.setText(sdfShort.format(exame.getData()));
        
        this.setVisible(true);
    }
    
    private void populaResultados () {
        ArrayList<ExamResult> resultados = new ArrayList<>();
        try {
            resultados = new ExamResultDAO().listar();
        } catch (NotConnectionException ex) {
            Logger.getLogger(ExamNew.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ExamNew.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (ExamResult r : resultados) {
            jcmbResultado.addItem(r.getDescricao());
        }
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
            java.util.logging.Logger.getLogger(ExamNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExamNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExamNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ExamNew dialog = new ExamNew(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jbtnAudit;
    private javax.swing.JButton jbtnBuscar;
    private javax.swing.JButton jbtnRefazer;
    private javax.swing.JButton jbtnSalvar;
    private javax.swing.JComboBox<String> jcmbResultado;
    private javax.swing.JFormattedTextField jftxtData;
    private javax.swing.JLabel jlblColeta;
    private javax.swing.JLabel jlblData;
    private javax.swing.JLabel jlblResultado;
    private javax.swing.JLabel jlblTeste;
    private javax.swing.JTextField jtxtColeta;
    private javax.swing.JTextField jtxtTeste;
    // End of variables declaration//GEN-END:variables
}
