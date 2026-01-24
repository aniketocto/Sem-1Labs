class ArrayUtilities {
    int[] data;
    int size;

    ArrayUtilities(int size) {
        data = new int[size];
        this.size = size;
    }

    void setData(int[] data) {
        this.data = data;
    }

    int maxArray() {
        int max = data[0];
        for (int i = 0; i < size; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }

    int minArray() {
        int min = data[0];
        for (int i = 0; i < size; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        return min;
    }

    int meanArray() {
        int res = 0;
        for (int i = 0; i < size; i++) {
            res += data[i];
        }
        return (res / size);
    }

    int sdArray() {
        double sd = 0;
        double mean = meanArray();
        for (int i = 0; i < size; i++) {
            sd += Math.pow(data[i] - mean, 2);
        }
        return (int) Math.sqrt(sd / size);
    }
}

public class ArrayUtilTest {
    public static void main(String[] args) {
        ArrayUtilities arrayUtil = new ArrayUtilities(5);
        int[] data = {10, 20, 30, 40, 50};
        arrayUtil.setData(data);

        System.out.println("Maximum: " + arrayUtil.maxArray());
        System.out.println("Minimum: " + arrayUtil.minArray());
        System.out.println("Mean: " + arrayUtil.meanArray());
        System.out.println("Standard Deviation: " + arrayUtil.sdArray());
    }
}
