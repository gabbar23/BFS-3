Time Complexity (TC): O(2^n * n), where n is the length of the input string s. The worst case involves generating all possible subsets of the string (2^n), and for each subset, we may need to check if it is valid and compute its substring, leading to an O(n) complexity for each operation.

Space Complexity (SC): O(2^n), due to the space required for the queue and visited set, which store all the generated strings.
class Solution {
    // isValid utility
    private boolean isValid(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                count++;
            } else if(c == ')') {
                count--;
            }
            if (count < 0)
                return false;
        }
        return count == 0;
    }

    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> visited = new HashSet<>();
        Queue<String> que = new LinkedList<>();
        List<String> result = new ArrayList<>();
        boolean flag = false;
        que.add(s);
        visited.add(s);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                String curr = que.poll();
                if (isValid(curr)) {
                    flag = true;
                    result.add(curr);
                } else {
                    // find new strings
                    for (int k = 0; k < curr.length(); k++) {
                        if(Character.isAlphabetic(curr.charAt(k)))continue;
                        String newString = curr.substring(0, k) + curr.substring(k + 1, curr.length());
                        if (!visited.contains(newString)) {
                            visited.add(newString);
                            que.add(newString);
                        }
                    }

                }

            }
            if (flag)
                break;

        }
        return result;

    }
}
