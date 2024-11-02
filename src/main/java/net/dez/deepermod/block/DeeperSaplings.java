package net.dez.deepermod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.PlantType;

import java.util.function.Supplier;

public class DeeperSaplings extends SaplingBlock {

    private Supplier<Block> otherDirt;

    public DeeperSaplings(AbstractTreeGrower p_55978_, Properties p_55979_, Supplier<Block> placeableBlock) {
        super(p_55978_, p_55979_);
        this.otherDirt = placeableBlock;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter getter, BlockPos bPos){
      return state.is(otherDirt.get()) || state.is(BlockTags.DIRT) || state.is(Blocks.FARMLAND);
    };

    @Override
    public PlantType getPlantType(BlockGetter level, BlockPos pos){
        return PlantType.get("custom");
    }
}
