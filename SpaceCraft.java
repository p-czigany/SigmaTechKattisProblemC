public class SpaceCraft {
    private Position position;
    private double radius;
    private Speed speed;

    public SpaceCraft(double x, double y, double z, double r, double vx, double vy, double vz) {
        this.position = new Position(x, y, z);
        this.radius = r;
        this.speed = new Speed(vx, vy, vz);
    }

    public void move(double timeElapsed) {
        this.position = new Position(position.getX() + speed.getVx() * timeElapsed, position.getY() + speed.getVy() * timeElapsed, position.getZ() + speed.getVz() * timeElapsed);
    }

    public Position getPosition() {
        return this.position;
    }

    public double getRadius() {
        return radius;
    }

    public Speed getSpeed() {
        return speed;
    }
}
