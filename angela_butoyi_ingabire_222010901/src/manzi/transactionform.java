package manzi;

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

public class transactionform implements ActionListener{
	JFrame frame;//transaction_id,transaction_type,amount,transaction_date,account_id;
	JLabel transaction_id_lb=new JLabel("transaction_id");
	JLabel transaction_type_lb=new JLabel("transaction_type");
	JLabel amount_lb=new JLabel("amount");
	JLabel transaction_date_lb=new JLabel("transaction_date");
	JLabel account_id_lb=new JLabel("account_id");
	
	JTextField transaction_id_txf=new JTextField();
	JTextField transaction_type_txf=new JTextField();
	JTextField amount_txf=new JTextField();
	JTextField transaction_date_txf=new JTextField();
	JTextField account_id_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public transactionform(){
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
		frame.setTitle("TRANSACTION FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.green);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		transaction_id_lb.setBounds(10,20,140,30);
		transaction_type_lb.setBounds(10,60,160,30);
		amount_lb.setBounds(10,100,190,30);
		transaction_date_lb.setBounds(10,140,190,30);
		account_id_lb.setBounds(10,180,210,30);
		
		transaction_id_txf.setBounds(250,10,190,30);
		transaction_type_txf.setBounds(250,50,190,30);
		amount_txf.setBounds(250,90,190,30);
		transaction_date_txf.setBounds(250,130,190,30);
		account_id_txf.setBounds(250,170,190,30);
		
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
		transaction_id_lb.setFont(font);
		transaction_type_lb.setFont(font);
		amount_lb.setFont(font);
		transaction_date_lb.setFont(font);
		account_id_lb.setFont(font);
		
		transaction_id_txf.setFont(font);
		transaction_type_txf.setFont(font);
		amount_txf.setFont(font);
		transaction_date_txf.setFont(font);
		account_id_txf.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(transaction_id_lb);
		frame.add(transaction_type_lb);
		frame.add(amount_lb);
		frame.add(transaction_date_lb);
		frame.add(account_id_lb);
		
		frame.add(transaction_id_txf);
		frame.add(transaction_type_txf);
		frame.add(amount_txf);
		frame.add(transaction_date_txf);
		frame.add(account_id_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
        frame.add(table);
		ActionEvent ();
	}

	 @Override
	    public void actionPerformed(ActionEvent e) {
	        transaction tra = new transaction();
	        if (e.getSource() == insert_btn) {
	            tra.setTransaction_type(transaction_type_txf.getText());
	            tra.setAmount(amount_txf.getText());
	            tra.setTransaction_date(transaction_date_txf.getText());
	            tra.setAccount_id(account_id_txf.getText());
	            tra.insertData();
	
		
	        }
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("transaction_type");
            model.addColumn("amount");
            model.addColumn("transaction_date");
            model.addColumn("account_id");
           
            ResultSet resultSet =transaction.viewData();
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
			int id=Integer.parseInt(transaction_id_txf.getText());
		    tra.setTransaction_type(transaction_type_txf.getText());
			tra.setAmount(amount_txf.getText());
			tra.setTransaction_date(transaction_date_txf.getText());
			tra.setAccount_id(account_id_txf.getText());
			tra.update(id);
	    }
	  else {
			int id=Integer.parseInt(transaction_id_txf.getText());
			tra.delete(id);
			}
	 }
	 
		
	public static void main(String[] args) {
		transactionform traForm= new transactionform();
		System.out.println(traForm);

	}
	
	}





