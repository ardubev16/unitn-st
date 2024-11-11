package connection;
import java.sql.*;
import static connection.Provider.*;

public class ConnectionString {
	static Connection con=null;
	//single connection object for whole application since we used static
	public static Connection getCon() throws ClassNotFoundException, SQLException{
        if(con == null){
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
            con=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);
            System.out.print("connected");
        }
        else {
        	System.out.print("Not connected");
        }
        return con;
    }
	
	/*static{
		try{
			//we can use provider object properties because we statically imported Provider object
			Class.forName("com.mysql.cj.jdbc.Driver"); //com.mysql.cj.jdbc.Driver com.mysql.jdbc.Driver
			con=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);
			}catch(Exception e){
				e.printStackTrace();
			}
	}*/
	
	//returns already existing connection object
	/*public static Connection getCon(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}*/
}
