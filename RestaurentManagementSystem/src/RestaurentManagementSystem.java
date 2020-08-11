import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;

public class RestaurentManagementSystem extends JFrame {
	Connection conn=null;
	private JPanel contentPane;
	private JTextField cbTF;
	private JTextField cbbbqTF;
	private JTextField bfTF;
	private JTextField coDrinksTF;
	private JTextField coMealTF;
	private JTextField coDeliveryTF;
	private JTextField inputCTF;
	private JTextField outputCTF;
	private JTextField subTTF;
	private JTextField taxTF;
	private JTextField totalTF;
	private JComboBox drinkCB,currencyCB;
	private JCheckBox chckbxTax,chckbxChickenBurger,chckbxChickenBurgerBbq,chckbxBeefBurger,chckbxHomeDelivary;
	private JLabel lblDrinks,lblCostOfDrinls;
	private JLabel lblRestaurentmanagementsystem;
	private JTextArea RtextArea;
	
	double[] result = new double[5];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurentManagementSystem frame = new RestaurentManagementSystem();
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
	private void CurrencyConverter() {
		
		
		float taka = Float.parseFloat(inputCTF.getText());
		if(currencyCB.getSelectedItem().equals("US")) {
			outputCTF.setText("BDT "+taka*80);
		}
		if(currencyCB.getSelectedItem().equals("Canada")) {
			outputCTF.setText("BDT "+taka*56);
		}
		if(currencyCB.getSelectedItem().equals("India")) {
			outputCTF.setText("BDT "+taka*1.23);
		}
		if(currencyCB.getSelectedItem().equals("Pakistan")) {
			outputCTF.setText("BDT "+taka*1.55);
		}
		
		
	}
	
	private void calculatorDrink() {
		if(drinkCB.getSelectedItem().equals("Mountain Dew")) {
			coDrinksTF.setText(""+30);
		}
		if(drinkCB.getSelectedItem().equals("Coca Cola")) {
			coDrinksTF.setText(""+25);
		}
		if(drinkCB.getSelectedItem().equals("Pepsi")) {
			coDrinksTF.setText(""+27);
		}
		if(drinkCB.getSelectedItem().equals("RC")) {
			coDrinksTF.setText(""+22);
		}
		if(drinkCB.getSelectedItem().equals("Cold Coffee")) {
			coDrinksTF.setText(""+15);
		}
		if(drinkCB.getSelectedItem().equals("Black Coffee")) {
			coDrinksTF.setText(""+18);
		}
		if(drinkCB.getSelectedItem().equals("Pran Up")) {
			coDrinksTF.setText(""+24);
		}
		
	}
	private void calcTotal() {
		double a = Double.parseDouble(coMealTF.getText());
		double b = Double.parseDouble(coDeliveryTF.getText());
		double c = Double.parseDouble(coDrinksTF.getText());
		double d = Double.parseDouble(taxTF.getText());
		
		double subT = a+b+c;
		subTTF.setText(""+subT);
		
		double totalF = a+b+c+d;
		totalTF.setText(""+totalF);
		
		
		
	}
	private void receipt() {
		RtextArea.append("\tMuHib Restaurent\n\n Sub Total :\t " + subTTF.getText() + "\n Tax:\t "+ taxTF.getText()
		+"\nTotal Amount:\t "+totalTF.getText() + "");
		
	}
	
	private void print() {
		try {
			boolean complete = RtextArea.print();
			if(complete) {
				JOptionPane.showMessageDialog(null, "Printing Done...", null, JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Error Occure...", null, JOptionPane.INFORMATION_MESSAGE);
			}
			
		}catch(PrinterException e) {
			JOptionPane.showMessageDialog(null, e);
			
		}
		
		
	}
	
	public RestaurentManagementSystem() {
		conn= SQLConnection.ConnerDb();
		setTitle("Restaurent Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblRestaurentmanagementsystem = new JLabel("Restaurent Management System");
		lblRestaurentmanagementsystem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRestaurentmanagementsystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestaurentmanagementsystem.setBounds(10, 11, 654, 28);
		contentPane.add(lblRestaurentmanagementsystem);
		
		chckbxChickenBurger = new JCheckBox("Chicken Burger");
		chckbxChickenBurger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				double q = Double.parseDouble(cbTF.getText());
				double sum= Double.parseDouble(coMealTF.getText());
				
				if(chckbxChickenBurger.isSelected()) {
					result[0]= (120 * q) + sum;
					String meal = String.format("%.2f", result[0]);
					coMealTF.setText(meal);
				}
				
			}
		});
		chckbxChickenBurger.setBounds(10, 58, 138, 23);
		contentPane.add(chckbxChickenBurger);
		
		chckbxChickenBurgerBbq = new JCheckBox("Chicken Burger BBQ");
		chckbxChickenBurgerBbq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				double q = Double.parseDouble(cbbbqTF.getText());
				double sum= Double.parseDouble(coMealTF.getText());
				
				if(chckbxChickenBurgerBbq.isSelected()) {
					result[1]= (130*q) + sum;
					String meal = String.format("%.2f", result[1]);
					coMealTF.setText(meal);
				}
			}
		});
		chckbxChickenBurgerBbq.setBounds(10, 84, 147, 23);
		contentPane.add(chckbxChickenBurgerBbq);
		
		chckbxBeefBurger = new JCheckBox("Beef Burger");
		chckbxBeefBurger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				double q = Double.parseDouble(bfTF.getText());
				double sum= Double.parseDouble(coMealTF.getText());
				
				if(chckbxBeefBurger.isSelected()) {
					result[2]= (150*q) + sum;
					String meal = String.format("%.2f", result[2]);
					coMealTF.setText(meal);
				}
				
			}
		});
		chckbxBeefBurger.setBounds(10, 110, 138, 23);
		contentPane.add(chckbxBeefBurger);
		
		cbTF = new JTextField();
		cbTF.setText("0");
		cbTF.setBounds(163, 59, 86, 20);
		contentPane.add(cbTF);
		cbTF.setColumns(10);
		
		cbbbqTF = new JTextField();
		cbbbqTF.setText("0");
		cbbbqTF.setColumns(10);
		cbbbqTF.setBounds(163, 85, 86, 20);
		contentPane.add(cbbbqTF);
		
		bfTF = new JTextField();
		bfTF.setText("0");
		bfTF.setColumns(10);
		bfTF.setBounds(163, 111, 86, 20);
		contentPane.add(bfTF);
		
		drinkCB = new JComboBox();
		drinkCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calculatorDrink();
			}
		});
		drinkCB.setModel(new DefaultComboBoxModel(new String[] {"--", "Mountain Dew", "Coca Cola", "Pepsi", "RC", "Pran Up", "Mojo", "Cold Coffee", "Black Coffee"}));
		drinkCB.setBounds(139, 142, 110, 20);
		contentPane.add(drinkCB);
		
		lblDrinks = new JLabel("Drinks");
		lblDrinks.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDrinks.setHorizontalAlignment(SwingConstants.CENTER);
		lblDrinks.setBounds(20, 140, 73, 22);
		contentPane.add(lblDrinks);
		
		chckbxTax = new JCheckBox("Tax");
		chckbxTax.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				double tax;
				double a = Double.parseDouble(coMealTF.getText());
				double b = Double.parseDouble(coDeliveryTF.getText());
				double c = Double.parseDouble(coDrinksTF.getText());
				tax= (a+b+c)/100;
				taxTF.setText(String.format("%.2f", tax));
			}
		});
		chckbxTax.setBounds(10, 180, 60, 23);
		contentPane.add(chckbxTax);
		
		chckbxHomeDelivary = new JCheckBox("Home Delivary");
		chckbxHomeDelivary.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				coDeliveryTF.setText(""+50);
			}
		});
		chckbxHomeDelivary.setBounds(139, 180, 110, 23);
		contentPane.add(chckbxHomeDelivary);
		
		lblCostOfDrinls = new JLabel("Cost of Drinks");
		lblCostOfDrinls.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCostOfDrinls.setBounds(10, 244, 86, 17);
		contentPane.add(lblCostOfDrinls);
		
		JLabel lblCostOfMeal = new JLabel("Cost of Meal");
		lblCostOfMeal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCostOfMeal.setBounds(10, 272, 86, 23);
		contentPane.add(lblCostOfMeal);
		
		JLabel lblCostOfDelivery = new JLabel("Cost of Delivery");
		lblCostOfDelivery.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCostOfDelivery.setBounds(10, 306, 97, 23);
		contentPane.add(lblCostOfDelivery);
		
		coDrinksTF = new JTextField();
		coDrinksTF.setText("0");
		coDrinksTF.setEditable(false);
		coDrinksTF.setBounds(139, 241, 86, 20);
		contentPane.add(coDrinksTF);
		coDrinksTF.setColumns(10);
		
		coMealTF = new JTextField();
		coMealTF.setText("0");
		coMealTF.setEditable(false);
		coMealTF.setColumns(10);
		coMealTF.setBounds(139, 274, 86, 20);
		contentPane.add(coMealTF);
		
		coDeliveryTF = new JTextField();
		coDeliveryTF.setText("0");
		coDeliveryTF.setEditable(false);
		coDeliveryTF.setColumns(10);
		coDeliveryTF.setBounds(139, 308, 86, 20);
		contentPane.add(coDeliveryTF);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(0, 45, 269, 171);
		contentPane.add(horizontalBox);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBounds(0, 227, 268, 122);
		contentPane.add(horizontalBox_1);
		
		currencyCB = new JComboBox();
		currencyCB.setModel(new DefaultComboBoxModel(new String[] {"--", "US", "Canada", "India", "Pakisthan", "Germany", "Franch"}));
		currencyCB.setBounds(297, 61, 86, 28);
		contentPane.add(currencyCB);
		
		inputCTF = new JTextField();
		inputCTF.setText("0");
		inputCTF.setBounds(297, 97, 167, 23);
		contentPane.add(inputCTF);
		inputCTF.setColumns(10);
		
		outputCTF = new JTextField();
		outputCTF.setEditable(false);
		outputCTF.setColumns(10);
		outputCTF.setBounds(297, 131, 167, 23);
		contentPane.add(outputCTF);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CurrencyConverter();
				
			}
		});
		btnConvert.setBounds(297, 165, 86, 23);
		contentPane.add(btnConvert);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputCTF.setText(null);
				outputCTF.setText(null);
				currencyCB.getModel().setSelectedItem("--");
			}
		});
		btnReset.setBounds(391, 165, 73, 23);
		contentPane.add(btnReset);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setBounds(279, 45, 204, 171);
		contentPane.add(horizontalBox_2);
		
		JLabel lblSubTotal = new JLabel("Sub Total");
		lblSubTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSubTotal.setBounds(297, 242, 73, 19);
		contentPane.add(lblSubTotal);
		
		JLabel lblTax = new JLabel("Tax:");
		lblTax.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTax.setBounds(297, 272, 73, 23);
		contentPane.add(lblTax);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTotal.setBounds(297, 306, 73, 23);
		contentPane.add(lblTotal);
		
		subTTF = new JTextField();
		subTTF.setText("0");
		subTTF.setEditable(false);
		subTTF.setBounds(380, 243, 86, 20);
		contentPane.add(subTTF);
		subTTF.setColumns(10);
		
		taxTF = new JTextField();
		taxTF.setText("0");
		taxTF.setEditable(false);
		taxTF.setColumns(10);
		taxTF.setBounds(378, 275, 86, 20);
		contentPane.add(taxTF);
		
		totalTF = new JTextField();
		totalTF.setText("0");
		totalTF.setEditable(false);
		totalTF.setColumns(10);
		totalTF.setBounds(378, 308, 86, 20);
		contentPane.add(totalTF);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(504, 45, 247, 304);
		contentPane.add(tabbedPane);
		
		JPanel receiptPanel = new JPanel();
		receiptPanel.setToolTipText("");
		tabbedPane.addTab("Receipt", null, receiptPanel, null);
		receiptPanel.setLayout(null);
		
		RtextArea = new JTextArea();
		RtextArea.setFont(new Font("MS UI Gothic", Font.PLAIN, 13));
		RtextArea.setBounds(0, 0, 242, 276);
		receiptPanel.add(RtextArea);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		horizontalBox_3.setBounds(278, 227, 205, 122);
		contentPane.add(horizontalBox_3);
		
		JButton btnNewButton = new JButton("Total");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcTotal();
			}
		});
		btnNewButton.setBounds(4, 357, 78, 23);
		contentPane.add(btnNewButton);
		
		JButton btnReceipt = new JButton("Receipt");
		btnReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				receipt();
			}
		});
		btnReceipt.setBounds(92, 357, 86, 23);
		contentPane.add(btnReceipt);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				print();
			}
			
		});
		btnPrint.setBounds(191, 357, 78, 23);
		contentPane.add(btnPrint);
		
		JButton btnReset_1 = new JButton("Reset");
		btnReset_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chckbxChickenBurger.setSelected(false);
				chckbxChickenBurgerBbq.setSelected(false);
				chckbxBeefBurger.setSelected(false);
				chckbxTax.setSelected(false);
				chckbxHomeDelivary.setSelected(false);
				cbTF.setText("0");
				cbbbqTF.setText("0");
				bfTF.setText("0");
				coDrinksTF.setText("0");
				coMealTF.setText("0");
				coDeliveryTF.setText("0");
				subTTF.setText("0");
				taxTF.setText("0");
				cbTF.setText("0");
				inputCTF.setText("0");
				outputCTF.setText("0");
				totalTF.setText("0");
				currencyCB.getModel().setSelectedItem("--");
				drinkCB.getModel().setSelectedItem("--");
				RtextArea.setText(null);
				
			}
		});
		btnReset_1.setBounds(279, 357, 78, 23);
		contentPane.add(btnReset_1);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(405, 357, 78, 23);
		contentPane.add(btnExit);
	}
}
