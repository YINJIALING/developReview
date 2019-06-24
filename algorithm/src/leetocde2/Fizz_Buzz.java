package leetocde2;

import java.util.ArrayList;
import java.util.List;

public class Fizz_Buzz {

	public static void main(String[] args) {

		fizzBuzz(1);
	}

	public static List<String> fizzBuzz(int n) {
		ArrayList<String> res = new ArrayList<>(n);

		for (int i = 1; i <= n; ++i) {
			StringBuilder str = new StringBuilder();
			if (i % 3 == 0) {
				str.append("Fizz");
			}
			if (i % 5 == 0)
				str.append("Buzz");
			if (!(i % 5 == 0 || i % 3 == 0))
				str.append(i);
			res.add(str.toString());
			System.out.println(str.toString());
		}

		return res;
	}

}
