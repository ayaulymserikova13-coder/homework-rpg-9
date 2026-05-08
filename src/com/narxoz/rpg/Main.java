package com.narxoz.rpg;

import com.narxoz.rpg.artifact.Inventory;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.Weapon;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        System.out.println("=== Homework 9 Demo: Visitor + Memento ===");

        Inventory armanInventory = new Inventory();
        armanInventory.addArtifact(new Weapon("Training Sword", 25, 5, 3));

        Inventory danaInventory = new Inventory();
        danaInventory.addArtifact(new Potion("Small Mana Tonic", 20, 1, 6));

        Hero arman = new Hero("Arman", 100, 40, 18, 8, 60, armanInventory);
        Hero dana = new Hero("Dana", 80, 65, 12, 5, 95, danaInventory);

        ChronomancerEngine engine = new ChronomancerEngine();
        VaultRunResult result = engine.runVault(List.of(arman, dana));

        System.out.println();
        System.out.println("--- Final VaultRunResult ---");
        System.out.println(result);
    }
}
