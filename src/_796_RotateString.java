public class _796_RotateString {
//    Example 1:
//    Input: A = 'abcde', B = 'cdeab'
//    Output: true
//
//    Example 2:
//    Input: A = 'abcde', B = 'abced'
//    Output: false
    public boolean rotateString(String A, String B){
        if(A.length() != B.length()) return false;
        if(A.length() == 0) return false;

        search:
            for(int i = 0; i < A.length(); i++){
                for(int j = 0; j < A.length(); j++){
                    if(A.charAt((i + j)% A.length()) != B.charAt(j)){
                        continue search;
                    }
                }
                return true;
            }
            return false;
    }

    public boolean rotateString1(String A, String B){
        if(A.length() != B.length()) return false;
        if((A+A).contains(B))
            return true;
        else
            return false;
    }
}
