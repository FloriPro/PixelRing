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

    public ImageView getSprite() {
        return this.javafxNode;
    }

    /**
     * Sets the hitbox of the entity
     */
    public void setHitbox(Hitbox h) {
        this.hitbox = h;
    }

    /**
     * Sets the rotation of the entity in degrees
     * 
     * @param r
     */
    public void setRotation(int r) {
        rot = r;

        this.updatePos();
    }

    /**
     * Sets the position of the entity and does <b>not</b> check for collision!
     * 
     * @param x
     * @param y
     */
    public void setPosition(double x, double y) {
        posX = x;
        posY = y;

        this.updatePos();
    }

    /**
     * Sets the sprite of the entity
     * 
     * @param javafxNode
     */
    public void setSprite(ImageView javafxNode) {
        this.javafxNode = javafxNode;
        // TODO add to view
    }

    /**
     * Sets the size of the entity in pixels
     * 
     * @param x
     * @param y
     */
    public void setSize(int x, int y) {
        this.javafxNode.setFitHeight(x);
        this.javafxNode.setFitWidth(y);
    }

    /**
     * Removes the entity from the screen
     */
    public void remove() {
        // TODO remove from view and remove node remove from hitboxstore
    }

    /**
     * Updates the position of the entity on the screen
     */
    public void updatePos() {
        // TODO Set postion relative to camera, thats why we use the view for that
    }

    /**
     * Moves the entity by x and y and checks for collision
     * 
     * @param x
     * @param y
     */
    public void move(double x, double y) {
        posX += x;
        posY += y;

        if (HitboxStore.getInstance().checkCollision(this.getHitbox(), "Wall")) {
            // after moving we are in a wall, so we move back
            posX -= x;
            posY -= y;
        }

        // set Rotation
        rot = (int) Math.toDegrees(Math.atan2(y, x));

        this.updatePos();
    }
}
