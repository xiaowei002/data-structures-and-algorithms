package linkedListTest;

import com.xiaowei.datastruct.linkedList.CircularLinkedList;
import org.junit.Test;

/**
 * 双向循环链表测试
 */
public class CircularLinkedListTest {

    @Test
    public void test1(){
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);

        list.loopByWhile(System.out::println);
        System.out.println("---------");
        list.loopByFor(System.out::println);
    }

    @Test
    public void test2(){
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.addLast(5);
        list.addFirst(1);
        list.insert(1,2);
        list.insert(2,3);
        list.insert(0,4);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }


    @Test
    public void test3(){
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.addFirst(0);
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        System.out.println(list.get(0));
        for (Integer integer : list) {
            System.out.println(integer);
        }
        list.removeFirst();
        System.out.println("-============");
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Test
    public void test4(){
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.addFirst(0);
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);

        list.remove(5);
        for (Integer integer : list) {
            System.out.println(integer);
        }

        list.remove(2);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
