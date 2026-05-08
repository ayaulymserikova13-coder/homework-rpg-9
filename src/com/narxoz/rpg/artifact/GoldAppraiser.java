package com.narxoz.rpg.artifact;

public class GoldAppraiser implements ArtifactVisitor {

    private int totalValue;

    public int getTotalValue() {
        return totalValue;
    }

    @Override
    public void visit(Weapon weapon) {
        int price = weapon.getValue() + weapon.getAttackBonus() * 12;
        totalValue += price;
        System.out.println("[GoldAppraiser] Weapon: " + weapon.getName()
                + " | attack bonus: +" + weapon.getAttackBonus()
                + " | estimated value: " + price + " gold");
    }

    @Override
    public void visit(Potion potion) {
        int price = potion.getValue() + potion.getHealing() * 4;
        totalValue += price;
        System.out.println("[GoldAppraiser] Potion: " + potion.getName()
                + " | healing: +" + potion.getHealing()
                + " | estimated value: " + price + " gold");
    }

    @Override
    public void visit(Scroll scroll) {
        int price = scroll.getValue() + scroll.getSpellName().length() * 3;
        totalValue += price;
        System.out.println("[GoldAppraiser] Scroll: " + scroll.getName()
                + " | spell: " + scroll.getSpellName()
                + " | estimated value: " + price + " gold");
    }

    @Override
    public void visit(Ring ring) {
        int price = ring.getValue() + ring.getMagicBonus() * 15;
        totalValue += price;
        System.out.println("[GoldAppraiser] Ring: " + ring.getName()
                + " | magic bonus: +" + ring.getMagicBonus()
                + " | estimated value: " + price + " gold");
    }

    @Override
    public void visit(Armor armor) {
        int price = armor.getValue() + armor.getDefenseBonus() * 10;
        totalValue += price;
        System.out.println("[GoldAppraiser] Armor: " + armor.getName()
                + " | defense bonus: +" + armor.getDefenseBonus()
                + " | estimated value: " + price + " gold");
    }
}