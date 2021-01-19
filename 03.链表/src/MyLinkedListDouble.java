/**
 * 双向链表
 * */
public class MyLinkedListDouble<E> extends CommonParent<E> {

    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        return getNode(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> oldNode = getNode(index);
        E oldElement = oldNode.element;
        oldNode.element = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == size) { // 往尾结点添加元素
            Node<E> oldLast = last;
            last = new Node<>(element, oldLast, null);
            if (oldLast == null) { // 添加的第一个元素
                first = last;
            } else {
                oldLast.next = last;
            }
        } else {
            Node<E> nextNode = getNode(index);
            Node<E> prevNode = nextNode.prev;
            Node<E> node = new Node<>(element, prevNode, nextNode);
            if (prevNode == null) { // 往首节点添加元素
                first = node;
            } else {
                prevNode.next = node;
            }
            nextNode.prev = node;
        }
    }

    @Override
    public E remove(int index) {
        Node<E> oldNode = getNode(index);
        Node<E> prevNode = oldNode.prev;
        Node<E> nextNode = oldNode.next;
        if (prevNode == null) { // 删除的是首节点
            first = nextNode;
        } else {
            prevNode.next = nextNode;
        }
        if (nextNode == null) { // 删除的是尾结点
            last = prevNode;
        } else {
            nextNode.prev = prevNode;
        }
        size--;
        return oldNode.element;
    }

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

    private Node<E> getNode(int index) {
        rangeCheck(index);
        if (index < (size >> 1)) {
            // 前半部分
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            // 后半部分
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }
}
