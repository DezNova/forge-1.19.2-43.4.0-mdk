package net.dez.deepermod.worldgen.dimension.carvers;

import com.mojang.serialization.Codec;
import net.dez.deepermod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.CarvingMask;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.carver.CarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CarvingContext;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CaveWorldCarver;
import org.apache.commons.lang3.mutable.MutableBoolean;

import javax.annotation.Nullable;
import java.util.function.Function;

public class TectonicWorldCarver  extends CaveWorldCarver {

    public TectonicWorldCarver(Codec<CaveCarverConfiguration> caveCarverConfigurationCodec) {
        super(caveCarverConfigurationCodec);
    }


    @Override
    protected boolean carveBlock(CarvingContext context, CaveCarverConfiguration config, ChunkAccess chunk, Function<BlockPos, Holder<Biome>> biomeAccessor, CarvingMask carvingMask, BlockPos.MutableBlockPos pos, BlockPos.MutableBlockPos checkPos, Aquifer aquifer, MutableBoolean reachedSurface) {
        BlockState chunkState = chunk.getBlockState(pos);
        if (chunkState.is(Blocks.GRASS_BLOCK) || chunkState.is(ModBlocks.STILL_DIRT.get())) {
            reachedSurface.setTrue();
        }

        if (!this.canReplaceBlock(config, chunkState) ) {
            return false;
        } else {
            BlockState $$10 = this.getCarveState(context, config, pos, aquifer);
            if ($$10 == null) {
                return false;
            } else {
                chunk.setBlockState(pos, $$10, false);
                if (aquifer.shouldScheduleFluidUpdate() && !$$10.getFluidState().isEmpty()) {
                    chunk.markPosForPostprocessing(pos);
                }

                if (reachedSurface.isTrue()) {
                    checkPos.setWithOffset(pos, Direction.DOWN);
                    if (chunk.getBlockState(checkPos).is(Blocks.DIRT)) {
                        context.topMaterial(biomeAccessor, chunk, checkPos, !$$10.getFluidState().isEmpty()).ifPresent((p_190743_) -> {
                            chunk.setBlockState(checkPos, p_190743_, false);
                            if (!p_190743_.getFluidState().isEmpty()) {
                                chunk.markPosForPostprocessing(checkPos);
                            }

                        });
                    }
                }

                return true;
            }
        }
    }

    @Nullable
    private BlockState getCarveState(CarvingContext p_159419_, CaveCarverConfiguration p_159420_, BlockPos p_159421_, Aquifer p_159422_) {
        if (p_159421_.getY() <= p_159420_.lavaLevel.resolveY(p_159419_)) {
            return LAVA.createLegacyBlock();
        } else {
            BlockState $$4 = p_159422_.computeSubstance(new DensityFunction.SinglePointContext(p_159421_.getX(), p_159421_.getY(), p_159421_.getZ()), 0.0);
            return CAVE_AIR; //is this what's filling the cave with air?
            /*
            if ($$4 == null) {
                return isDebugEnabled(p_159420_) ? p_159420_.debugSettings.getBarrierState() : null;
            } else {
                return isDebugEnabled(p_159420_) ? getDebugState(p_159420_, $$4) : $$4;
            }*/
        }
    }


    /*
    @Override
    public boolean carve(CarvingContext context, CaveCarverConfiguration config, ChunkAccess p_224887_, Function<BlockPos, Holder<Biome>> biomeFunction, RandomSource p_224889_, Aquifer p_224890_, ChunkPos cPos, CarvingMask p_224892_) {
        if(cPos.getWorldPosition().getY() < 65){
            return false;
        }
        return super.carve(  context,  config,  p_224887_,  biomeFunction,  p_224889_,  p_224890_,  cPos,  p_224892_);
    }
    */


}
