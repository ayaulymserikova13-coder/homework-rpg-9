package com.narxoz.rpg.artifact;

public class CurseDetector implements ArtifactVisitor {

    private int cursedCount;

    public int getCursedCount() {
        return cursedCount;
    }

    @Override
    public void visit(Weapon weapon) {
        boolean cursed = weapon.getAttackBonus() >= 8;
        report(weapon.getName(), cursed, "high attack power may be blood-bound");
    }

    @Override
    public void visit(Potion potion) {
        boolean cursed = potion.getHealing() < 10;
        report(potion.getName(), cursed, "weak potion may be unstable");
    }

    @Override
    public void visit(Scroll scroll) {
        boolean cursed = scroll.getSpellName().toLowerCase().contains("shadow");
        report(scroll.getName(), cursed, "shadow magic detected");
    }

    @Override
    public void visit(Ring ring) {
        boolean cursed = ring.getMagicBonus() >= 7;
        report(ring.getName(), cursed, "strong ring magic may drain mana");
    }

    @Override
    public void visit(Armor armor) {
        boolean cursed = armor.getWeight() > 15;
        report(armor.getName(), cursed, "heavy armor may slow time around the hero");
    }

    private void report(String artifactName, boolean cursed, String reason) {
        if (cursed) {
            cursedCount++;
            System.out.println("[CurseDetector] WARNING: " + artifactName + " may be cursed — " + reason + ".");
        } else {
            System.out.println("[CurseDetector] Safe: " + artifactName + " shows no dangerous curse.");
        }
    }
}