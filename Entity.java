import javafx.scene.image.ImageView;

public class Entity {
    private double posX = 0.0;
    private double posY = 0.0;
    private int rot = 0;
    private Hitbox hitbox;
    private ImageView javafxNode;

    public Entity() {
        // constructor
    }

    public double getPosX() {
        return this.posX;
    }

    public double getPosY() {
        return this.posY;
    }

    public double getRot() {
        return this.rot;
    }

    public Hitbox getHitbox() {
        return this.hitbox;
    }

    public void setHitbox(Hitbox h) {
        this.hitbox = h;
    }

    public void setRotation(int r) {
        rot = r;

        this.updatePos();
    }

    public void setPosition(double x, double y) {
        posX = x;
        posY = y;

        this.updatePos();
    }

    public void setSprite(ImageView javafxNode) {
        this.javafxNode = javafxNode;
        // TODO add to view
    }

    public void setSize(int x, int y) {
        this.javafxNode.setFitHeight(x);
        this.javafxNode.setFitWidth(y);
    }

    public void remove() {
        // TODO remove from view and remove node remove from hitboxstore
    }

    public void updatePos() {
        // TODO Set postion
    }

    public void move(double x, double y) {
        // TODO check collision with walls

        posX += x;
        posY += y;

        // set Rotation
        rot = (int) Math.toDegrees(Math.atan2(y, x));

        this.updatePos();
    }
}
