class Solution {
public:
    int maxArea(vector<int>& height) {
        int vol=0,i=0,j=height.size()-1;
        int water;
        while(i<j){
            if(height[i]<height[j]){
                water=height[i]*(j-i);
            }
            else{
                water=height[j]*(j-i);
            }
            if(water>vol){
                vol=water;
            }
            if(height[i]<height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return vol;
    }
};