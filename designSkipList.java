package leetcode;

import java.util.Random;

class Skiplist {

	Random random = new Random();
    int maxLevel = 0;
    skipNode topHead = new skipNode(Integer.MIN_VALUE, null, null);
    
    public boolean search(int target) {
        skipNode prev = topHead;
        while(prev != null) {
        	while(prev.right != null && prev.right.val < target) {
        		prev = prev.right;
        	}
        	
        	if(prev.right != null && prev.right.val == target) {
        		return true;
        	}
        	
        	prev = prev.down;
        }
        
        return false;
    }
    
    public void add(int num) {
        int beginLevel = 0;
        while(true) {
        	if(random.nextInt(2) !=0) {
        		break;
        	}
        	
        	beginLevel++;
        }
        while(maxLevel < beginLevel) {
        	maxLevel++;
        	
        	skipNode node = new skipNode(Integer.MIN_VALUE, null, topHead);
        	topHead = node;
        }
        
        skipNode prev = topHead;
        skipNode top = null;
        
        for(int level = maxLevel; level >=0; level--) {
        	while(prev.right != null && prev.right.val < num) {
        		prev = prev.right;
        	}
        	if(level <=beginLevel) {
        		skipNode skNode = new skipNode(num,prev.right, null);
        		if(top != null) {
        			top.down = skNode;
        		}
        		prev.right = skNode;
        		top = skNode;
        	}
        	
        	prev = prev.down;
        }
    }
    
    public boolean erase(int num) {
        boolean result = false;
        
        skipNode prev = topHead;
        while(prev != null) {
        	while(prev.right != null && prev.right.val < num) {
        		prev = prev.right;
        	}
        	
        	if(prev.right != null && prev.right.val == num) {
        		prev.right = prev.right.right;
        		
        		result = true;
        	}
        	
        	prev = prev.down;
        }
        
        return result;
    }
    
    class skipNode{
	     int val;
	     skipNode right;
	     skipNode down;
	     
	     skipNode(int val, skipNode right, skipNode down) {
	    	 this.val = val;
	    	 this.right = right;
	    	 this.down = down;
	     }
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */