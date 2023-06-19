public class Author
{
	private String name;
	private String email;
	private char gender;

	public Author(String initName, String initEmail, char initGender){
		name = initName;
		email = initEmail;
		gender = initGender;
	}

	public String getName(){
		return name;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String newEmail){
		email = newEmail;
	}
	public char getGender(){
		return gender;
	}

	public String toString(){
		return "Author[name="+name+",email="+email+",gender="+gender+"]";
	}
}