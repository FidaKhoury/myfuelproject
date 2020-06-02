/**
 * 
 */
/**
 * @author Moustafa
 *
 */
package logic;

public class Employee {

	private String id;
	private String fName;
	private String lName;
	private String company;
	private String role;
	private String email;
	/**
	 * @param id
	 * @param name
	 * @param name2
	 * @param comp
	 * @param role
	 */
	public Employee(String id, String name, String name2, String comp,String role,String email) {
		super();
		this.id = id;
		fName = name;
		lName = name2;
		company=comp;
		this.role=role;
		this.email=email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String em) {
		this.email = em;
	}
	/**
	 * @return the company
	 */
	public String getComp() {
		return company;
	}
	/**
	 * @param set company
	 */
	public void setComp(String comp) {
		this.company = comp;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the lName
	 */
	public String getLName() {
		return lName;
	}
	/**
	 * @param name the lName to set
	 */
	public void setLName(String name) {
		lName = name;
	}
	/**
	 * @return the fName
	 */
	public String getFName() {
		return fName;
	}
	/**
	 * @param name the pName to set
	 */
	public void setFName(String name) {
		fName = name;
	}
	
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param name the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	public String toString(){
		return String.format("%s %s %s %s %s %s\n",id,fName,lName,email,company,role);
	}
	
}
