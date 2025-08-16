import java.util.Scanner;

class Projectile {
    double initialVelocity;
    double angle;

    Projectile(double v, double a) {
        this.initialVelocity = v;
        this.angle = a;
    }
}

public class ProjectileSimulation {

    static final double GRAVITY = 9.81;

    static double calculateRange(double v, double angle) {
        double theta = Math.toRadians(angle);
        return (v * v * Math.sin(2 * theta)) / GRAVITY;
    }

    static void simulateProjectile(Projectile proj) {
        double theta = Math.toRadians(proj.angle);

        double timeOfFlight = (2 * proj.initialVelocity * Math.sin(theta)) / GRAVITY;
        double maxHeight = (proj.initialVelocity * proj.initialVelocity * Math.pow(Math.sin(theta), 2)) / (2 * GRAVITY);
        double range = calculateRange(proj.initialVelocity, proj.angle);

        System.out.printf("Time of flight: %.2f seconds\n", timeOfFlight);
        System.out.printf("Maximum height: %.2f meters\n", maxHeight);
        System.out.printf("Horizontal range: %.2f meters\n", range);

        // Trajectory diagram
        System.out.println("\nProjectile Trajectory:");
        int rows = (int) maxHeight + 5;
        int cols = (int) range + 5;

        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                double x = (range / cols) * j;
                double y = x * Math.tan(theta) - (GRAVITY * x * x) / (2 * proj.initialVelocity * proj.initialVelocity * Math.pow(Math.cos(theta), 2));

                double currentHeight = (maxHeight / rows) * (rows - i);

                if (Math.abs(currentHeight - y) < 0.5) {
                    System.out.print("*"); // projectile path
                } else if (i == rows) {
                    System.out.print("_"); // ground line
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the initial velocity (m/s): ");
        double velocity = sc.nextDouble();

        System.out.print("Enter the launch angle (degrees): ");
        double angle = sc.nextDouble();

        Projectile p = new Projectile(velocity, angle);
        simulateProjectile(p);

        sc.close();
    }
}
