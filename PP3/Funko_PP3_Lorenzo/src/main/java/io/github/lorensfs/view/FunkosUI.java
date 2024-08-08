package io.github.lorensfs.view;

import io.github.lorensfs.controllers.FunkosController;
import io.github.lorensfs.models.Funkos;

import javax.swing.*;

public class FunkosUI extends JFrame {
    private JTextField nameField;
    private JButton searchButton;
    private JButton saveButton;
    private JButton clearButton;
    private JTextField descriptionField;
    private JCheckBox vaultedCheckBox;
    private JButton deleteButton;
    private JButton modifyButton;
    private JPanel mainPannel;
    private final FunkosController funkosController = new FunkosController();

    public FunkosUI() {
        setContentPane(mainPannel);
        setTitle("Funko CRUD");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        searchButton.addActionListener(e -> {
            if (!nameField.getText().isEmpty()) {
                Funkos funkos = funkosController.consultFunkoByName(nameField.getText());
                nameField.setText(funkos.getName());
                descriptionField.setText(funkos.getDescription());
                vaultedCheckBox.setSelected(funkos.getVaulted());
            } else {
                JOptionPane.showMessageDialog(null, "Input a name value first");
            }
        });

        modifyButton.addActionListener(e -> {
            if ((!nameField.getText().isEmpty() && !descriptionField.getText().isEmpty())) {
                if (!funkosController.consultFunkoByName(nameField.getText()).getVaulted()) {
                    Boolean isModified = funkosController.modifyFunko(nameField.getText(), descriptionField.getText());
                    clearButton.doClick();
                    if (isModified) {
                        JOptionPane.showMessageDialog(null, "Funko was " +
                                "successfully modified");
                    } else {
                        JOptionPane.showMessageDialog(null, "Funko couldn't " +
                                "be modified");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Funko couldn't " +
                            "be modified as it's already vaulted");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Input a value first " +
                        "in both name and description field");
            }
        });

        saveButton.addActionListener(e -> {
            if ((!nameField.getText().isEmpty() && !descriptionField.getText().isEmpty())) {
                Boolean isModified = funkosController.insertFunko(nameField.getText(), descriptionField.getText());
                clearButton.doClick();
                if (isModified) {
                    JOptionPane.showMessageDialog(null, "Funko was successfully " +
                            "inserted into the database");
                } else {
                    JOptionPane.showMessageDialog(null, "Funko couldn't" +
                            " be inserted as it already exist or the name/description is too long");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Input a value first " +
                        "in both name and description field");
            }
        });
        deleteButton.addActionListener(e -> {
            if ((!nameField.getText().isEmpty())) {
                Boolean isModified = funkosController.softDeleteFunko(nameField.getText());
                clearButton.doClick();
                if (isModified) {
                    JOptionPane.showMessageDialog(null, "Funko was successfully " +
                            "deleted");
                } else {
                    JOptionPane.showMessageDialog(null, "Funko couldn't" +
                            " be deleted");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Input a name value first ");
            }
        });

        clearButton.addActionListener(e -> {
            nameField.setText("");
            descriptionField.setText("");
            vaultedCheckBox.setSelected(false);
        });

    }
}
