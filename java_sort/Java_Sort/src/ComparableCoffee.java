import java.util.Arrays;
import java.util.Collections;

class Coffee implements Comparable<Coffee> {
    private String name;
    private int price;

    public Coffee(String name, int age){
        this.name = name;
        this.price= age;
    }

    public String print(){
        return this.name+"("+this.price+"원)";
    }

    @Override
    public int compareTo(Coffee coffee) {
        // TODO Auto-generated method stub
        if (this.price < coffee.price) {
            return -1;
        } else if (this.price == coffee.price) {
            return 0;
        } else {
            return 1;
        }
    }
}

public class ComparableCoffee{
    public static void main(String[] args)  {
        Coffee[] arr = { new Coffee("아메리카노", 4000)
                , new Coffee("라떼", 4500)
                , new Coffee("아포가토", 6000)
                , new Coffee("아이스티", 3000)
                , new Coffee("허니브레드", 8000)};

        Arrays.sort(arr); //오름차순 정렬

        for (Coffee i : arr) {
            System.out.print(i.print()+" ");
        }

        Arrays.sort(arr,Collections.reverseOrder()); //내림차순 정렬
        System.out.println();

        for (Coffee i : arr) {
            System.out.print(i.print()+" ");
        }
    }
}