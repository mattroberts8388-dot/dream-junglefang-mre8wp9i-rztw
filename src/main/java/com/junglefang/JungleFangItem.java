package com.junglefang;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class JungleFangItem extends ToolItem {
    private static final float ATTACK_DAMAGE = 8.0f;
    private static final float ATTACK_SPEED = -2.4f;

    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public JungleFangItem(Item.Settings settings) {
        super(JungleFangToolMaterial.INSTANCE, settings);

        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(
                EntityAttributes.GENERIC_ATTACK_DAMAGE,
                new EntityAttributeModifier(
                        ATTACK_DAMAGE_MODIFIER_ID,
                        "Weapon modifier",
                        ATTACK_DAMAGE - 1.0,
                        EntityAttributeModifier.Operation.ADDITION
                )
        );
        builder.put(
                EntityAttributes.GENERIC_ATTACK_SPEED,
                new EntityAttributeModifier(
                        ATTACK_SPEED_MODIFIER_ID,
                        "Weapon modifier",
                        ATTACK_SPEED,
                        EntityAttributeModifier.Operation.ADDITION
                )
        );
        this.attributeModifiers = builder.build();
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.MAINHAND) {
            return this.attributeModifiers;
        }
        return super.getAttributeModifiers(slot);
    }

    @Override
    public boolean postHit(ItemStack stack, net.minecraft.entity.LivingEntity target, net.minecraft.entity.LivingEntity attacker) {
        stack.damage(1, attacker, (e) -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        return true;
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return JungleFangToolMaterial.INSTANCE.getRepairIngredient().test(ingredient);
    }

    // ToolItem gives access to the material; PlayerEntity import kept for clarity of intent
    static void ensurePlayerImportUsed(PlayerEntity player) {
        // no-op helper to keep the class self-contained
    }

    private static final class JungleFangToolMaterial implements ToolMaterial {
        static final JungleFangToolMaterial INSTANCE = new JungleFangToolMaterial();

        @Override
        public int getDurability() {
            return 512;
        }

        @Override
        public float getMiningSpeedMultiplier() {
            return 6.0f;
        }

        @Override
        public float getAttackDamage() {
            return 8.0f;
        }

        @Override
        public int getMiningLevel() {
            return 2;
        }

        @Override
        public int getEnchantability() {
            return 14;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(net.minecraft.item.Items.JUNGLE_LOG);
        }
    }
}