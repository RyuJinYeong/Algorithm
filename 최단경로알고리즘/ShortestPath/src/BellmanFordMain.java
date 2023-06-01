import java.util.Arrays;

public class BellmanFordMain {

	public static void solve(int num, int[][] g1, int src) {
		int[] dists = new int[num];
		Arrays.fill(dists, 99);
		dists[src] = 0;
		System.out.println(Arrays.toString(dists));
		for (int i = 0; i < num; i++) {
			for (int v = 0; v < num; ++v) {
				for (int w = 0; w < num; ++w) {
					if (g1[v][w] != 99) {
						dists[w] = Math.min(dists[w], dists[v] + g1[v][w]);
					}
				}
				if(v==0) {
					System.out.println(Arrays.toString(dists));
				}

			}
			
		}

		System.out.println("Shortest Distances from vertex 0");
		System.out.println(Arrays.toString(dists));

	}

	public static void main(String[] args) {
		int num = 6;// 정점의 갯수
		int[][] g1 = new int[][] { 
			{ 0, 6, 5, 5, 99,99 }, 
			{ 99, 0, 99, 99, -1,99 }, 
			{ 99, -2, 0, 99, 1, 99 },
			{ 99, 99, -3, 0, 99,-1 }, 
			{ 99, 99, 99, 99, 0, 3 },
			{ 99, 99, 99, 99, 99, 0 }
		};
		int src = 0;// 시작정점

		solve(num, g1, src);
	}

}