import java.util.Arrays;

public class DijkstraMain{
    // 양의 가중치만을 허용
	
    public static void main(String[] args)     { 
    	
    	int[][] G1= { //인접행렬로 표현
    			{0,10,5, 99, 99},
    			{99,0,2,1,99},
    			{99,3,0,9,2},
    			{99,99,99,0,4},
    			{7,99,99,6,0}
    			
    	};
    
    	int[] Q = {0, 10, 5, 99, 99};//최초가중치배열
    	boolean[] visited = new boolean[G1.length];
    	visited[0]=true;//시작점
    	for (int n=1; n<G1.length;n++) {//최단정점을 하나씩 선택
    		int minIndex=-1; //최소가중치가 저장된 방번호
    		int min=99;//최초최소가중치
    		
    		for (int i=0; i<G1.length;i++) {
    			if(!visited[i]&&min>Q[i]){//최소값정점찾기
    				minIndex=i;
    				min=Q[i];
    			}
    		}
    		visited[minIndex]=true; //최소값가진 정점찾음
    		System.out.println("selectd v:"+minIndex);
    		
    		//선택한 정점을 지나는 경로와 기존 경로를 비교하여 작은값취함
    		for(int i=0; i<G1.length;i++) {
    			if (!visited[i]&&G1[minIndex][i]!=99&& Q[i]>Q[minIndex]+G1[minIndex][i]) {
    				Q[i]=Q[minIndex]+G1[minIndex][i];
    			}
    		}
    		System.out.println(Arrays.toString(visited));
    		System.out.println(Arrays.toString(Q));
    	}
        
    } 
} 