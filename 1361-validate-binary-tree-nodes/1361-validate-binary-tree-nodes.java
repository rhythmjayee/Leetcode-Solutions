class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int count = 0;
        int[] v = new int[n];
        int[] notRoot = new int[n];
        
        for(int i  = 0; i<n; i++){//get root node which is not left, right of any node
            int l = leftChild[i];
            int r = rightChild[i];
            if(l != -1) notRoot[l] = 1;
            if(r != -1) notRoot[r] = 1;
        }
        
        int root = -1;
        for(int i  = 0; i<n; i++){//get single root node
           if(notRoot[i] == 0 && root == -1){
               count++;
               root = i;
           }else if(notRoot[i] == 0 && root != -1) return false;//if more 1 root node than not tree
        }

        if(count == 0) return false;//if no root
        
        boolean b = get(root,leftChild,rightChild,v);
        if(!b) return false;
        
        for(int i = 0; i<n;i++){//to get disconnected parts
            if(v[i] == 0) return false;
        }
        return true;
    }
    public boolean get(int i ,int[] l,int[] r,int[] v){
        if(i == -1) return true;
        if(v[i] == 1) return false;
        v[i] = 1;
        
        boolean lft = get(l[i],l,r,v);
        if(!lft) return false;
        boolean rht = get(r[i],l,r,v);
        
        return rht;
    }
}