package aflevering4;


public class TestStdDraw {
    public static void main(String[] args) {
        StdDraw.setXscale(0, 5);
        StdDraw.setYscale(5, 0);
        StdDraw.setPenRadius(20.0/1000);
        StdDraw.point(0, 0);
        StdDraw.filledRectangle(1, 2, 1,1);
    }
}