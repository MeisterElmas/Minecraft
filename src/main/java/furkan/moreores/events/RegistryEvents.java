package furkan.moreores.events;

import org.apache.logging.log4j.Logger;

import furkan.moreores.moreores;
import furkan.moreores.lists.BlockList;
import furkan.moreores.lists.ItemList;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents
{
    public static final Logger LOGGER = moreores.LOGGER;
    public static final String MOD_ID = moreores.MOD_ID;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll
        (
            ItemList.amethyst_item = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("amethyst_item")),
            ItemList.amethyst_block = new BlockItem(BlockList.amethyst_block, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.amethyst_block.getRegistryName())
        );  
    }
    
    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll
        (
        	BlockList.amethyst_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(6).sound(SoundType.STONE)).setRegistryName(location("amethyst_block")));
    }
        public static ResourceLocation location(String name)
    {
        return new ResourceLocation(MOD_ID, name);
    }
}