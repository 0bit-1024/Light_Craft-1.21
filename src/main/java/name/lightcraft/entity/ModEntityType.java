package name.lightcraft.entity;

import name.lightcraft.entity.projectile.BallLightningEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.projectile.WindChargeEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.resource.featuretoggle.ToggleableFeature;
import net.minecraft.util.TypeFilter;
import org.jetbrains.annotations.Nullable;

public class ModEntityType<T extends Entity> implements ToggleableFeature, TypeFilter<Entity, T> {
    public static final EntityType<BallLightningEntity> BALL_LIGHTNING = register(
            "ball_lightning",
            EntityType.Builder.<BallLightningEntity>create(BallLightningEntity::new, SpawnGroup.MISC)
                    .dimensions(0.3125F, 0.3125F)
                    .eyeHeight(0.0F)
                    .maxTrackingRange(4)
                    .trackingTickInterval(10)
    );

    private static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> type) {
        return Registry.register(Registries.ENTITY_TYPE, id, type.build(id));
    }
    @Override
    public FeatureSet getRequiredFeatures() {
        return null;
    }

    @Nullable
    public T downcast(Entity entity) {
        return null;
    }

    @Override
    public Class<? extends Entity> getBaseClass() {
        return Entity.class;
    }
}