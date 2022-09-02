package Logic;

import UI.Login;
import UI.Messenger;
import UI.Registration;

import javax.swing.*;
import java.awt.*;

public class UIManager {
    JFrame frame = new JFrame();

    public UIManager() {
//        frame.add(new Login(this)); frame.setResizable(false);
//        frame.pack();
//        frame.setVisible(true);
        SwitchState(State.RUNNING);
        frame.setVisible(true);
    }

    public void ShowErrorMsg(String msg) {
        JOptionPane.showMessageDialog(frame,msg,"Error",JOptionPane.ERROR_MESSAGE);
    }

    public void SwitchState(State state) {
        frame.getContentPane().removeAll();
        frame.repaint();

        switch (state){
            case LOGIN:
                frame.setTitle("Login");
                frame.setResizable(false);
                frame.add(new Login(this));
                break;
            case REGISTER:
                frame.setTitle("Registration");
                frame.setResizable(false);
                frame.add(new Registration(this));
                break;
            case RUNNING:
                frame.setTitle("Messenger");
                frame.setResizable(true);
                frame.add(new Messenger(this));
                break;
        }
        frame.pack();
        frame.validate();
        frame.pack();
    }
}

