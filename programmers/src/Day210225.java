import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/***
 * 
 * @author sdy10
 * 
 *         코딩테스트 연습 > 월간 코드 챌린지 시즌1 > 두 개 뽑아서 더하기
 *         https://programmers.co.kr/learn/courses/30/lessons/68644
 * 
 */
public class Day210225 {

	public static void main(String[] args) {
		Solution sol = new Solution();
		// Solution2 sol = new Solution2();
		int[] numbers = { 2, 0, 3, 7 };

		for (int i : sol.solution(numbers)) {
			System.out.print(i + "\t");
		}
	}

}

class Solution {
	public int[] solution(int[] numbers) {
		ArrayList<Integer> res = new ArrayList<>();
		ArrayList<Integer> num = new ArrayList<>();

		for (int number : numbers) {
			num.add(number);
		}

		Collections.sort(num);

		for (int i = 0; i < num.size(); i++) {
			int a = num.get(i);

			for (int j = i + 1; j < num.size(); j++) {
				int b = num.get(j);

				int sum = a + b;

				if (!res.contains(sum)) {
					res.add(sum);
				}
			}
		}

		Collections.sort(res);

		int[] result = new int[res.size()];

		int index = 0;
		for (int r : res) {
			result[index++] = r;
		}
		return result;
	}
}

// 다시 생각한 방법
class Solution2 {
	public int[] solution(int[] numbers) {
		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				set.add(numbers[i] + numbers[j]);
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int val : set) {
			list.add(val);
		}

		Collections.sort(list);

		int[] result = new int[list.size()];

		int index = 0;
		for (int r : list) {
			result[index++] = r;
		}
		return result;
	}
}