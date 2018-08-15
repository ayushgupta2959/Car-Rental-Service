package carRentalService.views;

import carRentalService.common.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class EmployeeView extends JFrame {

	private static final long serialVersionUID = -5245874686996310152L;
	private int username;
	private JPanel contentPane;
	private JComboBox comboBox;
	private JTextField textField;
	private JLabel lblHireDriver;
	private JTextField hireDriverID;
	private JTextField hireDriverLicenceNo;
	private JTextField hireDriverSalary;
	private JTextField hireDriverName;
	private JTextField hireDriverAddress;
	private JButton btnAddDriver;
	private JTextField hireDriverContactNo;
	private JTextField hireDriverDateOfJoin;
	private JPanel employeePanel;
	private JPanel hireDriverPanel;
	private JLabel lblHireCar;
	private JComboBox cbxCarName;
	private JComboBox cbxCategory;
	private JButton btnSubmitToSchedule;
	private JPanel carPanel;
	private JTextField updateDriverLicenceNo;
	private JTextField updateDriverAddress;
	private JTextField updateDriverContactNo;
	private JTextField updateDriverSalary;

	public EmployeeView(int uname) {
		username = uname;
		initComponents();
		createEvents();
		
	}
	
	private void createEvents() {
		
		btnSubmitToSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	private void initComponents() {
		
		setTitle("Easy Car Rental Service");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/carRentalService/resourses/vector-retro-car.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		carPanel = new JPanel();
		
		employeePanel = new JPanel();
		
		hireDriverPanel = new JPanel();
		
		JPanel updateDriverPanel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(employeePanel, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
						.addComponent(updateDriverPanel, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(hireDriverPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(carPanel, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(carPanel, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
						.addComponent(employeePanel, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(updateDriverPanel, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(hireDriverPanel, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
							.addGap(14))))
		);
		GroupLayout gl_employeePanel = new GroupLayout(employeePanel);
		gl_employeePanel.setHorizontalGroup(
			gl_employeePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 369, Short.MAX_VALUE)
		);
		gl_employeePanel.setVerticalGroup(
			gl_employeePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 154, Short.MAX_VALUE)
		);
		employeePanel.setLayout(gl_employeePanel);
		
		JLabel lblUpdateOrRemove = new JLabel("Update or Remove Driver");
		
		updateDriverLicenceNo = new JTextField();
		updateDriverLicenceNo.setColumns(10);
		
		JComboBox cbxUpdateDriverID = new JComboBox();
		
		JComboBox cbxUpdateDriverName = new JComboBox();
		
		updateDriverAddress = new JTextField();
		updateDriverAddress.setColumns(10);
		
		updateDriverContactNo = new JTextField();
		updateDriverContactNo.setColumns(10);
		
		JButton btnUpdateDriver = new JButton("Update");
		
		JButton btnRemoveDriver = new JButton("Remove");
		
		updateDriverSalary = new JTextField();
		updateDriverSalary.setColumns(10);
		GroupLayout gl_updateDriverPanel = new GroupLayout(updateDriverPanel);
		gl_updateDriverPanel.setHorizontalGroup(
			gl_updateDriverPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_updateDriverPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_updateDriverPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_updateDriverPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(Alignment.TRAILING, gl_updateDriverPanel.createSequentialGroup()
								.addComponent(lblUpdateOrRemove)
								.addGap(90))
							.addGroup(gl_updateDriverPanel.createSequentialGroup()
								.addGroup(gl_updateDriverPanel.createParallelGroup(Alignment.TRAILING)
									.addComponent(updateDriverAddress, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
									.addComponent(cbxUpdateDriverID, 0, 100, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_updateDriverPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_updateDriverPanel.createSequentialGroup()
										.addComponent(updateDriverContactNo, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(updateDriverSalary, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_updateDriverPanel.createSequentialGroup()
										.addComponent(cbxUpdateDriverName, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(updateDriverLicenceNo, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
								.addGap(18)))
						.addGroup(Alignment.TRAILING, gl_updateDriverPanel.createSequentialGroup()
							.addComponent(btnRemoveDriver)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnUpdateDriver)
							.addGap(18))))
		);
		gl_updateDriverPanel.setVerticalGroup(
			gl_updateDriverPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_updateDriverPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblUpdateOrRemove)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_updateDriverPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbxUpdateDriverID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbxUpdateDriverName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(updateDriverLicenceNo, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_updateDriverPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(updateDriverAddress, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(updateDriverContactNo, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(updateDriverSalary, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addGroup(gl_updateDriverPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRemoveDriver)
						.addComponent(btnUpdateDriver))
					.addGap(21))
		);
		updateDriverPanel.setLayout(gl_updateDriverPanel);
		
		lblHireDriver = new JLabel("Hire Driver");
		
		hireDriverID = new JTextField();
		hireDriverID.setColumns(10);
		TextPrompt placeholderHireDriverID = new TextPrompt("ID",hireDriverID);
		placeholderHireDriverID.setHorizontalAlignment(SwingConstants.CENTER);
		placeholderHireDriverID.setForeground(Color.MAGENTA);
		placeholderHireDriverID.changeAlpha(0.5f);
		placeholderHireDriverID.changeStyle(Font.ITALIC);
		
		
		hireDriverLicenceNo = new JTextField();
		hireDriverLicenceNo.setColumns(10);
		TextPrompt placeholderHireDriverLicenceNo = new TextPrompt("Licence No",hireDriverLicenceNo);
		placeholderHireDriverLicenceNo.setHorizontalAlignment(SwingConstants.CENTER);
		placeholderHireDriverLicenceNo.setForeground(Color.MAGENTA);
		placeholderHireDriverLicenceNo.changeAlpha(0.5f);
		placeholderHireDriverLicenceNo.changeStyle(Font.ITALIC);
		
		
		hireDriverName = new JTextField();
		hireDriverName.setColumns(10);
		TextPrompt placeholderDriverName = new TextPrompt("Name",hireDriverName);
		placeholderDriverName.setHorizontalAlignment(SwingConstants.CENTER);
		placeholderDriverName.setForeground(Color.MAGENTA);
		placeholderDriverName.changeAlpha(0.5f);
		placeholderDriverName.changeStyle(Font.ITALIC);
		
		hireDriverAddress = new JTextField();
		hireDriverAddress.setColumns(10);
		TextPrompt placeholderHireDriverAddress = new TextPrompt("Address",hireDriverAddress);
		placeholderHireDriverAddress.setHorizontalAlignment(SwingConstants.CENTER);
		placeholderHireDriverAddress.setForeground(Color.MAGENTA);
		placeholderHireDriverAddress.changeAlpha(0.5f);
		placeholderHireDriverAddress.changeStyle(Font.ITALIC);
		
		hireDriverContactNo = new JTextField();
		hireDriverContactNo.setColumns(10);
		TextPrompt placeholderHireDriverContactNo = new TextPrompt("Contact No",hireDriverContactNo);
		placeholderHireDriverContactNo.setHorizontalAlignment(SwingConstants.CENTER);
		placeholderHireDriverContactNo.setForeground(Color.MAGENTA);
		placeholderHireDriverContactNo.changeAlpha(0.5f);
		placeholderHireDriverContactNo.changeStyle(Font.ITALIC);
		
		hireDriverDateOfJoin = new JTextField();
		hireDriverDateOfJoin.setColumns(10);
		TextPrompt placeholderHireDriverDateOfJoin = new TextPrompt("Date of Join(yyyy-mm-dd)",hireDriverDateOfJoin);
		placeholderHireDriverDateOfJoin.setHorizontalAlignment(SwingConstants.CENTER);
		placeholderHireDriverDateOfJoin.setForeground(Color.MAGENTA);
		placeholderHireDriverDateOfJoin.changeAlpha(0.5f);
		placeholderHireDriverDateOfJoin.changeStyle(Font.ITALIC);
		
		hireDriverSalary = new JTextField();
		hireDriverSalary.setColumns(10);
		TextPrompt placeholderHireDriverSalary = new TextPrompt("Salary",hireDriverSalary);
		placeholderHireDriverSalary.setHorizontalAlignment(SwingConstants.CENTER);
		placeholderHireDriverSalary.setForeground(Color.MAGENTA);
		placeholderHireDriverSalary.changeAlpha(0.5f);
		placeholderHireDriverSalary.changeStyle(Font.ITALIC);
		
		btnAddDriver = new JButton("Add");
		btnAddDriver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database db = Database.getInstance();
				if( hireDriverID.getText().isEmpty() || hireDriverLicenceNo.getText().isEmpty() || hireDriverName.getText().isEmpty() ||
						hireDriverAddress.getText().isEmpty() || hireDriverContactNo.getText().isEmpty() || 
						hireDriverDateOfJoin.getText().isEmpty() ||hireDriverSalary.getText().isEmpty() ) {
					JOptionPane.showMessageDialog( null, "Some Fields are Empty ","Error",JOptionPane.ERROR_MESSAGE);
				}
				else {

					try {
						db.insertDriver(Integer.parseInt(hireDriverID.getText()), hireDriverLicenceNo.getText(), hireDriverName.getText(), hireDriverAddress.getText(), hireDriverContactNo.getText(), hireDriverDateOfJoin.getText(), "YES", Double.parseDouble(hireDriverSalary.getText()));
						JOptionPane.showMessageDialog( null, "Details have been successfully updated in te Database","Success",JOptionPane.INFORMATION_MESSAGE);
						hireDriverID.setText(null);
						hireDriverLicenceNo.setText(null);
						hireDriverName.setText(null);
						hireDriverAddress.setText(null);
						hireDriverContactNo.setText(null);
						hireDriverDateOfJoin.setText(null);
						hireDriverSalary.setText(null);
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog( null, "Invalid entry ID or Salary Field","Error",JOptionPane.ERROR_MESSAGE);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		GroupLayout gl_hireDriverPanel = new GroupLayout(hireDriverPanel);
		gl_hireDriverPanel.setHorizontalGroup(
			gl_hireDriverPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_hireDriverPanel.createSequentialGroup()
					.addContainerGap(24, Short.MAX_VALUE)
					.addGroup(gl_hireDriverPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_hireDriverPanel.createSequentialGroup()
							.addComponent(lblHireDriver)
							.addGap(147))
						.addGroup(gl_hireDriverPanel.createSequentialGroup()
							.addGroup(gl_hireDriverPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_hireDriverPanel.createSequentialGroup()
									.addComponent(hireDriverID, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(hireDriverLicenceNo, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(hireDriverName, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_hireDriverPanel.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnAddDriver, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_hireDriverPanel.createSequentialGroup()
										.addComponent(hireDriverAddress, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(hireDriverContactNo, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(hireDriverSalary, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))
									.addGroup(gl_hireDriverPanel.createSequentialGroup()
										.addComponent(hireDriverDateOfJoin, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
										.addGap(155))))
							.addGap(36))))
		);
		gl_hireDriverPanel.setVerticalGroup(
			gl_hireDriverPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_hireDriverPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblHireDriver)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_hireDriverPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(hireDriverName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(hireDriverLicenceNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(hireDriverID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_hireDriverPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(hireDriverAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(hireDriverContactNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(hireDriverSalary, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(hireDriverDateOfJoin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnAddDriver)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		hireDriverPanel.setLayout(gl_hireDriverPanel);
		
		lblHireCar = new JLabel("Hire Car");
		
		cbxCategory = new JComboBox();
		
		cbxCarName = new JComboBox();
		
		comboBox = new JComboBox();
		
		btnSubmitToSchedule = new JButton("Submit");
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_carPanel = new GroupLayout(carPanel);
		gl_carPanel.setHorizontalGroup(
			gl_carPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_carPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_carPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSubmitToSchedule)
						.addGroup(gl_carPanel.createSequentialGroup()
							.addComponent(cbxCategory, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbxCarName, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_carPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblHireCar)
								.addGroup(gl_carPanel.createSequentialGroup()
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		gl_carPanel.setVerticalGroup(
			gl_carPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_carPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblHireCar)
					.addGap(27)
					.addGroup(gl_carPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbxCategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbxCarName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addComponent(btnSubmitToSchedule)
					.addContainerGap(203, Short.MAX_VALUE))
		);
		carPanel.setLayout(gl_carPanel);
		contentPane.setLayout(gl_contentPane);
	}
}
