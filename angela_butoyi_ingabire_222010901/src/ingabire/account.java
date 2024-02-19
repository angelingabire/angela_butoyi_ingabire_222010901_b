package ingabire;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class account {
	private int account_id;
	private String account_number;
	private String account_type;
	private String balance_amount;
	private String customer_id;
	
	public account() {
	    // Default constructor
	}
	public account(int account_id,String account_number ,String account_type,String balance_amount,String customer_id) {
		super();
		this.account_id=account_id;
		this.account_number=account_number;
		this.account_type=account_type;
		this.balance_amount=balance_amount;
		this.customer_id=customer_id;
	}
	
		
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public String getBalance_amount() {
		return balance_amount;
	}
	public void setBalance_amount(String balance_amount) {
		this.balance_amount = balance_amount;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public void makeconnection() {
	}

		public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/angela_butoyi_ingabire_b_m_s";
	    String user = "222010901";
	    String password = "222010901";

	    // SQL query to insert data
	    String sql = "INSERT INTO account (	account_number, account_type,balance_amount,customer_id) VALUES (?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.account_number);
	       preparedStatement.setString(2, this.account_type);
	       preparedStatement.setString(3, this.balance_amount);
	       preparedStatement.setString(4, this.customer_id);
	       
	        
	        // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data insert successfully!");
	            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }}
	 
	
    public static ResultSet viewData() {
        String host = "jdbc:mysql://localhost/angela_butoyi_ingabire_b_m_s";
        String user = "222010901";
        String password = "222010901";

        String sql = "SELECT * FROM account";

        try {
            Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
public void update(int inputaccount_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/angela_butoyi_ingabire_b_m_s";
	    String user = "222010901";
	    String password = "222010901";

	    // SQL query to update data
	    String sql = "UPDATE account SET  account_number= ?,account_type= ?, balance_amount= ?  WHERE account_id = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement ac = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  ac.setString(1, this.getAccount_number());
	          ac.setString(2, this.getAccount_type());
	          ac.setString(3, this.getBalance_amount());
	          ac.setString(4, this.getCustomer_id());
	          
	          // Assuming there is a column named 'id' for the WHERE clause
	       
	          ac.setInt(4, inputaccount_id);
	       
	        // Execute the update
	        int rowsAffected = ac.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}
	public void delete(int inputaccount_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/angela_butoyi_ingabire_b_m_s";
	    String user = "222010901";
	    String password = "222010901";

	    // SQL query to delete data
	    String sql = "DELETE FROM account WHERE account_id = ?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputaccount_id); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = pl.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	}
}


