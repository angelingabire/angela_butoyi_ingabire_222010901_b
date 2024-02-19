package mugabo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class employee {
	private int employee_id;
	private String employee_name;
	private String email;
	private String phone_number;
	private String customer_id;
	
	public employee() {
	    // Default constructor
	}
	public employee(int employee_id,String employee_name ,String email,String phone_number,String customer_id) {
		super();
		this.employee_id=employee_id;
		this.employee_name=employee_name;
		this.email=email;
		this.phone_number=phone_number;
		this.customer_id=customer_id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
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
	    String sql = "INSERT INTO employee (employee_name,email,phone_number,customer_id) VALUES (?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.employee_name);
	       preparedStatement.setString(2, this.email);
	       preparedStatement.setString(3, this.phone_number);
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

        String sql = "SELECT * FROM employee";

        try {
            Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
public void update(int inputemployee_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/angela_butoyi_ingabire_b_m_s";
	    String user = "222010901";
	    String password = "222010901";

	    // SQL query to update data
	    String sql = "UPDATE employee SET  employee_name= ?,email= ?, phone_number= ?,customer_id=?  WHERE employee_id = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement emp = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  emp.setString(1, this.getEmployee_name());
	          emp.setString(2, this.getEmail());
	          emp.setString(3, this.getPhone_number());
	          emp.setString(4, this.getCustomer_id());
	          
	          // Assuming there is a column named 'id' for the WHERE clause
	       
	          emp.setInt(5, inputemployee_id);
	       
	        // Execute the update
	        int rowsAffected = emp.executeUpdate();

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
	public void delete(int inputemployee_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/angela_butoyi_ingabire_b_m_s";
	    String user = "222010901";
	    String password = "222010901";

	    // SQL query to delete data
	    String sql = "DELETE FROM employee WHERE employee_id = ?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputemployee_id); // Assuming there is a column named 'id' for the WHERE clause

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



		
	