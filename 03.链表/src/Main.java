public class Main {
    public static void main(String[] args) {
        MyLinkedList<Object> list = new MyLinkedList<>();
        list.add(123);
        list.add("Jack");
        System.out.println(list);
        System.out.println(list.indexOf("Jack"));
    }
}
