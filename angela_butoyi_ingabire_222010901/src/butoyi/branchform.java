package butoyi;

import java.awt.Color;
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

public class branchform implements ActionListener {
	
	JFrame frame;//branch_id, branch_name,address;
	JLabel branch_id_lb=new JLabel("branch_id");
	JLabel branch_name_lb=new JLabel("branch_name");
	JLabel address_lb=new JLabel("address");
	
	JTextField branch_id_txf=new JTextField();
	JTextField branch_name_txf=new JTextField();
	JTextField address_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public branchform(){
		createForm();
	    }
	private void ActionEvent() {
		insert_btn.addActionListener((ActionListener) this);
		read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
	}
	
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("BRANCH FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.red);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		branch_id_lb.setBounds(10, 10, 120, 30);
		branch_name_lb.setBounds(10,50,150,30);
	    address_lb.setBounds(10, 90, 140, 30);
		
		branch_id_txf.setBounds(160, 10, 130, 30);
		branch_name_txf.setBounds(160, 50, 130, 30);
		address_txf.setBounds(160, 90, 130, 30);
		
		
		insert_btn.setBounds(10,250, 85, 30);
		read_btn.setBounds(100,250, 85, 30);
		update_btn.setBounds(190,250, 85, 30);
		delete_btn.setBounds(280,250, 85, 30);
		table.setBounds(500, 10, 600, 240);
		
		
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
	    branch_id_lb.setFont(font);
		branch_name_lb.setFont(font);
		address_lb.setFont(font);
		
		
		branch_id_txf.setFont(font);
		branch_name_txf.setFont(font);
		address_txf.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(branch_id_lb);
		frame.add(branch_name_lb);
		frame.add(address_lb);
		
		
		frame.add(branch_id_txf);
		frame.add(branch_name_txf);
		frame.add(address_txf);
		
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
        frame.add(table);
		ActionEvent ();
	}

	@Override

	public void actionPerformed (ActionEvent e) {
		branch br=new branch();
		if(e.getSource()==insert_btn) {
			br.setBranch_name(branch_name_txf.getText());
			br.setAddress(address_txf.getText());
			br.insertData();
			
		}
		
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("branch_name");
            model.addColumn("address");
           
            ResultSet resultSet =branch.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } 

    else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(branch_id_txf.getText());
			br.setBranch_name(branch_name_txf.getText());
			br.setAddress(address_txf.getText());
			
			br.update(id);
	    }
	  else {
			int id=Integer.parseInt(branch_id_txf.getText());
			br.delete(id);
			}
	}
		
	public static void main(String[] args) {
		branchform br= new branchform();
		System.out.println(br);

	}
	



}

