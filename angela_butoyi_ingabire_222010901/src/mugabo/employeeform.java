package mugabo;


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

public class employeeform implements ActionListener{
	JFrame frame;//employee_id,employee_name,email,phone_number,customer_id;
	JLabel employee_id_lb=new JLabel("employee_id");
	JLabel employee_name_lb=new JLabel("employee_name");
	JLabel email_lb=new JLabel("email");
	JLabel phone_number_lb=new JLabel("phone_number");
	JLabel customer_id_lb=new JLabel("customer_id");
	
	JTextField employee_id_txf=new JTextField();
	JTextField employee_name_txf=new JTextField();
	JTextField email_txf=new JTextField();
	JTextField phone_number_txf=new JTextField();
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
	public employeeform(){
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
		frame.setTitle("EMPLOYEE FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.cyan);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		employee_id_lb.setBounds(10,10,130,30);
		employee_name_lb.setBounds(10,50,150,30);
		email_lb.setBounds(10,90,170,30);
		phone_number_lb.setBounds(10,130,190,30);
		customer_id_lb.setBounds(10,170,210,30);
		
		employee_id_txf.setBounds(250,10,190,30);
		employee_name_txf.setBounds(250,50,190,30);
		email_txf.setBounds(250,90,190,30);
		phone_number_txf.setBounds(250,130,190,30);
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
		employee_id_lb.setFont(font);
		employee_name_lb.setFont(font);
		email_lb.setFont(font);
		phone_number_lb.setFont(font);
		customer_id_lb.setFont(font);
		
		employee_id_txf.setFont(font);
		employee_name_txf.setFont(font);
		email_txf.setFont(font);
		phone_number_txf.setFont(font);
		customer_id_txf.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(employee_id_lb);
		frame.add(employee_name_lb);
		frame.add(email_lb);
		frame.add(phone_number_lb);
		frame.add(customer_id_lb);
		
		frame.add(employee_id_txf);
		frame.add(employee_name_txf);
		frame.add(email_txf);
		frame.add(phone_number_txf);
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
	        employee emp = new employee();
	        if (e.getSource() == insert_btn) {
	           emp.setEmployee_name(employee_name_txf.getText());
	           emp.setEmail(email_txf.getText());
	           emp.setPhone_number(phone_number_txf.getText());
	           emp.setCustomer_id(customer_id_txf.getText());
	           emp.insertData();
	
		
	        }
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("employee_name");
            model.addColumn("email");
            model.addColumn("phone_number");
            model.addColumn("customer_id");
           
            ResultSet resultSet =employee.viewData();
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
			int id=Integer.parseInt(employee_id_txf.getText());
			emp.setEmployee_name(employee_name_txf.getText());
			emp.setEmail(email_txf.getText());
			emp.setPhone_number(phone_number_txf.getText());
			emp.setCustomer_id(customer_id_txf.getText());
			emp.update(id);
	    }
	  else {
			int id=Integer.parseInt(employee_id_txf.getText());
			emp.delete(id);
			}
	 }
	 
		
	public static void main(String[] args) {
		employeeform empyForm= new employeeform();
		System.out.println(empyForm);

	}
	
	}





