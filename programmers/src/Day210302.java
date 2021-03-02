
public class Day210302 {
	public static void main(String[] args) {
		String test1 = "...!@BaT#*..y.abcdefghijklm";
		String test2 = "z-+.^.";
		String test3 = "=.=";
		String test4 = "123_.def";
		String test5 = "abcdefghijklmn.p";

		System.out.println(new Solution3().solution(test1));
		System.out.println();
		System.out.println(new Solution3().solution(test2));
		System.out.println();
		System.out.println(new Solution3().solution(test3));
		System.out.println();
		System.out.println(new Solution3().solution(test4));
		System.out.println();
		System.out.println(new Solution3().solution(test5));
	}
}

class Solution3 {
	public String solution(String new_id) {
		String answer = new_id;

		// 1단계
		answer = sol1(answer);

		// 2단계
		answer = sol2(answer);

		// 3단계
		answer = sol3(answer);

		// 4단계
		answer = sol4(answer);

		// 5단계
		answer = sol5(answer);

		// 6단계
		answer = sol6(answer);

		// 7단계
		answer = sol7(answer);

		return answer;
	}

	public String sol1(String new_id) {
		return new_id.toLowerCase();
	}

	public String sol2(String new_id) {
		String pattern = "[^a-z0-9-_\\.]*";


		return new_id.replaceAll(pattern, "");
	}

	public String sol3(String new_id) {
		String pattern = "[\\.]+";


		return new_id.replaceAll(pattern, ".");
	}

	public String sol4(String new_id) {
		String pre = new_id;

		if (new_id.charAt(0) == '.' && new_id.length() >= 1) {
			new_id = new_id.replaceFirst(".", "");
		}
		if (new_id.length() >= 1 && new_id.charAt(new_id.length() - 1) == '.') {
			new_id = new_id.substring(0, new_id.length() - 1);
		}

		return new_id;
	}

	public String sol5(String new_id) {
		String pre = new_id;
		if (new_id.length() == 0)
			new_id = "a";

		return new_id;
	}

	public String sol6(String new_id) {
		String pre = new_id;
		if (new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
		}

		if (new_id.length() >= 1 && new_id.charAt(new_id.length() - 1) == '.') {
			new_id = new_id.substring(0, new_id.length() - 1);
		}

		return new_id;
	}

	public String sol7(String new_id) {
		String pre = new_id;
		if (new_id.length() <= 2) {
			char ch = new_id.charAt(new_id.length() - 1);

			for (; new_id.length() != 3;) {
				new_id += ch+"";
			}
		}
		return new_id;
	}
}