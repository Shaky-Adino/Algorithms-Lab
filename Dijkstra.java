import java.util.*;
class Pair{
    int first,second;
    Pair(int f,int s){
        first = f;
        second = s;
    }
}
public class Dijkstra {
	
	int v;
	LinkedList<Pair> adj[];
	
	Dijkstra(int v){
		this.v = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++)
			adj[i] = new LinkedList();
	}
	
	public void addEdge(int u, int v, int wt) {
		adj[u].add(new Pair(v, wt));
		adj[v].add(new Pair(u, wt));
	}
	
	public void dijkstra(int s) {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(v, (a,b) -> a.first - b.first);
		
		int[] dist = new int[v];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		int[] parent = new int[v];
		parent[s] = -1;
		
		pq.add(new Pair(0, s));
		dist[s] = 0;
		
		while(!pq.isEmpty()) {
			
			int u = pq.poll().second;
			
			for(Pair curr : adj[u]) {
				int v = curr.first;
				int wt = curr.second;
				
				if(dist[u] + wt < dist[v]) {
					parent[v] = u;
					dist[v] = dist[u] + wt;
					pq.add(new Pair(dist[v], v));
				}
			}
		}
		
		for(int i=0;i<v;i++) {
			System.out.println("Cost of shortest path from "+ s +" to "+ i + " = " + dist[i]);
			
			System.out.println("Path :-");
			System.out.print(s + " ");
			printPath(i, parent);
			System.out.println("\n");
		}
	}
	
	void printPath(int curr, int[] parent)
	{
		if (parent[curr] == -1)
			return;
		
		printPath(parent[curr], parent);
		
		System.out.print(curr + " ");
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of vertices ");
		int n = sc.nextInt();
		
		Dijkstra d = new Dijkstra(n);
		
		System.out.println("Enter the number of edges ");
		int m = sc.nextInt();
		
		while(m-- > 0) {
			System.out.println("Enter the edge (u,v,w) :-");
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			d.addEdge(u, v, w);
		}
		
		System.out.println("\nEnter the starting node ");
		int s = sc.nextInt();
	    
	    d.dijkstra(s);
		
	}

}
