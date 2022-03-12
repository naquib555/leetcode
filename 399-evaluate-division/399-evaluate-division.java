class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0);
            String divisor = equation.get(1);
            double quotient = values[i];
            
            if (!graph.containsKey(dividend))
                graph.put(dividend, new HashMap<>());
            if (!graph.containsKey(divisor))
                graph.put(divisor, new HashMap<>());
            
            graph.get(dividend).put(divisor, quotient);
            graph.get(divisor).put(dividend, 1 / quotient);
        }
        
        double[] results = new double[queries.size()];
        
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0);
            String divisor = query.get(1);
            
            if (!graph.containsKey(dividend) || !graph.containsKey(divisor))
                results[i] = -1.0;
            else if (dividend == divisor)
                results[i] = 1.0;
            else {
                HashSet<String> visited = new HashSet<>();
                results[i] = dfs(graph, visited, dividend, divisor, 1);
            }
        }
        return results;
    }
    
    double dfs(HashMap<String, HashMap<String, Double>> graph, HashSet<String> visited, String currentNode, String targetNode, double product) {
        visited.add(currentNode);
        
        double result = -1.0;
        
        Map<String, Double> neighbors = graph.get(currentNode);
        
        if (neighbors.containsKey(targetNode)) {
            result = product * neighbors.get(targetNode);
        } else {
            for (Map.Entry<String, Double> pair : neighbors.entrySet()) {
                String nextNode = pair.getKey();
                if (visited.contains(nextNode)) continue;
                result = dfs(graph, visited, nextNode, targetNode, product * pair.getValue());
                
                if (result != -1.0)
                    break;
            }
        }
        visited.remove(currentNode);
        return result;
    }
}