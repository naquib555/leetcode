class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Pair<Integer, Integer>[] pairs = new Pair[position.length];
        
        for (int i = 0; i < position.length; i++) {
            pairs[i] = new Pair<>(position[i], speed[i]);
        }
        
        Arrays.sort(pairs, (a, b) -> b.getKey() - a.getKey());
        
        Stack<Double> stack = new Stack();
        
        for (int i = 0; i < pairs.length; i++) {
            double p = (double) pairs[i].getKey();
            double s = (double) pairs[i].getValue();
            
            stack.push((target - p) / s);
            
            if (stack.size() >= 2) {
                double second = stack.pop();
                double first = stack.peek();
                
                if (second > first)
                    stack.push(second);
            }
            
        }
        
        return stack.size();
    }
}