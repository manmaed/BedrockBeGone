package net.manmaed.bbg.datagen;

import net.manmaed.bbg.BedrockBeGone;
import net.manmaed.bbg.tag.BBGTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BBGTagsProvider extends BlockTagsProvider {


    public BBGTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, BedrockBeGone.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider context) {
        tag(BBGTags.INCORRECT_FOR_BBG_TOOL);
    }
}
