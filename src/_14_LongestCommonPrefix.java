public class _14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] s){
        if(s.length == 0) return "";
        String prefix = s[0];
        for(int i = 1; i < s.length; i++){
            while(s[i].indexOf(prefix) != 0 ){//when s[i].indexOf(prefix) = 0 means prefix is common
                prefix = prefix.substring(0, prefix.length()-1);//when isn't 0, deduct the last letter until is 0, move to another string
                if(prefix.isEmpty()) return "0";
            }
        }
        return prefix;
    }
}
