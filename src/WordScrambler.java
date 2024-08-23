
public class WordScrambler {
    private String[] scrambledWords;

    public WordScrambler(String[] wordArr) {

        if (wordArr.length % 2 == 1) {
            throw new IllegalArgumentException("Word Array must contain an even number of elements!");
        }
        if (!(checkValid(wordArr))) {
            throw new IllegalArgumentException("Word Array must contain single words only! Attack on Titan contains more than one word!");
        }
        scrambledWords = mixedWords(wordArr);


    }

    public String[] getScrambledWords() {
        return scrambledWords;
    }

    private String recombine(String word1, String word2) {
        int length1 = word1.length()/2;
        int length2 = word2.length()/2;
        String temp = "";
        if (word1.length() % 2 ==0) {
             temp += word1.substring(0, length1);
        }
        else {
            temp +=  word1.substring(0, (word1.length()-1) / 2);
        }
        if (word2.length() % 2 ==0) {
            temp += word2.substring(length2);
        }
        else {
            temp += word2.substring((word2.length()-1) / 2);
        }
        return temp;


        // To be implemented.

    }

    private String[] mixedWords(String[] words) {
        String [] newWords = new String[words.length];
        String word1;
        String word2;
//first need to read/store word x and x+1
        // then need to call reconbine() with words x and x+1
        // then need to store [x+x+1, x+1,x , y+y+1, y+1+y,...]
        // finally need to return the array
        //[abc, cba, efg ,gfe}
        for(int i = 0; i<words.length; i+=2){
            word1 = words[i];
            word2 = words[i+1];
            newWords[i] = recombine(word1, word2);
            newWords[i+1] = recombine(word2, word1);

        }
        return newWords;
    }

    private boolean checkValid(String[] word) {
        for (String s : word) {
            if (s.contains(" ")) {
                return false;
            }
        }
        return true;
    }
}
