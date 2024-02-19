package ingabire;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import java.awt.Color;

public class accountform implements ActionListener{
	JFrame frame;//account_id,account_number,account_type,balance_amount,customer_id;
	JLabel account_id_lb=new JLabel("account_id");
	JLabel account_number_lb=new JLabel("account_number");
	JLabel account_type_lb=new JLabel("account_type");
	JLabel balance_amount_lb=new JLabel("balance_amount");
	JLabel customer_id_lb=new JLabel("customer_id");
	
	JTextField account_id_txf=new JTextField();
	JTextField account_number_txf=new JTextField();
	JTextField account_type_txf=new JTextField();
	JTextField balance_amount_txf=new JTextField();
	JTextField customer_id_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public accountform(){
		createForm();
	    }
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
	}
	
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("ACCOUNT FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.cyan);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		account_id_lb.setBounds(10,10,130,30);
		account_number_lb.setBounds(10,50,150,30);
		account_type_lb.setBounds(10,90,170,30);
		balance_amount_lb.setBounds(10,130,190,30);
		customer_id_lb.setBounds(10,170,210,30);
		
		account_id_txf.setBounds(250,10,190,30);
		account_number_txf.setBounds(250,50,190,30);
		account_type_txf.setBounds(250,90,190,30);
		balance_amount_txf.setBounds(250,130,190,30);
		customer_id_txf.setBounds(250,170,190,30);
		
		insert_btn.setBounds(10,220,85,30);
		read_btn.setBounds(100,220,85,30);
		update_btn.setBounds(190,220,85,30);
		delete_btn.setBounds(280,220,85,30);
		
		table.setBounds(500, 10, 600, 240);
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		account_id_lb.setFont(font);
		account_number_lb.setFont(font);
		account_type_lb.setFont(font);
		balance_amount_lb.setFont(font);
		customer_id_lb.setFont(font);
		
		account_id_txf.setFont(font);
		account_number_txf.setFont(font);
		account_type_txf.setFont(font);
		balance_amount_txf.setFont(font);
		customer_id_txf.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(account_id_lb);
		frame.add(account_number_lb);
		frame.add(account_type_lb);
		frame.add(balance_amount_lb);
		frame.add(customer_id_lb);
		
		frame.add(account_id_txf);
		frame.add(account_number_txf);
		frame.add(account_type_txf);
		frame.add(balance_amount_txf);
		frame.add(customer_id_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
        frame.add(table);
		ActionEvent ();
	}

	 @Override
	    public void actionPerformed(ActionEvent e) {
	        account ac = new account();
	        if (e.getSource() == insert_btn) {
	            ac.setAccount_number(account_number_txf.getText());
	            ac.setAccount_type(account_type_txf.getText());
	            ac.setBalance_amount(balance_amount_txf.getText());
	            ac.setCustomer_id(customer_id_txf.getText());
	            ac.insertData();
	
		
	        }
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("account_name");
            model.addColumn("account_type");
            model.addColumn("balance_amount");
            model.addColumn("customer_id");
           
            ResultSet resultSet =account.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } 

    else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(account_id_txf.getText());
			ac.setAccount_number(account_number_txf.getText());
			ac.setAccount_type(account_type_txf.getText());
			ac.setBalance_amount(balance_amount_txf.getText());
			ac.update(id);
	    }
	  else {
			int id=Integer.parseInt(account_id_txf.getText());
			ac.delete(id);
			}
	 }
	 
		
	public static void main(String[] args) {
		accountform acForm= new accountform();
		System.out.println(acForm);

	}
	
	}




