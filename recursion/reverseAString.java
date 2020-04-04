import java.io.FileInputStream;
import java.util.Scanner;

public class reverseAString {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input"));
		Scanner sc = new Scanner (System.in);
		char[] inputArr = (sc.next()).toCharArray();
		helper (0, inputArr);
	}

	private static void helper(int index, char[] string) {
		// TODO Auto-generated method stub
		if(string == null || index >=string.length)
			return;
		helper(index+1, string);
		System.out.print(string[index] + " ");
	}
}
