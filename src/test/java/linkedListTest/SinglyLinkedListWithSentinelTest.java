package linkedListTest;

import com.xiaowei.datastruct.linkedList.SinglyLinkedListWithSentinel;
import org.junit.Test;

public class SinglyLinkedListWithSentinelTest {
    @Test
    public void test1(){
        SinglyLinkedListWithSentinel<Integer> sen = new SinglyLinkedListWithSentinel<>();
        sen.addFirst(1);
        sen.addFirst(2);
        sen.addFirst(3);
        sen.addFirst(4);

        sen.loopByWhile(System.out::println);
    }

    @Test
    public void test2(){
        SinglyLinkedListWithSentinel<Integer> sen = new SinglyLinkedListWithSentinel<>();
        sen.addFirst(1);
        sen.addFirst(2);
        sen.addFirst(3);
        sen.addFirst(4);

        sen.loopByFor(System.out::println);
    }

    @Test
    public void test3(){
        SinglyLinkedListWithSentinel<Integer> sen = new SinglyLinkedListWithSentinel<>();
        sen.addFirst(1);
        sen.addFirst(2);
        sen.addFirst(3);
        sen.addFirst(4);

        for (Integer integer : sen) {
            System.out.println(integer);
        }
    }

    @Test
    public void test4(){
        SinglyLinkedListWithSentinel<Integer> sen = new SinglyLinkedListWithSentinel<>();
        sen.addLast(1);
        sen.addLast(2);
        sen.addLast(3);
        sen.addLast(4);

        for (Integer integer : sen) {
            System.out.println(integer);
        }
    }

    @Test
    public void test5(){
        SinglyLinkedListWithSentinel<Integer> sen = new SinglyLinkedListWithSentinel<>();
        sen.addLast(1);
        sen.addLast(2);
        sen.addLast(3);
        sen.addLast(4);

        sen.insert(4,5);
        sen.insert(0,6);
       for (Integer integer : sen) {
            System.out.println(integer);
        }
    }

    @Test
    public void test6(){
        SinglyLinkedListWithSentinel<Integer> sen = new SinglyLinkedListWithSentinel<>();
        sen.addLast(1);
        sen.addLast(2);
        sen.addLast(3);
        sen.addLast(4);

        System.out.println(sen.get(0));
        System.out.println(sen.get(3));
//        System.out.println(sen.get(4));
        System.out.println(sen.get(2));
    }

    @Test
    public void test7(){
        SinglyLinkedListWithSentinel<Integer> sen = new SinglyLinkedListWithSentinel<>();
        sen.addLast(1);
        sen.addLast(2);
        sen.addLast(3);
        sen.addLast(4);



        sen.remove(3);
        sen.loopByWhile(System.out::println);
    }
}
