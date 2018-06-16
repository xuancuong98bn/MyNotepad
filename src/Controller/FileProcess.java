/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.MainForm;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author MTC
 */
public class FileProcess {

    private MainForm notepad;

    private boolean saved;
    private boolean newFileFlag;

    private String fileName;
    private String applicationTitle = "Notepad";

    private File fileRef;
    private JFileChooser chooser;

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public boolean isNewFileFlag() {
        return newFileFlag;
    }

    public void setNewFileFlag(boolean newFileFlag) {
        this.newFileFlag = newFileFlag;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileProcess() {
    }

    public FileProcess(MainForm notepad) {
        this.notepad = notepad;
        saved = true;
        newFileFlag = true;
        fileName = "Untiled";
        fileRef = new File(fileName);
        this.notepad.setTitle(fileName + " - " + applicationTitle);

        chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().endsWith(".java");
                }
            }

            @Override
            public String getDescription() {
                return "Java Source Files(*.java)";
            }
        });
        chooser.addChoosableFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().endsWith(".txt");
                }
            }

            @Override
            public String getDescription() {
                return "Text Files(*.txt)";
            }
        });
        chooser.setCurrentDirectory(new File("."));
    }

    //--- Save File ---
    public boolean saveFile(File temp) {
        FileWriter fout = null;
        try {
            fout = new FileWriter(temp);
            fout.write(notepad.getTxtaMain().getText());
        } catch (IOException e) {
            updateStatus(temp, false);
            return false;
        } finally {
            try {
                fout.close();
            } catch (IOException excp) {
            }
        }
        updateStatus(temp, true);
        return true;
    }

    public void updateStatus(File temp, boolean saved) {
        if (saved) {
            this.saved = true;
            fileName = temp.getName();
            if (!temp.canWrite()) {
                fileName += "(Read only)";
                newFileFlag = true;
            }
            fileRef = temp;
            notepad.setTitle(fileName + " - " + applicationTitle);
            notepad.getLblStatus().setText("File : " + temp.getPath() + " saved/opened successfully.");
            newFileFlag = false;
        } else {
            notepad.getLblStatus().setText("Failed to save/open : " + temp.getPath());
        }
    }

    public boolean saveThisFile() {
        if (!newFileFlag) {
            return saveFile(fileRef);
        }
        return saveAsFile();
    }

    public boolean saveAsFile() {
        File temp = null;
        do {
            if (chooser.showSaveDialog(this.notepad) != JFileChooser.APPROVE_OPTION) {
                return false;
            }
            temp = chooser.getSelectedFile();
            if (!temp.exists()) {
                break;
            }
            if (JOptionPane.showConfirmDialog(
                    this.notepad, "<html>" + temp.getName()+ " already exists.<br>Do you want to replace it?<html>",
                    "Save As", JOptionPane.YES_NO_OPTION
            ) == JOptionPane.YES_OPTION) {
                break;
            }
        } while (true);

        return saveFile(temp);
    }

    public boolean openFile(File temp) {
        FileInputStream fin = null;
        BufferedReader din = null;

        try {
            fin = new FileInputStream(temp);
            din = new BufferedReader(new InputStreamReader(fin));
            String str = "";
            while (str != null) {
                str = din.readLine();
                if (str == null) {
                    break;
                }
                this.notepad.getTxtaMain().append(str + "\n");
            }

        } catch (IOException ioe) {
            updateStatus(temp, false);
            return false;
        } finally {
            try {
                din.close();
                fin.close();
            } catch (IOException excp) {
            }
        }
        updateStatus(temp, true);
        this.notepad.getTxtaMain().setCaretPosition(0);
        return true;
    }

    public boolean openFile() {
        if (!confirmSave()) {
            return false;
        }

        File temp = null;
        do {
            if (chooser.showOpenDialog(this.notepad) != JFileChooser.APPROVE_OPTION) {
                return false;
            }
            temp = chooser.getSelectedFile();

            if (temp.exists()) {
                break;
            }

            JOptionPane.showMessageDialog(this.notepad,
                    "<html>" + temp.getName() + "<br>file not found.<br>"
                    + "Please verify the correct file name was given.<html>",
                    "Open", JOptionPane.INFORMATION_MESSAGE);

        } while (true);

        this.notepad.getTxtaMain().setText("");

        if (!openFile(temp)) {
            fileName = "Untitled";
            saved = true;
            this.notepad.setTitle(fileName + " - " + applicationTitle);
        }
        if (!temp.canWrite()) {
            newFileFlag = true;
        }
        return true;
    }

    public boolean confirmSave() {
        String strMsg = "<html><div style = 'color:blue'>Do you want to save the changes to "+fileRef+"</div><html>";
        if (!saved) {
            int x = JOptionPane.showConfirmDialog(this.notepad, strMsg, applicationTitle,
                    JOptionPane.YES_NO_CANCEL_OPTION);

            if (x == JOptionPane.CANCEL_OPTION) {
                return false;
            }
            if (x == JOptionPane.YES_OPTION && !saveAsFile()) {
                return false;
            }
        }
        return true;
    }

    public void newFile() {
        if (!confirmSave()) {
            return;
        }

        this.notepad.getTxtaMain().setText("");
        fileName = "Untitled";
        fileRef = new File(fileName);
        saved = true;
        newFileFlag = true;
        this.notepad.setTitle(fileName + " - " + applicationTitle);
    }
}
