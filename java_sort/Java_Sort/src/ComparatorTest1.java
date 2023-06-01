
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Node {
	String name;
	int age;

	public Node(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

}

class sortByName implements Comparator<Node> {
	@Override
	public int compare(Node o1, Node o2) {
		return o1.name.compareTo(o2.name);
	}
}

public class ComparatorTest1 {

	public static void main(String[] args) {
		ArrayList<Node> list = new ArrayList<>();

		list.add(new Node("Tommy", 25));
		list.add(new Node("Jenny", 17));
		list.add(new Node("Army", 30));

		Collections.sort(list, new sortByName());

		for (Node node : list) {
			System.out.println("(" + node.name + "," + node.age + ")");
		}
	}
}