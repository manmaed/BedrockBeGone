package net.manmaed.bbg.items;

import net.manmaed.bbg.BedrockBeGone;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BBGItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BedrockBeGone.MOD_ID);

    public static final DeferredItem<Item> BEDROCK_PICKAXE = ITEMS.register("bbg_pickaxe", BedRockPickaxe::new);



}
