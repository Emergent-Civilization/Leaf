package org.dreeam.leaf.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PoweredRailBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.dreeam.leaf.rail.RailPoweredStateProvider;

import java.util.Optional;

public final class RailDataSupport {

    private RailDataSupport() {
    }

    public static Optional<Boolean> getRailPoweredState(Level level, BlockPos pos, BlockState state) {
        if (state.is(Blocks.POWERED_RAIL)) {
            return Optional.of(state.getValue(PoweredRailBlock.POWERED));
        }

        RailPoweredStateProvider provider = Bukkit.getServicesManager().load(RailPoweredStateProvider.class);
        if (provider == null) {
            return Optional.empty();
        }

        World world = level.getWorld();
        return provider.getRailPoweredState(world.getBlockAt(pos.getX(), pos.getY(), pos.getZ()));
    }
}
