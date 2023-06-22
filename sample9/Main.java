package sample9;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        LinkedList num = new LinkedList();

        num.addFirst(30);
        num.addFirst(20);
        num.addFirst(10);

     //   System.out.println(num.node(0));

        num.addLast(74);
        num.addLast(22);
        num.addLast(80);

        num.add(3,90);

        System.out.println(num);
        System.out.println(num.removeFirst());

        System.out.println(num);
        System.out.println(num.remove(3));
        System.out.println(num);

        System.out.println(num.removeLast());
        System.out.println(num);
    }
}
