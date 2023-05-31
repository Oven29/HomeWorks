package HomeWork1;

public class Sword<Material extends Metal> {
    public boolean proverka(Material material) {
        return material.getEndurance() > 49;
    }
}
