
public class MidProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dice_rolled = 0;  // �� ȸ���� ���� �ֻ��� Ƚ��
		int total_dice_rolled = 0; // �� �ֻ��� ���� Ƚ��
		
		for(int i = 1; i <= 30; i++) { // ��ü ���� Ƚ�� : 30ȸ �ݺ�
			boolean finished = false;  // �� ���� ���� ���� 
			int room_num = 1;  // ��� �� ��ȣ
			
			while(!finished) {  // 100�� ����� ���ֽ� �ݺ��� ����
				int move = (int)(Math.random() * 5) + 1; // 1~6 ���� ����, �ֻ��� ����
				
				//System.out.println("���ȣ : " + room_num);
				//System.out.println("�ֻ��� �� : " + move);
				
				room_num += move;  // ���ȣ += ������ �ֻ��� ��
				
				dice_rolled++;  // �ֻ��� ���� Ƚ�� 1 ����
				
				if(room_num == 8) {        // 8�� ���ϰ��
					//System.out.println("8->55 �̵�");
					room_num = 55;         // 55�� ������ �̵�
				}
				else if(room_num == 19) {  // 19�� ���ϰ��
					//System.out.println("19->76 �̵�");
					room_num = 76;		   // 76�� ������ �̵�
				}
				else if(room_num == 32) {  // 32�� ���ϰ��
					//System.out.println("32->92 �̵�");
					room_num = 92;         // 92�� ������ �̵�
				}
				else if(room_num == 56) {  // 56�� ���ϰ��
					//System.out.println("56->4 �̵�");
					room_num = 4;          // 4�� ������ �̵�
				}
				else if(room_num == 88) {  // 88�� ���ϰ��
					//System.out.println("88->33 �̵�");
					room_num = 33;         // 33�� ������ �̵�
				}
				else if(room_num == 97) {  // 97�� ���ϰ��
					//System.out.println("97->59 �̵�");
					room_num = 59;         // 59�� ������ �̉�
				}
				
				//System.out.println("�̵� �� ���ȣ : " + room_num);
			    //System.out.println("�ֻ��� ���� Ƚ�� : " + dice_rolled);
				//System.out.println();
				
				if(room_num >= 100) { // 100���� �̻��ϰ��
					finished = true;  // ������ ������ ���� false -> true
				}
			}
			
			System.out.println(i + "ȸ�� �ֻ��� ���� Ƚ�� : " + dice_rolled); 
			System.out.println();
			
			total_dice_rolled += dice_rolled; // �� �ֻ��� ���� Ƚ�� += �� ȸ���� ���� �ֻ��� Ƚ��
			dice_rolled = 0; // �� ȸ���� ������ ȸ���� �ֻ��� Ƚ�� �ʱ�ȭ 
		}
		
		System.out.println("�� ���� �ֻ��� Ƚ�� : " + total_dice_rolled);
		System.out.println("��� �ֻ��� ���� Ƚ�� : " + total_dice_rolled/30);
		
	}

}
