public class Pair{
    public Pair(int repeatNum, int countVal) {
        this.repeatNum = repeatNum;
        this.countVal = countVal;
    }
    private int repeatNum;
    private int countVal;

    @Override
    public String toString() {
        return "val is: " + repeatNum + " with count of " + countVal;
    }
}