package com.xiaowei.datastruct.heap;

/**
 * @author weiguowei
 * @date 2023.12.14 15:48
 * 使用floyd算法 建立大顶堆，时间复杂度为O(n)
 * 算法描述：1.找到最后一个非叶子借点
 * 2.从后向前，对每个节点进行下潜
 */
public class MaxHeap {
    //数组存储元素
    public int[] array;

    //数组内的元素个数
    public int size;

    /**
     * 构造方法
     *
     * @param capacity 堆的容量
     */
    public MaxHeap(int capacity) {
        this.array = new int[capacity];
    }


    public MaxHeap(int[] array) {
        this.array = array;
        this.size = array.length;
        heapify();
    }

    /**
     * 建堆算法
     */
    private void heapify() {
        //1.找到最后的非叶子节点（堆大小/2 - 1）适用于索引0为堆顶的堆寻找最后一个非叶子节点
        for (int i = size / 2 - 1; i >= 0; i--) { //从非叶子节点开始，从后向前
            //2.下潜
            down(i);
        }
    }

    /**
     * 移除堆顶元素
     *
     * @return
     */
    private int poll() {
        int top = array[0];
        //交换索引0处的元素和最后一个元素
        swap(0, size - 1);
        //移除最后一个位置的元素
        size--;
        array[size-1] = 0; //help gc
        //对堆顶元素下潜
        down(0);
        return top;
    }

    /**
     * 移除指定索引处的元素
     *
     * @param index
     * @return
     */
    private int poll(int index) {
        int delete = array[index];
        //交换当前位置元素和末尾元素
        swap(index,size-1);
        //删除元素
        size--;
        array[size-1] = 0; //help gc

        //下潜新交换的元素
        down(index);
        return delete;
    }

    /**
     * 获取堆顶元素
     *
     * @return
     */
    private Integer peek() {
        if (size == 0) {
            return null;
        }
        return array[0];
    }

    /**
     * 往堆尾添加元素
     *
     * @param offered
     * @return
     */
    private boolean offer(int offered) {
        if (isFull()) {
            return false;
        }
        up(offered);
        size++;
        return true;
    }

    /**
     * 上浮元素，直到小于父元素或到堆顶
     *
     * @param offered 索引处元素
     */
    private void up(int offered) {
        int child = size; //新增的索引
        while (child > 0) {
            int parent = (child-1) / 2;
            if (array[parent] < offered) {
                array[child] = array[parent];
            }else {
                break;
            }
            child = parent;
        }
        array[child] = offered;
    }

    /**
     * 下潜，与俩孩子中较大的交换，直到没有孩子或者没有孩子比他大
     *
     * @param parent 索引处的元素
     */
    public void down(int parent) {
        //左孩子索引
        int left = parent * 2 + 1;
        int right = left + 1;
        int max = parent;
        if (left < size && array[left] > array[max]) { //有效索引
            max = left;
        }

        if (right < size && array[right] > array[max]) { //有效索引
            max = right;
        }

        if (max != parent) { //找到了更大的孩子
            swap(max, parent);
            down(max);
        }

    }

    /**
     * 交换索引i和j处的元素
     *
     * @param i
     * @param j
     */
    public void swap(int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    /**
     * 替换堆顶元素
     * @param replaced
     */
    public void replace(int replaced){
        array[0] = replaced;
        down(0);
    }

    /**
     * 堆空
     * @return
     */
    private boolean isEmpty() {
        return size == 0;
    }
    /**
     * 堆满
     */
    private boolean isFull() {
        return size == array.length;
    }
}
