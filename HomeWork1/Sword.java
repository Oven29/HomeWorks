package HomeWork1;

public class Sword<Material extends Metal> {
    public boolean strengthCheck(Material material) {
        return material.getEndurance() > 49;
    }
}
