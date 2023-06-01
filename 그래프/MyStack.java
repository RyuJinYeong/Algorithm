import java.util.Stack;
import java.util.Iterator;


class MyNode {
	int id;
	String name;
	public MyNode(int id1, String name1) {
		id=id1;
		name=name1;
	}
	public String toString() {
		return "id="+id+" name="+name;
	}
}
public class MyStack {
	public static void main(String[] args) {
		Stack<Integer> stack1 = new Stack<>();
		
		stack1.push(10);
		stack1.push(20);
		stack1.push(30);
		stack1.pop();
		stack1.peek();
		stack1.push(stack1.pop());
		
		
		Stack<MyNode> stack2 = new Stack<>();
		//stack2.peek();
		MyNode tmpNode1=new MyNode(1,"Kim");
		stack2.push(tmpNode1);
		tmpNode1=new MyNode(2,"Lee");
		stack2.push(tmpNode1);
		tmpNode1=new MyNode(3,"Park");
		stack2.push(tmpNode1);
		tmpNode1=new MyNode(4,"Choi");
		stack2.push(tmpNode1);
		for(MyNode s : stack2) {
			System.out.println("s="+s);
		}
		
		System.out.println("Iterator ");
		Iterator iter =stack2.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next()+" ");
		}
		System.out.println();
		System.out.println(stack2.pop());
		System.out.println("size of stack="+stack2.size());
		for(int i=0;i<stack2.size();i++) {
			System.out.println(i+" "+stack2.pop());
		}
	};
}
