class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length()==1) return true;
        char first = word.charAt(0);
        char second = word.charAt(1);
        int i=2;
        if(Character.isUpperCase(first) && Character.isUpperCase(second)){
            // Check capital
            while(i<word.length()){
                char ch=word.charAt(i);
                if(!Character.isUpperCase(ch)){
                    return false;
                }
                i++;
            }

        }
        else if(Character.isUpperCase(first) && Character.isLowerCase(second)){
            // Check capitalize
            while(i<word.length()){
                char ch=word.charAt(i);
                if(!Character.isLowerCase(ch)){
                    return false;
                }
                i++;
            }

        }
        else if(Character.isLowerCase(first) && Character.isLowerCase(second)){
            // Check Lower
            while(i<word.length()){
                char ch=word.charAt(i);
                if(!Character.isLowerCase(ch)){
                    return false;
                }
                i++;
            }
        }
        else{
            return false;
        }
        return true;
    }
}