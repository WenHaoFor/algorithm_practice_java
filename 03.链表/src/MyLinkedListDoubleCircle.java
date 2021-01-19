/**
 * 双向循环链表
 * */
public class MyLinkedListDoubleCircle<E> extends CommonParent<E> {

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
        //
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == size) { // 添加到尾节点
            Node<E> oldLastNode = last;
            Node<E> newOldNode = new Node<>(element, oldLastNode, first);
            if (oldLastNode == null) { // 添加的首个元素
                first = last = newOldNode;
                first.prev = first;
                first.next = first;
            } else {
                oldLastNode.next = newOldNode;
                first.prev = newOldNode;
            }
        } else {
            Node<E> nextNode = getNode(index);
            Node<E> prevNode = nextNode.prev;
            Node<E> node = new Node<>(element, prevNode, nextNode);
            prevNode.next = node;
            nextNode.prev = node;
            if (nextNode == prevNode) { // 添加到头结点
                first = node;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        // index == 0、index == size - 1，
        Node<E> oldNode = getNode(index);
        if (oldNode.prev == oldNode.next) { // 只有一个元素
            first = last = null;
        } else {
            Node<E> nextNode = oldNode.next;
            Node<E> prevNode = oldNode.prev;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            if (oldNode == first) {
                first = nextNode;
            }
            if (oldNode == nextNode) {
                last = prevNode;
            }
        }
        size--;
        return oldNode.element;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    private Node<E> getNode(int index) {
        rangeCheck(index);
        if (index < (size >> 1)) {
            // 从前往后查找
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            // 从后往前查找
            Node<E> node = last;
            for (int i = size - 1; i < index; i--) {
                node = node.prev;
            }
            return node;
        }
    }
}
