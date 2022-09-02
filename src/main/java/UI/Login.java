package UI;

import Logic.SaveManager;
import Logic.State;
import Logic.UIManager;
import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JPanel {
    @Override
    public Dimension getSize() {
        return new Dimension(1920/4, 1080/6);
    }

    @Override
    public Dimension getPreferredSize() {
        return getSize();
    }

    public Login(UIManager uiManager) {
        JTextField nameField = new JTextField(1);
        JPasswordField passwordField = new JPasswordField();

        this.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 1;
        c.weighty = 1;

        c.insets = new Insets(6, 6,0, 0);
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(new JLabel("Name"), c);

        c.insets = new Insets(6, 0,0, 6);
        c.gridx = 1;
        c.weightx = 2;
        this.add(nameField, c);

        c.insets = new Insets(6, 6,0, 0);
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(new JLabel("Password"), c);

        c.insets = new Insets(0, 0,0, 6);
        c.gridx = 1;
        this.add(passwordField, c);

        // Login button & function
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            String hash = SaveManager.GetUserPasswordHash(nameField.getText());
            // If hash is null the requested user does not exist
            if (hash != null){
                if (BCrypt.checkpw(String.valueOf(passwordField.getPassword()), SaveManager.GetUserPasswordHash(nameField.getText()))) {
                    uiManager.SwitchState(State.RUNNING);
                    return;
                }
            }
            uiManager.ShowErrorMsg("Wrong login info!");
        });
        c.insets = new Insets(6, 6,6, 3);
        c.gridwidth = 1;
        c.gridheight = 2;
        c.gridx = 0;
        c.gridy = 2;
        c.fill = GridBagConstraints.BOTH;
        this.add(loginButton, c);

        // Register button & function
        JButton registrationButton = new JButton("Register");
        registrationButton.addActionListener(e -> {
            // Switch to registration
            uiManager.SwitchState(State.REGISTER);
        });
        c.insets = new Insets(6, 3,6, 6);
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 2;
        c.fill = GridBagConstraints.BOTH;
        this.add(registrationButton, c);
    }
}
