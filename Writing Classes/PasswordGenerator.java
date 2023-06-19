public class PasswordGenerator
{
	private int digitLength;
	private String prefix;
	public static int count = 0;
    public PasswordGenerator(int digitLength, String prefix){
		this.digitLength = digitLength;
		this.prefix = prefix;
	}
	public PasswordGenerator(int digitLength){
		this.digitLength = digitLength;
		prefix = "A";
	}

	public static void pwCount(){
		System.out.println(count);
	}

	public void pwGen(){
		count++;
		System.out.println(this);
	}

	public String toString(){
		return prefix + "." + (int)(Math.random()*Math.pow(10,digitLength));
	}

	public static void main(String[] args){
		PasswordGenerator pw1 = new PasswordGenerator(3, "chs");
		pw1.pwCount();
		pw1.pwGen();
		pw1.pwGen();
		pw1.pwCount();
		PasswordGenerator pw2 = new PasswordGenerator(6);
		pw2.pwCount();
		pw2.pwGen();
		pw2.pwCount();
		pw1.pwCount();
	}

}