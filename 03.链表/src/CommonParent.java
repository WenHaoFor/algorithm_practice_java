public abstract class CommonParent<E> implements ListInterface<E> {
    protected int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    public void add(E element) {
        add(size, element);
    }

    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index：" + index + ", Size：" + size);
    }

    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }

    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }
}
