package net.manmaed.bbg.datagen;

import net.manmaed.bbg.datagen.lang.BBGENUS;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;

public class BBGLanguageProvider {
    public static void addTranslations(DataGenerator generator) {
        PackOutput output = generator.getPackOutput();
        /**
         * To Add a new LanguageProvider make a new fine in the net.manmaed.bbg.datagen.lang called BBGlocale (eg BBGENPT for Pirate Speak)
         * then make that extend LanguageProvider make it only need a PackOutput and define the modID as BedrockBeGone.MOD_ID and the locale in the super
         * Example:
         * public BBGENPT(PackOutput output) { super(output, BedrockBeGone.MOD_ID, "en_pt") }
         * --
         * please add the fist 2 lines to the new Language for Language Name, Translator Name
         * Example:
         * add("a.lang.file.name", "Pirate Speak");
         * add("a.lang.author.name", "manmaed");
         */
        generator.addProvider(true, new BBGENUS(output));
    }

}
