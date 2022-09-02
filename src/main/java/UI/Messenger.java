package UI;

import Logic.UIManager;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Messenger extends JPanel {
    public Messenger(UIManager uiManager) {
        this.setLayout(new GridBagLayout());
        //this.setSize(new Dimension(1200,800));
        GridBagConstraints c;

        // TOP PANEL
        JPanel TopPanel = new JPanel();
        TopPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        TopPanel.add(new JLabel("TOP"));

        // SIDE PANEL
        JPanel SidePanel = new JPanel();
        SidePanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
        SidePanel.add(new JLabel("SIDE"));

        // CHAT PANEL
        JPanel ChatPanel = new JPanel();
        ChatPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        ChatPanel.add(new JLabel("CHAT"));

        // INPUT PANEL
        JPanel InputPanel = new JPanel();
        InputPanel.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 1));
        InputPanel.add(new JLabel("INPUT"));

        // TOP PANEL LAYOUT
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(TopPanel, c);

        // SIDE PANEL LAYOUT
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 0;
        c.gridheight = 2;
//        c.fill = GridBagConstraints.BOTH;
        this.add(SidePanel, c);

        // CHAT PANEL LAYOUT
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 0;
        c.gridheight = 2;
//        c.fill = GridBagConstraints.BOTH;
        this.add(ChatPanel, c);

        // CHAT PANEL LAYOUT
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 2;
        c.gridheight = 0;
//        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(InputPanel, c);


        //        this.setLayout(new GridLayout(2,1));
//
//        // Create Left Side Bar & Add Components
//        //
//        JPanel ContactsView = new JPanel(new GridLayout(1,2));
//        this.add(ContactsView);
//
//        // Create & Add RecentChatsBar
//        JPanel RecentChatsBar = new JPanel(new SpringLayout());
//        RecentChatsBar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
//
//        RecentChatsBar.add(new JLabel("Recent Chats"));
//
//
//
//        ContactsView.add(RecentChatsBar);
//
//        // Create & Add ContactsList & Entries
//        String[] RecentChatsEntries = {"ENTRY 1", "ENTRY2"};
//        JList RecentChatsList = new JList(RecentChatsEntries);
//        ContactsView.add(RecentChatsList);
//
//
//
//
//
//
//
//
//        // Create Chat View & Add Components
//        //
//        JPanel ChatView = new JPanel(new GridLayout(1,2));
//
//        // Create & Add top left bar
//        JPanel ChatBar = new JPanel(new SpringLayout());
//        ChatBar.add(new JTextField("ChatBar Test"));
//        ChatView.add(ChatBar);
//
//        // Create & Add ChatList & Entries
//        String[] ChatListEntries = {"ENTRY 1", "ENTRY2"};
//        JList ChatList = new JList(ChatListEntries);
//        ChatView.add(ChatList);
//
//        // Add Chat View
//        //
//        this.add(ChatView);

    }
}
