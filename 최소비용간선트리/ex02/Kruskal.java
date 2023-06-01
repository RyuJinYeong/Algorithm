import java.util.ArrayList;
import java.util.Collections;
 
//Comparable �� ������ ���ؼ�
class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int cost;
 
    Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
 
    @Override
    public int compareTo(Edge o) {  // cost�� ������ ������ �ϰڴٰ� ������ ����
        if (this.cost < o.cost) {
            return - 1;
        }
        else if (this.cost == o.cost) {
            return 0;
        }
        else {
            return 1;
        }
    }
}
 
public class Kruskal {
    public static int[] parent;
    public static ArrayList<Edge> edgeList;
 
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
 
        if (x != y) {
            parent[y] = x;
        }
    }
 
    public static int find(int x) {  // �θ� ��� ã�� �޼ҵ�
        if (parent[x] == x) {
            return x;
        }
 
        return parent[x] = find(parent[x]);
    }
 
    //same parent means cycle
    public static boolean isSameParent(int x, int y) {
        x = find(x);  // find �޼ҵ带 ���ؼ� �θ� ��� ��ȣ�� ���� ����
        y = find(y);
 
        if (x == y) {
            return true;
        }
        else {
            return false;
        }
    }
 
    public static void main(String[] args) {
        edgeList = new ArrayList<Edge>();
 
        edgeList.add(new Edge(0, 1, 5));
        edgeList.add(new Edge(0, 2, 4));
        edgeList.add(new Edge(1, 2, 2));
        edgeList.add(new Edge(1, 3, 7));
        edgeList.add(new Edge(2, 3, 6));
        edgeList.add(new Edge(2, 4, 11));        
        edgeList.add(new Edge(3, 4, 3));
        edgeList.add(new Edge(3, 5, 8));
        edgeList.add(new Edge(4, 5, 8));
        
 
        parent = new int[8];
 
        for (int i = 1; i <= 7; ++i) {
            parent[i] = i;
        }
 
        Collections.sort(edgeList);// �������� ����
 
        int sum = 0;
        System.out.println("최소 비용 간선 (정점A-가중치-정점B)");
        for (int i = 0; i < edgeList.size(); ++i) {
            Edge edge = edgeList.get(i);
            if(!isSameParent(edge.v1, edge.v2)) {// no cycle
            	System.out.print("("+edge.v1+"-"+edge.cost+"-"+edge.v2+")\t");
                sum += edge.cost;
                union(edge.v1, edge.v2);
            }
        }
 
        System.out.println(sum);
    }
}
