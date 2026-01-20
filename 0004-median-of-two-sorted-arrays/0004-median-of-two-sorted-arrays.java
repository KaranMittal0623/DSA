class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        // First array small hona chahiye dusre se
        if(n1>n2){
           return findMedianSortedArrays(nums2,nums1);
        }

        int n = n1+n2;
        // total me se left ka size pta krlo kitna hona chaiye
        int leftSize = (n1+n2+1) / 2;
        // first and second element se kitne le skte aa voh define krlo starting
        int low = 0 , high = n1;

        while(low<=high){
            // First array me se kitne le skte aa
            int mid1 = (low+high)/2;
            // Second array me se ktine le skte aa....jitne first me aagye utne second se minus krdo
            int mid2 = leftSize - mid1;
            int l1 = Integer.MIN_VALUE,l2=Integer.MIN_VALUE,r1=Integer.MAX_VALUE,r2=Integer.MAX_VALUE;

            if(mid1<n1){
                r1 = nums1[mid1];
            }
            if(mid2<n2){
                r2 = nums2[mid2];
            }
            if(mid1-1>=0){
                l1 = nums1[mid1-1];
            }
            if(mid2-1>=0){
                l2 = nums2[mid2-1];
            }
            // array sorted aa final break point milgeya ab median return krdo
            if(l1<=r2 && l2<=r1){
                if(n%2==1){
                    return Math.max(l1,l2);
                }
                else{
                    return ((double)(Math.max(l1,l2) + Math.min(r1,r2))) / 2.0;
                }
            }

            else if(l1>r2){
                high = mid1-1;
            }
            else{
                low = mid1+1;
            }
        }
        return 0;
    }
}