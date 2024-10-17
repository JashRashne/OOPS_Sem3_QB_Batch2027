import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainFrame extends JFrame {
    Container c;
    JLabel labHeading, labName, labStudentID, labEmail, labPhone, labGender, labBranch, labPassword, labTandC;
    JTextField txtName, txtStudentID, txtEmail, txtPhone;
    JPasswordField txtPassword;
    JCheckBox cbTandC;
    JRadioButton rbMale, rbFemale, rbOther;
    JComboBox<String> cmbBranch;
    JButton btnSubmit, btnClear;
    ButtonGroup genderGroup;

    MainFrame() {

        c = getContentPane();
        c.setLayout(null);

        // Instantiate labels and text fields
        labHeading = new JLabel("College Registration Form", JLabel.CENTER);
        labName = new JLabel("Enter Student Name: ", JLabel.LEFT);
        txtName = new JTextField(20);

        labStudentID = new JLabel("Enter Student ID: ", JLabel.LEFT);
        txtStudentID = new JTextField(20);

        labEmail = new JLabel("Enter Email: ", JLabel.LEFT);
        txtEmail = new JTextField(20);

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

        labBranch = new JLabel("Select Course: ", JLabel.LEFT);
        String[] branch = {"Select", "COMPUTERS", "IT", "AIDS", "EXTC", "CHEMICAL"};
        cmbBranch = new JComboBox<>(branch);

        labPassword = new JLabel("Enter Password: ", JLabel.LEFT);
        txtPassword = new JPasswordField(20);

        labTandC = new JLabel("Accept Terms and Conditions: ", JLabel.LEFT);
        cbTandC = new JCheckBox("I agree to the terms and conditions.");

        btnSubmit = new JButton("Submit");
        btnClear = new JButton("Clear");

        // Formatting text
        Font f = new Font("Arial", Font.BOLD, 20);
        labHeading.setFont(new Font("Arial", Font.BOLD, 35));
        labName.setFont(f);
        txtName.setFont(f);
        labStudentID.setFont(f);
        txtStudentID.setFont(f);
        labEmail.setFont(f);
        txtEmail.setFont(f);
        labPhone.setFont(f);
        txtPhone.setFont(f);
        labGender.setFont(f);
        rbMale.setFont(f);
        rbFemale.setFont(f);
        rbOther.setFont(f);
        labBranch.setFont(f);
        cmbBranch.setFont(f);
        labPassword.setFont(f);
        txtPassword.setFont(f);
        labTandC.setFont(f);
        cbTandC.setFont(f);
        btnSubmit.setFont(f);
        btnClear.setFont(f);

        // Setting layout and position in content pane
        labHeading.setBounds(70, 10, 500, 50);
        labName.setBounds(70, 70, 500, 50);
        txtName.setBounds(70, 110, 500, 50);
        labStudentID.setBounds(70, 160, 500, 50);
        txtStudentID.setBounds(70, 200, 500, 50);
        labEmail.setBounds(70, 250, 500, 50);
        txtEmail.setBounds(70, 290, 500, 50);
        labPhone.setBounds(70, 340, 500, 50);
        txtPhone.setBounds(70, 380, 500, 50);
        labGender.setBounds(70, 430, 200, 50);
        rbMale.setBounds(280, 430, 100, 50);
        rbFemale.setBounds(390, 430, 100, 50);
        rbOther.setBounds(500, 430, 100, 50);
        labBranch.setBounds(70, 480, 500, 50);
        cmbBranch.setBounds(70, 520, 500, 50);
        labPassword.setBounds(70, 570, 500, 50);
        txtPassword.setBounds(70, 610, 500, 50);
        cbTandC.setBounds(70, 660, 500, 50);
        btnSubmit.setBounds(100, 720, 200, 50);
        btnClear.setBounds(350, 720, 200, 50);

        // Add action listeners
        ActionListener submitAction = (ae) -> {
            String name = txtName.getText();
            String studentID = txtStudentID.getText();
            String email = txtEmail.getText();
            String phone = txtPhone.getText();
            String gender = "";
            String br = (String) cmbBranch.getSelectedItem();
            String password = new String(txtPassword.getPassword());

            if (rbMale.isSelected()) gender = "Male";
            else if (rbFemale.isSelected()) gender = "Female";
            else if (rbOther.isSelected()) gender = "Other";

            if (cbTandC.isSelected()) {
                if (name.isEmpty() || studentID.isEmpty() || email.isEmpty() || phone.isEmpty() || gender.isEmpty() || br.equals("Select") || password.isEmpty()) {
                    JOptionPane.showMessageDialog(c, "Please fill in all the required fields.");
                } else {
                    JOptionPane.showMessageDialog(c, "Registration Successful");
                    // Clear all fields after submission
                    txtName.setText("");
                    txtStudentID.setText("");
                    txtEmail.setText("");
                    txtPhone.setText("");
                    genderGroup.clearSelection();
                    cmbBranch.setSelectedIndex(0);
                    txtPassword.setText("");
                    cbTandC.setSelected(false);
                }
            } else {
                JOptionPane.showMessageDialog(c, "You must accept the terms and conditions to proceed.");
            }
        };

        btnSubmit.addActionListener(submitAction);

        ActionListener clearAction = (ae) -> {
            txtName.setText("");
            txtStudentID.setText("");
            txtEmail.setText("");
            txtPhone.setText("");
            genderGroup.clearSelection();
            cmbBranch.setSelectedIndex(0);
            txtPassword.setText("");
            cbTandC.setSelected(false);
        };

        btnClear.addActionListener(clearAction);

        // Adding components to content pane
        c.add(labHeading);
        c.add(labName);
        c.add(txtName);
        c.add(labStudentID);
        c.add(txtStudentID);
        c.add(labEmail);
        c.add(txtEmail);
        c.add(labPhone);
        c.add(txtPhone);
        c.add(labGender);
        c.add(rbMale);
        c.add(rbFemale);
        c.add(rbOther);
        c.add(labBranch);
        c.add(cmbBranch);
        c.add(labPassword);
        c.add(txtPassword);
        c.add(labTandC);
        c.add(cbTandC);
        c.add(btnSubmit);
        c.add(btnClear);

        // Setting frame properties
        setTitle("College Registration Form");
        setSize(650, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class CollegeRegistrationGUI {
    public static void main(String args[]) {
        new MainFrame();
    }
}
