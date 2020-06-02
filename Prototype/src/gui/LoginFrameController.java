package gui;

import java.util.ArrayList;

import client.ChatClient;
import client.ClientUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.Employee;
public class LoginFrameController {
	private Employee emp;
	
	@FXML
	private Button btnExit = null;
	
	@FXML
	private Button btnSend = null;
	
	@FXML
	private TextField idtxt;
	
	@FXML
	private TextField passtxt;
	
	
	private String getID()
	{
		return idtxt.getText();
	}
	
	private String getPass()
	{
		return passtxt.getText();
	}
	
	public void Send(ActionEvent event) throws Exception {
		ArrayList<String> Al =new ArrayList<String>();
		String id,pass;
		FXMLLoader loader = new FXMLLoader();
		
		id=getID();
		pass=getPass();
		if(id.trim().isEmpty())
		{

			System.out.println("You must enter a id number");
				
		}
		else if(pass.trim().isEmpty())
		{
			System.out.println("You must enter a password");

		}
		else
		{	Al.add("LogIn");
			Al.add(id);//change
			Al.add(pass);
			ClientUI.chat.accept(Al);
			if(ChatClient.emp.getId().equals("Error"))
			{
				System.out.println("Employee ID is Not Found");
				
			}
			else 
			{
		        
				((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
				Stage primaryStage = new Stage();
				Pane root = loader.load(getClass().getResource("/gui/EmployeeUpdate.fxml").openStream());
				EmployeeController	employeeFormController = loader.getController();		
				employeeFormController.loadStudent(ChatClient.emp);
		
				Scene scene = new Scene(root);			
				primaryStage.setTitle("Employee Managment Tool");

				primaryStage.setScene(scene);		
				primaryStage.show();
			}
		
		}
	}
	public void start(Stage primaryStage) throws Exception 
	{	
		Parent root = FXMLLoader.load(getClass().getResource("/gui/login.fxml"));
				
		Scene scene = new Scene(root);
		primaryStage.setTitle("LogIn Page");
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}

	public void getExitBtn(ActionEvent event) throws Exception {
		System.out.println("exit Login page");
		System.exit(0);//exit the window
	
	}


}
