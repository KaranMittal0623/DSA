class Solution {
    public int[] plusOne(int[] digits) {
        // Last se shuru krenge
        for(int i = digits.length-1; i>=0; i--){
            // Agr last vala 9 se km hai toh ek bdaado and return krdo bss array ko
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            // Agr nhi toh mtlb 9 hoga...1 add krenge toh 0 ayega vaha and 1 carry ho jayega next loop me
            digits[i] = 0;
        }
        // Agr saare 999999 hai toh sb 0 ho jayenge upr vaale loop se ....end me ek  new array bnayenge and uski 1st position ko 1 set krdenge
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}