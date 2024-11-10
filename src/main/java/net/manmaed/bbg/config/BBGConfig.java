package net.manmaed.bbg.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class BBGConfig {
    private static final ModConfigSpec.Builder COMMON_BUILDER = new ModConfigSpec.Builder();

    public static ModConfigSpec COMMON_CONFIG;

    public static final String CAT_TOOL_SETTINGS = "tool_settings";

    public static ModConfigSpec.BooleanValue BEDROCK_DROPS;
    public static ModConfigSpec.IntValue DAMAGE_PICK_BY;

    static {
        COMMON_BUILDER.comment("Tool Settings").push(CAT_TOOL_SETTINGS);
        BEDROCK_DROPS = COMMON_BUILDER.comment("Should Bedrock drop when mined? [DEFAULT: true]")
                        .define("bedrock_drop", true);
        DAMAGE_PICK_BY = COMMON_BUILDER.comment("How Much should the pickaxe be dammaged by when bedrock is mined? [DEFAULT: 50]").comment(" Positive numbers damages the pickaxe & Negative numbers heals the pickaxe")
                        .defineInRange("damage_by", 50, -4062, 4062);

        COMMON_BUILDER.pop();
        COMMON_CONFIG = COMMON_BUILDER.build();
    }
}
