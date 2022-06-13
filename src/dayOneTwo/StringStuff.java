import java.util.HashMap;
import java.util.Set;

public class StringStuff {
    public static void main(String[] args) {


    }

    void getCharCount(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<str.length();i++) {
            Character ch = Character.valueOf(str.charAt(i));

            if(map.containsKey(ch)) {
                int currentCount = map.get(ch);
                int newCount = currentCount + 1;
                map.put(ch, newCount);
            } else {
                map.put(ch, 1);
            }

        }

        Set<Character> keys = map.keySet();

        for(Character ch: keys) {
            int count = map.get(ch);
            System.out.println(ch+ " = "+ count);
        }
    }
}

