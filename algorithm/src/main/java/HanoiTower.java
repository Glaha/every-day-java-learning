public class HanoiTower {
    public int run(int i) {
        return run(i, 'A', 'B', 'C');
    }

    private int run(int i, char a, char b, char c) {
        int m = 0;
        if (i == 1) {
            System.out.println("1 plate " + a + "->" + c);
            return 1;
        } else {
            //System.out.println("multi plates " + a + "->" + b);
            m = m + run(i - 1, a, c, b);
            System.out.println("1 plate " + a + "->" + c);
            m = m + 1;
            //System.out.println("multi plates " + b + "->" + c);
            m = m + run(i - 1, b, a, c);
        }
        return m;
    }
}
