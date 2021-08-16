import java.util.*;

public class GaleShapley
{
    int n;
    int[][] menPrefList, womenPrefList;
 
    public GaleShapley(int[][] mp, int[][] wp, int n)
    {
    	this.n = n;
        menPrefList = mp;
        womenPrefList = wp;
        printPrefList(menPrefList, true);
        printPrefList(womenPrefList, false);
    }
    
    public void stableMatching() {
    	
    	Stack<Integer> freeMen = new Stack<Integer>();
    	
    	for(int i=0;i<n;i++) {
    		freeMen.push(i);
    	}
    	
    	int[] women = new int[n];
    	Arrays.fill(women, -1);
    	
    	while(!freeMen.empty()) {
    		
    		int m = freeMen.pop();
    		
    		for(int i=0;i<n;i++) {
    			
    			int pref = menPrefList[m][i];
    			
    			if(women[pref] == -1) {
    				women[pref] = m;
    				break;
    			}
    			else {
    				int m1 = women[pref];
    				if(mOverm1(m,m1,pref)) {
    					women[pref] = m;
    					freeMen.push(m1);
    					break;
    				}
    			}
    		}
    	}
    	
    	printCouples(women);
    }
    
    public boolean mOverm1(int newPartner, int curPartner, int index)
    {
        for (int i = 0; i < n; i++)
        {
            if (womenPrefList[index][i] == newPartner)
                return true;
            if (womenPrefList[index][i] == curPartner)
                return false;
        }
        return false;
    }
   
    
    
    public void printCouples(int[] women)
    {
        System.out.println("\nCouples are :- ");
        
        for (int i = 0; i < n; i++)
        {
            System.out.println((char)(women[i] + 'A') +" - "+ (char)(i + 'W'));
        }
    }
    
    public void printPrefList(int[][] prefList, boolean men) {
    	char c1,c2;
    	if(men){
    		System.out.println("\nMen's Preference List :-");
    		c1 = 'A';
    		c2 = 'W';
    	} else {
    		System.out.println("\nWomen's Preference List :-");
    		c1 = 'W';
    		c2 = 'A';
    	}
    	for(int i=0;i<n;i++) {
    		System.out.print((char)(i + c1) + " --> ");
    		for(int j=0;j<n;j++) {
    			System.out.print((char)(prefList[i][j] + c2) + " ");
    		}
    		System.out.println();
    	}
    }
    
    public static void main(String[] args) 
    {
        System.out.println("\nGale-Shapley Algorithm");

        int[][] mp = {{0, 1, 2 ,3}, 
                      {1, 0, 2, 3}, 
                      {3, 0, 2, 1}, 
                      {3, 2, 1, 0}};
                           
        int[][] wp = {{0, 1, 3, 2}, 
                      {1, 2, 0, 3}, 
                      {2, 3, 0, 1},
                      {2, 3, 1, 0}};
        
        GaleShapley gs = new GaleShapley(mp, wp, 4); 
        
        gs.stableMatching();
    }
}
