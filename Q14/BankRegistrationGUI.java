import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainFrame extends JFrame {
    Container c;
    JLabel labHeading, labFullName, labAccountNumber, labPhone, labGender, labAccountType, labPassword, labTandC, labSecurityQuestion, labSecurityAnswer;
    JTextField txtFullName, txtAccountNumber, txtPhone, txtSecurityAnswer;
    JPasswordField txtPassword;
    JCheckBox cbTandC;
    JRadioButton rbMale, rbFemale, rbOther;
    JComboBox<String> cmbAccountType, cmbSecurityQuestion;
    JButton btnSubmit, btnClear;
    ButtonGroup genderGroup;

    MainFrame() {
        c = getContentPane();
        c.setLayout(null);

        // Instantiate labels and text fields
        labHeading = new JLabel("Bank Registration Form", JLabel.CENTER);
        labFullName = new JLabel("Enter Full Name: ", JLabel.LEFT);
        txtFullName = new JTextField(20);

        labAccountNumber = new JLabel("Enter Account Number: ", JLabel.LEFT);
        txtAccountNumber = new JTextField(20);

        labPhone = new JLabel("Enter Phone Number: ", JLabel.LEFT);
        txtPhone = new JTextField(20);

        labGender = new JLabel("Select Gender: ", JLabel.LEFT);
        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");
        rbOther = new JRadioButton("Other");
        genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);
        genderGroup.add(rbOther);

        labAccountType = new JLabel("Select Account Type: ", JLabel.LEFT);
        String[] accountTypes = {"Select", "Savings", "Current", "Fixed Deposit"};
        cmbAccountType = new JComboBox<>(accountTypes);

        labPassword = new JLabel("Create Password: ", JLabel.LEFT);
        txtPassword = new JPasswordField(20);

        labTandC = new JLabel("Accept Terms and Conditions: ", JLabel.LEFT);
        cbTandC = new JCheckBox("I agree to the terms and conditions.");

        labSecurityQuestion = new JLabel("Select Security Question: ", JLabel.LEFT);
        String[] securityQuestions = {"Select", "What is your mother’s maiden name?", "What was the name of your first pet?", "What is your favorite color?"};
        cmbSecurityQuestion = new JComboBox<>(securityQuestions);

        labSecurityAnswer = new JLabel("Answer to Security Question: ", JLabel.LEFT);
        txtSecurityAnswer = new JTextField(20);

        btnSubmit = new JButton("Submit");
        btnClear = new JButton("Clear");

        // Formatting text
        Font f = new Font("Arial", Font.BOLD, 18);  // Reduced font size to 18
        labHeading.setFont(new Font("Arial", Font.BOLD, 28));
        labFullName.setFont(f);
        txtFullName.setFont(f);
        labAccountNumber.setFont(f);
        txtAccountNumber.setFont(f);
        labPhone.setFont(f);
        txtPhone.setFont(f);
        labGender.setFont(f);
        rbMale.setFont(f);
        rbFemale.setFont(f);
        rbOther.setFont(f);
        labAccountType.setFont(f);
        cmbAccountType.setFont(f);
        labPassword.setFont(f);
        txtPassword.setFont(f);
        labSecurityQuestion.setFont(f);
        cmbSecurityQuestion.setFont(f);
        labSecurityAnswer.setFont(f);
        txtSecurityAnswer.setFont(f);
        labTandC.setFont(f);
        cbTandC.setFont(f);
        btnSubmit.setFont(f);
        btnClear.setFont(f);

        // Setting layout and position in content pane (adjusted for reduced height)
        labHeading.setBounds(70, 10, 500, 40);

        labFullName.setBounds(70, 60, 500, 30);
        txtFullName.setBounds(70, 90, 500, 30);

        labAccountNumber.setBounds(70, 130, 500, 30);
        txtAccountNumber.setBounds(70, 160, 500, 30);

        labPhone.setBounds(70, 200, 500, 30);
        txtPhone.setBounds(70, 230, 500, 30);

        labGender.setBounds(70, 270, 200, 30);
        rbMale.setBounds(280, 270, 100, 30);
        rbFemale.setBounds(390, 270, 100, 30);
        rbOther.setBounds(500, 270, 100, 30);

        labAccountType.setBounds(70, 310, 500, 30);
        cmbAccountType.setBounds(70, 340, 500, 30);

        labPassword.setBounds(70, 380, 500, 30);
        txtPassword.setBounds(70, 410, 500, 30);

        labSecurityQuestion.setBounds(70, 450, 500, 30);
        cmbSecurityQuestion.setBounds(70, 480, 500, 30);

        labSecurityAnswer.setBounds(70, 520, 500, 30);
        txtSecurityAnswer.setBounds(70, 550, 500, 30);

        cbTandC.setBounds(70, 590, 500, 30);

        btnSubmit.setBounds(100, 640, 200, 40);   // Adjusted y-coordinate
        btnClear.setBounds(350, 640, 200, 40);    // Adjusted y-coordinate

        // Add action listeners
        ActionListener submitAction = (ae) -> {
            String fullName = txtFullName.getText();
            String accountNumber = txtAccountNumber.getText();
            String phone = txtPhone.getText();
            String gender = "";
            String accountType = (String) cmbAccountType.getSelectedItem();
            String password = new String(txtPassword.getPassword());
            String securityQuestion = (String) cmbSecurityQuestion.getSelectedItem();
            String securityAnswer = txtSecurityAnswer.getText();

            if (rbMale.isSelected()) gender = "Male";
            else if (rbFemale.isSelected()) gender = "Female";
            else if (rbOther.isSelected()) gender = "Other";

            if (cbTandC.isSelected()) {
                if (fullName.isEmpty() || accountNumber.isEmpty() || phone.isEmpty() || gender.isEmpty() || accountType.equals("Select") || password.isEmpty() || securityQuestion.equals("Select") || securityAnswer.isEmpty()) {
                    JOptionPane.showMessageDialog(c, "Please fill in all the required fields.");
                } else {
                    JOptionPane.showMessageDialog(c, "Registration Successful");
                    // Clear all fields after submission
                    txtFullName.setText("");
                    txtAccountNumber.setText("");
                    txtPhone.setText("");
                    genderGroup.clearSelection();
                    cmbAccountType.setSelectedIndex(0);
                    txtPassword.setText("");
                    cmbSecurityQuestion.setSelectedIndex(0);
                    txtSecurityAnswer.setText("");
                    cbTandC.setSelected(false);
                }
            } else {
                JOptionPane.showMessageDialog(c, "You must accept the terms and conditions to proceed.");
            }
        };

        btnSubmit.addActionListener(submitAction);

        ActionListener clearAction = (ae) -> {
            txtFullName.setText("");
            txtAccountNumber.setText("");
            txtPhone.setText("");
            genderGroup.clearSelection();
            cmbAccountType.setSelectedIndex(0);
            txtPassword.setText("");
            cmbSecurityQuestion.setSelectedIndex(0);
            txtSecurityAnswer.setText("");
            cbTandC.setSelected(false);
        };

        btnClear.addActionListener(clearAction);

        // Adding components to content pane
        c.add(labHeading);
        c.add(labFullName);
        c.add(txtFullName);
        c.add(labAccountNumber);
        c.add(txtAccountNumber);
        c.add(labPhone);
        c.add(txtPhone);
        c.add(labGender);
        c.add(rbMale);
        c.add(rbFemale);
        c.add(rbOther);
        c.add(labAccountType);
        c.add(cmbAccountType);
        c.add(labPassword);
        c.add(txtPassword);
        c.add(labSecurityQuestion);
        c.add(cmbSecurityQuestion);
        c.add(labSecurityAnswer);
        c.add(txtSecurityAnswer);
        c.add(labTandC);
        c.add(cbTandC);
        c.add(btnSubmit);
        c.add(btnClear);

        // Setting frame properties
        setTitle("Bank Registration Form");
        setSize(650, 750);  // Adjusted window size to fit everything properly
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class BankRegistrationGUI {
    public static void main(String args[]) {
        new MainFrame();
    }
}
