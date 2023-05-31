package HomeWork2;

public class Test2HW {
    public static void main(String[] args) {
        MyLinkedList<String> mas = new MyLinkedList<>();
        mas.add("132a");
        mas.add("d1");
        mas.add("1", 0);
        mas.remove(0);
        System.out.println(mas);
        System.out.println(mas.get(1));
    }
}
