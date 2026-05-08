package com.narxoz.rpg.vault;

import com.narxoz.rpg.artifact.Armor;
import com.narxoz.rpg.artifact.CurseDetector;
import com.narxoz.rpg.artifact.EnchantmentScanner;
import com.narxoz.rpg.artifact.GoldAppraiser;
import com.narxoz.rpg.artifact.Inventory;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.Ring;
import com.narxoz.rpg.artifact.Scroll;
import com.narxoz.rpg.artifact.Weapon;
import com.narxoz.rpg.artifact.WeightCalculator;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.combatant.HeroMemento;
import com.narxoz.rpg.memento.Caretaker;
import java.util.List;

public class ChronomancerEngine {

    public VaultRunResult runVault(List<Hero> party) {
        System.out.println();
        System.out.println("=== Chronomancer's Vault opens ===");

        if (party == null || party.isEmpty()) {
            System.out.println("No heroes entered the vault.");
            return new VaultRunResult(0, 0, 0);
        }

        System.out.println();
        System.out.println("--- Party enters the vault ---");
        for (Hero hero : party) {
            System.out.println(hero);
        }

        Inventory vaultInventory = buildVaultInventory();

        System.out.println();
        System.out.println("--- Mixed vault inventory prepared ---");
        System.out.println("Artifacts found: " + vaultInventory.size());

        System.out.println();
        System.out.println("--- Visitor appraisal starts ---");

        GoldAppraiser goldAppraiser = new GoldAppraiser();
        EnchantmentScanner enchantmentScanner = new EnchantmentScanner();
        CurseDetector curseDetector = new CurseDetector();

        System.out.println();
        System.out.println("1) Gold appraisal:");
        vaultInventory.accept(goldAppraiser);
        System.out.println("Total estimated value: " + goldAppraiser.getTotalValue() + " gold");

        System.out.println();
        System.out.println("2) Enchantment scan:");
        vaultInventory.accept(enchantmentScanner);

        System.out.println();
        System.out.println("3) Curse detection:");
        vaultInventory.accept(curseDetector);
        System.out.println("Cursed artifacts detected: " + curseDetector.getCursedCount());

        System.out.println();
        System.out.println("4) Open/Closed proof visitor - Weight calculation:");
        WeightCalculator weightCalculator = new WeightCalculator();
        vaultInventory.accept(weightCalculator);
        System.out.println("Total vault weight: " + weightCalculator.getTotalWeight());

        System.out.println();
        System.out.println("--- Visitor appraisal ends ---");

        Hero targetHero = party.get(0);
        Caretaker caretaker = new Caretaker();

        System.out.println();
        System.out.println("--- Memento snapshot phase ---");
        System.out.println("Before snapshot: " + targetHero);

        HeroMemento beforeTrap = targetHero.createMemento();
        caretaker.save(beforeTrap);

        System.out.println("Snapshot saved for " + targetHero.getName());
        System.out.println("Caretaker history size: " + caretaker.size());

        System.out.println();
        System.out.println("--- Vault trap changes hero state ---");
        targetHero.takeDamage(35);
        targetHero.spendMana(15);
        targetHero.addGold(120);
        targetHero.setInventory(vaultInventory.copy());

        System.out.println("After trap and treasure surge: " + targetHero);

        System.out.println();
        System.out.println("--- Rewind through time crystal ---");
        HeroMemento rewindPoint = caretaker.undo();
        targetHero.restoreFromMemento(rewindPoint);

        System.out.println("After rewind: " + targetHero);
        System.out.println("Caretaker history size: " + caretaker.size());

        System.out.println();
        System.out.println("=== Chronomancer's Vault closes ===");

        int mementosCreated = 1;
        int restoredCount = rewindPoint == null ? 0 : 1;

        return new VaultRunResult(vaultInventory.size(), mementosCreated, restoredCount);
    }

    private Inventory buildVaultInventory() {
        Inventory inventory = new Inventory();

        inventory.addArtifact(new Weapon("Blade of Reversed Seconds", 140, 8, 9));
        inventory.addArtifact(new Potion("Crimson Healing Flask", 45, 2, 18));
        inventory.addArtifact(new Scroll("Scroll of Shadow Blink", 90, 1, "Shadow Blink"));
        inventory.addArtifact(new Ring("Ring of Silent Hours", 110, 1, 7));
        inventory.addArtifact(new Armor("Clockwork Guardian Plate", 160, 18, 10));

        return inventory;
    }
}