import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class ProblemC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int numberOfTests = sc.nextInt();
            if (numberOfTests < 1 || numberOfTests > 500)
                throw new IllegalArgumentException("Number of tests is not valid!");
            for (int i = 0; i < numberOfTests; i++) {
                double x1 = sc.nextInt();
                double y1 = sc.nextInt();
                double z1 = sc.nextInt();
                double r1 = sc.nextInt();
                double vx1 = sc.nextInt();
                double vy1 = sc.nextInt();
                double vz1 = sc.nextInt();

                double x2 = sc.nextInt();
                double y2 = sc.nextInt();
                double z2 = sc.nextInt();
                double r2 = sc.nextInt();
                double vx2 = sc.nextInt();
                double vy2 = sc.nextInt();
                double vz2 = sc.nextInt();

                SpaceCraft spaceCraft1 = new SpaceCraft(x1, y1, z1, r1, vx1, vy1, vz1);
                SpaceCraft spaceCraft2 = new SpaceCraft(x2, y2, z2, r2, vx2, vy2, vz2);

                double currentTime = 0;
                double oldDistance;
                double newDistance = distance(spaceCraft1, spaceCraft2);
                double timeElapsed = 0.001;
                while (true) {
                    currentTime += timeElapsed;
                    spaceCraft1.move(timeElapsed);
                    spaceCraft2.move(timeElapsed);
                    oldDistance = newDistance;
                    newDistance = distance(spaceCraft1, spaceCraft2);
                    if (newDistance > oldDistance) {
                        System.out.println("No collision");
                        break;
                    } else if (newDistance <= 0) {
                        System.out.printf("%.3f%n", currentTime);
                        break;
                    }
                }
            }
        }
    }

    public static double distance(SpaceCraft spaceCraft1, SpaceCraft spaceCraft2) {
        double distanceOfCenters = sqrt((pow(spaceCraft2.getPosition().getX() - spaceCraft1.getPosition().getX(), 2) +
                pow(spaceCraft2.getPosition().getY() - spaceCraft1.getPosition().getY(), 2) +
                pow(spaceCraft2.getPosition().getZ() - spaceCraft1.getPosition().getZ(), 2)));
        double radii = spaceCraft1.getRadius() + spaceCraft2.getRadius();
        return distanceOfCenters - radii;
    }
}
