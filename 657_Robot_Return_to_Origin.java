class Solution {
    public boolean judgeCircle(String moves) {
        
        //moves = moves.toUpperCase();
        int[] loc = {0,0};
        
        for (int i = 0; i < moves.length(); i++) {
            
            char move = moves.charAt(i);
            
            switch (move) {
                case 'U':
                    loc[0]++;
                    break;
                case 'D':
                    loc[0]--;
                    break;
                case 'L':
                    loc[1]--;
                    break;
                case 'R':
                    loc[1]++;
                    break;
                default:
                    System.out.println("error performing move " + move);
                    break;           
                        
            }
            
        }
        
        return (loc[0] == 0 && loc[1] == 0);
        
    }
}