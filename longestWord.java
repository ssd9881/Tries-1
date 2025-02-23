// Tc: l*w 
// sc:l*w
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
            if(curr.children[c-'a']==null){
                curr.children[c-'a']= new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    TrieNode root;
    String maxStr;
    public String longestWord(String[] words) {
        this.root= new TrieNode();
        this.maxStr ="";
        for(String word:words){
            insert(word);
        }
        backtrack(root,new StringBuilder());
        return maxStr;
    }

    private void backtrack(TrieNode curr, StringBuilder path){
        // base
        if(path.length()>maxStr.length()){
            maxStr = path.toString();
        }
        // logic
        for(int i=0;i<26;i++){
            if(curr.children[i]!=null && curr.children[i].isEnd){
                // action
                int le = path.length();
                path.append((char)(i+97));
                // recurse
                backtrack(curr.children[i],path);
                // backtrack
                path.setLength(le);
            }
        }
    }
}