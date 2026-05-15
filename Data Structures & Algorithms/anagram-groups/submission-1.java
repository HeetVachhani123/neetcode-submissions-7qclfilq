class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        java.util.HashMap<String, List<String>> map = new java.util.HashMap<>();

        for (String s : strs) {

            char[] arr = s.toCharArray();

            java.util.Arrays.sort(arr);

            String key = new String(arr);

            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}