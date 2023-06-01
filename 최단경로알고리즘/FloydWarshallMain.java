
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
		int V=4;
		System.out.println("Hello Floyd Warshall Algorithm");
		int graph[][] = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
              };

		AllshortestPath graph1 = new AllshortestPath();
		graph1.floydWarshall(graph, V);
	}
}
