package io.github.lorensfs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

    private JPanel jPanel;
    private JButton multiplicarButton;
    private JButton sumarButton;
    private JButton dividirButton;
    private JButton restarButton;
    private JTextField textField1;
    private JTextField textField2;

    Calculator() {
        setContentPane(jPanel);
        setTitle("Calculadora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);

        multiplicarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int x= Integer.parseInt((textField1.getText()));
                    int y= Integer.parseInt((textField2.getText()));
                    int mul=(x*y);
                    JOptionPane.showMessageDialog(null, mul);
                }catch (NullPointerException p){
                    JOptionPane.showMessageDialog(null, "Ingrese un valor que no sea null"+ p.getMessage());
                }catch (ArithmeticException p){
                    JOptionPane.showMessageDialog(null, p.getMessage());
                }catch (NumberFormatException p){
                    JOptionPane.showMessageDialog(null, "Ingrese un valor númerico"+ p.getMessage());
                }
        }});
        sumarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int x = Integer.parseInt(textField1.getText());
                    int y = Integer.parseInt(textField2.getText());
                    int sum = x + y;
                    JOptionPane.showMessageDialog(null, sum);
                } catch (NullPointerException p) {
                    JOptionPane.showMessageDialog(null, "Ingrese un valor que no sea null: " + p.getMessage());
                } catch (NumberFormatException p) {
                    JOptionPane.showMessageDialog(null, "Ingrese un valor numérico: " + p.getMessage());
                }
            }
        });
        dividirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int x = Integer.parseInt(textField1.getText());
                    int y = Integer.parseInt(textField2.getText());
                    int div = x / y;
                    JOptionPane.showMessageDialog(null, div);
                } catch (NullPointerException p) {
                    JOptionPane.showMessageDialog(null, "Ingrese un valor que no sea null: " + p.getMessage());
                } catch (ArithmeticException p) {
                    JOptionPane.showMessageDialog(null, "División por cero no es permitida: " + p.getMessage());
                } catch (NumberFormatException p) {
                    JOptionPane.showMessageDialog(null, "Ingrese un valor numérico: " + p.getMessage());
                }
            }
        });
        restarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int x = Integer.parseInt(textField1.getText());
                    int y = Integer.parseInt(textField2.getText());
                    int sub = x - y;
                    JOptionPane.showMessageDialog(null, sub);
                } catch (NullPointerException p) {
                    JOptionPane.showMessageDialog(null, "Ingrese un valor que no sea null: " + p.getMessage());
                } catch (NumberFormatException p) {
                    JOptionPane.showMessageDialog(null, "Ingrese un valor numérico: " + p.getMessage());
                }
            }
        });
    }

}
