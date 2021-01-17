import java.util.Arrays;

@SuppressWarnings("unchecked")
public class MyArrayList<E> extends CommonParent<E> {

    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENTS_NOT_FOUND = -1;

    public MyArrayList(int capacity) {
        capacity = Math.max(capacity, DEFAULT_CAPACITY);
        elements = (E[]) new Object[capacity];
    }

    public MyArrayList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public void add(int index, E element) {
        // 基本思路：先将要添加位置后面的元素依次往后移，然后再插入要添加的元素
        // 1、判断是否越界
        rangeCheckForAdd(index);
        // 2、确保容量
        ensureCapacity(size + 1);
        // 3. 添加
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    public E remove(int index) {
        // 基本思路：将要添加位置后面的元素依次往前移，然后将最后一位置为null
        rangeCheck(index);
        E oldElement = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        size --;
        elements[size] = null;
        return oldElement;
    }

    public int indexOf(E element) {
        // 基本思路：将null和其他类型分开
        if (element == null) {
            // 找到第一个为null的元素
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) return i;
            }
        }
        return ELEMENTS_NOT_FOUND;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    private void ensureCapacity(int minCapacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= minCapacity) return;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println("扩容前：" + oldCapacity + "，扩容后：" + newCapacity);
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}
