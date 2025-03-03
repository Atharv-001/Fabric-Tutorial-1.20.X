package net.kaupenjoe.tutorialmod.item.custom;

import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ExpStaffItem extends Item {
    public ExpStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient) {
            HitResult hitResult = player.raycast(50, 0, false);
            if (hitResult instanceof BlockHitResult blockHit) {
                Vec3d spawnPos = blockHit.getPos();

                // Create TNT Entity
                TntEntity tnt = new TntEntity(world, spawnPos.x, spawnPos.y, spawnPos.z, player);
                tnt.setFuse(0); // Instant explosion
                world.spawnEntity(tnt);

                // Play Sound
                world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.PLAYERS, 1.0f, 1.0f);
            }
        }
        return TypedActionResult.success(player.getStackInHand(hand));
    }
}
