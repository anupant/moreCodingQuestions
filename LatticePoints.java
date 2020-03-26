// he formula to rotate any pair of points (x,y) clockwise about the origin is (y, -x), 
// and counter-clockwise is (-y, x) .
public class LatticePoints {

	int[] lattice(int ax, int ay, int bx, int by) {
        int dx = bx - ax, dy = by - ay;

        // rotate 90
        int rx = dy, ry = -dx;

        // reduce
        int gcd = Math.abs(gcd(rx, ry));
        rx /= gcd;
        ry /= gcd;
        
        return new int[]{bx + rx, by + ry};
    }

    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
