import java.util.*;

class Solution {
    int n;
    ArrayList<String> result = new ArrayList<>();
    
    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        if (n > 12 || n < 4) return result; // IP must have 4-12 digits
        
        solve(s, 0, 0, "");
        return result;
    }

    void solve(String s, int idx, int parts, String curr) {
        // Base case: if we've processed all characters and have 4 parts
        if (idx == n && parts == 4) {
            result.add(curr.substring(0, curr.length() - 1)); // Remove trailing dot
            return;
        }
        
        // If we've processed all characters but don't have 4 parts, or vice versa
        if (idx == n || parts == 4) {
            return;
        }

        // Try 1-digit part
        if (idx + 1 <= n) {
            String oneDigit = s.substring(idx, idx + 1);
            if (isValid(oneDigit)) {
                solve(s, idx + 1, parts + 1, curr + oneDigit + ".");
            }
        }

        // Try 2-digit part
        if (idx + 2 <= n) {
            String twoDigits = s.substring(idx, idx + 2);
            if (isValid(twoDigits)) {
                solve(s, idx + 2, parts + 1, curr + twoDigits + ".");
            }
        }

        // Try 3-digit part
        if (idx + 3 <= n) {
            String threeDigits = s.substring(idx, idx + 3);
            if (isValid(threeDigits)) {
                solve(s, idx + 3, parts + 1, curr + threeDigits + ".");
            }
        }
    }

    boolean isValid(String str) {
        // Check for leading zeros
        if (str.length() > 1 && str.charAt(0) == '0') {
            return false;
        }
        
        // Convert to integer and check range
        
        int val = Integer.parseInt(str);
        return val >= 0 && val <= 255;
    
        
        
    }
}