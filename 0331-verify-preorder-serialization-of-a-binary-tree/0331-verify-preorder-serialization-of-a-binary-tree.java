class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] data = preorder.split(",");
        return helper(data);
    }
    public boolean helper(String[] data){
        Stack<String> storage = new Stack<>();
        for(String val : data){
            storage.push(val);
            check(storage);
        }

        return (storage.size()==1 && storage.peek().equals("#"));
    }
    public void check(Stack<String> storage){
        while(storage.size()>=3 && storage.peek().equals("#") && storage.get(storage.size()-2).equals("#") && !storage.get(storage.size()-3).equals("#")){
            storage.pop();
            storage.pop();
            storage.pop();

            storage.push("#");
        }
    }
}