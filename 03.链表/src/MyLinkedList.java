public class MyLinkedList<E> extends CommonParent<E> {

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
        Node<E> old = getNode(index);
        E oldElement = old.element;
        old.element = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == 0) {
            first = new Node<>(element, first);
        } else {
            Node<E> preNode = getNode(index - 1);
            preNode.next = new Node<>(element, preNode.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        Node<E> removeNode = first;
        if (index == 0) {
            first = first.next;
        } else {
            Node<E> preNode = getNode(index - 1);
            removeNode = preNode.next;
            preNode.next = preNode.next.next;
        }
        size--;
        return removeNode.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MyLinkedList{");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                builder.append(", ");
            }
            builder.append(node.element);
            node = node.next;
        }
        builder.append("}");
        return builder.toString();
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
