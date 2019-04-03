class Solution {
    public int[] prisonAfterNDays(int[] cellInts, int N) {
        HashMap<ArrayList<Integer>,Integer> cycles = new HashMap<>();
        ArrayList<Integer> cells = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            cells.add(Integer.valueOf(cellInts[i]));
        }
        
        int cycleStart = -1;
        int cycleEnd = -1;
        int cycleCount = -1;
        ArrayList<Integer> cycleStartCells = new ArrayList<>();

        int d = 1;
        boolean cycle = false;
        
        while (d <= N && cycle == false) {            

            cells = dayCells(cells);
        
            if (!cycles.containsKey(cells)) {
                cycles.put(cells, d);
                
                if (cycleStart != -1) {
                    cycleStart = -1;
                    cycleCount = -1;
                    cycleEnd = -1;
                    cycleStartCells.clear();                    
                }
            
            } else {
                
                if (cycleStart == -1) {
                    
                    cycleStart = cycles.get(cells);
                    cycleCount = cycleStart; 
                    for (Integer c : cells) {
                        cycleStartCells.add(c);
                    }
                    
                } else if (cycles.get(cells) == cycleCount + 1) {

                    cycleCount++;
                    
                } else if (cells.equals(cycleStartCells)) {
                    
                    cycleEnd = cycleCount;
                    cycle = true;
                    
                } else {
                    
                    cycleStart = -1;
                    cycleCount = -1;
                    cycleEnd = -1;
                    cycleStartCells.clear();
                    
                }
            }
            
            d++;    
        }
        
        
        
        if (cycle == true) {
                    
            int mod = cycleEnd - cycleStart + 1;
            int cycleMod = N % mod;
            
            if (cycleMod == 0)
                cycleMod = mod;

            for (int i = 1; i < cycleMod; i++) {
                cycleStartCells = dayCells(cycleStartCells);
            }            
            
            for (int i = 0; i < 8; i++) {
                cellInts[i] = Integer.valueOf(cycleStartCells.get(i));
            }
            
        } else {
        
            for (int i = 0; i < 8; i++) {
                cellInts[i] = Integer.valueOf(cells.get(i));
            }
            
        }
        
        return cellInts;
        
    }
    
    
    
    
    public static ArrayList<Integer> dayCells(ArrayList<Integer> cells) { 

        ArrayList<Integer> res = new ArrayList<>();
          
        for (int i = 0; i < 8; i++) {

            try {    
                if (cells.get(i-1) == cells.get(i+1))
                    res.add(1);
                else 
                    res.add(0);
            } catch (Exception e) {
                res.add(0);
            }
                
        }

        
        return res;
            
    }
    

}