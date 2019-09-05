class Solution {
    func commonChars(_ A: [String]) -> [String] {
        
        //use the first string to get candidates for matching
        var candidates = [Character : Int]()        
        for ch in A[0] {
            if let val = candidates[ch] {
                candidates[ch] = val + 1
            } else {
                candidates[ch] = 1
            }
        }
        
        //create a dict for each additional string and compare
        for i in 1..<A.count {
            var matcher = [Character : Int]()
            for ch in A[i] {
                if let _ = candidates[ch] { 
                    if let val = matcher[ch] {
                        matcher[ch] = val + 1
                    } else {
                        matcher[ch] = 1
                    }
                } 
            }
            
            //reduct initial candidates list down to what we had in common
            candidates = reduceCandidates(candidates: candidates, matcher: matcher)
        }

        //convert from dict's quantities to array and return the result
        var result = [String]()
        for (c, n) in candidates {
            for i in 0..<n {
                result.append(String(c))
            }
        }
        return result
    }
    
    
    func reduceCandidates(candidates: [Character : Int], matcher: [Character : Int]) -> [Character : Int] {
        var newCandidates = candidates
        for (c, n) in candidates {
            if let val = matcher[c] {
                newCandidates[c] = min(candidates[c]!, val)  
            } else {
                newCandidates[c] = nil
            }
        }
    
        return newCandidates
        
    }
}