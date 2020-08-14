import javafx.util.Pair;

import java.util.*;

public class _127_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        int L = beginWord.length();
        Map<String, List<String>> allComboDict = new HashMap<>();

        wordList.forEach(
                word ->{
                    for(int i = 0; i < L; i ++){
                        //key is the generic word
                        //Value is a list of words which have the same intermediate generic word
                        String newWord = word.substring(0, i) + "*" + word.substring(i+1, L);//length of substring is endIndex - beginIndex.
                        List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<String>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                }
        );

        //Queue for BFS
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));

        //Visied to make sure we don't repeat processing same word
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()){
            Pair<String, Integer> node= Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for(int i = 0; i < L; i++){
                //Intermediate words for current word
                String newWord = word.substring(0, i) + "*" + word.substring(i+1, L);
                //Next states are all the words which share the same intermediate state.
                for(String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())){
                    if(adjacentWord.equals(endWord)){
                        return level + 1;
                    }
                    if(!visited.containsKey(adjacentWord)){
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level+1));
                    }
                }

            }
        }
        return 0;
    }
}
