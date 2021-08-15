import java.util.LinkedList;
import java.util.Scanner;

public class Rat {
	
	int v;
	LinkedList<Integer> adj[];
	
	Rat(int v){
		this.v = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++)
			adj[i] = new LinkedList();
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
	
	public void DFS(int v, boolean visited[]) {
		visited[v] = true;
		System.out.print(v + " ");
		
		for(int u : adj[v]) {
        	if(!visited[u]) {
        		DFS(u, visited);
        	}
        }
	}
	
	public void DFS(int s) {
		
		boolean visited[] = new boolean[v];
		
		DFS(s, visited);
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of vertices :-");
		int n = sc.nextInt();
		
		Rat g = new Rat(n);
		
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
		g.DFS(s);

	}

}
