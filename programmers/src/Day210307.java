import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Day210307 {

	public static void main(String[] args) {
		int[] answers = { 1, 2, 3, 4, 5 };
		//int[] answers = { 1,3,2,4,2 };

		System.out.println(new Solution6().solution(answers));
	}

}

class Solution6 {
	public ArrayList<Integer> solution(int[] answers) {
		ArrayList<Integer> answer = new ArrayList<>();

		int[] play1 = { 1, 2, 3, 4, 5 };
		int[] play2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] play3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("play1", 0);
		hm.put("play2", 0);
		hm.put("play3", 0);

		for (int i = 0; i < answers.length; i++) {
			int a = play1[i % 5];
			int b = play2[i % 8];
			int c = play3[i % 10];

			int bs = answers[i];

			if (bs == a) {
				hm.put("play1", hm.get("play1") + 1);
			}
			if (bs == b) {
				hm.put("play2", hm.get("play2") + 1);
			}
			if (bs == c) {
				hm.put("play3", hm.get("play3") + 1);
			}
		}
		
		ArrayList<String> keys=new ArrayList<>(hm.keySet());
		
		Collections.sort(keys, (o1,o2) -> (hm.get(o2).compareTo(hm.get(o1))));
		
		int max=hm.get(keys.get(0));
		for(String key:keys) {
			if(max==hm.get(key)) {
				answer.add(key.charAt(4)-'0');
			}
		}
		
		
		
		return answer;
	}
}