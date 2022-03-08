/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    
    Map<Integer, Employee> empRecord;
    
    public int getImportance(List<Employee> employees, int id) {
        empRecord = new HashMap<>();
        
        for (Employee emp : employees)
            empRecord.put(emp.id, emp);
        
        return dfs(id);
    }
    
    int dfs(int id) {
        Employee emp = empRecord.get(id);
        
        int totalImp = emp.importance;
        
        for (Integer subord : emp.subordinates) {
            totalImp += dfs(subord);
        }
        
        return totalImp;
    }
}
