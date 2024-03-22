import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RegistrationForm extends JFrame implements ActionListener {
    private JTextField nameField, mobileField, dobField, addressField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JCheckBox termsCheckBox;
    private JButton submitButton, resetButton;

    public RegistrationForm() {
        setTitle("Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,300);
        setLayout(new GridLayout(7, 4, 7, 5));

        JLabel nameLabel = new JLabel("Name:");
        add(nameLabel);
        nameField = new JTextField();
        add(nameField);

        JLabel mobileLabel = new JLabel("Mobile:");
        add(mobileLabel);
        mobileField = new JTextField();
        add(mobileField);

        JLabel genderLabel = new JLabel("Gender:");
        add(genderLabel);
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        add(maleRadioButton);
        add(femaleRadioButton);

        JLabel dobLabel = new JLabel("Date of Birth:");
        add(dobLabel);
        dobField = new JTextField();
        add(dobField);

        JLabel addressLabel = new JLabel("Address:");
        add(addressLabel);
        addressField = new JTextField();
        add(addressField);

        JLabel termsLabel = new JLabel("Agree to Terms:");
        add(termsLabel);
        termsCheckBox = new JCheckBox("I accept the terms and conditions");
        add(termsCheckBox);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        add(resetButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            if (termsCheckBox.isSelected()) {
                // Process registration submission
                String name = nameField.getText();
                String mobile = mobileField.getText();
                String gender = maleRadioButton.isSelected() ? "Male" : "Female";
                String dob = dobField.getText();
                String address = addressField.getText();

                // Display registration information
                JOptionPane.showMessageDialog(this, "Name: " + name + "\nMobile: " + mobile + "\nGender: " + gender + "\nDOB: " + dob + "\nAddress: " + address, "Registration Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Please accept the terms and conditions to proceed.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == resetButton) {
            // Reset form
            nameField.setText("");
            mobileField.setText("");
            dobField.setText("");
            addressField.setText("");
            maleRadioButton.setSelected(false);
            femaleRadioButton.setSelected(false);
            termsCheckBox.setSelected(false);
        }
    }
}
