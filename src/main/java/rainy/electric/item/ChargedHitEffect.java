package rainy.electric.item;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ChargedHitEffect extends Item {

    private static int LIGHTING_STRIKES = 3;


    public ChargedHitEffect(Settings settings) {
        super(settings);
    }

    @Override

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = attacker.getEntityWorld();

        if (!world.isClient) {
            explode(world, target, attacker);
            turnintoEmptyBattery(stack, attacker);
        }
        return true;
    }
    private void turnintoEmptyBattery(ItemStack stack, LivingEntity attacker) {

        stack.decrement(1);

        if (attacker instanceof PlayerEntity player) {
            ItemStack  empty = new ItemStack(RainyItems.EMPTY_BATTERY);
            if(!player.getInventory().insertStack(empty)) {
                player.dropItem(empty, false);

            }
        }

    }

    private void explode(World world, LivingEntity target, LivingEntity attacker) {

        double x = target.getX();
        double y = target.getY();
        double z = target.getZ();

        world.createExplosion(
                attacker, x, y , z , 6F , true , World.ExplosionSourceType.MOB
        );
        for (int i = 0; i < LIGHTING_STRIKES; i++) {
            LightningEntity bolt = EntityType.LIGHTNING_BOLT.create(world);
            if (bolt != null) {
                double offsetX = x + (world.random.nextDouble() - 0.5) * 2.0;
                double offsetZ = z + (world.random.nextDouble() - 0.5) * 2.0;
                bolt.refreshPositionAfterTeleport(new Vec3d(offsetX, y, offsetZ));
                world.spawnEntity(bolt);
            }
        }
        world.playSound(null, x, y, z, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.HOSTILE, 4.0F, 1.0F);





    }


}
