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
        JPanel TopPanel = new JPanel();
        TopPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        TopPanel.add(new JLabel("TOP"));

        // SIDE PANEL
        JPanel SidePanel = new JPanel();
        SidePanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        SidePanel.add(new JLabel("SIDE"));

        // CHAT PANEL
        JPanel ChatPanel = new JPanel();
        ChatPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        ChatPanel.add(new JLabel("CHAT"));

        // INPUT PANEL
        JPanel InputPanel = new JPanel();
        InputPanel.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 2));
        InputPanel.add(new JLabel("INPUT"));

        // TOP PANEL LAYOUT
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 0;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(TopPanel, c);

        // SIDE PANEL LAYOUT
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 3;
        c.weighty = 1;
        c.gridwidth = 1;
        c.gridheight = 2;
        c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(SidePanel, c);

        // CHAT PANEL LAYOUT
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        this.add(ChatPanel, c);

        // INPUT PANEL LAYOUT
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 2;
        c.weightx = 1;
        c.weighty = 0.5;
        c.gridwidth = 1;
        c.gridheight = 0;
        c.fill = GridBagConstraints.BOTH;
//        c.anchor = GridBagConstraints.LAST_LINE_END;
        this.add(InputPanel, c);
    }
}
