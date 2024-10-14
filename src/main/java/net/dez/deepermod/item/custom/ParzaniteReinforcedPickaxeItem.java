package net.dez.deepermod.item.custom;

import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class ParzaniteReinforcedPickaxeItem extends PickaxeItem {

    public ParzaniteReinforcedPickaxeItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties.stacksTo(1).defaultDurability(tier.getUses() * 2) );
    }


    //public ParzaniteIronPickItem(Properties properties) {
    //    super(properties);
    //}



}
