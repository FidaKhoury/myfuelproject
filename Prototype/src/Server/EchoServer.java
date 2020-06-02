// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 
package Server;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import logic.Employee;
import ocsf.server.*;

/**
 * This class overrides some of the methods in the abstract 
 * superclass in order to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */

public class EchoServer extends AbstractServer 
{
  //Class variables *************************************************
	ArrayList<String> employeeAL= new ArrayList<String>(); 

  /**
   * The default port to listen on.
   */
  //final public static int DEFAULT_PORT = 5555;
  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the echo server.
   *
   * @param port The port number to connect on.
   * 
   */
 public static Employee  Employee=new Employee(null, null, null, null, null, null);

  public EchoServer(int port) 
  {
    super(port);
  }

  //Instance methods ************************************************
  
  /**
   * This method handles any messages received from the client.
   *
   * @param msg The message received from the client.
   * @param client The connection from which the message originated.
   * @param 
 * @throws SQLException 
   */
  public void handleMessageFromClient  (Object msg, ConnectionToClient client)
  {
	  	employeeAL=(ArrayList<String>) msg;
	  	int flag=0;
	  	
	    System.out.println("Message received: " + msg + " from " + client);
	  
	    if(employeeAL.get(0).equals("LogIn")) {
	    	flag=login(employeeAL);
	    	if(flag==1)this.sendToAllClients("Save");
	    }
	   
	  }
    
  /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
   */
  protected void serverStarted()//change
  {
    System.out.println ("Server listening for connections on port " + getPort());


  }
  /**
   * This method overrides the one in the superclass.  Called
   * when the server stops listening for connections.
   */
  protected void serverStopped()
  {
    System.out.println ("Server has stopped listening for connections.");
  }  
  
  
 public int  login(ArrayList<String> employeeAL){
	 try {
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=IST","root","Aa123456");
	        String str=("SELECT username,password FROM user WHERE username= (?) AND password= (?) ; ");
	        PreparedStatement st= conn.prepareStatement(str);
	        st.setString(1, employeeAL.get(1));
	        st.setString(2, employeeAL.get(2));
	        ResultSet rs=st.executeQuery();
	        if(rs.next()) {
	        	//dispose();
	        	System.out.println("Employee ID Found");
	        	return 1;
	        }
			else
			{
				
				System.out.println("Employee ID  NOT Found");
 return 0;
			}

		}catch(SQLException e) {e.printStackTrace();};
		return 0;
  }
}


//End of EchoServer class
