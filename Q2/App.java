import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainFrame extends JFrame{
	Container c;
	JLabel labHeading, labName, labEmail,labPhone,labUsername, labPassword , labGender , labTandC;
	JTextField txtName, txtEmail,txtPhone,txtUsername;
	JPasswordField txtPassword;
	JCheckBox cbTandC;
	JRadioButton rbMale, rbFemale, rbOther;
	JButton btnSubmit , btnClear;

	MainFrame(){
		
		c = getContentPane();
		c.setLayout(null);
		
		//instantiating objects 
		labHeading = new JLabel("Library Registration Form", JLabel.CENTER);
		labName = new JLabel("Enter Name: " , JLabel.LEFT);
		txtName = new JTextField(20);
		labEmail = new JLabel("Enter Email: ", JLabel.LEFT);
		txtEmail = new JTextField(20); 
		labPhone = new JLabel("Enter Phone No.: ", JLabel.LEFT);
		txtPhone = new JTextField(20);
		labGender = new JLabel("Select your Gender: ",JLabel.LEFT);
		labUsername = new JLabel("Enter Username: ", JLabel.LEFT);
		txtUsername = new JTextField(20);
		labPassword =  new JLabel("Enter Password: ", JLabel.LEFT);
		txtPassword = new JPasswordField(20);
		cbTandC = new JCheckBox("Accept Terms And Conditions");
		rbMale = new JRadioButton("Male");
		rbFemale = new JRadioButton("Female");
		rbOther = new JRadioButton("Other");
		btnSubmit = new JButton("Submit");
		btnClear = new JButton("Clear");
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(rbMale);
		genderGroup.add(rbFemale);
		genderGroup.add(rbOther);
		
		
		// formating text
		Font f = new Font("Arial", Font.BOLD, 20);
		labHeading.setFont(new Font("Arial" , Font.BOLD, 35));
		labName.setFont(f);
		txtName.setFont(f);
		labEmail.setFont(f);
		txtEmail.setFont(f);
		labPhone.setFont(f);
		txtPhone.setFont(f);
		labGender.setFont(f);
		labUsername.setFont(f);
		txtUsername.setFont(f);
		labPassword.setFont(f);
		txtPassword.setFont(f);
		cbTandC.setFont(f);
		rbMale.setFont(f);
		rbFemale.setFont(f);
		rbOther.setFont(f);
		btnSubmit.setFont(f);
		btnClear.setFont(f);
				
		//setting location in content pane
		labHeading.setBounds(70, 10, 500, 50);
		labName.setBounds(70, 70, 500, 50);
		txtName.setBounds(70, 110,500, 50); 
		labEmail.setBounds(70, 160, 500, 50);
		txtEmail.setBounds(70, 200, 500, 50);
		labPhone.setBounds(70, 250, 500, 50);
		txtPhone.setBounds(70, 290, 500, 50);
		labGender.setBounds(70, 340, 200, 50);
		rbMale.setBounds(280,340,100,50);
		rbFemale.setBounds(390,340,100,50);
		rbOther.setBounds(500,340,100,50);
		labUsername.setBounds(70, 380, 500, 50);
		txtUsername.setBounds(70, 430, 500, 50);
		labPassword.setBounds(70, 470, 500, 50);
		txtPassword.setBounds(70, 520, 500, 50);
		cbTandC.setBounds(160,590,500,50);
		btnSubmit.setBounds(100,660,200,50);
		btnClear.setBounds(350,660,200,50);
		//adding actionListeners 
		ActionListener a = (ae) -> {
			String name = txtName.getText();
			String email = txtEmail.getText();
			String phone = txtPhone.getText();
			String username = txtUsername.getText();
			String password = new String(txtPassword.getPassword());
			String gender = "";
		        if (rbMale.isSelected()) {
		        	gender = "Male";
		        } else if (rbFemale.isSelected()) {
		            	gender = "Female";
		        } else if (rbOther.isSelected()) {
		            	gender = "Other";
		        }
			if (cbTandC.isSelected()) {
        		        if (name.isEmpty()||email.isEmpty()||phone.isEmpty()||username.isEmpty()||password.isEmpty()||gender.equals("")) {
            				JOptionPane.showMessageDialog(c, "Please fill in all the required fields.");
        			} else {
            		       		JOptionPane.showMessageDialog(c, "Registration Successful");
					txtName.setText("");
					txtEmail.setText("");
					txtPhone.setText("");	
					txtUsername.setText("");
					txtPassword.setText("");
				    	cbTandC.setSelected(false);
    					genderGroup.clearSelection();
        			}
    			} else {
        			JOptionPane.showMessageDialog(c, "You must accept the terms and conditions to proceed.");
    			}
		};
		btnSubmit.addActionListener(a);

		ActionListener b = (ae) -> {
		    	txtName.setText("");
		    	txtEmail.setText("");
    			txtPhone.setText("");
    			txtUsername.setText("");
    			txtPassword.setText(""); 
		    	cbTandC.setSelected(false);
    			genderGroup.clearSelection();
		};
		btnClear.addActionListener(b);


		//adding into content pane
		c.add(labHeading);
		c.add(labName); 
		c.add(txtName);
		c.add(labEmail);
		c.add(txtEmail); 
		c.add(labPhone);
		c.add(txtPhone);
		c.add(labGender);
		c.add(rbMale);
		c.add(rbFemale);
		c.add(rbOther);
		c.add(labUsername);
		c.add(txtUsername); 
		c.add(labPassword);
		c.add(txtPassword); 
		c.add(cbTandC);
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