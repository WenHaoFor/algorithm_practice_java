public class Main {
    public static void main(String[] args) {
        MyArrayList<Object> list = new MyArrayList(11);
        list.add(1);
        list.add(new Person(10, "Jack"));
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
//        list.remove(0);
        list.set(2, 3);
        System.out.println(list);
        int index = list.indexOf(new Person(10, "Jack"));
        System.out.println(index);
    }
}
