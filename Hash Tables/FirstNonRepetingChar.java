public class Solution {
  private char findingFirstNonRepetitiveChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int count;

        for(char ch: str.toCharArray()) {
            if(map.containsKey(ch)) {
                count = map.get(ch);
            }
            else
                count = 0;

            map.put(ch, count+1);
        }

        System.out.println(map);

        for(char ch: str.toCharArray()) {
            if(map.get(ch) == 1)
                return ch;
        }

        return Character.MIN_VALUE;
    }
}
