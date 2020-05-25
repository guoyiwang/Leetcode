public class _791_CustomSortString {
//    Example :
//    Input:
//    S = "cba"
//    T = "abcd"
//    Output: "cbad"
//    Explanation:
//            "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
//    Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
    public String customSortString(String S, String T){
        String reset = "";
        char[] StoCharArray = S.toCharArray();
        char[] TtoCharArray = T.toCharArray();
        for(int i = 0; i < StoCharArray.length; i++){
            for(int j = 0; j < TtoCharArray.length; j++){
                if(StoCharArray[i] == TtoCharArray[j]){
                    reset = reset + StoCharArray[i];
                    TtoCharArray[j] = '#';
                }
            }
        }
        for(int i = 0; i < TtoCharArray.length; i++){
            if(TtoCharArray[i] != '#') reset += TtoCharArray[i];
        }
        return reset;
    }
}
