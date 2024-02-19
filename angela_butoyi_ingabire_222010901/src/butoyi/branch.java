package butoyi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class branch {
	
		private int branch_id;
		private String branch_name;
		private String address;
		
		public branch() {
		    // Default constructor
		}
		public branch(int branch_id,String branch_name,String address) {
			super();
			this.branch_id=branch_id;
			this.branch_name=branch_name;
			this.address=address;
	
		}
		public int getbranch_id() {
			return branch_id;
		}
		public void setbranch_id(int branch_id) {
			this.branch_id = branch_id;
		}
		public String getbranch_name() {
			return branch_name;
		}
		public void setPname(String branch_name) {
			this.branch_name = branch_name;
		}
		public String getaddress() {
			return address;
		}
		public void setPdescription(String address) {
			this.address = address;
		}
		
		public void makeconnection() {
		}
				public void insertData() {
			// JDBC URL, username, and password of MySQL server
		    String host = "jdbc:mysql://localhost/banking_management_system";
		    String user = "222010901";
		    String password = "222010901";

		    // SQL query to insert data
		    String sql = "INSERT INTO branch (	branch_name, address) VALUES (?,?)";
			
		    try (
		        // Establish the connection
		        Connection con = DriverManager.getConnection(host, user, password);

		        // Create a prepared statement
		    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
		    	    ) {
		        // Set the values for the prepared statement
		       preparedStatement.setString(1, this.branch_name);
		       preparedStatement.setString(2, this.address);
		       
		        
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
				public int getBranch_id() {
					return branch_id;
				}
				public void setBranch_id(int branch_id) {
					this.branch_id = branch_id;
				}
				public String getBranch_name() {
					return branch_name;
				}
				public void setBranch_name(String branch_name) {
					this.branch_name = branch_name;
				}
				public String getAddress() {
					return address;
				}
				public void setAddress(String address) {
					this.address = address;
				}
		 
		
	   public static ResultSet viewData() {
	        String host = "jdbc:mysql://localhost/angela_butoyi_ingabire_b_m_s";
	        String user = "222010901";
	        String password = "222010901";

	        String sql = "SELECT * FROM branch";

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
			// JDBC URL, username, and password of MySQL server
		    String url = "jdbc:mysql://localhost/angela_butoyi_ingabire_b_m_s";
		    String user = "222010901";
		    String password = "222010901";

		    // SQL query to update data
		    String sql = "UPDATE Product SET  branch_name= ?,address= ?  WHERE branch_id = ?";

		    try (
		        // Establish the con
		        Connection con = DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement stm = con.prepareStatement(sql);
		    ) {
		        // Set the new values for the update
		    	  stm.setString(1, this.getBranch_name());
		          stm.setString(2, this.getAddress());
		          // Assuming there is a column named 'id' for the WHERE clause
		       
		          stm.setInt(3, inputpid);
		       
		        // Execute the update
		        int rowsAffected = stm.executeUpdate();

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
		public void delete(int inputpid) {
			// JDBC URL, username, and password of MySQL server
		    String url = "jdbc:mysql://localhost/angela_butoyi_ingabire_b_m_s";
		    String user = "222010901";
		    String password = "222010901";

		    // SQL query to delete data
		    String sql = "DELETE FROM branch WHERE  branch_id = ?";

		    try (
		        // Establish the 
		        Connection con= DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement pl = con.prepareStatement(sql);
		    ) {
		        // Set the value for the WHERE clause
		        pl.setInt(1, inputpid); // Assuming there is a column named 'id' for the WHERE clause

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


