class Solution {
    public String capitalizeTitle(String title) {
        int len = title.length();
        char[] arr = title.toCharArray();
        int i = 0;

        while (i < len) {
            int j = i;

            // find end of word
            while (j < len && arr[j] != ' ') {
                j++;
            }

            int wordLen = j - i;

            if (wordLen < 3) {
                // all lowercase
                for (int k = i; k < j; k++) {
                    arr[k] = Character.toLowerCase(arr[k]);
                }
            } else {
                // first uppercase
                arr[i] = Character.toUpperCase(arr[i]);
                // rest lowercase
                for (int k = i + 1; k < j; k++) {
                    arr[k] = Character.toLowerCase(arr[k]);
                }
            }

            // move to next word
            i = j + 1;
        }

        return new String(arr);
    }
}
