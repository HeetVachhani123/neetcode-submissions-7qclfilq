class Solution {
    public int countSeniors(String[] details) {
        int count = 0;

        for (String s : details) {
            // Extract age (2 characters)
            int age = Integer.parseInt(s.substring(11, 13));

            if (age > 60) {
                count++;
            }
        }

        return count;
    }
}