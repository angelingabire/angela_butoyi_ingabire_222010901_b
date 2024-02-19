package angela;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class customer {
    private int customerId;
    private String customerName;
    private String email;
    private String telephone;
    private String address;
    private String branchId;
    

    public customer() {
    }

    public customer(int customerId, String customerName, String email, String telephone,String address, String branchId) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.branchId = branchId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getbranchId() {
        return branchId;
    }

    public void setbranchId(String branchId) {
        this.branchId = branchId;
    }

    public void makeConnection() {
        // Implement connection creation logic here
    }

    public void insertData() {
        String host = "jdbc:mysql://localhost/angela_butoyi_ingabire_b_m_s";
        String user = "222010901";
        String password = "222010901";
        String sql = "INSERT INTO customer (customer_name, email, telephone, address, branch_id) VALUES (?,?,?,?,?)";

        try (Connection con = DriverManager.getConnection(host, user, password);
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            preparedStatement.setString(1, this.customerName);
            preparedStatement.setString(2, this.email);
            preparedStatement.setString(3, this.telephone);
            preparedStatement.setString(4, this.address);
            preparedStatement.setString(5, this.branchId);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
                JOptionPane.showMessageDialog(null, "Data inserted successfully!", "After insert", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to insert data.");
                JOptionPane.showMessageDialog(null, "Failed to insert data!", "After insert", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet viewData() {
	    String host = "jdbc:mysql://localhost/angela_butoyi_ingabire_b_m_s";
	    String user = "222010901";
	    String password = "222010901";
	    String sql = "SELECT * FROM customer";

	    try {
	        Connection con = DriverManager.getConnection(host, user, password);
	        PreparedStatement preparedStatement = con.prepareStatement(sql);
	        return preparedStatement.executeQuery();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}


    public void update(int inputpid) {
        String url = "jdbc:mysql://angela_butoyi_ingabire_b_m_s";
        String user = "222010901";
        String password = "222010901";
        String sql = "UPDATE customer SET customer_name=?,  email=?, telephone=?,address=?, branch_id=? WHERE customer_id=?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setString(1, this.customerName);
            stm.setString(2, this.email);
            stm.setString(3, this.telephone);
            stm.setString(4, this.address);
            stm.setString(5, this.branchId);
            stm.setInt(6, inputpid);

            int rowsAffected = stm.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data updated successfully!");
                JOptionPane.showMessageDialog(null, "Data updated successfully!", "After update", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to update data. No matching record found.");
                JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found!", "After insert", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int inputpid) {
        String url = "jdbc:mysql://localhost/angela_butoyi_ingabire_b_m_s";
        String user = "222010901";
        String password = "222010901";
        String sql = "DELETE FROM customer WHERE customer_id = ?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pl = con.prepareStatement(sql)) {

            pl.setInt(1, inputpid);

            int rowsAffected = pl.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data deleted successfully!");
                JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to delete data. No matching record found.");
                JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found!", "After insert", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
