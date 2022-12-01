package hw1;

import java.util.Random;

public class hw1 {

	public static void main(String[] args) {
		int x=0;
		Random random = new Random();
		int t = 10;
		while (t-- > 0) {
			int r = random.nextInt(3);
			System.out.println(r);
		}
	}

}
