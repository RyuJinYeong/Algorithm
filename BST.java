// Integer version
class TreeNode {
	int key;
	TreeNode left;
	TreeNode right;
}

class BinarySearchTree {
	
	TreeNode rootNode;
	
	private TreeNode insertKey(TreeNode T, int x) { // insert()�޼ҵ忡 ���� ���Ǵ� ���� ��ȯ �޼ҵ�
		if (T == null) {
			TreeNode newNode = new TreeNode();
			newNode.key = x;
			return newNode;
		} 
		else if (x < T.key) { // x < T.key�̸� x��
			T.left = insertKey(T.left, x); // T�� ���� ����Ʈ���� ����
			return T;
		} 
		else if (x > T.key) { // x > T.key�̸� x��
			T.right = insertKey(T.right, x); // T�� ������ ����Ʈ���� ����
			return T;
		} 
		else { // key�� x�� �̹� T�� �ִ� ���
			return T;
		}
	}
	TreeNode deleteKey(TreeNode T, int x) {
		TreeNode p; // �ӽ� �ּ� ���� ���� �湮�� ���
		TreeNode parent; // �ƹ���
		TreeNode q;
		
		p = T;
		parent = null;
		while(p != null && p.key != x) {
			parent = p; // ���� ��带 ����. �ƹ����� ��.
			if(x < p.key) {
				p = p.left;
			}
			else {
				p = p.right;
			}
		}
		if(p == null) { 
			return null;
		} // ������ ���Ҹ� �߰����� ����
		
		// ������ ���Ұ� �߰ߵǾ��� 
		// 1. �����尡 �ڽ��� ����
		if(p.left == null && p.right == null) { // ����, ������ �ڽ� ����
			if(parent == null) { // ��Ʈ�� �����Ϸ� �� ��
				T = null;
			}
			else if(parent.left == p) { 
				parent.left = null; 
			}
			else { 
				parent.right = null;
			}	
		}
		
		// 2. ���� �����Ϸ��� ����� �ڽ��� �ϳ� ������
		else if(p.left == null || p.right == null) { // �ڽ��� �ϳ� ���� ��
			if(p.left != null) { // ���ʿ� �ڽ��� ����. �����ʿ� ����
				if(parent.left == p) { 
					parent.left = p.left;
				}
				else {
					parent.right = p.left;
				}
			}
			else { // �����ʿ� �ڽ��� ����. ���ʿ� ����
				if(parent.left == p) { 
					parent.left = p.right;
				}
				else {
					parent.right = p.right;
				}
			}
		}
		
		// 3. ���� �����Ϸ��� ��尡 �ڽ��� �� �� ���� ��
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
	
	TreeNode maxNode(TreeNode B) { // ����Ʈ���� �ִ� ���Ҹ� ����
		TreeNode p;
		p = B;
		if (p == null) {
			return p;
		}
		else if (p.right == null) {
			return p;
		}
		else {
			while (p.right != null) {// ���������� ��� ��������.
				p = p.right;
			}
			return p;
		}
	}
	
	TreeNode minNode(TreeNode B) { // ����Ʈ���� �ּ� ���Ҹ� ����
		TreeNode p;
		p = B;
		if (p == null) {
			return p;
		}
		else if (p.left == null) {
			return p;
		}
		else {
			while (p.left != null) { // �������� ��� ��������.
				p = p.left;
			}
			return p;
		}
	}
	
	void insert(int x) {
		rootNode = insertKey(rootNode, x);
	}
	
	private void printNode(TreeNode N) { // printBST() �޼ҵ忡 ���� ���Ǵ� ��ȯ �޼ҵ�
		if (N != null) {
			System.out.print("(");
			printNode(N.left);
			System.out.print(N.key); // ������ȸ������� ���
			printNode(N.right);
			System.out.print(")");
		}
	} // ��� ���� ��
	
	void delete(int x) {
		rootNode = deleteKey(rootNode,x);
	}
	
	void printBST() { // Ʈ���� ��ȣ�� ����Ͽ� ���
		printNode(rootNode);
		System.out.println();
	} // ��� ��
	
	TreeNode find(int x) {
		TreeNode T = rootNode; // Ʈ���� ��Ʈ����
		//int result;
		while (T != null) {
			//if ((result = x) < T.key) { //�������� ����
			if (x < T.key) { //�������� ����
				T = T.left;
			} 
			else if (T.key==x) { // ã����
				
				return T; // �ּҰ��� ����
			} 
			else { // ���������� ����.
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
		
		System.out.println("Ʈ���� ����մϴ�.");
		T.printBST();
		System.out.println();
		
		System.out.println("Ʈ���� 17�� �����ϸ� Ž�� ����");
		if (T.find(17) == null) { 
			System.out.println("Ž�� ����");
		}
		else { 
			System.out.println("Ž�� ����");
		}
		System.out.println();
		
		System.out.println("Ʈ���� 44�� �����ϸ� Ž�� ����");
		if (T.find(44) == null) { 
			System.out.println("Ž�� ����");
		}
		else { 
			System.out.println("Ž�� ����");
		}
		System.out.println();
		
		System.out.println("Ʈ���� 36�� �����ϸ� Ž�� ����");
		if (T.find(36) == null) { 
			System.out.println("Ž�� ����");
		}
		else { 
			System.out.println("Ž�� ����");
		}
		System.out.println();
		
		T.printBST();
		
		// ����
		System.out.println("����Ʈ�� 9�� �����մϴ�.");
		T.delete(9);
		T.printBST();
		
//		System.out.println("�ڽ��� ���� ���)");
//		System.out.println("����Ʈ�� 1�� �����մϴ�.");
//		T.delete(1);
//		T.printBST();
		
//		System.out.println("�ڽ��� �� �� �ִ� ���)");
//		System.out.println("����Ʈ�� 36�� �����մϴ�.");
//		T.delete(36);
//		T.printBST();
		
	}
}

