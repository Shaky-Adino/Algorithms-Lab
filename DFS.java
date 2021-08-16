import java.util.*;
public class DFS {
	
	int v;
	LinkedList<Integer> adj[];
	
	DFS(int v){
		this.v = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++)
			adj[i] = new LinkedList();
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
	
	public void dfs(int v, boolean visited[]) {
		visited[v] = true;
		System.out.print(v + " ");
		
		for(int u : adj[v]) {
        	if(!visited[u]) {
        		dfs(u, visited);
        	}
        }
	}
	
	public void dfs(int s) {
		
		boolean visited[] = new boolean[v];
		
		dfs(s, visited);
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of vertices :-");
		int n = sc.nextInt();
		
		DFS g = new DFS(n);
		
		System.out.println("Enter the number of edges :-");
		int m = sc.nextInt();
		
		while(m-- > 0) {
			System.out.println("Enter the edge (u,v) :-");
			int u = sc.nextInt();
			int v = sc.nextInt();
			g.addEdge(u, v);
		}
		
		System.out.println("Enter the starting vertex :-");
		int s = sc.nextInt();
		
		System.out.println("Depth First Traversal :-");
		g.dfs(s);

	}

}
