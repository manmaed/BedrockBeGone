package net.manmaed.bbg.datagen.lang;

import net.manmaed.bbg.BedrockBeGone;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class BBGENUS extends LanguageProvider {
    public BBGENUS(PackOutput output) {
        super(output, BedrockBeGone.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("a.lang.file.name", "English US");
        add("a.lang.author.name", "manmaed");
        add("itemGroup." + BedrockBeGone.MOD_ID, "Bedrock Be Gone");
        add("item.bbg.bbg_pickaxe", "Reinforced Diamond Pickaxe");
        add("item.bbg.bbg_pickaxe.offhand.failed", "Unable to break Bedrock, you have an item in the offhand");
        add("item.bbg.bbg_pickaxe.tooltip.one", "To Mine Bedrock use right click");
        add("item.bbg.bbg_pickaxe.tooltip.two", "It will take %1$s durability to mine Bedrock.");
        add("item.bbg.bbg_pickaxe.tooltip.three", "Will it give Bedrock?: %1$s");

    }
}
