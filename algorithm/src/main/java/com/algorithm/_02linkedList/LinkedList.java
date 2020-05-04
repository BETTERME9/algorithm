package com.algorithm._02linkedList;

import com.algorithm.utils.AbstractList;

/**
 * @Description : //链表
 * @Author : BETTERME
 */
public class LinkedList<E> extends AbstractList<E> {

    private Node<E> first;


    /**
     * 构造函数
     * @param <E>
     */
    public class Node<E> {
        E element;
        Node<E> next;
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    /**
     * 清除链表
     */
    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    /**
     * 获取index位置元素
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        return node(index).element;
    }

    /**
     * 修改index位置值
     * @param index
     * @param element
     * @return
     */
    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    /**
     * 在指定位置添加值
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == 0) {

            first = new Node<E>(element,first);
        }else {
            //获取index位置前面位置的值
            Node<E> prev = node(index - 1);
            //创建新节点
            Node<E> node = new Node<>(element, prev.next);

            //上一个节点的next指向新节点
            prev.next = node;
        }
        size++;

    }

    /**
     * 删除指定位置元素
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = first;
        if (index == 0) {
            first = first.next;
        }else {
            Node<E> prev = node(index-1);
            node = prev.next;
            prev.next = node.next;
        }
        size--;
        return node.element;
    }

    /**
     * 返回指定元素位置索引
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {
        if (element == null) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;

                node = node.next;
            }
        } else {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;

                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 获取index位置节点对象
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        rangeCheck(index);

        //找到index节点的位置,必须要从first节点开始,index传了几,就要next几次
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(node.element);

            node = node.next;
        }
        string.append("]");
        return string.toString();
    }
}
