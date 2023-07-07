package linkedListTest;

import com.xiaowei.datastruct.linkedList.SinglyLinkedList;
import org.junit.Test;


public class SinglyLinkedListTest {

    @Test
    public void test1(){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        list.loopByWhile(System.out::println);
    }

    @Test
    public void test2(){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        list.loopByFor(System.out::println);
    }

    @Test
    public void test3(){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Test
    public void test4(){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Test
    public void test5(){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        System.out.println(list.get(3));
    }

    @Test
    public void test6(){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.insert(4,5);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Test
    public void test7(){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.removeFirst();
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println("====================");

        list.removeFirst();
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println("====================");

        list.removeFirst();
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println("====================");

        list.removeFirst();
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println("====================");
    }


    @Test
    public void test8(){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.remove(0);
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println("===========");

        list.remove(1);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
