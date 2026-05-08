package com.narxoz.rpg.artifact;

public class WeightCalculator implements ArtifactVisitor {

    private int totalWeight;

    public int getTotalWeight() {
        return totalWeight;
    }

    @Override
    public void visit(Weapon weapon) {
        addWeight("Weapon", weapon.getName(), weapon.getWeight());
    }

    @Override
    public void visit(Potion potion) {
        addWeight("Potion", potion.getName(), potion.getWeight());
    }

    @Override
    public void visit(Scroll scroll) {
        addWeight("Scroll", scroll.getName(), scroll.getWeight());
    }

    @Override
    public void visit(Ring ring) {
        addWeight("Ring", ring.getName(), ring.getWeight());
    }

    @Override
    public void visit(Armor armor) {
        addWeight("Armor", armor.getName(), armor.getWeight());
    }

    private void addWeight(String type, String name, int weight) {
        totalWeight += weight;
        System.out.println("[WeightCalculator] " + type + ": " + name
                + " | weight: " + weight
                + " | running total: " + totalWeight);
    }
}