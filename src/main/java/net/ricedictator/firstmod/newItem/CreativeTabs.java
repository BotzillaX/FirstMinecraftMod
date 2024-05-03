package net.ricedictator.firstmod.newItem;



import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.ricedictator.firstmod.FirstMod;
import org.spongepowered.asm.service.IPropertyKey;

public class CreativeTabs {
    public static final DeferredRegister<CreativeModeTab> Creative_Mode_Tabs =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstMod.MOD_ID);


    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = Creative_Mode_Tabs.register("tutorial_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(newModItem.SAPPHIRE.get()))
                    .title(Component.translatable("creativetab.tutorial_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(newModItem.SAPPHIRE.get());
                        pOutput.accept(newModItem.RAW_SAPPHIRE.get());

                        pOutput.accept(Items.DIAMOND);


                    })
                    .build());

    public static void register(IEventBus eventBus){
        Creative_Mode_Tabs.register(eventBus);
    }
}
