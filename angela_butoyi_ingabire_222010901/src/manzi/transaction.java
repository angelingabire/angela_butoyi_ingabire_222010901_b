package manzi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class transaction {
    private int transaction_id;
    private String transaction_type;
    private String amount;
    private String transaction_date;
    private String account_id;
    
    

    public transaction() {
    }

    public transaction(int transaction_id, String transaction_type, String amount, String transaction_date, String account_id){
        this.transaction_id =transaction_id;
        this.transaction_type = transaction_type;
        this.amount =amount;
        this.transaction_date =transaction_date;
        this.account_id =account_id;
    }
        
    
	public int getTransaction_Id() {
		return transaction_id;
	}

	public void setTransaction_Id(int transaction_Id) {
		this.transaction_id = transaction_Id;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	 public void makeConnection() {
	        // Implement connection creation logic here
	    }

	    public void insertData() {
	        String host = "jdbc:mysql://localhost/angela_butoyi_ingabire_b_m_s";
	        String user = "222010901";
	        String password = "222010901";
	        String sql = "INSERT INTO transaction ( transaction_type, amount, transaction_date,account_id) VALUES (?,?,?,?)";

	        try (Connection con = DriverManager.getConnection(host, user, password);
	             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

	            preparedStatement.setString(1, this.transaction_type);
	            preparedStatement.setString(2, this.amount);
	            preparedStatement.setString(3, this.transaction_date);
	            preparedStatement.setString(4, this.account_id);
	            

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
		    String sql = "SELECT * FROM transaction";

		    try {
		        Connection con = DriverManager.getConnection(host, user, password);
		        PreparedStatement preparedStatement = con.prepareStatement(sql);
		        return preparedStatement.executeQuery();
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return null;
		    }
		}


	    public void update(int inputtransaction_id) {
	        String url = "jdbc:mysql://localhost/angela_butoyi_ingabire_b_m_s";
	        String user = "222010901";
	        String password = "222010901";
	        String sql = "UPDATE transaction SET transaction_type=?, amount=?,transaction_date=?, account_id=? WHERE transaction_id=?";

	        try (Connection con = DriverManager.getConnection(url, user, password);
	             PreparedStatement tra = con.prepareStatement(sql)) {

	            tra.setString(1, this.transaction_type);
	            tra.setString(2, this.amount);
	            tra.setString(3, this.transaction_date);
	            tra.setString(4, this.account_id);
	            tra.setInt(5, inputtransaction_id);

	            int rowsAffected = tra.executeUpdate();

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

	    public void delete(int inputtransaction_id) {
	        String url = "jdbc:mysql://localhost/angela_butoyi_ingabire_b_m_s";
	        String user = "222010901";
	        String password = "222010901";
	        String sql = "DELETE FROM transaction WHERE transaction_id = ?";

	        try (Connection con = DriverManager.getConnection(url, user, password);
	             PreparedStatement pl = con.prepareStatement(sql)) {

	            pl.setInt(1, inputtransaction_id);

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
