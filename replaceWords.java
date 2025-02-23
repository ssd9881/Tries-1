// Tc: l*w insertion&replacement
// l: no.of words
// w: avg. len of words
// sc: l*w+m*n

class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    private void insert(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a']==null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    private TrieNode root;
    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        for(String word:dictionary){
            insert(word);
        }
        StringBuilder result = new StringBuilder();
        String [] strArr = sentence.split(" ");
        for(int i=0;i<strArr.length;i++){
            String word = strArr[i];
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            for(int j=0;j<word.length();j++){
                char c = word.charAt(j);
                if(curr.children[c-'a']==null || curr.isEnd){
                    break;
                }
                curr=curr.children[c-'a'];
                replacement.append(c);
            }
            result.append(" ");
            if(curr.isEnd){
                result.append(replacement);
            }else{
                result.append(word);
            }
        }

        return result.toString().trim();
    }
}