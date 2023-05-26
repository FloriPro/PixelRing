import java.util.ArrayList;
import java.util.List;

public class HitboxStore {
    private final static HitboxStore instance = new HitboxStore();

    private List<Hitbox> hitboxes = new ArrayList<Hitbox>();

    /**
     * Private constructor for singleton
     */
    private HitboxStore() {
    }

    /**
     * Returns the only instance of HitboxStore
     * 
     * @return The only instance of HitboxStore
     */
    public static HitboxStore getInstance() {
        return instance;
    }

    /**
     * Adds the given hitbox to the store
     * 
     * @param h The hitbox to add
     */
    public void addHitbox(Hitbox h) {
        hitboxes.add(h);
    }

    /**
     * Removes the given hitbox from the store
     * 
     * @param h The hitbox to remove
     */
    public void removeHitbox(Hitbox h) {
        hitboxes.remove(h);
    }

    /**
     * Removes all hitboxes from the store
     */
    public void clear() {
        hitboxes.clear();
    }

    /**
     * Checks if the given hitbox collides with any hitbox in the store
     * 
     * @param h The hitbox to check for collision
     * @return True if the given hitbox collides with any hitbox in the store, false
     *         otherwise
     */
    public boolean checkCollision(Hitbox h) {
        for (Hitbox hitbox : hitboxes) {
            if (h == hitbox) {
                continue;
            }
            if (h.checkCollision(hitbox)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the given hitbox collides with any hitbox of the given type
     * 
     * @param h    The hitbox to check for collision
     * @param type The type of hitbox to check for collision
     * @return True if the given hitbox collides with any hitbox of the given type,
     *         false otherwise
     */
    public boolean checkCollision(Hitbox h, String type) {
        for (Hitbox hitbox : hitboxes) {
            if (h == hitbox) {
                continue;
            }
            if (hitbox.getType().equals(type)) {
                if (h.checkCollision(hitbox)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns the first hitbox that collides with the given
     * 
     * @param h The hitbox to check for collision
     * @return The first hitbox that collides with the given hitbox or null if no
     *         collision
     */
    public Hitbox getCollider(Hitbox h) {
        for (Hitbox hitbox : hitboxes) {
            if (h == hitbox) {
                continue;
            }
            if (h.checkCollision(hitbox)) {
                return hitbox;
            }
        }
        return null;
    }

    /**
     * Returns the first hitbox of the given type that collides with the given
     * 
     * @param h    The hitbox to check for collision
     * @param type The type of hitbox to check for collision
     * @return The first hitbox of the given type that collides with the given
     *         hitbox or null if no collision
     */
    public Hitbox getCollider(Hitbox h, String type) {
        for (Hitbox hitbox : hitboxes) {
            if (h == hitbox) {
                continue;
            }
            if (hitbox.getType().equals(type)) {
                if (h.checkCollision(hitbox)) {
                    return hitbox;
                }
            }
        }
        return null;
    }
}
