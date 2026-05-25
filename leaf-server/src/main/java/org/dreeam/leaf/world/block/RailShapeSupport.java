package org.dreeam.leaf.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseRailBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RailShape;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.dreeam.leaf.rail.RailShapeProvider;
import org.jspecify.annotations.Nullable;

public final class RailShapeSupport {

    private RailShapeSupport() {
    }

    public static boolean isRail(Level level, BlockPos pos, BlockState state) {
        return getRailShape(level, pos, state) != null;
    }

    public static @Nullable RailShape getRailShape(Level level, BlockPos pos, BlockState state) {
        if (state.is(BlockTags.RAILS) && state.getBlock() instanceof BaseRailBlock baseRailBlock) {
            return state.getValue(baseRailBlock.getShapeProperty());
        }

        RailShapeProvider provider = Bukkit.getServicesManager().load(RailShapeProvider.class);
        if (provider == null) {
            return null;
        }

        World world = level.getWorld();

        String serializedShape = provider.getRailShape(world.getBlockAt(pos.getX(), pos.getY(), pos.getZ()));
        if (serializedShape == null || serializedShape.isBlank()) {
            return null;
        }

        for (RailShape railShape : RailShape.values()) {
            if (railShape.getSerializedName().equals(serializedShape)) {
                return railShape;
            }
        }

        return null;
    }
}
