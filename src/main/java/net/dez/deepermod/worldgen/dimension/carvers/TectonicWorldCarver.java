package net.dez.deepermod.worldgen.dimension.carvers;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CaveWorldCarver;

public class TectonicWorldCarver  extends CaveWorldCarver {

    public TectonicWorldCarver(Codec<CaveCarverConfiguration> caveCarverConfigurationCodec) {
        super(caveCarverConfigurationCodec);
    }
}
