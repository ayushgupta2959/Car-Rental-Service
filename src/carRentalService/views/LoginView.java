package carRentalService.views;

import carRentalService.common.*;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup rdoBtnLoginGrp = new ButtonGroup();
	private JRadioButton rdoBtnEmployee;
	private JRadioButton rdoBtnAdmin;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JPasswordField pwdFldPassword;
	private JTextField txtFldUsername;

	public LoginView() {
		initComponents();
		createEvents();
	}
	
	private void createEvents() {
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtFldUsername.getText().isEmpty()||pwdFldPassword.getPassword().length == 0) {
					JOptionPane.showMessageDialog( null, "Username or Password field cannot be empty","Error",JOptionPane.ERROR_MESSAGE);
				}
				else {
					boolean validateResult = false;
					try {
						validateResult = validate(Integer.parseInt(txtFldUsername.getText()),new String(pwdFldPassword.getPassword()),rdoBtnLoginGrp.getSelection().getActionCommand());
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog( null, "Invalid Username","Error",JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(validateResult) {
						if(rdoBtnLoginGrp.getSelection().getActionCommand() == "Emplo") {
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										EmployeeView frame = new EmployeeView(Integer.parseInt(txtFldUsername.getText()));
										frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
						}
						else {
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										AdminView frame = new AdminView();
										frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
						}
						dispose(); //to close the login view
					}	
					else {
						JOptionPane.showMessageDialog( null, "Wrong Username or Password");
					}
				}
			}
		});
	}
	
	private void initComponents() {
		
		setTitle("Easy Car Rental Service");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/carRentalService/resourses/vector-retro-car.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnLogin = new JButton("Login");
		
		lblUsername = new JLabel("Username :");
		
		lblPassword = new JLabel("Password :");
		
		txtFldUsername = new JTextField();
		txtFldUsername.setColumns(10);
		
		pwdFldPassword = new JPasswordField();
		
		rdoBtnEmployee = new JRadioButton("Employee");
		rdoBtnEmployee.setActionCommand("Emplo");
		rdoBtnEmployee.setSelected(true);
		rdoBtnLoginGrp.add(rdoBtnEmployee);
		
		rdoBtnAdmin = new JRadioButton("Admin");
		rdoBtnAdmin.setActionCommand("Admin");
		rdoBtnLoginGrp.add(rdoBtnAdmin);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(24, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdoBtnAdmin)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdoBtnEmployee))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblPassword)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(pwdFldPassword, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblUsername)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtFldUsername))
							.addComponent(btnLogin, Alignment.TRAILING)))
					.addGap(25))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(73, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(txtFldUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(pwdFldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdoBtnAdmin)
						.addComponent(rdoBtnEmployee))
					.addGap(10)
					.addComponent(btnLogin)
					.addGap(76))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private boolean validate(int username,String password,String tag) {
		
		Database db = Database.getInstance();
		String getPassword = null;
		String getTag = null;
		try {
			getPassword = new String(db.getPassword(username));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			getTag= db.getTag(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(password.equals(getPassword)&&tag.equals(getTag)) {
			return true;
		}
		else {
		return false;
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
