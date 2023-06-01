
class Graph {
	int[][] adjMatrix;
	int N;
	
	public Graph(int n) {
		N=n;
		adjMatrix = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0; j<n;j++) {
				adjMatrix[i][j]=0;
			}
		}
	}
	public void insertEdge(int u, int v) {
		if(u>=N||v>=N) {
			System.out.println("Vertex error");
			return;
		}
		adjMatrix[u][v]=1;
	}
	public void printMatrix() {
		for(int i=0;i<N;i++) {
			for(int j=0; j<N;j++) {
				System.out.print(" "+adjMatrix[i][j]);
			}
			System.out.println();
		}
	}
}
public class GraphMatrix {

	
	public static void main(String[] args) {
		
		Graph g1;
		g1 = new Graph(8);

		g1.insertEdge(0,1);
		g1.insertEdge(0,4);
		g1.insertEdge(1,0);
		g1.insertEdge(1,5);
		g1.insertEdge(2,3);
		g1.insertEdge(2,5);
		g1.insertEdge(2,6);
		g1.insertEdge(3,2);
		g1.insertEdge(3,7);
		g1.insertEdge(4,0);
		g1.insertEdge(5,1);
		g1.insertEdge(5,2);
		g1.insertEdge(5,6);
		g1.insertEdge(6,2);
		g1.insertEdge(6,5);
		g1.insertEdge(6,7);
		g1.insertEdge(7,3);
		g1.insertEdge(7,6);
		
		g1.printMatrix();
	}
}
