public class Student
{
	private String firstName;
	private String lastName;
	private int gradeLevel;

	public Student(String firstName, String lastName, int gradeLevel){
		this.firstName = firstName;
		this.lastName = lastName;
		this.gradeLevel = gradeLevel;
	}

	public String getFirstName(){
		return firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public int getGradeLevel(){
		return gradeLevel;
	}

	public String toString(){
		return firstName + " " + lastName + " in grade " + gradeLevel;
	}

	public static void main(String[] args){
		Student one = new Student("Brandon", "Adams", 9);
		Student two = new Student("Onayemi", "Jelugbo", 12);
		Student three = new Student("Megan", "Fleischner", 11);
		Student four = new Student("Sarah", "Morales", 12);
		Student five = new Student("Amelia", "Valente", 9);
		Student six = new Student("Christopher", "Hamilton", 11);
		Student seven = new Student("David", "Shirley", 10);
		Student eight = new Student("Ramona", "Wallace", 10);
		Student nine = new Student("George", "Washington", 9);
		Student ten = new Student("James", "Madison",11);
		Student[] students = {one, two, three, four, five, six, seven, eight, nine, ten};

		for (Student info: students){
			System.out.println(info.getFirstName() + " " + info.getLastName() + " in grade " + info.getGradeLevel());
		}
	}
}