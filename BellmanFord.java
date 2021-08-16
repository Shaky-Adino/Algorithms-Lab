import java.util.*;
class Edge{
	int u,v,wt;
	Edge(int u,int v, int wt){
		this.u = u;
		this.v = v;
		this.wt = wt;
	}
}
public class BellmanFord {
	
	int v,e;
	Edge edges[];
	
	BellmanFord(int v, int e) {
		this.v = v;
		this.e = e;
		edges = new Edge[e];
	}
	
	void bellman(int s) {
		
		int dist[] = new int[v];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		
		for(int i=0;i<v-1;i++) {
			for(int j=0;j<e;j++) {
				int u = edges[j].u;
				int v = edges[j].v;
				int wt = edges[j].wt;
				if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v])
					dist[v] = dist[u] + wt;
			}
		}
		
		print(s, dist);
	}
	
	void print(int s, int[] dist) {
		
		System.out.println("\nVertex - Shortest path from "+s);
        for (int i = 0; i < v; i++)
            System.out.println(" " + i + "\t\t" + dist[i]);
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of vertices and edges ");
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		BellmanFord b = new BellmanFord(V, E);
		
		for(int i=0;i<E;i++) {
			System.out.println("Enter the edge (u,v,w) :-");
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			b.edges[i] = new Edge(u, v, w);
		}
		
		System.out.println("\nEnter the starting vertex");
		int s = sc.nextInt();
		
		b.bellman(s);
	}

}
