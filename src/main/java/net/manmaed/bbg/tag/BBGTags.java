package net.manmaed.bbg.tag;

import net.manmaed.bbg.BedrockBeGone;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class BBGTags {
    public static final TagKey<Block> INCORRECT_FOR_BBG_TOOL = createBlockTag("incorrect_for_bbg_tool");

    //Item
    //public static final TagKey<Item> ANTIBLOCK_WITHOUT_BORDERS_ITEM = createItemTag("antiblock_without_borders");

    private static TagKey<Block> createBlockTag(String name) {
        return TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(BedrockBeGone.MOD_ID, name));
    }
    private static TagKey<Item> createItemTag(String name) {
        return TagKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(BedrockBeGone.MOD_ID, name));
    }

}
