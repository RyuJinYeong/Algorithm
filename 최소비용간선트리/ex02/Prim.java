
import java.util.*;
import java.util.ArrayList;


class Edge implements Comparable<Edge> {
    int from, to, cost;
 
    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
 
    @Override // Prioirty Queue �켱���� ť�� ����ϱ� ���� �Լ� �������̵�
   public int compareTo(Edge e) {  
        return this.cost - e.cost;
    }
}

class Graph {
    List<Edge>[] edge;
 
    public Graph(int V) {
        edge = new LinkedList[V];
 
        for (int i=0; i < V; i++)
            edge[i] = new LinkedList<>();
    }
 
    // ����� �׷���
    public void addEdge(int from, int to, int cost) {
        edge[from].add(new Edge(from, to, cost));
        edge[to].add(new Edge(to, from, cost));
    }

}

public class Prim {
    static int V, E, min = 0;
    static Graph g1;
    static boolean[] visited;//�湮�ߴ��� ǥ��
    static ArrayList<Edge> mst; //mst������ ����
    
    public static void Prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>(); // ����ġ�� ���� ����� ������ ������ �켱����
        Queue<Integer> queue = new LinkedList<>();      // �����湮 ������ ó���� ���� ť
 
        queue.add(0);                                   // ���� 1�� ������������ ����
 
        while (!queue.isEmpty()) {
            int from = queue.poll();
            visited[from] = true;
 
            for (Edge edge : g1.edge[from]) {        // ���� ���� from�� ����� ���� ��
                if (!visited[edge.to]) {                // ���� ���� to�� �湮���� �ʾҴٸ�
                    pq.add(edge);                       // �켱���� ť�� ������ �߰��Ѵ�. �켱����ť�̹Ƿ� �����Ϳ��� ū ������������
                }
            }
 
            while (!pq.isEmpty()) {// edges are in pq 
                Edge edge = pq.poll();                  // ����ġ�� ���� ���� ������ ���� ���̸�,
                if (!visited[edge.to]) {                // ������ ����� ���� to�� �湮�� ���� ���ٸ�,
                   queue.add(edge.to);                 // ť�� �����Ͽ� ������ �湮�Ѵ�.
                    visited[edge.to] = true;            // �湮�ߴ� ������ �ٽ� �湮���� �ʵ��� �湮ǥ��.
                    mst.add(edge);                      // �ּ� ���д� Ʈ���� �����ϴ� ���� �߰�.
                    min += edge.cost;                   // �� �ּ� ����ġ ���� ���ϱ� ���� ����.
                    break;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        V = 6;
        E = 9;
        visited = new boolean[V];
        mst = new ArrayList<>();
        g1 = new Graph(V);
 
        g1.addEdge(0, 1, 5);
        g1.addEdge(0, 2, 4);
        g1.addEdge(1, 2, 2);
        g1.addEdge(1, 3, 7);
        g1.addEdge(2, 3, 6);
        g1.addEdge(2, 4, 11);        
        g1.addEdge(3, 4, 3);
        g1.addEdge(3, 5, 8);
        g1.addEdge(4, 5, 8);
                
        Prim();        
        
        
        
        System.out.println("최소 비용 간선(정점A-가중치-정점B)");
        for (Edge edge : mst) {
            System.out.print("("+edge.from + "-" + edge.cost+ "-" + edge.to+")\t");
        }
 
        System.out.println(min);
    }
 
  
}
 
