
public class MidProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dice_rolled = 0;  // 각 회차별 굴린 주사위 횟수
		int total_dice_rolled = 0; // 총 주사위 굴림 횟수
		
		for(int i = 1; i <= 30; i++) { // 전체 게임 횟수 : 30회 반복
			boolean finished = false;  // 각 게임 완주 여부 
			int room_num = 1;  // 출발 방 번호
			
			while(!finished) {  // 100번 방까지 완주시 반복문 종료
				int move = (int)(Math.random() * 5) + 1; // 1~6 난수 생성, 주사위 굴림
				
				//System.out.println("방번호 : " + room_num);
				//System.out.println("주사위 눈 : " + move);
				
				room_num += move;  // 방번호 += 생성된 주사위 눈
				
				dice_rolled++;  // 주사위 굴린 횟수 1 증가
				
				if(room_num == 8) {        // 8번 방일경우
					//System.out.println("8->55 이동");
					room_num = 55;         // 55번 방으로 이동
				}
				else if(room_num == 19) {  // 19번 방일경우
					//System.out.println("19->76 이동");
					room_num = 76;		   // 76번 방으로 이동
				}
				else if(room_num == 32) {  // 32번 방일경우
					//System.out.println("32->92 이동");
					room_num = 92;         // 92번 방으로 이동
				}
				else if(room_num == 56) {  // 56번 방일경우
					//System.out.println("56->4 이동");
					room_num = 4;          // 4번 방으로 이동
				}
				else if(room_num == 88) {  // 88번 방일경우
					//System.out.println("88->33 이동");
					room_num = 33;         // 33번 방으로 이동
				}
				else if(room_num == 97) {  // 97번 방일경우
					//System.out.println("97->59 이동");
					room_num = 59;         // 59번 방으로 이돟
				}
				
				//System.out.println("이동 후 방번호 : " + room_num);
			    //System.out.println("주사위 굴린 횟수 : " + dice_rolled);
				//System.out.println();
				
				if(room_num >= 100) { // 100번방 이상일경우
					finished = true;  // 완주한 것으로 인정 false -> true
				}
			}
			
			System.out.println(i + "회차 주사위 굴림 횟수 : " + dice_rolled); 
			System.out.println();
			
			total_dice_rolled += dice_rolled; // 총 주사위 굴림 횟수 += 각 회차별 굴린 주사위 횟수
			dice_rolled = 0; // 각 회차가 끝나면 회차별 주사위 횟수 초기화 
		}
		
		System.out.println("총 굴린 주사위 횟수 : " + total_dice_rolled);
		System.out.println("평균 주사위 굴림 횟수 : " + total_dice_rolled/30);
		
	}

}
