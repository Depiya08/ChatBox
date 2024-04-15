
package com.chatBox;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleChatBox implements ActionListener {
    JTextArea chatArea;
    JTextField inputField;

    SimpleChatBox() {
        // Create the frame
        JFrame frame = new JFrame("Simple Chat Box");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Create the chat area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Create the input field
        inputField = new JTextField();
        inputField.addActionListener(this);
        frame.add(inputField, BorderLayout.SOUTH);

        // Display the frame
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String message = inputField.getText();
        if (!message.isEmpty()) {
            // Display the message in the chat area
            chatArea.append("You: " + message + "\n");
            // Clear the input field
            inputField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SimpleChatBox();
            }
        });
    }
}

