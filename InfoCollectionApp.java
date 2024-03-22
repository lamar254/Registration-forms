import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class InfoCollectionApp extends JFrame implements ActionListener {
    private JTextField idField, nameField, addressField, contactsField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JButton registerButton, exitButton;
    private JTextArea displayArea;

    public InfoCollectionApp() {
        setTitle("Registration Form");
        setSize(800, 400); // increased width to accommodate the display area
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel idLabel = new JLabel("ID Number:");
        idField = new JTextField();
        inputPanel.add(idLabel);
        inputPanel.add(idField);

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);

        JLabel genderLabel = new JLabel("Gender:");
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        inputPanel.add(genderLabel);
        inputPanel.add(genderPanel);

        JLabel addressLabel = new JLabel("Address:");
        addressField = new JTextField();
        inputPanel.add(addressLabel);
        inputPanel.add(addressField);

        JLabel contactsLabel = new JLabel("Contacts:");
        contactsField = new JTextField();
        inputPanel.add(contactsLabel);
        inputPanel.add(contactsField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        buttonPanel.add(registerButton);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        buttonPanel.add(exitButton);

        displayArea = new JTextArea(10, 30); // Set fixed size
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Arial", Font.PLAIN, 14));
        displayArea.append("ID\tName\tGender\tAddress\tContacts\n"); // Add headings

        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); // Always show horizontal scrollbar

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel, BorderLayout.CENTER); // Add input panel to the center

        add(scrollPane, BorderLayout.EAST); // Add display area to the right
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            // Gather the information
            String id = idField.getText();
            String name = nameField.getText();
            String gender = maleRadioButton.isSelected() ? "Male" : "Female";
            String address = addressField.getText();
            String contacts = contactsField.getText();

            // Display the information
            String info = id + "\t" + name + "\t" + gender + "\t" + address + "\t" + contacts + "\n";
            displayArea.append(info);
        } else if (e.getSource() == exitButton) {
            // Exit the application
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        // Run the GUI application
        SwingUtilities.invokeLater(() -> {
            InfoCollectionApp app = new InfoCollectionApp();
            app.setVisible(true);
        });
    }
}
