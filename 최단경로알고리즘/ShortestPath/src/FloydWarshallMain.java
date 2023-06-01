
class AllshortestPath {
	
	public void floydWarshall(int graph[][], int V) {
		int dist[][] =new int[V][V];
		for(int i=0; i<V;i++) {
			for(int j=0;j<V;j++) {
				dist[i][j]=graph[i][j];
			}
		}
		
		for(int k=0;k<V;k++) {
			for(int i=0; i<V;i++) {
				for(int j=0;j<V;j++) {
					if(dist[i][k]+dist[k][j]<dist[i][j]) {
						dist[i][j]=dist[i][k]+dist[k][j];
					}
				}
			}
		}
		
		for(int i=0; i<V;i++) {
			for(int j=0;j<V;j++) {
				System.out.print("  "+dist[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
public class FloydWarshallMain {

	public static void main(String[] args) {
		int INF=99;
		int V=5;
		System.out.println("Hello Floyd Warshall Algorithm");
		int graph[][] = { {0,   3,	8,  INF, -4},
                {INF, 0,   99, 1, 7},
                {INF, 4, 0, INF, INF},
                {2, INF, -5, 0, INF},
                {INF, INF, INF, 6, 0}
              };

		AllshortestPath graph1 = new AllshortestPath();
		graph1.floydWarshall(graph, V);
	}
}
