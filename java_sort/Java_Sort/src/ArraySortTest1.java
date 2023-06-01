import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class  Fruit implements Comparable<Fruit> {
    private String name;
    private int price;
    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "{name: " + name + ", price: " + price + "}";
    }

    @Override
    public int compareTo( Fruit fruit) {
        return this.price - fruit.price;
    }
}
public class ArraySortTest1 {

	public static void main(String[] args) {
		
		int[] arr = {1, 26, 17, 25, 99, 44, 303};
		Arrays.sort(arr);
		System.out.println("Sorted arr[] : " + Arrays.toString(arr));
		
		//역순정렬
		Integer[] arr1 = {1, 26, 17, 25, 99, 44, 303};
		Arrays.sort(arr1, Collections.reverseOrder());
		System.out.println("Sorted arr[] : " + Arrays.toString(arr1));
		//comparator 사용 Integer을 사용해야 함
		Arrays.sort(arr1, new Comparator<Integer>() {
		    @Override
		    public int compare(Integer i1, Integer i2) {
		        //return i2 - i1;
		    	return i1-i2;
		    }
		});
		System.out.println("Sorted arr[] : " + Arrays.toString(arr1));
		//문자열배열정렬
		String[] arr2 = {"Apple", "Kiwi", "Orange", "Banana", "Watermelon", "Cherry"};
		Arrays.sort(arr2);
		System.out.println("Sorted arr[] : " + Arrays.toString(arr2));
		Arrays.sort(arr2, Collections.reverseOrder());
		System.out.println("Sorted arr[] : " + Arrays.toString(arr2));
		Arrays.sort(arr2, new Comparator<String>() {
		    @Override
		    public int compare(String s1, String s2) {
		        return s1.length() - s2.length();
		    }
		});
		System.out.println("Sorted arr[] : " + Arrays.toString(arr2));
		
		Fruit[] arr3 = {
		        new Fruit("Apple", 100),
		        new Fruit("Kiwi", 500),
		        new Fruit("Orange", 200),
		        new Fruit("Banana", 50),
		        new Fruit("Watermelon", 880),
		        new Fruit("Cherry", 10)
		};

		Arrays.sort(arr3);

		System.out.println("Sorted arr[] : " + Arrays.toString(arr3));
		 for (Fruit num : arr3) {
	            System.out.print(num + " ");
	        }
	}
}
