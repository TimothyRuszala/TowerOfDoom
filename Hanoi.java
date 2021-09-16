public class Hanoi {

    private static int[] positions;
    private static double discHeight;
    private static double discWidthDecrement;
    private static int pause;

    public static void drawFrame() {
        StdDraw.line(0.5, 0.1, 0.5, 0.9);
        StdDraw.line(1.5, 0.1, 1.5, 0.9);
        StdDraw.line(2.5, 0.1, 2.5, 0.9);
    }

    public static void shiftDisc(int n, boolean left, int numOfDiscs) {
        int discIndex = numOfDiscs - n;
        StdDraw.setPenColor(0, 0, 0);
        // Erase disc
        StdDraw.filledRectangle(1.5,
                                0.1 + discHeight / 2 + (discIndex * discHeight),
                                1.5, discHeight / 2);
        StdDraw.setPenColor(255, 255, 255);
        drawFrame(); // To cover what was erased when clearing disc
        // Update disc position
        if (!left) {
            positions[discIndex] = (positions[discIndex] + 1) % 3;
        }
        else {
            positions[discIndex] = (positions[discIndex] + 2) % 3;
        }

        // Draw disc in new position
        switch (positions[discIndex]) {
            case 0:
                StdDraw.filledRectangle(0.5,
                                        0.1 + discHeight / 2 +
                                                (discIndex * discHeight),
                                        0.45 - (discIndex * discWidthDecrement),
                                        discHeight / 2);
                break;
            case 1:
                StdDraw.filledRectangle(1.5,
                                        0.1 + discHeight / 2 +
                                                (discIndex * discHeight),
                                        0.45 - (discIndex * discWidthDecrement),
                                        discHeight / 2);
                break;
            case 2:
                StdDraw.filledRectangle(2.5,
                                        0.1 + discHeight / 2 +
                                                (discIndex * discHeight),
                                        0.45 - (discIndex * discWidthDecrement),
                                        discHeight / 2);
                break;
            default:
                StdOut.println("Something went wrong: " + discIndex);
        }
        StdDraw.show();
        StdDraw.pause(pause);
    }

    // recursive function solving the Towers of Hanoi problem
    public static void moves(int n, boolean left, int numOfDiscs) {
        if (n == 0) return;
        moves(n - 1, !left, numOfDiscs);
        if (left) {
            StdOut.println(n + " left");
            shiftDisc(n, left, numOfDiscs);
        }
        else {
            StdOut.println(n + " right");
            shiftDisc(n, left, numOfDiscs);
        }
        moves(n - 1, !left, numOfDiscs);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        pause = Integer.parseInt(args[1]);
        positions = new int[n];

        // Set up black canvas
        StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);

        // Set up StdDraw
        StdDraw.setPenColor(255, 255, 255);
        StdDraw.setXscale(0, 3);
        StdDraw.enableDoubleBuffering();

        // Set up tower frame
        drawFrame();
        StdDraw.line(0.0, 0.1, 3.0, 0.1);


        // Set up initial disc positions
        discHeight = 0.7 / n;
        // This allows us to guarantee 0.1 width for top, with bottom starting
        // at 0.9 width.
        discWidthDecrement = 0.8 / n / 2;
        for (int i = 0; i < n; i++) {
            StdDraw.filledRectangle(0.5,
                                    0.1 + (discHeight / 2) + (i * discHeight),
                                    0.45 - (discWidthDecrement * i),
                                    discHeight / 2);
        }
        StdDraw.show();
        StdDraw.pause(pause);

        moves(n, true, n);
    }
}
