import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainFrame extends JFrame{
    Container c;
    JLabel labHeading, labName, labID, labBookname, labBookID, labIssueDate, labDueDate;
    JTextField txtName, txtID, txtBookname, txtBookID, txtIssueDate, txtDueDate;
    JButton btnSubmit, btnClear;

    MainFrame(){
        c = getContentPane();
        c.setLayout(null);

        //instantiating objects 
        labHeading = new JLabel("Library Registration Form", JLabel.CENTER);
        labName = new JLabel("Enter Student Name: ", JLabel.LEFT);
        txtName = new JTextField(20);
        labID = new JLabel("Enter Student ID: ", JLabel.LEFT);
        txtID = new JTextField(20);
        labBookname = new JLabel("Enter Book Name: ", JLabel.LEFT);
        txtBookname = new JTextField(20);
        labBookID = new JLabel("Enter Book ID: ", JLabel.LEFT);
        txtBookID = new JTextField(20);
        labIssueDate = new JLabel("Issue Date: ", JLabel.LEFT);
        txtIssueDate = new JTextField(20);
        labDueDate = new JLabel("Due Date: ", JLabel.LEFT);
        txtDueDate = new JTextField(20);
        btnSubmit = new JButton("Submit");
        btnClear = new JButton("Clear");

        // Font formatting
        Font font = new Font("Arial", Font.BOLD, 20);
        labHeading.setFont(new Font("Arial", Font.BOLD, 35));
        labName.setFont(font);
        txtName.setFont(font);
        labID.setFont(font);
        txtID.setFont(font);
        labBookname.setFont(font);
        txtBookname.setFont(font);
        labBookID.setFont(font);
        txtBookID.setFont(font);
        labIssueDate.setFont(font);
        txtIssueDate.setFont(font);
        labDueDate.setFont(font);
        txtDueDate.setFont(font);
        btnSubmit.setFont(font);
        btnClear.setFont(font);

        //setting location in content pane
        labHeading.setBounds(70, 10, 500, 50);
        labName.setBounds(70, 70, 500, 50);
        txtName.setBounds(70, 110, 500, 50);
        labID.setBounds(70, 160, 500, 50);
        txtID.setBounds(70, 200, 500, 50);
        labBookname.setBounds(70, 250, 500, 50);
        txtBookname.setBounds(70, 290, 500, 50);
        labBookID.setBounds(70, 340, 500, 50);
        txtBookID.setBounds(70, 380, 500, 50);
        labIssueDate.setBounds(70, 430, 500, 50);
        txtIssueDate.setBounds(70, 470, 500, 50);
        labDueDate.setBounds(70, 510, 500, 50);
        txtDueDate.setBounds(70, 550, 500, 50);
        btnSubmit.setBounds(100, 610, 200, 50);
        btnClear.setBounds(350, 610, 200, 50);

        //adding actionListeners 
        ActionListener submitAction = (ae) -> {
            String name = txtName.getText();
            String studentID = txtID.getText();
            String bookName = txtBookname.getText();
            String bookID = txtBookID.getText();
            String issueDate = txtIssueDate.getText();
            String dueDate = txtDueDate.getText();

            if (name.isEmpty() || studentID.isEmpty() || bookName.isEmpty() || bookID.isEmpty() || issueDate.isEmpty() || dueDate.isEmpty()) {
                JOptionPane.showMessageDialog(c, "Please fill in all the required fields.");
            } else {
                JOptionPane.showMessageDialog(c, "Form Submitted Successfully!");
                // Optionally clear the fields after submission
                txtName.setText("");
                txtID.setText("");
                txtBookname.setText("");
                txtBookID.setText("");
                txtIssueDate.setText("");
                txtDueDate.setText("");
            }
        };
        btnSubmit.addActionListener(submitAction);

        ActionListener clearAction = (ae) -> {
            txtName.setText("");
            txtID.setText("");
            txtBookname.setText("");
            txtBookID.setText("");
            txtIssueDate.setText("");
            txtDueDate.setText("");
        };
        btnClear.addActionListener(clearAction);

        //adding into content pane
        c.add(labHeading);
        c.add(labName);
        c.add(txtName);
        c.add(labID);
        c.add(txtID);
        c.add(labBookname);
        c.add(txtBookname);
        c.add(labBookID);
        c.add(txtBookID);
        c.add(labIssueDate);
        c.add(txtIssueDate);
        c.add(labDueDate);
        c.add(txtDueDate);
        c.add(btnSubmit);
        c.add(btnClear);

        setTitle("Library Registration Form");
        setSize(650,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class App{
    public static void main(String args[]){
        new MainFrame();
    }
}
