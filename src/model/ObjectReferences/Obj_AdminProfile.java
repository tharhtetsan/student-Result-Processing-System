package model.ObjectReferences;

public class Obj_AdminProfile {

	private String userId;
	private String Name;
	private String Post;
	private String userName;
	private String password;
	private String info;
	
	public Obj_AdminProfile()
	{
		
	}
	
	public Obj_AdminProfile(String userId,String name,String post,String userName,String password,String info)
	{
		this.userId=userId;
		this.Name=name;
		this.Post=post;
		this.userName=userName;
		this.password=password;
		this.info=info;
	}
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPost() {
		return Post;
	}
	public void setPost(String post) {
		Post = post;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
	
	
}
