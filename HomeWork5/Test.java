package HomeWork5;

public class Test {
    public static void main(String[] args) {
        MyHashSet<String, String> mhm = new MyHashSet<>();
        mhm.add("key1", "value1");
        mhm.add("key2", "value2");
        mhm.add("key3", "value3");
        mhm.add("key4", "value4");
        mhm.add("key5", "value5");
        mhm.add("key6", "value6");
        System.out.println(mhm);
        System.out.println(mhm.get("key3"));
        System.out.println(mhm.remove("key1"));
        System.out.println(mhm.remove("key3"));
        System.out.println(mhm);
        System.out.println(mhm.remove("key6"));
        System.out.println(mhm);
    }
}
