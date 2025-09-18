class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = findRowIndex(matrix,target);
        if(rowIndex!=-1) return binaryOverRow(matrix,target,rowIndex);
        else return false;
    }

    public int findRowIndex(int[][] matrix, int target){
        int l=0;
        int r=matrix.length-1;
        while(l<=r){
            int mid = l + (r-l) / 2;
            if(target>= matrix[mid][0] && target<= matrix[mid][matrix[0].length-1]) return mid;
            else if(target>matrix[mid][0]){
                l=mid+1;
            }
            else if(target<matrix[mid][0]){
                r=mid-1;
            }
        }
        return -1;
    }

    public boolean binaryOverRow(int[][] matrix,int target,int rowIndex){
        int l = 0;
        int r = matrix[rowIndex].length-1;

        while(l<=r){
            int mid = l + (r-l)/2;
            if(matrix[rowIndex][mid]==target) return true;
            else if(matrix[rowIndex][mid]<target){
                l = mid+1;
            }
            else if(matrix[rowIndex][mid]>target){
                r = mid-1;
            }
        }
        return false;

    }
}