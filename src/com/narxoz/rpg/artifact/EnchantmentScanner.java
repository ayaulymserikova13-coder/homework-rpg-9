package com.narxoz.rpg.artifact;

public class EnchantmentScanner implements ArtifactVisitor {

    @Override
    public void visit(Weapon weapon) {
        System.out.println("[EnchantmentScanner] " + weapon.getName()
                + " hums with battle energy. Attack aura: +" + weapon.getAttackBonus());
    }

    @Override
    public void visit(Potion potion) {
        System.out.println("[EnchantmentScanner] " + potion.getName()
                + " glows softly. Restorative power: +" + potion.getHealing() + " HP");
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println("[EnchantmentScanner] " + scroll.getName()
                + " contains spell rune: " + scroll.getSpellName());
    }

    @Override
    public void visit(Ring ring) {
        System.out.println("[EnchantmentScanner] " + ring.getName()
                + " bends mana around the wearer. Magic bonus: +" + ring.getMagicBonus());
    }

    @Override
    public void visit(Armor armor) {
        System.out.println("[EnchantmentScanner] " + armor.getName()
                + " carries a protective field. Defense aura: +" + armor.getDefenseBonus());
    }
}