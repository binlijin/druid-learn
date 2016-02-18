
// https://en.wikipedia.org/wiki/Duff%27s_device
// http://stackoverflow.com/questions/514118/how-does-duffs-device-work
// PooledTopNAlgorithm
public class TestDuff {

    public void test1() {
        int[] myArray = new int[100];
        for (int i = 0; i < 100; i++) {
            myArray[i] += 1;
        }
    }

    public void test2() {
        int[] myArray = new int[100];
        for (int i = 0; i < 100; i += 10) {
            myArray[i] += 1;
            myArray[i+1] += 1;
            myArray[i+2] += 1;
            myArray[i+3] += 1;
            myArray[i+4] += 1;
            myArray[i+5] += 1;
            myArray[i+6] += 1;
            myArray[i+7] += 1;
            myArray[i+8] += 1;
            myArray[i+9] += 1;
        }
    }

    public static void main(String[] args) {
        TestDuff duff = new TestDuff();
        long start = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            duff.test1();
        }
        long end = System.nanoTime();
        System.out.println("Test1 cost " + (end - start));
    }

}
