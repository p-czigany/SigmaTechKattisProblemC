public class SpaceCraft {
    Position position;
    double radius;
    Speed speed;

    public SpaceCraft(double x, double y, double z, double r, double vx, double vy, double vz) {
        this.position = new Position(x, y, z);
        this.radius = r;
        this.speed = new Speed(vx, vy, vz);
    }

    public void move(double timeElapsed) {
        this.position = new Position(position.x + speed.vx * timeElapsed, position.y + speed.vy * timeElapsed, position.z + speed.vz * timeElapsed);
    }
}
