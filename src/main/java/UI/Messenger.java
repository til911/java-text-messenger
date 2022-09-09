package UI;

import Logic.SaveManager;
import Logic.UIManager;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Vector;

public class Messenger extends JPanel {
    @Override
    public Dimension getSize() {
        return new Dimension(800, 500);
    }

    @Override
    public Dimension getPreferredSize() {
        return getSize();
    }

    @Override
    public void repaint() {
        super.repaint();
        // RESIZE EACH TEXZ MESSAGE WIDTH
    }

    private JPanel chatPanel = new JPanel();

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
        chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));

        // INPUT PANEL
        JPanel inputPanel = new JPanel(new BorderLayout());
        JTextArea inputField = new JTextArea();
        inputField.setRows(4);
        inputField.requestFocusInWindow();
        JScrollPane inputPane = new JScrollPane(inputField);

        JButton sendButton = new JButton("send");
        sendButton.addActionListener(e -> {
            String msg = inputField.getText();
            if (msg.equals("")){
                return;
            }
            AppendMessage(msg);
            inputField.setText("");
            inputField.requestFocusInWindow();
        });

        inputPanel.add(inputPane, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

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
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LAST_LINE_START;
        this.add(chatPanel, c);

        // INPUT PANEL LAYOUT
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 2;
        c.weightx = 1;
        c.weighty = 0;
        c.gridwidth = 1;
        c.gridheight = 0;
        c.fill = GridBagConstraints.BOTH;
        this.add(inputPanel, c);
    }

    private void AppendMessage(String msg) {
        JPanel panel = new JPanel(new BorderLayout());

        Color msgColor = new Color((int)(255*0.8),0,0);

        Font nameFont = new Font("Helvetica", Font.BOLD, 12);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(msgColor, 1), SaveManager.GetUserName(), TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, nameFont);
        titledBorder.setTitleColor(msgColor);
        panel.setBorder(titledBorder);


        JLabel message = new JLabel(msg);
        panel.add(message, BorderLayout.WEST);

        chatPanel.add(panel);
        revalidate();
    }
}
