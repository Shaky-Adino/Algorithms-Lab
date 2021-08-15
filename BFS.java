import java.util.LinkedList;
import java.util.Scanner;

public class BFS {
	
	int v;
	LinkedList<Integer> adj[];
	
	BFS(int v){
		this.v = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++)
			adj[i] = new LinkedList();
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
	
	public void bfs(int s) {
		
		boolean visited[] = new boolean[v];
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		visited[s] = true;
        queue.add(s);
        
        while (queue.size() != 0)
        {
            s = queue.poll();
            
            System.out.print(s+" ");
 
            for(int v : adj[s]) {
            	if(!visited[v]) {
            		visited[v] = true;
            		queue.add(v);
            	}
            }
        }
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of vertices :-");
		int n = sc.nextInt();
		
		BFS g = new BFS(n);
		
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
		
		System.out.println("The vertices that can be reached from "+s+" are :-");
		g.bfs(s);
	}

}
