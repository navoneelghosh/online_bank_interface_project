package com.bank.atm.gui.login;

import com.bank.atm.gui.user.UserMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

/**
 * @author Navoneel Ghosh
 * Login GUI
 */
public class Login extends JFrame {
    private JPanel loginPanel;
    private JTextField usernameTextField;
    private JPasswordField passwordPasswordField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel forgotPasswordLabel;
    private JButton loginButton;
    private JButton signUpButton;

    public Login(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(loginPanel);
        this.setPreferredSize(new Dimension(500, 500));//set width and height of our frame
        this.pack();

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    String userName = usernameTextField.getText().trim();
                    String password = Arrays.toString(passwordPasswordField.getPassword()).trim();
                    com.bank.atm.backend.authentication.Login login = new com.bank.atm.backend.authentication.Login(userName, password);
                    login.run();
                    dispose();
                    JFrame frame = new UserMenu("User Menu");
                    frame.setVisible(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(loginPanel, e.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                dispose();
                JFrame frame = new SignUp("Sign Up");
                frame.setVisible(true);
            }
        });

        forgotPasswordLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                try {
                    dispose();
                    JFrame frame = new ForgotPassword("Forgot Password");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void mouseEntered(MouseEvent event) {
                forgotPasswordLabel.setText("<html><a href=''>Forgot Password?</a></html>");
            }

            @Override
            public void mouseExited(MouseEvent event) {
                forgotPasswordLabel.setText("Forgot Password?");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new Login("Login");
        frame.setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setName("Login");
        usernameLabel = new JLabel();
        usernameLabel.setText("Username : ");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        loginPanel.add(usernameLabel, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginPanel.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        loginPanel.add(spacer2, gbc);
        passwordLabel = new JLabel();
        passwordLabel.setText("Password : ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        loginPanel.add(passwordLabel, gbc);
        usernameTextField = new JTextField();
        usernameTextField.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginPanel.add(usernameTextField, gbc);
        passwordPasswordField = new JPasswordField();
        passwordPasswordField.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginPanel.add(passwordPasswordField, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginPanel.add(spacer3, gbc);
        forgotPasswordLabel = new JLabel();
        forgotPasswordLabel.setHorizontalAlignment(10);
        forgotPasswordLabel.setHorizontalTextPosition(11);
        forgotPasswordLabel.setText("Forgot password?");
        forgotPasswordLabel.setVerticalAlignment(0);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        loginPanel.add(forgotPasswordLabel, gbc);
        loginButton = new JButton();
        loginButton.setLabel("Login");
        loginButton.setText("Login");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginPanel.add(loginButton, gbc);
        signUpButton = new JButton();
        signUpButton.setLabel("Sign Up");
        signUpButton.setText("Sign Up");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginPanel.add(signUpButton, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        loginPanel.add(spacer4, gbc);
        usernameLabel.setLabelFor(usernameTextField);
        passwordLabel.setLabelFor(passwordPasswordField);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return loginPanel;
    }

}
