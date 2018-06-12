/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Toolkit;
import javax.swing.*;

/**
 *
 * @author MTC
 */
public class MainForm extends javax.swing.JFrame {

    //---------------------------------------------
    public JCheckBoxMenuItem getCbxmniStatusBar() {
        return cbxmniStatusBar;
    }

    public void setCbxmniStatusBar(JCheckBoxMenuItem cbxmniStatusBar) {
        this.cbxmniStatusBar = cbxmniStatusBar;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JMenu getMnEdit() {
        return mnEdit;
    }

    public void setMnEdit(JMenu mnEdit) {
        this.mnEdit = mnEdit;
    }

    public JMenu getMnFile() {
        return mnFile;
    }

    public void setMnFile(JMenu mnFile) {
        this.mnFile = mnFile;
    }

    public JMenu getMnFormat() {
        return mnFormat;
    }

    public void setMnFormat(JMenu mnFormat) {
        this.mnFormat = mnFormat;
    }

    public JMenu getMnHelp() {
        return mnHelp;
    }

    public void setMnHelp(JMenu mnHelp) {
        this.mnHelp = mnHelp;
    }

    public JMenu getMnView() {
        return mnView;
    }

    public void setMnView(JMenu mnView) {
        this.mnView = mnView;
    }

    public JMenuBar getMnbMain() {
        return mnbMain;
    }

    public void setMnbMain(JMenuBar mnbMain) {
        this.mnbMain = mnbMain;
    }

    public JMenuItem getMniAbout() {
        return mniAbout;
    }

    public void setMniAbout(JMenuItem mniAbout) {
        this.mniAbout = mniAbout;
    }

    public JMenuItem getMniCopy() {
        return mniCopy;
    }

    public void setMniCopy(JMenuItem mniCopy) {
        this.mniCopy = mniCopy;
    }

    public JMenuItem getMniCut() {
        return mniCut;
    }

    public void setMniCut(JMenuItem mniCut) {
        this.mniCut = mniCut;
    }

    public JMenuItem getMniDateTime() {
        return mniDateTime;
    }

    public void setMniDateTime(JMenuItem mniDateTime) {
        this.mniDateTime = mniDateTime;
    }

    public JMenuItem getMniDelete() {
        return mniDelete;
    }

    public void setMniDelete(JMenuItem mniDelete) {
        this.mniDelete = mniDelete;
    }

    public JMenuItem getMniExit() {
        return mniExit;
    }

    public void setMniExit(JMenuItem mniExit) {
        this.mniExit = mniExit;
    }

    public JMenuItem getMniFind() {
        return mniFind;
    }

    public void setMniFind(JMenuItem mniFind) {
        this.mniFind = mniFind;
    }

    public JMenuItem getMniFindNext() {
        return mniFindNext;
    }

    public void setMniFindNext(JMenuItem mniFindNext) {
        this.mniFindNext = mniFindNext;
    }

    public JMenuItem getMniFont() {
        return mniFont;
    }

    public void setMniFont(JMenuItem mniFont) {
        this.mniFont = mniFont;
    }

    public JMenuItem getMniGoTo() {
        return mniGoTo;
    }

    public void setMniGoTo(JMenuItem mniGoTo) {
        this.mniGoTo = mniGoTo;
    }

    public JMenuItem getMniNew() {
        return mniNew;
    }

    public void setMniNew(JMenuItem mniNew) {
        this.mniNew = mniNew;
    }

    public JMenuItem getMniOpen() {
        return mniOpen;
    }

    public void setMniOpen(JMenuItem mniOpen) {
        this.mniOpen = mniOpen;
    }

    public JMenuItem getMniPageSetup() {
        return mniPageSetup;
    }

    public void setMniPageSetup(JMenuItem mniPageSetup) {
        this.mniPageSetup = mniPageSetup;
    }

    public JMenuItem getMniPaste() {
        return mniPaste;
    }

    public void setMniPaste(JMenuItem mniPaste) {
        this.mniPaste = mniPaste;
    }

    public JMenuItem getMniPrint() {
        return mniPrint;
    }

    public void setMniPrint(JMenuItem mniPrint) {
        this.mniPrint = mniPrint;
    }

    public JMenuItem getMniReplace() {
        return mniReplace;
    }

    public void setMniReplace(JMenuItem mniReplace) {
        this.mniReplace = mniReplace;
    }

    public JMenuItem getMniSave() {
        return mniSave;
    }

    public void setMniSave(JMenuItem mniSave) {
        this.mniSave = mniSave;
    }

    public JMenuItem getMniSaveAs() {
        return mniSaveAs;
    }

    public void setMniSaveAs(JMenuItem mniSaveAs) {
        this.mniSaveAs = mniSaveAs;
    }

    public JMenuItem getMniSelectAll() {
        return mniSelectAll;
    }

    public void setMniSelectAll(JMenuItem mniSelectAll) {
        this.mniSelectAll = mniSelectAll;
    }

    public JMenuItem getMniUndo() {
        return mniUndo;
    }

    public void setMniUndo(JMenuItem mniUndo) {
        this.mniUndo = mniUndo;
    }

    public JMenuItem getMniRedo() {
        return mniRedo;
    }

    public void setMniRedo(JMenuItem mniRedo) {
        this.mniRedo = mniRedo;
    }
   
    public JMenuItem getMniViewHelp() {
        return mniViewHelp;
    }

    public void setMniViewHelp(JMenuItem mniViewHelp) {
        this.mniViewHelp = mniViewHelp;
    }

    public JCheckBoxMenuItem getCbxMniWordWrap() {
        return cbxmniWordWrap;
    }

    public void setCbxMniWordWrap(JCheckBoxMenuItem cbxmniWordWrap) {
        this.cbxmniWordWrap = cbxmniWordWrap;
    }

    public JPopupMenu.Separator getSprtEdit1() {
        return sprtEdit1;
    }

    public void setSprtEdit1(JPopupMenu.Separator sprtEdit1) {
        this.sprtEdit1 = sprtEdit1;
    }

    public JPopupMenu.Separator getSprtEdit2() {
        return sprtEdit2;
    }

    public void setSprtEdit2(JPopupMenu.Separator sprtEdit2) {
        this.sprtEdit2 = sprtEdit2;
    }

    public JPopupMenu.Separator getSprtEdit3() {
        return sprtEdit3;
    }

    public void setSprtEdit3(JPopupMenu.Separator sprtEdit3) {
        this.sprtEdit3 = sprtEdit3;
    }

    public JPopupMenu.Separator getSprtFile1() {
        return sprtFile1;
    }

    public void setSprtFile1(JPopupMenu.Separator sprtFile1) {
        this.sprtFile1 = sprtFile1;
    }

    public JPopupMenu.Separator getSprtFile2() {
        return sprtFile2;
    }

    public void setSprtFile2(JPopupMenu.Separator sprtFile2) {
        this.sprtFile2 = sprtFile2;
    }

    public JPopupMenu.Separator getSprtHelp() {
        return sprtHelp;
    }

    public void setSprtHelp(JPopupMenu.Separator sprtHelp) {
        this.sprtHelp = sprtHelp;
    }

    public JTextArea getTxtaMain() {
        return txtaMain;
    }

    public void setTxtaMain(JTextArea txtaMain) {
        this.txtaMain = txtaMain;
    }

    public JLabel getLblStatus() {
        return lblStatus;
    }

    public void setLblStatus(JLabel lblStatus) {
        this.lblStatus = lblStatus;
    }

    public JPopupMenu.Separator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(JPopupMenu.Separator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }

    public JMenuItem getMniBackgroudColor() {
        return mniBackgroudColor;
    }

    public void setMniBackgroudColor(JMenuItem mniBackgroudColor) {
        this.mniBackgroudColor = mniBackgroudColor;
    }

    public JMenuItem getMniTextColor() {
        return mniTextColor;
    }

    public void setMniTextColor(JMenuItem mniTextColor) {
        this.mniTextColor = mniTextColor;
    }

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        initComponents();
        setIcon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtaMain = new javax.swing.JTextArea();
        lblStatus = new javax.swing.JLabel();
        mnbMain = new javax.swing.JMenuBar();
        mnFile = new javax.swing.JMenu();
        mniNew = new javax.swing.JMenuItem();
        mniOpen = new javax.swing.JMenuItem();
        mniSave = new javax.swing.JMenuItem();
        mniSaveAs = new javax.swing.JMenuItem();
        sprtFile1 = new javax.swing.JPopupMenu.Separator();
        mniPageSetup = new javax.swing.JMenuItem();
        mniPrint = new javax.swing.JMenuItem();
        sprtFile2 = new javax.swing.JPopupMenu.Separator();
        mniExit = new javax.swing.JMenuItem();
        mnEdit = new javax.swing.JMenu();
        mniUndo = new javax.swing.JMenuItem();
        mniRedo = new javax.swing.JMenuItem();
        sprtEdit1 = new javax.swing.JPopupMenu.Separator();
        mniCut = new javax.swing.JMenuItem();
        mniCopy = new javax.swing.JMenuItem();
        mniPaste = new javax.swing.JMenuItem();
        mniDelete = new javax.swing.JMenuItem();
        sprtEdit2 = new javax.swing.JPopupMenu.Separator();
        mniFind = new javax.swing.JMenuItem();
        mniFindNext = new javax.swing.JMenuItem();
        mniReplace = new javax.swing.JMenuItem();
        mniGoTo = new javax.swing.JMenuItem();
        sprtEdit3 = new javax.swing.JPopupMenu.Separator();
        mniSelectAll = new javax.swing.JMenuItem();
        mniDateTime = new javax.swing.JMenuItem();
        mnFormat = new javax.swing.JMenu();
        mniFont = new javax.swing.JMenuItem();
        cbxmniWordWrap = new javax.swing.JCheckBoxMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mniTextColor = new javax.swing.JMenuItem();
        mniBackgroudColor = new javax.swing.JMenuItem();
        mnView = new javax.swing.JMenu();
        cbxmniStatusBar = new javax.swing.JCheckBoxMenuItem();
        mnHelp = new javax.swing.JMenu();
        mniViewHelp = new javax.swing.JMenuItem();
        sprtHelp = new javax.swing.JPopupMenu.Separator();
        mniAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(250, 200));

        txtaMain.setColumns(20);
        txtaMain.setRows(30);
        jScrollPane1.setViewportView(txtaMain);

        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblStatus.setText("|        Ln 1, Col 1  ");

        mnbMain.setBorder(null);

        mnFile.setText("File");
        mnFile.setMaximumSize(new java.awt.Dimension(33, 32767));
        mnFile.setMinimumSize(new java.awt.Dimension(33, 19));

        mniNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mniNew.setText("New");
        mnFile.add(mniNew);

        mniOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mniOpen.setText("Open...");
        mnFile.add(mniOpen);

        mniSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mniSave.setText("Save");
        mnFile.add(mniSave);

        mniSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mniSaveAs.setText("Save As...");
        mnFile.add(mniSaveAs);
        mnFile.add(sprtFile1);

        mniPageSetup.setText("Page Setup...");
        mnFile.add(mniPageSetup);

        mniPrint.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        mniPrint.setText("Print...");
        mnFile.add(mniPrint);
        mnFile.add(sprtFile2);

        mniExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        mniExit.setText("Exit");
        mnFile.add(mniExit);

        mnbMain.add(mnFile);
        mnFile.getAccessibleContext().setAccessibleDescription("");

        mnEdit.setText("Edit");
        mnEdit.setMaximumSize(new java.awt.Dimension(33, 32767));

        mniUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        mniUndo.setText("Undo");
        mnEdit.add(mniUndo);

        mniRedo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mniRedo.setText("Redo");
        mnEdit.add(mniRedo);
        mnEdit.add(sprtEdit1);

        mniCut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        mniCut.setText("Cut");
        mnEdit.add(mniCut);

        mniCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        mniCopy.setText("Copy");
        mnEdit.add(mniCopy);

        mniPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        mniPaste.setText("Paste");
        mnEdit.add(mniPaste);

        mniDelete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        mniDelete.setText("Delete");
        mnEdit.add(mniDelete);
        mnEdit.add(sprtEdit2);

        mniFind.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        mniFind.setText("Find...");
        mnEdit.add(mniFind);

        mniFindNext.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        mniFindNext.setText("Find Next");
        mnEdit.add(mniFindNext);

        mniReplace.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        mniReplace.setText("Replace...");
        mnEdit.add(mniReplace);

        mniGoTo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        mniGoTo.setText("Go To...");
        mnEdit.add(mniGoTo);
        mnEdit.add(sprtEdit3);

        mniSelectAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        mniSelectAll.setText("Select All");
        mnEdit.add(mniSelectAll);

        mniDateTime.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        mniDateTime.setText("Time/Date");
        mnEdit.add(mniDateTime);

        mnbMain.add(mnEdit);

        mnFormat.setText("Format");

        mniFont.setText("Font...");
        mnFormat.add(mniFont);

        cbxmniWordWrap.setText("Word Wrap");
        mnFormat.add(cbxmniWordWrap);
        mnFormat.add(jSeparator1);

        mniTextColor.setText("Text Color...");
        mnFormat.add(mniTextColor);

        mniBackgroudColor.setText("Backgroud Color...");
        mnFormat.add(mniBackgroudColor);

        mnbMain.add(mnFormat);

        mnView.setText("View");

        cbxmniStatusBar.setSelected(true);
        cbxmniStatusBar.setText("Status Bar");
        mnView.add(cbxmniStatusBar);

        mnbMain.add(mnView);

        mnHelp.setText("Help");

        mniViewHelp.setText("View Help");
        mnHelp.add(mniViewHelp);
        mnHelp.add(sprtHelp);

        mniAbout.setText("About Notepad");
        mnHelp.add(mniAbout);

        mnbMain.add(mnHelp);

        setJMenuBar(mnbMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
            .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem cbxmniStatusBar;
    private javax.swing.JCheckBoxMenuItem cbxmniWordWrap;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JMenu mnEdit;
    private javax.swing.JMenu mnFile;
    private javax.swing.JMenu mnFormat;
    private javax.swing.JMenu mnHelp;
    private javax.swing.JMenu mnView;
    private javax.swing.JMenuBar mnbMain;
    private javax.swing.JMenuItem mniAbout;
    private javax.swing.JMenuItem mniBackgroudColor;
    private javax.swing.JMenuItem mniCopy;
    private javax.swing.JMenuItem mniCut;
    private javax.swing.JMenuItem mniDateTime;
    private javax.swing.JMenuItem mniDelete;
    private javax.swing.JMenuItem mniExit;
    private javax.swing.JMenuItem mniFind;
    private javax.swing.JMenuItem mniFindNext;
    private javax.swing.JMenuItem mniFont;
    private javax.swing.JMenuItem mniGoTo;
    private javax.swing.JMenuItem mniNew;
    private javax.swing.JMenuItem mniOpen;
    private javax.swing.JMenuItem mniPageSetup;
    private javax.swing.JMenuItem mniPaste;
    private javax.swing.JMenuItem mniPrint;
    private javax.swing.JMenuItem mniRedo;
    private javax.swing.JMenuItem mniReplace;
    private javax.swing.JMenuItem mniSave;
    private javax.swing.JMenuItem mniSaveAs;
    private javax.swing.JMenuItem mniSelectAll;
    private javax.swing.JMenuItem mniTextColor;
    private javax.swing.JMenuItem mniUndo;
    private javax.swing.JMenuItem mniViewHelp;
    private javax.swing.JPopupMenu.Separator sprtEdit1;
    private javax.swing.JPopupMenu.Separator sprtEdit2;
    private javax.swing.JPopupMenu.Separator sprtEdit3;
    private javax.swing.JPopupMenu.Separator sprtFile1;
    private javax.swing.JPopupMenu.Separator sprtFile2;
    private javax.swing.JPopupMenu.Separator sprtHelp;
    private javax.swing.JTextArea txtaMain;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(("./img/Notepad_Icon.png")));
    }
}
