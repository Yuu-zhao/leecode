public class NumWaterBottles1518 {
    public static void main(String[] args) {
        System.out.println(numWaterBottles(9, 3));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        while (numBottles >= numExchange) {
            res += numBottles / numExchange;
            numBottles = (numBottles % numExchange) + (numBottles / numExchange);
        }
        return res;
    }
}
