/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.*;
import MyStack.MyStack;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author MTC
 */
public class Controller {

    //<editor-fold defaultstate="collapsed" desc=" Declare the objects will be use in this program ">
    StartForm startNote;
    MainForm notepad;
    FileProcess fileProcess;

    FindDialog findDialog = null;
    ReplaceDialog replaceDialog = null;

    MyStack saveStep = null;
    MyStack saveUndoStep = null;
    //</editor-fold>

    //Initialization constructor 
    Controller() {
        startNote = new StartForm();
        startNote.setVisible(true);
        notepad = new MainForm();
        fileProcess = new FileProcess(notepad);
        saveStep = new MyStack();
        saveUndoStep = new MyStack();
        controlStart();
    }

    //handling manipulation of user include NEW, OPEN, ABOUT
    private void controlStart() {
        startNote.getBtnNew().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNote.dispose();
                notepad.setVisible(true);
            }
        });
        startNote.getBtnOpen().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileProcess.openFile()) {
                    startNote.dispose();
                    notepad.setVisible(true);
                }
            }
        });
        startNote.getBtnAbout().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepad.getMniAbout().doClick();
            }
        });
    }

    //control the activity of notepad 
    public void control() {
        //listen activity will occur during program running
        //this action will use for undo, redo method and update the position of pointer
        notepad.getTxtaMain().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                //check text will save into stack
                if (!notepad.getTxtaMain().getText().equals(saveStep.top())
                        && !notepad.getTxtaMain().getText().equals("")) {
                    String saveText = notepad.getTxtaMain().getText();
                    saveStep.push(saveText);
                }
                //check text area empty
                if (notepad.getTxtaMain().getText().isEmpty() && fileProcess.isNewFileFlag()) {
                    fileProcess.setSaved(true);
                }
                //update the position of pointer
                int lineNumber = 0, column = 0, pos = 0;
                try {
                    pos = notepad.getTxtaMain().getCaretPosition();
                    lineNumber = notepad.getTxtaMain().getLineOfOffset(pos);
                    column = pos - notepad.getTxtaMain().getLineStartOffset(lineNumber);
                } catch (Exception excp) {
                }
                if (notepad.getTxtaMain().getText().length() == 0) {
                    lineNumber = 0;
                    column = 0;
                }
                notepad.getLblStatus().setText("|        Ln " + (lineNumber + 1) + ", Col " + (column + 1));
            }
        });

        //track the change of Text Area and give status saved
        notepad.getTxtaMain().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                fileProcess.setSaved(false);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                fileProcess.setSaved(false);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                fileProcess.setSaved(false);
            }
        });

        //close program method
        notepad.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                if (fileProcess.confirmSave()) {
                    System.exit(0);
                }
            }
        });

        //set enabled of the menu items
        notepad.getMnEdit().addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                {
                    //check the text whether is empty or not to set enable
                    if (notepad.getTxtaMain().getText().length() == 0) {
                        notepad.getMniUndo().setEnabled(false);
                        notepad.getMniFind().setEnabled(false);
                        notepad.getMniFindNext().setEnabled(false);
                        notepad.getMniReplace().setEnabled(false);
                        notepad.getMniSelectAll().setEnabled(false);
                        notepad.getMniGoTo().setEnabled(false);
                    } else {
                        notepad.getMniUndo().setEnabled(true);
                        notepad.getMniFind().setEnabled(true);
                        notepad.getMniFindNext().setEnabled(true);
                        notepad.getMniReplace().setEnabled(true);
                        notepad.getMniSelectAll().setEnabled(true);
                        notepad.getMniGoTo().setEnabled(true);
                    }
                    //check the selection area to set enable of method cut, copy, delete
                    if (notepad.getTxtaMain().getSelectionStart() == notepad.getTxtaMain().getSelectionEnd()) {
                        notepad.getMniCut().setEnabled(false);
                        notepad.getMniCopy().setEnabled(false);
                        notepad.getMniDelete().setEnabled(false);
                    } else {
                        notepad.getMniCut().setEnabled(true);
                        notepad.getMniCopy().setEnabled(true);
                        notepad.getMniDelete().setEnabled(true);
                    }
                    //check the stack whether has any item or not
                    if (saveUndoStep.isEmpty()) {
                        notepad.getMniRedo().setEnabled(false);
                    } else {
                        notepad.getMniRedo().setEnabled(true);
                    }
                }
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });

        actionPerformed();

    }

    //Go to method: move the poiter to any line number
    public void goTo() {
        int lineNumber = 0;
        try {
            lineNumber = notepad.getTxtaMain().getLineOfOffset(notepad.getTxtaMain().getCaretPosition()) + 1;
            String tempStr = JOptionPane.showInputDialog(notepad, "Enter Line Number:", "" + lineNumber);
            if (tempStr == null) {
                return;
            }
            lineNumber = Integer.parseInt(tempStr);
            notepad.getTxtaMain().setCaretPosition(notepad.getTxtaMain().getLineStartOffset(lineNumber - 1));
        } catch (Exception e) {
        }
    }

    //<editor-fold defaultstate="collapsed" desc=" Handle background and foreground color ">
    JColorChooser bcolorChooser = null;
    JDialog backgroundDialog = null;

    public void showBackgroundColorDialog() {
        if (bcolorChooser == null) {
            bcolorChooser = new JColorChooser();
        }
        if (backgroundDialog == null) {
            backgroundDialog = JColorChooser.createDialog(notepad,
                    "Background Color",
                    false,
                    bcolorChooser,
                    new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evvv) {
                    notepad.getTxtaMain().setBackground(bcolorChooser.getColor());
                }
            },
                    null);
        }

        backgroundDialog.setVisible(true);
    }

    //--------//
    JColorChooser fcolorChooser = null;
    JDialog foregroundDialog = null;

    public void showForegroundColorDialog() {
        if (fcolorChooser == null) {
            fcolorChooser = new JColorChooser();
        }
        if (foregroundDialog == null) {
            foregroundDialog = JColorChooser.createDialog(notepad,
                    "Text Color",
                    false,
                    fcolorChooser,
                    new ActionListener() {
                public void actionPerformed(ActionEvent evvv) {
                    notepad.getTxtaMain().setForeground(fcolorChooser.getColor());
                }
            },
                    null);
        }

        foregroundDialog.setVisible(true);
    } //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Handle find, find next method ">
    public void controlFind() {
        findDialog.getBtnFindNext().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = findNext();
                if (index != -1) {
                    notepad.getTxtaMain().setSelectionStart(index);
                    notepad.getTxtaMain().setSelectionEnd(index + findDialog.getTxtFindWhat().getText().length());
                } else {
                    JOptionPane.showMessageDialog(findDialog,
                            "Cannot find" + " \"" + findDialog.getTxtFindWhat().getText() + "\"",
                            "Find", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        findDialog.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findDialog.setVisible(false);
            }
        });
    }

    private int findNext() {
        String textMain = notepad.getTxtaMain().getText();
        String textFind = findDialog.getTxtFindWhat().getText();

        int lastIndex = notepad.getTxtaMain().getCaretPosition();
        int selStart = notepad.getTxtaMain().getSelectionStart();
        int selEnd = notepad.getTxtaMain().getSelectionEnd();

        if (findDialog.getRadUp().isSelected()) {
            if (selStart != selEnd) {
                lastIndex = selEnd - textFind.length() - 1;
            }
            if (!findDialog.getCbMatchCase().isSelected()) {
                lastIndex = textMain.toUpperCase().lastIndexOf(textFind.toUpperCase(), lastIndex);
            } else {
                lastIndex = textMain.lastIndexOf(textFind, lastIndex);
            }
        } else {
            if (selStart != selEnd) {
                lastIndex = selStart + 1;
            }
            if (!findDialog.getCbMatchCase().isSelected()) {
                lastIndex = textMain.toUpperCase().indexOf(textFind.toUpperCase(), lastIndex);
            } else {
                lastIndex = textMain.indexOf(textFind, lastIndex);
            }
        }
        return lastIndex;
    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Handle replace method ">
    public void controlReplace() {
        replaceDialog.getTxtFindWhat().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                String findwhat = replaceDialog.getTxtFindWhat().getText();
                String replacewith = replaceDialog.getTxtReplaceWith().getText();

                if (findwhat.isEmpty()) {
                    replaceDialog.getBtnFindNext().setEnabled(false);
                    replaceDialog.getBtnReplace().setEnabled(false);
                    replaceDialog.getBtnReplaceAll().setEnabled(false);
                } else {
                    replaceDialog.getBtnFindNext().setEnabled(true);
                    replaceDialog.getBtnReplace().setEnabled(true);
                    replaceDialog.getBtnReplaceAll().setEnabled(true);
                }
            }
        });
        replaceDialog.getBtnFindNext().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = findNextReplace();
                if (index != -1) {
                    notepad.getTxtaMain().setSelectionStart(index);
                    notepad.getTxtaMain().setSelectionEnd(index + replaceDialog.getTxtFindWhat().getText().length());
                } else {
                    JOptionPane.showMessageDialog(replaceDialog,
                            "Cannot find" + " \"" + replaceDialog.getTxtFindWhat().getText() + "\"",
                            "Find", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        replaceDialog.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replaceDialog.setVisible(false);
            }
        });
        replaceDialog.getBtnReplace().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replaceNext();
            }
        });
        replaceDialog.getBtnReplaceAll().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Total replacements made= " + replaceAll());
            }
        });
    }

    private int findNextReplace() {

        String textMain = notepad.getTxtaMain().getText();
        String textFind = replaceDialog.getTxtFindWhat().getText();

        int lastIndex = notepad.getTxtaMain().getCaretPosition();
        int selStart = notepad.getTxtaMain().getSelectionStart();
        int selEnd = notepad.getTxtaMain().getSelectionEnd();

        if (selStart != selEnd) {
            lastIndex = selStart + 1;
        }
        if (!replaceDialog.getBtnMatchCase().isSelected()) {
            lastIndex = textMain.toUpperCase().indexOf(textFind.toUpperCase(), lastIndex);
        } else {
            lastIndex = textMain.indexOf(textFind, lastIndex);
        }
        return lastIndex;
    }

    private void replaceNext() {
        // if nothing is selectd
        if (notepad.getTxtaMain().getSelectionStart() == notepad.getTxtaMain().getSelectionEnd()) {
            replaceDialog.getBtnFindNext().doClick();
            return;
        }

        String searchText = replaceDialog.getTxtFindWhat().getText();
        String temp = notepad.getTxtaMain().getSelectedText();	//get selected text

        //check if the selected text matches the search text then do replacement
        if ((replaceDialog.getBtnMatchCase().isSelected() && temp.equals(searchText))
                || (!replaceDialog.getBtnMatchCase().isSelected() && temp.equalsIgnoreCase(searchText))) {
            notepad.getTxtaMain().replaceSelection(replaceDialog.getTxtReplaceWith().getText());
        }

        replaceDialog.getBtnFindNext().doClick();
    }

    private int replaceAll() {
        int savePos = notepad.getTxtaMain().getCaretPosition();
        notepad.getTxtaMain().setCaretPosition(0);

        int index = 0;
        int counter = 0;
        do {
            index = findNextReplace();
            if (index == -1) {
                break;
            }
            counter++;
            notepad.getTxtaMain().replaceRange(replaceDialog.getTxtReplaceWith().getText(), index, index + replaceDialog.getTxtFindWhat().getText().length());
        } while (index != -1);
        notepad.getTxtaMain().setCaretPosition(savePos);
        return counter;
    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Initialization the value of font form ">
    FontChooser fontDialog = null;
    String[] fontNames = GraphicsEnvironment
            .getLocalGraphicsEnvironment()
            .getAvailableFontFamilyNames();

    public void initValueFont() {
        fontDialog.getListFont().setModel(new DefaultComboBoxModel(fontNames));
        ArrayList<Integer> sizes = new ArrayList<>();
        for (int i = 8; i < 73; i += 2) {
            sizes.add(i);
        }
        fontDialog.getListSize().setModel(new DefaultComboBoxModel(sizes.toArray()));

        String txtaFontName = notepad.getTxtaMain().getFont().getFamily();
        int txtaStyle = notepad.getTxtaMain().getFont().getStyle();
        int txtaSize = notepad.getTxtaMain().getFont().getSize();

        fontDialog.getListFont().setSelectedValue(txtaFontName, true);
        fontDialog.getListFontStyle().setSelectedIndex(txtaStyle);
        fontDialog.getListSize().setSelectedValue(txtaSize, true);
        fontDialog.getTxtFont().setText(txtaFontName);
        fontDialog.getTxtFontStyle().setText(fontDialog.getListFontStyle().getSelectedValue());
        fontDialog.getTxtSize().setText(txtaSize + "");
        fontDialog.getTxtaExample().setFont(new Font(txtaFontName, txtaStyle, txtaSize));

        fontDialog.getListFont().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String fontName = fontDialog.getListFont().getSelectedValue();

                fontDialog.getTxtFont().setText(fontName);

                int currentStyle = fontDialog.getTxtFont().getFont().getStyle();
                int currentSize = fontDialog.getTxtFont().getFont().getSize();
                fontDialog.getTxtFont().setFont(new Font(fontName, currentStyle, currentSize));
                fontDialog.getListFontStyle().setSelectedIndex(currentStyle);
            }
        });
        fontDialog.getListFontStyle().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String currentFontName = fontDialog.getTxtFontStyle().getFont().getFamily();
                int style = fontDialog.getListFontStyle().getSelectedIndex();
                int currentSize = fontDialog.getTxtFontStyle().getFont().getSize();

                fontDialog.getTxtFontStyle().setText(fontDialog.getListFontStyle().getSelectedValue());
                fontDialog.getTxtFontStyle().setFont(new Font(currentFontName, style, currentSize));
            }
        });
        fontDialog.getListSize().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int temp = fontDialog.getListSize().getSelectedIndex() * 2 + 8;
                fontDialog.getTxtSize().setText(temp + "");
            }
        });
        fontDialog.getTxtFont().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = fontDialog.getTxtFont().getText();
                for (String mem : fontNames) {
                    if (mem.equalsIgnoreCase(temp)) {
                        fontDialog.getListFont().setSelectedValue(temp, true);
                        break;
                    };
                }
            }
        });
        fontDialog.getTxtaExample().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                String fontName = "";
                int style = 0;
                int size = 12;
                try {
                    fontName = fontDialog.getTxtFont().getText();
                    style = fontDialog.getListFontStyle().getSelectedIndex();
                    size = Integer.parseInt(fontDialog.getTxtSize().getText());
                } catch (NumberFormatException nume) {
                    notepad.getLblStatus().setText("Enter Font invalid! Value change to default.");
                }
                fontDialog.getTxtaExample().setFont(new Font(fontName, style, size));
            }
        });
    }//</editor-fold>

    //control font
    public void controlFont() {
        fontDialog.getBtnOK().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Font willChangeFont = fontDialog.getTxtaExample().getFont();
                notepad.getTxtaMain().setFont(willChangeFont);
                fontDialog.setVisible(false);
            }
        });
        fontDialog.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fontDialog.setVisible(false);
            }
        });
    }

    //listen all activity will happen in the menu bar
    public void actionPerformed() {
        ////////////////////////////////////  
        notepad.getMniNew().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileProcess.newFile();
            }
        });

        notepad.getMniOpen().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileProcess.openFile();
            }
        });

        notepad.getMniSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileProcess.saveThisFile();
            }
        });

        notepad.getMniSaveAs().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileProcess.saveAsFile();
            }
        });

        notepad.getMniExit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileProcess.confirmSave()) {
                    System.exit(0);
                }
            }
        });

        notepad.getMniPageSetup().addActionListener(new ActionListener()    {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        notepad,
                        "This function will be coming soon.",
                        "Function developing",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        notepad.getMniPrint().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        notepad,
                        "This function will be coming soon.",
                        "Function developing",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        notepad.getMniUndo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!saveStep.isEmpty()) {
                    saveUndoStep.push(saveStep.pop());
                    if (!saveStep.isEmpty()) {
                        notepad.getTxtaMain().setText(saveStep.top().toString());
                    } else {
                        notepad.getTxtaMain().setText("");
                    }
                }
            }
        });

        notepad.getMniRedo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!saveUndoStep.isEmpty()) {
                    notepad.getTxtaMain().setText(saveUndoStep.pop().toString());
                }
            }
        });

        notepad.getMniCut().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepad.getTxtaMain().cut();
            }
        });

        notepad.getMniCopy().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepad.getTxtaMain().copy();
            }
        });

        notepad.getMniPaste().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepad.getTxtaMain().paste();
            }
        });

        notepad.getMniDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepad.getTxtaMain().replaceSelection("");
            }
        });

        notepad.getMniFind().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (notepad.getTxtaMain().getText().length() == 0) {
                    return; // text box have no text  
                }
                if (findDialog == null) {
                    findDialog = new FindDialog(notepad, true);
                }
                controlFind();
                findDialog.setVisible(true);
            }
        });

        notepad.getMniFindNext().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (notepad.getTxtaMain().getText().length() == 0) {
                    return; // text box have no text  
                }
                if (findDialog == null || findDialog.getTxtFindWhat().getText().equals("")) {
                    notepad.getLblStatus().setText("Fill Find option of Edit Menu first !!!!");
                } else {
                    findDialog.getBtnFindNext().doClick();
                }
            }
        });

        notepad.getMniReplace().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (notepad.getTxtaMain().getText().length() == 0) {
                    return; // text box have no text  
                }
                if (replaceDialog == null) {
                    replaceDialog = new ReplaceDialog(notepad, true);
                }
                controlReplace();
                replaceDialog.setVisible(true);
            }
        });

        notepad.getMniGoTo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (notepad.getTxtaMain().getText().length() == 0) {
                    return; // text box have no text  
                }
                goTo();
            }
        });

        notepad.getMniSelectAll().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepad.getTxtaMain().selectAll();
            }
        });

        notepad.getMniDateTime().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepad.getTxtaMain().insert(new Date().toString(), notepad.getTxtaMain().getSelectionStart());
            }
        });

        notepad.getCbxMniWordWrap().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean checkWW = notepad.getCbxMniWordWrap().isSelected();
                boolean checkSB = notepad.getCbxmniStatusBar().isSelected();
                notepad.getTxtaMain().setLineWrap(checkWW);
                notepad.getCbxmniStatusBar().setEnabled(!checkWW);
                notepad.getMniGoTo().setEnabled(!checkWW);
                if (!checkWW && checkSB) {
                    notepad.getLblStatus().setVisible(true);
                } else if (!checkWW && !checkSB || checkWW) {
                    notepad.getLblStatus().setVisible(false);
                }

            }
        });

        notepad.getMniFont().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fontDialog = new FontChooser(notepad, true);
                initValueFont();
                controlFont();
                fontDialog.setVisible(true);
            }
        });

        notepad.getMniTextColor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showForegroundColorDialog();
            }
        });

        notepad.getMniBackgroundColor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showBackgroundColorDialog();
            }
        });

        notepad.getCbxmniStatusBar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepad.getLblStatus().setVisible(notepad.getCbxmniStatusBar().isSelected());
            }
        });

        notepad.getMniViewHelp().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        URI uri = new URI("https://answers.microsoft.com/en-us/windows/forum/apps_windows_10");
                        desktop.browse(uri);
                    } catch (IOException ex) {
                        // do nothing
                    } catch (URISyntaxException ex) {
                        //do nothing
                    }
                } else {
                    //do nothing
                }
            }
        });

        notepad.getMniAbout().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(notepad, "This is about", "hehehehhe",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    //Main :)
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.control();
    }
}
