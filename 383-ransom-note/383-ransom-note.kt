class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val mapCount = mutableMapOf<Char, Int>()
        
        for (c in magazine) {
            val curr = mapCount.getOrElse(c) { 0 }
            mapCount.put(c, curr + 1)
        }
        
        for (c in ransomNote) {
            var curr = mapCount.getOrElse(c) { 0 }
            
            if (curr != 0) 
                mapCount.put(c, --curr)
            else 
                return false
        }
        
        return true
    }
}