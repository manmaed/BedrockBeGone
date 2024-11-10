package net.manmaed.bbg.datagen;

import net.manmaed.bbg.BedrockBeGone;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = BedrockBeGone.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class BBGDataGeneration {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(true, new ModItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(true, new BBGRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(true, new BBGTagsProvider(packOutput, lookupProvider, existingFileHelper));
        BBGLanguageProvider.addTranslations(generator);

    }
}
