package rainy.electric.screen;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;
import rainy.electric.entity.InsulatorBlockEntity;

public class InsulatorScreenHandler extends ScreenHandler {

        private final Inventory inventory;
        private final PropertyDelegate propertyDelegate;

        public final InsulatorBlockEntity blockEntity;


     public InsulatorScreenHandler(int SyncId, PlayerInventory inventory, BlockPos pos) {
      this(SyncId, inventory, inventory.player.getWorld().getBlockEntity(pos), new ArrayPropertyDelegate(2));

}
      public InsulatorScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity, PropertyDelegate arrayPropertyDelegate) {
         super (ModScreenHandlers.INSULATOR_SCREEN_HANDLER, syncId);
         this.inventory = ((Inventory) blockEntity);

         this.blockEntity = ((InsulatorBlockEntity) blockEntity);
         this.propertyDelegate = arrayPropertyDelegate;

         this.addSlot(new Slot(inventory, 0, 54, 34));
         this.addSlot(new Slot(inventory, 1 , 104, 34));

         addPlayerInventorySlots(playerInventory);
         addPlayerHotbarSlots(playerInventory);
         addProperties(arrayPropertyDelegate);



      }

      public boolean isCrafting() {
         return propertyDelegate.get(0) > 0;
      }

       public int getScaledArrowProgress() {
         int progress = this.propertyDelegate.get(0);
         int maxProgress = this.propertyDelegate.get(1);
         int arrowPixelSize = 24;
         return maxProgress != 0 && progress != 0 ? progress * arrowPixelSize / maxProgress : 0;
       }




@Override
        public ItemStack quickMove(PlayerEntity player, int invslot) {
    ItemStack newStack = ItemStack.EMPTY;
    Slot slot = this.slots.get(invslot);
    if (slot != null && slot.hasStack()) {
        ItemStack originalStack = slot.getStack();
        newStack = originalStack.copy();

        if (invslot < this.inventory.size()) {
            if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                return ItemStack.EMPTY;
            }
         } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
            return ItemStack.EMPTY;
        } else {
            slot.markDirty();
        }
    }
    return newStack;
}

@Override
        public boolean canUse(PlayerEntity player) {
    return this.inventory.canPlayerUse(player);
   }

   private void addPlayerInventorySlots(PlayerInventory playerInventory) {
         for (int i = 0; i < 3; ++i) {
             for (int l = 0; l < 9; ++l){
                 this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
             }
         }

   }
    private void addPlayerHotbarSlots(PlayerInventory playerInventory) {
         for (int i = 0; i < 9; ++i) {
             this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
         }
    }
  }
