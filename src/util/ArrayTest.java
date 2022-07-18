package util;

public class ArrayTest {
    public static int[] getIntArray() {
        int[] data = { 1, 2, 2 };
        return data;
    }

    public static void printArray() {
        int[] data = getIntArray();
        for (int i : data) {
            System.out.println(i);
        }
    }
}
