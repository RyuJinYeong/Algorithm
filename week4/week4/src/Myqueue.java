import java.util.LinkedList;


public class Myqueue {
	public static void main(String[] args) {
		LinkedList<Integer> queue1 = new LinkedList<>();
		
		queue1.push(10);
		queue1.push(20);
		queue1.push(30);
		queue1.pop();
		queue1.peek();
		queue1.push(40);
		queue1.push(queue1.pop());
		
		// Display contents of the queue.
		System.out.println("Elements of queue-"+queue1);
		// To remove the head of queue.
		
		LinkedList<MyNode> queue2 = new LinkedList<>();
		
		MyNode tmpNode1=new MyNode(1,"Kim");
		queue2.push(tmpNode1);
		tmpNode1=new MyNode(2,"Lee");
		queue2.push(tmpNode1);
		tmpNode1=new MyNode(3,"Park");
		queue2.push(tmpNode1);
		tmpNode1=new MyNode(4,"Choi");
		queue2.push(tmpNode1);
		
		queue2.pop();
		
		System.out.println("Elements of queue2-"+queue2);
	}
}