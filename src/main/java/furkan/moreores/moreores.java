package furkan.moreores;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import furkan.moreores.lists.ItemList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod ("moreores")

public class moreores 
{
	public static moreores instance;
	public static final String MODID = "moreores";
	
	private static final Logger LOGGER = LogManager.getLogger(MODID);	
	
	public moreores()
	{	
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		LOGGER.info("Setup funktioniert!");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		LOGGER.info("ClientRegistries funktioniert!");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegsitryEvent 
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll
			(
				ItemList.amethyst_item = new Item(new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("amethyst_item"))
			);  
		}
		
	     private static ResourceLocation location(String name)
		{
			return new ResourceLocation(MODID, name);
		}
	}
} 