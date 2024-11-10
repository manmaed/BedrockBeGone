package net.manmaed.bbg;

import net.manmaed.bbg.config.BBGConfig;
import net.manmaed.bbg.items.BBGItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Arrays;
import java.util.List;

@Mod(BedrockBeGone.MOD_ID)
public class BedrockBeGone {
    public static final String MOD_ID = "bbg";
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ABRC_TAB = CREATIVE_MODE_TABS.register(MOD_ID, () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(BBGItems.BEDROCK_PICKAXE.get()))
            .title(Component.translatable("itemGroup." + MOD_ID ))
            .displayItems((parameters, output) -> {
                List<DeferredRegister<Item>> myItems = Arrays.asList(
                        BBGItems.ITEMS
                );
                for (DeferredRegister<Item> register : myItems) {
                    register.getEntries().forEach(entry -> output.accept(entry.get()));
                }
            })
            .build());

    public BedrockBeGone(IEventBus event, ModContainer container) {
        BBGItems.ITEMS.register(event);
        CREATIVE_MODE_TABS.register(event);
        container.registerConfig(ModConfig.Type.COMMON, BBGConfig.COMMON_CONFIG);
    }
}
