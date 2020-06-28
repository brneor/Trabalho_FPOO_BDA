/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.trabalho_fpoo_bda.view;

import br.edu.vianna.trabalho_fpoo_bda.model.User;
import br.edu.vianna.trabalho_fpoo_bda.view.about.About;
import br.edu.vianna.trabalho_fpoo_bda.view.collect.CollectNew;
import br.edu.vianna.trabalho_fpoo_bda.view.exam.ExamNew;
import br.edu.vianna.trabalho_fpoo_bda.view.exam.ExamSearch;
import br.edu.vianna.trabalho_fpoo_bda.view.login.Login;
import br.edu.vianna.trabalho_fpoo_bda.view.patient.PatientNew;
import br.edu.vianna.trabalho_fpoo_bda.view.patient.PatientSearch;
import br.edu.vianna.trabalho_fpoo_bda.view.professional.ProfessionalNew;
import br.edu.vianna.trabalho_fpoo_bda.view.professional.ProfessionalSearch;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
/**
 *
 * @author breno
 */
public class Main extends javax.swing.JFrame {
    private User loggedUser = new User(); 

    /**
     * Creates new form Main
     */
    public Main() {
        // Resolve o problema do nome da aplicação no Gnome.
        try {
            Toolkit xToolkit = Toolkit.getDefaultToolkit();
            java.lang.reflect.Field awtAppClassNameField =
                xToolkit.getClass().getDeclaredField("awtAppClassName");
            awtAppClassNameField.setAccessible(true);
            awtAppClassNameField.set(xToolkit, "SuperLabManager");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
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

        jlblStatusBar = new javax.swing.JLabel();
        jmbMainMenu = new javax.swing.JMenuBar();
        jmSistema = new javax.swing.JMenu();
        jmiSobre = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmiSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SuperLabManager");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jlblStatusBar.setText("Usuário: ");
        jlblStatusBar.setMinimumSize(new java.awt.Dimension(0, 20));

        jmSistema.setText("Sistema");

        jmiSobre.setText("Sobre");
        jmiSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSobreActionPerformed(evt);
            }
        });
        jmSistema.add(jmiSobre);
        jmSistema.add(jSeparator1);

        jmiSair.setText("Sair");
        jmSistema.add(jmiSair);

        jmbMainMenu.add(jmSistema);

        setJMenuBar(jmbMainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblStatusBar, javax.swing.GroupLayout.DEFAULT_SIZE, 1086, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(596, Short.MAX_VALUE)
                .addComponent(jlblStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        createWebivew();
        callLogin();
    }//GEN-LAST:event_formWindowOpened

    private void jmiSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSobreActionPerformed
        About sobre = new About(this, true);
        sobre.setLocationRelativeTo(this);
        sobre.setVisible(true);
    }//GEN-LAST:event_jmiSobreActionPerformed
    
    // Chama o login
    private void callLogin() {
        Login login = new Login(this, true);
        
        login.setLocationRelativeTo(this);
        
        loggedUser = login.getLoggedUser();
        
        jlblStatusBar.setText(jlblStatusBar.getText() + loggedUser.getNome() + " [" + loggedUser.getTipoUsuario().getDescricao() + "]");
        createMenu(loggedUser.getTipoUsuario().getId());
    }
    // Cria um webview JavaFX para ser exibido na página principal.
    private void createWebivew() {
        // Cria o JFXPanel do tamanho da janela principal descontando o menu
        // e o espaço inferior para o botão.
        JFXPanel jfxPanel = new JFXPanel();
        this.add(jfxPanel);
        jfxPanel.setBounds(0, 0, this.getSize().width, this.getSize().height - 85);
        jfxPanel.setVisible(true);

        // Cria o WebView dentro do jfxPanel e navega para a URL informada.
        Platform.runLater(() -> {
            WebView webView = new WebView();
            jfxPanel.setScene(new Scene(webView));
            webView.getEngine().load("https://www.news.med.br/");
        });
    }
    
    private void createMenu(int userType) {
        // Cria os menus principais com base no tipo de usuário logado
        switch (userType) {
            // Usuário tipo "Cadastro".
            case 1:
                createMenuCadastro();
                break;
            // Usuário tipo "Responsável técnico".
            case 2:
                createMenuResponsavelTecnico();
                break;
            case 3:
                createMenuSupervisor();
                break;
            case 4:
                createMenuPaciente();
                break;
        }
    }
    
    private void createMenuCadastro() {
        // ---------------------------------------------------------------------
        // Menu paciente
        JMenu jmPatient = new JMenu();
        jmPatient.setText("Paciente");

        // Novo paciente
        JMenuItem jmiPatientNew = new JMenuItem();
        jmiPatientNew.setText("Novo...");
        jmiPatientNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPatientNewActionPerformed(evt);
            }
        });
        
        // Buscar paciente
        JMenuItem jmiPatientSearch = new JMenuItem();
        jmiPatientSearch.setText("Buscar...");
        jmiPatientSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPatientSearchActionPerformed(evt);
            }
        });
        
        // Adiciona os itens ao menu "Paciente"
        jmPatient.add(jmiPatientNew);
        jmPatient.add(jmiPatientSearch);
        // ---------------------------------------------------------------------
        
        // ---------------------------------------------------------------------
        // Menu Profissionais (de saúde)
        JMenu jmProfessional = new JMenu();
        jmProfessional.setText("Profissional");

        // Novo Profissional
        JMenuItem jmiProfessionalNew = new JMenuItem();
        jmiProfessionalNew.setText("Novo...");
        jmiProfessionalNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiProfessionalNewActionPerformed(evt);
            }
        });

        // Buscar Profissional
        JMenuItem jmiProfessionalSearch = new JMenuItem();
        jmiProfessionalSearch.setText("Buscar...");
        jmiProfessionalSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiProfessionalSearchActionPerformed(evt);
            }
        });

        // Adiciona os itens ao menu "Profissional"
        jmProfessional.add(jmiProfessionalNew);
        jmProfessional.add(jmiProfessionalSearch);
        // ---------------------------------------------------------------------
        
        // ---------------------------------------------------------------------
        // Menu "Coleta"
        JMenu jmCollect = new JMenu();
        jmCollect.setText("Coleta");
        
        // Nova coleta
        JMenuItem jmiCollectNew = new JMenuItem();
        jmiCollectNew.setText("Novo...");
        jmiCollectNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCollectNewActionPerformed(evt);
            }
        });
        
        // Adiciona o item ao menu
        jmCollect.add(jmiCollectNew);
        // ---------------------------------------------------------------------

        // Adiciona os menus ao menu principal
        jmbMainMenu.add(jmPatient);
        jmbMainMenu.add(jmProfessional);
        jmbMainMenu.add(jmCollect);

        // Seta a barra de menu para o jmbMainMenu
        this.setJMenuBar(jmbMainMenu);
    }
    
    private void createMenuResponsavelTecnico() {
        // ---------------------------------------------------------------------
        // Menu Exame
        JMenu jmExam = new JMenu();
        jmExam.setText("Exame");

        // Novo Exame
        JMenuItem jmiExamNew = new JMenuItem();
        jmiExamNew.setText("Novo...");
        jmiExamNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExamNewActionPerformed(evt);
            }
        });
        
        // Bsucar Exame
        JMenuItem jmiExamSearch = new JMenuItem();
        jmiExamSearch.setText("Buscar...");
        jmiExamSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExamSearchActionPerformed(evt);
            }
        });

        // Adiciona os itens ao menu "Exame"
        jmExam.add(jmiExamNew);
        jmExam.add(jmiExamSearch);
        // ---------------------------------------------------------------------
        
        // Adiciona os menus ao menu principal
        jmbMainMenu.add(jmExam);
        
        // Seta a barra de menu para o jmbMainMenu
        this.setJMenuBar(jmbMainMenu);
    }
    
    private void createMenuSupervisor(){
        
    }
    
    private void createMenuPaciente(){
    }
    
    private void jmiPatientNewActionPerformed(java.awt.event.ActionEvent evt) {
        // Cria e apresenta a tela de criação de paciente
        PatientNew pnew = new PatientNew(this, true);
        pnew.setLocationRelativeTo(this);
        pnew.setVisible(true);
    }
    
    private void jmiPatientSearchActionPerformed(java.awt.event.ActionEvent evt) {
        // Cria e mostra a tela de busca de paciente
        PatientSearch psearch = new PatientSearch(this, true);
        psearch.setLocationRelativeTo(this);
        psearch.setVisible(true);
    }
    
    private void jmiCollectNewActionPerformed(java.awt.event.ActionEvent evt) {
        // Cria e mostra a tela de cadastro de Coleta
        CollectNew cnew = new CollectNew(this, true);
        cnew.setLocationRelativeTo(this);
        cnew.setVisible(true);
    }
    
    private void jmiProfessionalNewActionPerformed(java.awt.event.ActionEvent evt) {
        // Cria e mostra a tela de cadastro de Coleta
        ProfessionalNew pnew = new ProfessionalNew(this, true);
        pnew.setLocationRelativeTo(this);
        pnew.setVisible(true);
    }
    
    private void jmiProfessionalSearchActionPerformed(java.awt.event.ActionEvent evt) {
        // Cria e mostra a tela de cadastro de Coleta
        ProfessionalSearch psearch = new ProfessionalSearch(this, true);
        psearch.setLocationRelativeTo(this);
        psearch.setVisible(true);
    }
    
    private void jmiExamNewActionPerformed(java.awt.event.ActionEvent evt) {
        // Cria e mostra a tela de cadastro de Exame
        ExamNew enew = new ExamNew(this, true);
        enew.setLocationRelativeTo(this);
        enew.setVisible(true);
    }
    
    private void jmiExamSearchActionPerformed(java.awt.event.ActionEvent evt) {
        // Cria e mostra a tela de bsuca de Exame
        ExamSearch esearch = new ExamSearch(this, true);
        esearch.setLocationRelativeTo(this);
        esearch.setVisible(true);
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Initializing FlatLaf style ">
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF due to " + ex.getMessage() );
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new Main();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel jlblStatusBar;
    private javax.swing.JMenu jmSistema;
    private javax.swing.JMenuBar jmbMainMenu;
    private javax.swing.JMenuItem jmiSair;
    private javax.swing.JMenuItem jmiSobre;
    // End of variables declaration//GEN-END:variables
}
