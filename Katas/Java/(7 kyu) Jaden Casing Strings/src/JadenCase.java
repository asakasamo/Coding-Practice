import java.util.ArrayList;

/**
 * @author Al-John
 */
public class JadenCase {

    public String toJadenCase(String phrase) {
        if(phrase == null || phrase.isEmpty())
            return null;

        String jadenCased = "";
        String[] words = phrase.split(" ");

        for(String word : words){
            jadenCased += ("" + word.charAt(0)).toUpperCase() + word.substring(1, word.length()) + " ";
        }

        jadenCased = jadenCased.trim();

        return jadenCased;
    }

}
