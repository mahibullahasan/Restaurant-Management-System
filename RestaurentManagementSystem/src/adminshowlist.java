import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adminshowlist extends JFrame {
	
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs = null;

	private JPanel contentPane;
	private JTable dataTable;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminshowlist frame = new adminshowlist();
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
	public adminshowlist() {
		conn = SQLConnection.ConnerDb();
		design();
		loadTable();
		
		
	}
	
	private void loadTable() {
		try {
			String query= "Select * from employee";
			pst=conn.prepareStatement(query);
			rs =pst.executeQuery();
			dataTable.setModel(DbUtils.resultSetToTableModel(rs));
			pst.close();
			rs.close();
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		
	}
	private void design() {
		setTitle("Admin Show List Employee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1068, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1032, 255);
		contentPane.add(scrollPane);
		
		dataTable = new JTable();
		scrollPane.setViewportView(dataTable);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choseadmin ch=new choseadmin();
				ch.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(56, 293, 89, 23);
		contentPane.add(btnBack);
	}

}
