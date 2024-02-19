package angela;

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

public class customerform implements ActionListener {
    JFrame frame;
    JLabel customer_id_lb = new JLabel("Customer ID");
    JLabel customer_name_lb = new JLabel("Customer Name");
    JLabel email_lb = new JLabel("Email");
    JLabel telephone_lb = new JLabel("Telephone");
    JLabel address_lb = new JLabel("Address");
    JLabel branch_id_lb = new JLabel("branchId");

    JTextField customer_id_txf = new JTextField();
    JTextField customer_name_txf = new JTextField();
    JTextField email_txf = new JTextField();
    JTextField telephone_txf = new JTextField();
    JTextField address_txf = new JTextField();
    JTextField branch_id_txf = new JTextField();

    // Buttons CRUD
    JButton insert_btn = new JButton("Insert");
    JButton read_btn = new JButton("View");
    JButton update_btn = new JButton("Update");
    JButton delete_btn = new JButton("Delete");
    
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screenSize.getWidth();
    int h = (int) screenSize.getHeight();

    public customerform() {
        createForm();
        setEventHandlers();
        setLocationAndSize();
        setFontForAll();
        addComponentsToFrame();
    }

    private void setEventHandlers() {
        insert_btn.addActionListener(this);
        read_btn.addActionListener(this);
        update_btn.addActionListener(this);
        delete_btn.addActionListener(this);
    }

    private void createForm() {
        frame = new JFrame();
        frame.setTitle("Customer Form");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.YELLOW);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }

    private void setLocationAndSize() {
        customer_id_lb.setBounds(10,10,120,30);
        customer_name_lb.setBounds(10,50,140,30);
        email_lb.setBounds(10,90,160,30);
        telephone_lb.setBounds(10,130,180,30);
        address_lb.setBounds(10,170,200,30);
        branch_id_lb.setBounds(10,210,220,30);

        customer_id_txf.setBounds(160, 10, 130, 30);
        customer_name_txf.setBounds(160, 50, 130, 30);
        email_txf.setBounds(160, 90, 130, 30);
        telephone_txf.setBounds(160, 130, 130, 30);
        address_txf.setBounds(160, 170, 130, 30);
        branch_id_txf.setBounds(160, 210, 130, 30);

        // Buttons CRUD
        insert_btn.setBounds(10, 250, 85, 30);
        read_btn.setBounds(100, 250, 85, 30);
        update_btn.setBounds(190, 250, 85, 30);
        delete_btn.setBounds(280, 250, 85, 30);
        table.setBounds(500, 10, 600, 240);

           }

    private void setFontForAll() {
        Font font = new Font("Times New Roman", Font.BOLD, 20);

        customer_id_lb.setFont(font);
        customer_name_lb.setFont(font);
        email_lb.setFont(font);
        telephone_lb.setFont(font);
        address_lb.setFont(font);
        branch_id_lb.setFont(font);

        customer_id_txf.setFont(font);
        customer_name_txf.setFont(font);
        email_txf.setFont(font);
        telephone_txf.setFont(font);
        address_txf.setFont(font);
        branch_id_txf.setFont(font);

        Font fonti = new Font("Courier New", Font.ITALIC, 12);

        insert_btn.setFont(fonti);
        read_btn.setFont(fonti);
        update_btn.setFont(fonti);
        delete_btn.setFont(fonti);
    }

    private void addComponentsToFrame() {
        frame.add(customer_id_lb);
        frame.add(customer_name_lb);
        frame.add(email_lb);
        frame.add(telephone_lb);
        frame.add(address_lb);
        frame.add(branch_id_lb);

        frame.add(customer_id_txf);
        frame.add(customer_name_txf);
        frame.add(email_txf);
        frame.add(telephone_txf);
        frame.add(address_txf);
        frame.add(branch_id_txf);

        // Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        frame.add(table);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        customer cstm = new customer();
        if (e.getSource() == insert_btn) {
            cstm.setCustomerName(customer_name_txf.getText());
            cstm.setAddress(address_txf.getText());
            cstm.setTelephone(telephone_txf.getText());
            cstm.setEmail(email_txf.getText());
            cstm.insertData();
        }
        
            else if (e.getSource() == read_btn) {
                model.setColumnCount(0);
                model.setRowCount(1);
                model.addColumn("customer_id");
                model.addColumn("customer_name");
                model.addColumn("email");
                model.addColumn("telephone");
                model.addColumn("address");
                model.addColumn("branch_id");
                
                ResultSet resultSet =customer.viewData();
                if (resultSet != null) {
                    try {
                        while (resultSet.next()) {
                            model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                    resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)});
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
         }
                } else if (e.getSource() == update_btn) {
            int id = Integer.parseInt(customer_id_txf.getText());
            cstm.setCustomerName(customer_name_txf.getText());
            cstm.setAddress(email_txf.getText());
            cstm.setTelephone(telephone_txf.getText());
            cstm.setAddress(address_txf.getText());
            cstm.setEmail(branch_id_txf.getText());

            cstm.update(id);
        } else {
            int id = Integer.parseInt(customer_id_txf.getText());
            cstm.delete(id);
        }
    }

    public static void main(String[] args) {
        customerform cstf = new customerform();
        System.out.println(cstf);
    }
}
