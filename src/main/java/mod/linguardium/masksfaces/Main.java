package mod.linguardium.masksfaces;

import dev.emi.trinkets.api.SlotGroups;
import dev.emi.trinkets.api.Slots;
import dev.emi.trinkets.api.TrinketSlots;
import mod.linguardium.masksfaces.masks.MaskItem;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.tag.FabricTag;
import net.fabricmc.fabric.api.tag.FabricTagBuilder;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.Tag;
import net.minecraft.tag.TagContainer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "masksfaces";
    public static final String MOD_NAME = "Masks and Faces";
    public static final MaskItem TEST_ITEM = Registry.register(Registry.ITEM,new Identifier(MOD_ID,"test_mask"),new MaskItem());
    public static final MaskItem SMILEY_MASK = Registry.register(Registry.ITEM,new Identifier(MOD_ID,"smiley_mask"),new MaskItem());
    public static final Tag<Item> MASKTAG = TagRegistry.item(new Identifier(MOD_ID,"masks"));
    public static final ItemGroup MASK_GROUP = FabricItemGroupBuilder.create(new Identifier(MOD_ID,"mask_group")).icon(()->new ItemStack(TEST_ITEM)).appendItems(a->a.add(new ItemStack(TEST_ITEM))).build();

    @Override
    public void onInitialize() {
        TrinketSlots.addSlot(SlotGroups.HEAD, Slots.MASK, new Identifier("trinkets", "textures/item/empty_trinket_slot_mask.png"));
        //TODO: Initializer
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}