package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Logic.SaveManager;
import Logic.State;
import Logic.UIManager;
import org.mindrot.jbcrypt.BCrypt;

public class Registration extends JPanel{
    @Override
    public Dimension getSize() {
        return new Dimension(1920/4, 1080/6);
    }

    @Override
    public Dimension getPreferredSize() {
        return getSize();
    }

    public Registration(UIManager uiManager) {

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

        JButton loginButton = new JButton("Cancel");
        loginButton.addActionListener(e -> {
            // switch to login
            uiManager.SwitchState(State.LOGIN);
        });
        c.insets = new Insets(6, 6,6, 3);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 2;
        c.fill = GridBagConstraints.BOTH;
        this.add(loginButton, c);


        JButton registrationButton = new JButton("Register");
        registrationButton.addActionListener(e -> {
                String password = String.valueOf(passwordField.getPassword());
                if (password.length() < 8) {
                    uiManager.ShowErrorMsg("Password needs to be at least 8 Characters!");
                    return;
                }

                String name = nameField.getText();
                if (name.length() < 5) {
                    uiManager.ShowErrorMsg("Username needs to be at least 5 Characters!");
                    return;
                }

                // Save user to file
                SaveManager.SaveUser(name, BCrypt.hashpw(String.valueOf(passwordField.getPassword()), BCrypt.gensalt()));

                // switch to login
                uiManager.SwitchState(State.LOGIN);
        });
        c.insets = new Insets(6, 3,6, 6);
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 2;
        c.fill = GridBagConstraints.BOTH;
        this.add(registrationButton, c);
    }
}
