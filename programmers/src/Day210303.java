import java.util.Arrays;
import java.util.HashMap;

public class Day210303 {

	public static void main(String[] args) {
		String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa" };
		String[] completion = { "josipa", "filipa", "marina", "nikola" };

		Solution4 sol = new Solution4();
		Solution5 sol2 = new Solution5();

		System.out.println(sol.solution(participant, completion));
		System.out.println(sol2.solution(participant, completion));
	}

}

class Solution4 {
	public String solution(String[] participant, String[] completion) {
		Arrays.sort(participant);
		Arrays.sort(completion);

		for (int i = 0; i < completion.length; i++) {
			if (!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}

		return participant[participant.length - 1];
	}
}

// 해시 사용
class Solution5 {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<>();

		for (String player : participant)
			hm.put(player, hm.getOrDefault(player, 0) + 1);
		for (String player : completion)
			hm.put(player, hm.get(player) - 1);

		for (String key : hm.keySet()) {
			if (hm.get(key) != 0)
				answer = key;
		}
		return answer;
	}
}