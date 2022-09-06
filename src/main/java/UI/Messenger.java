package UI;

import Logic.UIManager;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Messenger extends JPanel {
    public Messenger(UIManager uiManager) {
        this.setLayout(new GridBagLayout());

        GridBagConstraints c;

        // TOP PANEL
        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        topPanel.add(new JLabel("TOP"));

        // SIDE PANEL
        JPanel sidePanel = new JPanel();
        sidePanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        sidePanel.add(new JLabel("SIDE"));

        // CHAT PANEL
        JPanel chatPanel = new JPanel();
        chatPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        chatPanel.add(new JLabel("CHAT"));

        // INPUT PANEL
        JTextArea inputField = new JTextArea();
        JScrollPane inputPane = new JScrollPane(inputField);

        // TOP PANEL LAYOUT
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 0;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(topPanel, c);

        // SIDE PANEL LAYOUT
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0.2;
        c.weighty = 1;
        c.gridwidth = 1;
        c.gridheight = 2;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(sidePanel, c);

        // CHAT PANEL LAYOUT
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        this.add(chatPanel, c);

        // INPUT PANEL LAYOUT
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 2;
        c.weightx = 1;
        c.weighty = 0.2;
        c.gridwidth = 1;
        c.gridheight = 0;
        c.fill = GridBagConstraints.BOTH;
        this.add(inputPane, c);
    }
}
