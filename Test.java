import java.util.ArrayList;
import java.util.Scanner;

public class Test
{
	public static void main(String[] args)
	{
		Test app = new Test();
	}

	public Test(){
		method();
	}

public void method() { // 10
    int a = 0;
    for(int x = 0; x < 5; x++)
        a=methodB(methodA(methodB(x)));
    methodC(a);
}
public int methodA(int x){
    return x+2;
}
public int methodB(int x){
    return 2*x;
}
public void methodC(int s){
    System.out.println(s);
}






}