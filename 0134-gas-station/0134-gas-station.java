class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int netGas = 0;        
        int idx = 0;
        int gasHas = 0;
        
        for(int i = 0; i<gas.length; i++){
            netGas += (gas[i] - cost[i]);            
            gasHas += gas[i];
            gasHas -= cost[i];
            if(gasHas < 0){
                idx = i+1;
                gasHas = 0;
            }
        }
        
        return netGas < 0 ? -1 : idx;
    }
}