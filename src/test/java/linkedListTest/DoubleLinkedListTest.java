package linkedListTest;

import com.xiaowei.datastruct.linkedList.DoubleLinkedList;
import org.junit.Test;

public class DoubleLinkedListTest {
    @Test
    public void test1() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.addFirst(0);
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        list.loopByWhile(System.out::println);
    }


    @Test
    public void test2() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.addFirst(0);
        list.insert(1, 1);
        list.insert(2, 2);

        list.loopByFor(System.out::println);
    }

    @Test
    public void test3() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Test
    public void test4() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
    }

    @Test
    public void test5() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.removeFirst();
        for (Integer integer : list) {
            System.out.println(integer);
        }

        System.out.println("-----");
        list.removeFirst();
        for (Integer integer : list) {
            System.out.println(integer);
        }

        System.out.println("-----");
        list.removeFirst();
        for (Integer integer : list) {
            System.out.println(integer);
        }

        System.out.println("-----");
        list.removeFirst();
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Test
    public void test6() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.remove(0);
        for (Integer integer : list) {
            System.out.println(integer);
        }

        list.remove(2);
        for (Integer integer : list) {
            System.out.println(integer);
        }

        list.remove(1);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

}
