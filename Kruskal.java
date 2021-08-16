import java.util.*;
class Edge{
	int u,v,wt;
	Edge(int u,int v, int wt){
		this.u = u;
		this.v = v;
		this.wt = wt;
	}
}
public class Kruskal {
	
	int v,e;
	Edge edges[];
	int parent[];
	
	Kruskal(int v, int e){
		this.v = v;
		this.e = e;
		edges = new Edge[e];
		parent = new int[v];
		Arrays.fill(parent, -1);
	}
	
	int find(int i)
    {
        if (parent[i] == -1)
            return i;
        
        return find(parent[i]);
    }
 
    void union(int u, int v)
    {
        parent[u] = v;
    }
    
    void kruskal() {
    	
    	Arrays.sort(edges, (a,b) -> a.wt - b.wt);
    	
    	int i = 0, count = 0;
    	
    	Edge result[] = new Edge[v-1];
    	
    	while(count < v - 1) {
    		
    		Edge curr = edges[i++];
    		
    		if(find(curr.u) != find(curr.v)) {
    			result[count++] = new Edge(curr.u, curr.v, curr.wt);
    			union(curr.u, curr.v);
    		}
    	}
    	
    	System.out.println("\nMinimum Spanning Tree :-\n");
    	
    	int cost = 0;
    	
    	for(int j=0;j<v-1;j++) {
    		cost += result[j].wt;
    		System.out.println("Edge : ("+result[j].u+","+result[j].v+")     Cost = "+result[j].wt);
    	}
    	
    	System.out.println("\nMinimum Spanning Tree Cost = "+ cost);
    }

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of vertices and edges ");
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		Kruskal k = new Kruskal(V, E);
		
		for(int i=0;i<E;i++) {
			System.out.println("Enter the edge (u,v,w) :-");
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			k.edges[i] = new Edge(u, v, w);
		}
		
		k.kruskal();
	}

}
