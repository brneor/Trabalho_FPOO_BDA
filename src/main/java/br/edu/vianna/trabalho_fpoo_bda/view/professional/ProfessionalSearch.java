/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.trabalho_fpoo_bda.view.professional;

import br.edu.vianna.trabalho_fpoo_bda.exception.NotConnectionException;
import br.edu.vianna.trabalho_fpoo_bda.model.Professional;
import br.edu.vianna.trabalho_fpoo_bda.model.database.dao.ProfessionalDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author breno
 */
public class ProfessionalSearch extends javax.swing.JDialog {
    private Boolean insert = false;
    private Professional rProfessional = new Professional();
    /**
     * Creates new form ProfessionalNew
     */
    public ProfessionalSearch(java.awt.Frame parent, boolean modal) {
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

        jtxtBusca = new javax.swing.JTextField();
        jbtnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblResultado = new javax.swing.JTable();
        jbtnAction = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busca profissional");
        setMinimumSize(new java.awt.Dimension(300, 300));
        setResizable(false);
        setSize(new java.awt.Dimension(300, 290));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jbtnBuscar.setText("Buscar");
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });

        jtblResultado.setAutoCreateRowSorter(true);
        jtblResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Identificação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblResultado.getTableHeader().setReorderingAllowed(false);
        jtblResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtblResultadoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtblResultado);
        if (jtblResultado.getColumnModel().getColumnCount() > 0) {
            jtblResultado.getColumnModel().getColumn(1).setMinWidth(100);
            jtblResultado.getColumnModel().getColumn(1).setPreferredWidth(100);
            jtblResultado.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        jbtnAction.setText("Editar");
        jbtnAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnActionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtxtBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnBuscar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnAction)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnAction)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnActionActionPerformed
        // A ação depende de que tela invocou. Se foi do menu "Paciente"
        // oferece para editar. Se veio da criação de coleta, retorna 
        // o paciente selecionado na lista.
        if (insert && jtblResultado.getSelectedRow() != -1) {
            returnProfessional(
                Integer.parseInt(jtblResultado.getValueAt(jtblResultado.getSelectedRow(), 1).toString())
            );
        }
    }//GEN-LAST:event_jbtnActionActionPerformed

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        // Cria o model pra manipular a tabela
        DefaultTableModel model = (DefaultTableModel) jtblResultado.getModel();
        
        // Limpa a tabela antes de fazer a busca.
        model.setRowCount(0);
        
        // Cria o DAO e faz a busca.
        ProfessionalDAO pdao = new ProfessionalDAO();
        ArrayList<Professional> plist = new ArrayList<>();
        try {
            plist = pdao.buscar(jtxtBusca.getText());
        } catch (NotConnectionException ex) {
            Logger.getLogger(ProfessionalSearch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProfessionalSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Popula a tabela
        for (Professional p : plist) {
            System.out.println(p.getNome());
            model.addRow(new Object[]{p.getNome(), p.getId()});
        }
    }//GEN-LAST:event_jbtnBuscarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // Seta o botão padrão do fom
        this.getRootPane().setDefaultButton(jbtnBuscar);
    }//GEN-LAST:event_formWindowOpened

    private void jtblResultadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblResultadoMousePressed
        if (evt.getClickCount() == 2 && jtblResultado.getSelectedRow() != -1) {
            // Abre o paciente pra edição ou retorna o paciente dependendo do caller
            if (insert) {
                returnProfessional(
                    Integer.parseInt(jtblResultado.getValueAt(jtblResultado.getSelectedRow(), 1).toString())
                );
            }
        }
    }//GEN-LAST:event_jtblResultadoMousePressed

    // Retorna o profissional selecionado quando o for chamado pela tela
    // de cadastro de coleta
    public Professional getProfessional() {
        this.insert = true;
        this.jbtnAction.setText("Inserir");
        this.setVisible(true);
        return this.rProfessional;
    }
    
    private void returnProfessional(int id) {
        try {
            this.rProfessional = new ProfessionalDAO().buscarPeloId(id);
        } catch (NotConnectionException ex) {
            Logger.getLogger(ProfessionalSearch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProfessionalSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.dispose();
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
            java.util.logging.Logger.getLogger(ProfessionalSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfessionalSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfessionalSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfessionalSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProfessionalSearch dialog = new ProfessionalSearch(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnAction;
    private javax.swing.JButton jbtnBuscar;
    private javax.swing.JTable jtblResultado;
    private javax.swing.JTextField jtxtBusca;
    // End of variables declaration//GEN-END:variables
}
