package org.dreeam.leaf.rail;

import org.bukkit.block.Block;
import org.jspecify.annotations.Nullable;

/**
 * Supplies vanilla-compatible rail shapes for non-vanilla blocks.
 *
 * <p>Returning {@code null} means the queried block should not be treated as a rail.
 */
@FunctionalInterface
public interface RailShapeProvider {

    /**
     * Returns the serialized vanilla rail shape for the given block.
     *
     * <p>Valid values match {@code net.minecraft.world.level.block.state.properties.RailShape}
     * serialized names such as {@code north_south}, {@code east_west},
     * {@code ascending_north}, or {@code south_east}.
     *
     * @param block block to inspect
     * @return serialized rail shape, or {@code null} if the block is not a rail
     */
    @Nullable
    String getRailShape(Block block);
}
