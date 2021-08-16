import java.util.*;
public class Knapsack {
	
	int n,w;
	int dp[][];
	int[] wt, val;
	
	Knapsack(int n, int w){
		this.n = n;
		this.w = w;
		dp = new int[n+1][w+1];
		wt = new int[n];
		val = new int[n];
	}
	
	void knapsack() {
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=w;j++) {
				if(wt[i-1] <= j)
					dp[i][j] = Math.max(val[i-1] + dp[i-1][j - wt[i-1]], dp[i-1][j]);
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		
		System.out.println("\nMaximum value possible = " + dp[n][w]);
		printItems();
	}
	
	void printItems() {
		
		int res = dp[n][w], W = w;
		
		System.out.println("\nItems in knapsack are :-");
		
		for (int i = n; i > 0 && res > 0; i--) {
			
            	if (res == dp[i - 1][W])
                	continue;
            	else {
                	System.out.println("Item - "+i+" : weight = "+wt[i-1]+", value = "+val[i-1]);
                	res = res - val[i - 1];
                	W = W - wt[i - 1];
            	}
        }
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of items and capacity of Knapsack");
		int n = sc.nextInt();
		int w = sc.nextInt();
		
		Knapsack k = new Knapsack(n, w);
		
		for(int i=0;i<n;i++) {
			System.out.println("Enter weight and value for item "+(i + 1));
			int wt = sc.nextInt();
			int val = sc.nextInt();
			k.wt[i] = wt;
			k.val[i] = val;
		}
		
		k.knapsack();
		
	}

}
