package patel.udemy.model;

public class JiraLoginPostMethods {
	
	private String username ;
	private String password ;
	


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public JiraLoginPostMethods(String username,String password){
		this.username = username;
		this.password = password;
		
		
	}
	

}
