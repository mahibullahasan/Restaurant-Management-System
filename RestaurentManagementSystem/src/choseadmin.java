import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class choseadmin extends JFrame {
	
	
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs = null;

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					choseadmin frame = new choseadmin();
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
	public choseadmin() {
		conn = SQLConnection.ConnerDb();
		
		design();
		
		
		
	}
	
	
	
	private void design() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnShowEmployeePage = new JButton("Show Sells Page");
		btnShowEmployeePage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnShowEmployeePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RestaurentManagementSystem ch=new RestaurentManagementSystem();
				ch.setVisible(true);
				dispose();
				
			}
		});
		btnShowEmployeePage.setBounds(183, 86, 191, 23);
		contentPane.add(btnShowEmployeePage);
		
		JButton btnShowSellsDetails = new JButton("Show Employee Details");
		btnShowSellsDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnShowSellsDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//adminshowlist();
				adminshowlist ch=new adminshowlist();
				ch.setVisible(true);
				dispose();
			}
		});
		btnShowSellsDetails.setBounds(183, 38, 191, 23);
		contentPane.add(btnShowSellsDetails);
		
		JButton btnShowEmployeesSell = new JButton("Show Employee's Sell");
		btnShowEmployeesSell.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnShowEmployeesSell.setBounds(183, 133, 191, 23);
		contentPane.add(btnShowEmployeesSell);
	}

}
