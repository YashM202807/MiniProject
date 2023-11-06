import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginPage extends JFrame {

	protected static final JLabel edtUsername = null;
	protected static final JLabel edtPassword = null;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	protected JLabel txtPassword;

	
 // Setting Background
	
	//Image image=new Image("\"C:\\Users\\yasha\\OneDrive\\Desktop\\Logo.jpeg\"");
	
	//BackgroungImage bgImage=new BackgroungImage(
		//	image,
		//	BackgrondRepeat.NO_REPEAT,
		//	BackgrondRepeat.NO_REPEAT,
		//	BackgrounPosition.Center,
		//	new BackgroundSize(100,100,true,true,true,true)
		//	);
	/**
	 * Launch the application.
	 */
	
	//Background 
	public static void main(String[] args) {
		
		LoginPage log = new LoginPage();
		log.show();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login to ResumeBuilders");
		lblNewLabel.setForeground(new Color(204, 51, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 45));
		lblNewLabel.setBounds(692, 37, 465, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(671, 156, 148, 40);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(866, 159, 470, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblNewLabel_1_1.setBounds(671, 240, 148, 40);
		contentPane.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(866, 246, 470, 34);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("Don't have an account???");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(797, 431, 305, 40);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Signup");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpPage s1 = new SignUpPage();
				s1.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.setBounds(866, 481, 164, 40);
		contentPane.add(btnNewButton);
		
		Panel panel = new Panel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 46, 622, 610);
		contentPane.add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\yasha\\OneDrive\\Desktop\\Logo2.png"));
		panel.add(lblNewLabel_3);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e, Object DriveManager) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/yash?useSSL=false","root","YashApte@2004");
					
					String Username = edtUsername.getText();
					String Password = edtPassword.getText();
					
					Statement stm = con.createStatement();
					
					String sql = "select * login where username ='"+Username+"'and Password ='"+Password+"'";
					ResultSet rs = stm.executeQuery(sql);
					
					if(rs.next()) {
						dispose();
						HomePage hpage = new HomePage();
						hpage.show();
					}
					else {
						JOptionPane.showInputDialog(this,"Username or Psswrod is wrong" );
						edtUsername.setText("");
						edtPassword.setText("");
					}
					con.close();					
					
					
					
				} catch (Exception e1) {
					System.out.print(e1.getMessage());
					
				}
			}

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HomePage h1 = new HomePage();
				h1.setVisible(true);
				
			}
			
		});
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnLogin.setBounds(671, 333, 272, 54);
		contentPane.add(btnLogin);
		
		 JButton btnReset = new JButton("Reset");
		// btnReset.addActionListener(new ActionListener() {
		 //	public void actionPerformed(ActionEvent e) {
		 	//	edtUsername.setText(null);
		 		//edtPassword.setText(null);
		 	//}
		 	
		 //});
		// btnReset.addActionListener(new ActionListener() {
		 	//public void actionPerformed(ActionEvent e) {
		 	//	edtUsername.setText("");
		 		//edtPassword.setText("");
		 	//}
		 //}); 
		 
	
			
		btnReset.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnReset.setBounds(1021, 333, 272, 54);
		contentPane.add(btnReset);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
