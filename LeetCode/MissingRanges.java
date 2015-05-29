import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MissingRanges {
	public List<String> missingRanges(int[] ia) {
		int prev = -1;
		List<String> output = new ArrayList<String>();
		for (int j = 0; j <= ia.length; j++) {
			int current = j == ia.length ? 100 : ia[j];
			if (current - prev >= 2) {
				int diff = current - prev - 1;
				if (diff == 1)
					output.add("" + j);
				else
					output.add("" + (prev + 1) + "->" + (current - 1));
			}
			prev = current;
		}
		return output;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		MissingRanges test = new MissingRanges();
		int N = in.nextInt();
		int[] ia = new int[N];
		for (int i = 0; i < N; i++)
			ia[i] = in.nextInt();
		System.out.println(test.missingRanges(ia));
	}
}
