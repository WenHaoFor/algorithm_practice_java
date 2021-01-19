import org.w3c.dom.Node;

public class MyLinkedListCircle<E> extends CommonParent<E> {

    private Node<E> first;

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void clear() {
        first = null;
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
        if (index == 0) {
            first = new Node<>(element, first);
            // 拿到最后一个结点
            Node<E> lastNode = (size == 0) ? first : getNode(size - 1);
            lastNode.next = first;
        } else {
            Node<E> prevNode = getNode(index - 1);
            prevNode.next = new Node<>(element, prevNode.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> oldNode = first;
        if (index == 0) {
            if (size == 0) {
                first = null;
            } else {
                first = first.next;
                Node<E> lastNode = getNode(size - 1);
                lastNode.next = first;
            }
        } else {
            Node<E> prevNode = getNode(index - 1);
            oldNode = prevNode.next;
            prevNode.next = oldNode.next;
        }
        size--;
        return oldNode.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                node = node.next;
                if (node.element == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                node = node.next;
                if (element.equals(node.element)) return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    private Node<E> getNode(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}
