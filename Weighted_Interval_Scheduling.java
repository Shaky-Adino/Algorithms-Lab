import java.util.*;
class Request{
	int start, finish, value;
	
	Request(int s, int f, int v){
		start = s;
		finish = f;
		value = v;
	}
	
}
public class Weighted_Interval_Scheduling {
	
	int n;
	Request[] requests;
	int[] M;
	
	Weighted_Interval_Scheduling(int n){
		this.n = n;
		requests = new Request[n+1];
		requests[0] = new Request(0, 0, 0);
		M = new int[n+1];
	}
	
	int p(int j) {
		
		int l = 1, h = n, ans = 0;
		
		while(l <= h) {
			int mid = (l + h)/2;
			if(requests[mid].finish <= requests[j].start) {
				ans = mid;
				l = mid + 1;
			}
			else
				h = mid - 1;
		}
		
		return ans;
	}
	
	int computeOpt(int j){
		
		if(j == 0)
			return 0;
		
		else if(M[j] != 0)
			return M[j];
		
		return M[j] = Math.max(requests[j].value + computeOpt(p(j)), computeOpt(j-1));
	}
	
	void schedule() {
		
		Arrays.sort(requests, (a,b) -> a.finish - b.finish);
		
		System.out.println("\nThe maximum possible profit is " + computeOpt(n));
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of intervals");
		int n = sc.nextInt();
		
		Weighted_Interval_Scheduling ob = new Weighted_Interval_Scheduling(n);
		
		for(int i=1;i<=n;i++) {
			System.out.println("Enter the start time, finish time and value of interval " + i);
			int s = sc.nextInt();
			int f = sc.nextInt();
			int v = sc.nextInt();
			ob.requests[i] = new Request(s, f, v);
		}
		
		ob.schedule();
	}

}
