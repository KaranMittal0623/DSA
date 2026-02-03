class Solution {
    public int thirdMax(int[] nums) {
        // Either we can do sorting and return 3rd element distinct
        // Or we can solve with 3 variables in 1 pass

        int max = 0;
        int sMax = 0;
        int tMax = 0;
        boolean hasMax = false,hasSMax = false,hasTMax = false;
        for(int n : nums){
            if((hasMax && n==max) || (hasSMax && n == sMax) || (hasTMax && n==tMax)){
                continue;
            }
            if(!hasMax || n>max){
                tMax = sMax; hasTMax = hasSMax;
                sMax = max; hasSMax = hasMax;
                max = n; hasMax = true;
            }
            else if(!hasSMax || n>sMax){
                tMax = sMax; hasTMax = hasSMax;
                sMax = n; hasSMax = true;
            }
            else if(!hasTMax || n>tMax){
                tMax = n; hasTMax = true;
            }
        }
        return hasTMax ? tMax : max;
    }
}