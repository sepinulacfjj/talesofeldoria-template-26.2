package net.sepinula.talesofeldoria.block.events;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.sepinula.talesofeldoria.TalesOfEldoria;
import net.sepinula.talesofeldoria.item.ModItems;

import java.util.List;

@EventBusSubscriber(modid = TalesOfEldoria.MOD_ID)
public class AnvilInteractionEvents {

    @SubscribeEvent
    public static void onRightClickAnvilWithTool(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);
        Player player = event.getEntity();
        ItemStack heldItem = event.getItemStack();

        if (state.getBlock() instanceof AnvilBlock) {

            // 1. Tool check (e.g., Iron Pickaxe or custom Hammer)
            if (heldItem.is(Items.IRON_PICKAXE)) {

                AABB searchArea = new AABB(pos).move(0, 0.8, 0).inflate(0.2, 0.4, 0.2);
                List<ItemEntity> itemsOnAnvil = level.getEntitiesOfClass(ItemEntity.class, searchArea);

                for (ItemEntity itemEntity : itemsOnAnvil) {
                    ItemStack targetStack = itemEntity.getItem();

                    // 2. EXPLICIT ITEM CHECK: Ensures ONLY Verdigris transforms
                    if (targetStack.is(ModItems.VERDIGRIS.get())) {

                        event.setCanceled(true);

                        if (!level.isClientSide()) {
                            int count = targetStack.getCount();

                            // Transform Verdigris into Verdigris Ingot
                            itemEntity.setItem(new ItemStack(ModItems.VERDIGRIS_INGOT.get(), count));

                            player.addEffect(new MobEffectInstance(MobEffects.MINING_FATIGUE, 250));

                            level.playSound(null, pos, SoundEvents.ANVIL_USE, SoundSource.BLOCKS, 1.0f, 1.0f);
                            level.playSound(null, pos, SoundEvents.AMETHYST_CLUSTER_PLACE, SoundSource.BLOCKS, 2.0f, 1.0f);

                            heldItem.hurtAndBreak(1, player, player.getEquipmentSlotForItem(heldItem));
                        } else {
                            level.addParticle(ParticleTypes.END_ROD, pos.getX() + 0.5, pos.getY() + 1.2, pos.getZ() + 0.5, 0.0, 0.1, 0.0);
                        }

                        // ANVIL DAMAGE LOGIC HERE
                        // 12% chance (0.12F) to degrade the anvil, matching vanilla anvil usage odds
                        if (level.getRandom().nextFloat() < 0.12F) {
                            BlockState damagedState = AnvilBlock.damage(state);
                            if (damagedState == null) {
                                // Anvil completely breaks
                                level.destroyBlock(pos, false);
                                level.playSound(null, pos, SoundEvents.ANVIL_BREAK, SoundSource.BLOCKS, 1.0f, 1.0f);
                            } else {
                                // Anvil degrades to the next damage state (e.g. Normal -> Chipped -> Damaged)
                                level.setBlock(pos, damagedState, 3);
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
}
