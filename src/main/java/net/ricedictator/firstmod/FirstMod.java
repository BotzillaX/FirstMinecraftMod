package net.ricedictator.firstmod;


import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.ricedictator.firstmod.newBlock.newBlockSapphire;
import net.ricedictator.firstmod.newItem.CreativeTabs;
import net.ricedictator.firstmod.newItem.newModItem;
import org.slf4j.Logger;

@Mod(FirstMod.MOD_ID)
public class FirstMod {
    public static final String MOD_ID = "firstmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public FirstMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();


        newBlockSapphire.register(modEventBus);
        CreativeTabs.register(modEventBus);
        newModItem.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event){
    }
    private void addCreative(BuildCreativeModeTabContentsEvent event){
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(newModItem.SAPPHIRE);
        }
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(newModItem.RAW_SAPPHIRE);
        }
    }


    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());//
        }
    }
}
