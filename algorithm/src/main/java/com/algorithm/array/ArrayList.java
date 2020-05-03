package com.algorithm.array;

/**
 * @Description : //动态数组
 * @Author : BETTERME
 *
 */
public class ArrayList {

    private static final int DEFAULT_CAPATITY = 10;

    private int size;

    private int[] elements;

    public ArrayList(int capacity) {
        capacity = (capacity < DEFAULT_CAPATITY ) ? DEFAULT_CAPATITY :capacity ;
        elements = new int[capacity];
    }

    public ArrayList () {
        this(DEFAULT_CAPATITY);
    }

    /**
     * 获取元素数量
     */
    public int size () {

        return size;
    }

    /**
     * 是否为空
     */
    public boolean isEmpty () {

        return size == 0;
    }

    /**
     * 是否包含某个元素
     */
    public boolean contains (int element) {

        for (int i = 0; i < size; i++) {
            if (element == elements[i])
                return true;
        }
        return  false;
    }

    /**
     * 返回index位置对应的元素
     */
    public int get(int index) {
        if (index < 0 || index > size )
            throw new IndexOutOfBoundsException("索引越界");
        return elements[index];
    }

    /**
     * 添加元素都最后面
     */
    public void add (int element) {
        add(size,element);
    }

    /**
     * 添加元素都最后面
     * @param index
     * @param element
     * @return 原来的元素
     */
    public int add (int index, int element) {

        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("索引越界");

        int oldElement = elements[index];
        for (int i = index; i < size + 1; i++) {
            elements[i] = element;
        }
        size++;
        return oldElement;
    }


    public void insert(int index, int element ) {


        for (int i = size ; i >= index  ; i--) {
            elements[i+1] = elements[i];
        }
        elements[index] = element;
        size++;
    }


    /**
     * 删除index位置的元素
     */
    public int remove(int index) {

        if (index < 0 || index > size )
            throw new IndexOutOfBoundsException("索引越界");

        int element = elements[index];

        for (int i = index; i < size; i++) {
            elements[i]  = elements[i+1];
        }

        size--;

        return element;
    }

    /**
     * 查看元素的位置
     */
    public int indexOf(int element) {

        for (int i = 0; i < size; i++) {
            if (element == elements[i])
                return i;
        }
        return -1;
    }

    /**
     * 清除所有元素
     */
    public void clear () {

    }

    public String toString(){

        StringBuffer sb = new StringBuffer();

        sb.append("[");

        for (int i = 0; i < size; i++) {
            if (i!=size-1) {
                sb.append(elements[i] + ",");
            }else {
                sb.append(elements[i]);
            }


        }

        sb.append("]");

        return sb.toString();
    }



    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);


        list.insert(1,15);

        list.remove(2);
        System.out.println(list);

        System.out.println(list.get(5));
    }
}
