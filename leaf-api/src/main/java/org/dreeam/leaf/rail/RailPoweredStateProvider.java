package org.dreeam.leaf.rail;

import org.bukkit.block.Block;

import java.util.Optional;

/**
 * Supplies vanilla-compatible powered-rail state for non-vanilla blocks.
 */
@FunctionalInterface
public interface RailPoweredStateProvider {

    /**
     * Returns {@code Optional.empty()} if the block should not be treated as a powered rail.
     * Otherwise returns whether the rail is currently powered.
     *
     * @param block block to inspect
     * @return powered-rail state for the block
     */
    Optional<Boolean> getRailPoweredState(Block block);
}
