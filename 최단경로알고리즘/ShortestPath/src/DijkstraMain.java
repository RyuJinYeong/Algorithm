import java.util.Arrays;

public class DijkstraMain{
    // ���� ����ġ���� ���
	
    public static void main(String[] args)     { 
    	
    	int[][] G1= { //������ķ� ǥ��
    			{ 0, 3, 8, 99, 4 }, 
    			{ 99, 0, 99, 1, 7 }, 
    			{ 99, 4, 0, 99, 99 },
    			{ 99, 99, 5, 0, 99 }, 
    			{ 99, 99, 99, 6, 0 }
    			
    	};
    
    	int[] Q = {0, 10, 5, 99, 99};//���ʰ���ġ�迭
    	boolean[] visited = new boolean[G1.length];
    	visited[0]=true;//������
    	for (int n=1; n<G1.length;n++) {//�ִ������� �ϳ��� ����
    		int minIndex=-1; //�ּҰ���ġ�� ����� ���ȣ
    		int min=99;//�����ּҰ���ġ
    		
    		for (int i=0; i<G1.length;i++) {
    			if(!visited[i]&&min>Q[i]){//�ּҰ�����ã��
    				minIndex=i;
    				min=Q[i];
    			}
    		}
    		visited[minIndex]=true; //�ּҰ����� ����ã��
    		System.out.println("selectd v:"+minIndex);
    		
    		//������ ������ ������ ��ο� ���� ��θ� ���Ͽ� ����������
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