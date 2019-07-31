import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Userdao implements dao<User>{
	ConnectionUtil connection2 = new ConnectionUtil();    
	Connection connection = connection2.getconnection();

		public void insert(User e) {
			// TODO Auto-generated method stub
			
		}
		 public User getUser(String username, String password) {
			 User use = null;   
			 try {
		            PreparedStatement pStatement = connection.prepareStatement("select * from employee where username = ? and password = ?");
		            pStatement.setString(1, username);
		            pStatement.setString(2, password);
		            ResultSet resultSet = pStatement.executeQuery();
		            while (resultSet.next()) {
		                User user = new User();
		                user.setUsername(resultSet.getString("username"));
		                user.setPassword(resultSet.getString("password"));
		                user.setAuthority(resultSet.getInt("authority"));
		                use = user;
		            	}
			 } catch (SQLException e) {
		        }
		        return use;
		    }
		
		public User getNamedUser(String name) {
	    	User users = new User();
	        try {
	        	 PreparedStatement pStatement = connection.prepareStatement("select * from employee where username = ?");
		            pStatement.setString(1, name);
		            ResultSet resultSet = pStatement.executeQuery();
	            while (resultSet.next()) {
	                users = new User(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("password"), resultSet.getInt("authority"), resultSet.getString("name"), resultSet.getString("email"), resultSet.getString("phone"));
	            }
	        resultSet.close();
	        } catch (SQLException e) {
	        }
	        return users;
	    }
		
	    public List<Reimburstment> getAllnamed( String name) {
	    	List<Reimburstment> reimburstments = new ArrayList<Reimburstment>();
	        try {
	        	 PreparedStatement pStatement = connection.prepareStatement("select * from reimburstment where reimburstmentname = ?");
	        	 pStatement.setString(1, name);
		         ResultSet resultSet = pStatement.executeQuery();
	            while (resultSet.next()) {
	                Reimburstment reimb = new Reimburstment(resultSet.getInt("id"),resultSet.getString("reimburstmentname"),resultSet.getInt("amount"),resultSet.getString("reimburstmenttype"),resultSet.getString("status"));
	                reimburstments.add(reimb);
	            }
	        resultSet.close();
	        } catch (SQLException e) {
	        }
	        return reimburstments;
	    }

		
	    public List<Reimburstment> getAll() {
	    	List<Reimburstment> reimburstments = new ArrayList<Reimburstment>();
	        try {
	        	 PreparedStatement pStatement = connection.prepareStatement("select * from reimburstment");
		         ResultSet resultSet = pStatement.executeQuery();
	            while (resultSet.next()) {
	                Reimburstment reimb = new Reimburstment(resultSet.getInt("id"),resultSet.getString("reimburstmentname"),resultSet.getInt("amount"),resultSet.getString("reimburstmenttype"),resultSet.getString("status"));
	                reimburstments.add(reimb);
	            }
	        resultSet.close();
	        } catch (SQLException e) {
	        }
	        return reimburstments;
	    }

		public void makereim(Reimburstment reim) {
			// TODO Auto-generated method stub
			 try {
		            PreparedStatement pStatement = connection.prepareStatement("insert into reimburstment(reimburstmentname,Amount,reimburstmenttype,status) values(?,?,?,?)");
		        	pStatement.setString(1, reim.getUsername());
		        	pStatement.setInt(2, reim.getValue());
		            pStatement.setString(3, reim.getType());
		            pStatement.setString(4, reim.getStat());
		            pStatement.executeUpdate();  
			 } catch (SQLException e) {
		        }
		    }

		public void Acceptedrequest(int id ) {
			    	try {
			            PreparedStatement pStatement = connection.prepareStatement("update reimburstment set status = 'Accepted' where id = ?");
			            pStatement.setInt(1, id );
			            pStatement.executeQuery();
			        } catch (SQLException e) {
			        }
			    }
		public void Denyrequest(int id) {
			// TODO Auto-generated method stub
			try {
	            PreparedStatement pStatement = connection.prepareStatement("update reimburstment set status = 'Denied' where id = ?");
	            pStatement.setInt(1, id );
	            pStatement.executeQuery();
	        } catch (SQLException e) {
	        }
		}


		public void select() {
			// TODO Auto-generated method stub
			
		}

		public void delete() {
			// TODO Auto-generated method stub
			
		}

		public void update() {
			// TODO Auto-generated method stub
			
		}

		}