// Integer version
class TreeNode {
	int key;
	TreeNode left;
	TreeNode right;
}

class BinarySearchTree {
	
	TreeNode rootNode;
	
	private TreeNode insertKey(TreeNode T, int x) { // insert()메소드에 의해 사용되는 보조 순환 메소드
		if (T == null) {
			TreeNode newNode = new TreeNode();
			newNode.key = x;
			return newNode;
		} 
		else if (x < T.key) { // x < T.key이면 x를
			T.left = insertKey(T.left, x); // T의 왼쪽 서브트리에 삽입
			return T;
		} 
		else if (x > T.key) { // x > T.key이면 x를
			T.right = insertKey(T.right, x); // T의 오른쪽 서브트리에 삽입
			return T;
		} 
		else { // key값 x가 이미 T에 있는 경우
			return T;
		}
	}
	TreeNode deleteKey(TreeNode T, int x) {
		TreeNode p; // 임시 주소 변소 현재 방문한 노드
		TreeNode parent; // 아버지
		TreeNode q;
		
		p = T;
		parent = null;
		while(p != null && p.key != x) {
			parent = p; // 현재 노드를 저장. 아버지가 됨.
			if(x < p.key) {
				p = p.left;
			}
			else {
				p = p.right;
			}
		}
		if(p == null) { 
			return null;
		} // 삭제할 원소를 발견하지 못함
		
		// 삭제할 원소가 발견되었음 
		// 1. 현재노드가 자식이 없음
		if(p.left == null && p.right == null) { // 왼쪽, 오른쪽 자식 없음
			if(parent == null) { // 루트를 삭제하려 할 때
				T = null;
			}
			else if(parent.left == p) { 
				parent.left = null; 
			}
			else { 
				parent.right = null;
			}	
		}
		
		// 2. 현재 삭제하려는 노드의 자식이 하나 있을때
		else if(p.left == null || p.right == null) { // 자식이 하나 있을 때
			if(p.left != null) { // 왼쪽에 자식이 있음. 오른쪽에 없음
				if(parent.left == p) { 
					parent.left = p.left;
				}
				else {
					parent.right = p.left;
				}
			}
			else { // 오른쪽에 자식이 있음. 왼쪽에 없음
				if(parent.left == p) { 
					parent.left = p.right;
				}
				else {
					parent.right = p.right;
				}
			}
		}
		
		// 3. 현재 삭제하려는 노드가 자식이 두 개 있을 때
		else if (p.left != null && p.right != null) {
//			q = maxNode(p.left);
//			deleteKey(p.left, p.key);
//			p.key = q.key;
			
			q = minNode(p.right);
			deleteKey(p.right, p.key);
			p.key = q.key;
			p.right = q.right;
		}
		return T;
	}
	
	TreeNode maxNode(TreeNode B) { // 서브트리의 최대 원소를 리턴
		TreeNode p;
		p = B;
		if (p == null) {
			return p;
		}
		else if (p.right == null) {
			return p;
		}
		else {
			while (p.right != null) {// 오른쪽으로 계속 내려간다.
				p = p.right;
			}
			return p;
		}
	}
	
	TreeNode minNode(TreeNode B) { // 서브트리의 최소 원소를 리턴
		TreeNode p;
		p = B;
		if (p == null) {
			return p;
		}
		else if (p.left == null) {
			return p;
		}
		else {
			while (p.left != null) { // 왼쪽으로 계속 내려간다.
				p = p.left;
			}
			return p;
		}
	}
	
	void insert(int x) {
		rootNode = insertKey(rootNode, x);
	}
	
	private void printNode(TreeNode N) { // printBST() 메소드에 의해 사용되는 순환 메소드
		if (N != null) {
			System.out.print("(");
			printNode(N.left);
			System.out.print(N.key); // 중위순회방식으로 출력
			printNode(N.right);
			System.out.print(")");
		}
	} // 출력 보조 끝
	
	void delete(int x) {
		rootNode = deleteKey(rootNode,x);
	}
	
	void printBST() { // 트리를 괄호를 사용하여 출력
		printNode(rootNode);
		System.out.println();
	} // 출력 끝
	
	TreeNode find(int x) {
		TreeNode T = rootNode; // 트리는 루트부터
		//int result;
		while (T != null) {
			//if ((result = x) < T.key) { //왼쪽으로 가라
			if (x < T.key) { //왼쪽으로 가라
				T = T.left;
			} 
			else if (T.key==x) { // 찾았음
				
				return T; // 주소값을 리턴
			} 
			else { // 오른쪽으로 가라.
				T = T.right;
			}
		}
		return T;
	}
}

public class BST {

	public static void main(String[] args) {
		
		BinarySearchTree T = new BinarySearchTree();
		T.insert(22);
		T.insert(9);
		T.insert(3);
		T.insert(1);
		T.insert(7);
		T.insert(14);
		T.insert(67);
		T.insert(36);
		T.insert(44);
		T.insert(94);
		T.insert(97);
		
		System.out.println("트리를 출력합니다.");
		T.printBST();
		System.out.println();
		
		System.out.println("트리에 17이 존재하면 탐색 성공");
		if (T.find(17) == null) { 
			System.out.println("탐색 실패");
		}
		else { 
			System.out.println("탐색 성공");
		}
		System.out.println();
		
		System.out.println("트리에 44이 존재하면 탐색 성공");
		if (T.find(44) == null) { 
			System.out.println("탐색 실패");
		}
		else { 
			System.out.println("탐색 성공");
		}
		System.out.println();
		
		System.out.println("트리에 36이 존재하면 탐색 성공");
		if (T.find(36) == null) { 
			System.out.println("탐색 실패");
		}
		else { 
			System.out.println("탐색 성공");
		}
		System.out.println();
		
		T.printBST();
		
		// 삭제
		System.out.println("서브트리 9를 삭제합니다.");
		T.delete(9);
		T.printBST();
		
//		System.out.println("자식이 없는 경우)");
//		System.out.println("서브트리 1를 삭제합니다.");
//		T.delete(1);
//		T.printBST();
		
//		System.out.println("자식이 한 개 있는 경우)");
//		System.out.println("서브트리 36을 삭제합니다.");
//		T.delete(36);
//		T.printBST();
		
	}
}

