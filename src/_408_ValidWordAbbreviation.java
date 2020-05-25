public class _408_ValidWordAbbreviation {
//    A string such as "word" contains only the following valid abbreviations:
//        ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
//    Example1:
//    Given s = "internationalization", abbr = "i12iz4n":
//    Return true.
//    Example2:
//    Given s = "apple", abbr = "a2e":
//    Return false.
//    You need to understand the process in this question.
//    "internationalization"
//    "i12iz4n"
//    "internationalization"
//    "i5a11o1"
//    "internationalization"
//    "i12iz2n"
//    "a"
//    "2"
//    "a"
//    "01"
//    "hi"
//    "2i"
//    "hi"
//    "1"
    public boolean validWordAbbreviation(String word, String abbr){
        int i = 0, j = 0;
        if(abbr.charAt(j) == '0'){
            return false;
        }
        while( i < word.length() && j < abbr.length()){
            if(word.charAt(i) == abbr.charAt(j)){
                i++;
                j++;
                continue;
            }
            if(abbr.charAt(j) < '0' || abbr.charAt(j) > '9'){
                return false;
            }
            int start = j;
            while (j<abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9'){
                j++;
            }
            i = i + Integer.valueOf(abbr.substring(start,j));
        }
        return i == word.length() && j == abbr.length();
    }
}
