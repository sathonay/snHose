package net.minecraft.server;

public class GenLayerZoomFuzzy extends GenLayerZoom
{
    public GenLayerZoomFuzzy(final long n, final GenLayer genLayer) {
        super(n, genLayer);
    }
    
    @Override
    protected int b(final int n, final int n2, final int n3, final int n4) {
        return this.a(new int[] { n, n2, n3, n4 });
    }
}
