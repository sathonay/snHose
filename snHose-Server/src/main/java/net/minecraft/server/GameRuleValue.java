package net.minecraft.server;

class GameRuleValue
{
    private String a;
    private boolean b;
    private int c;
    private double d;
    
    public GameRuleValue(final String s) {
        this.a(s);
    }
    
    public void a(final String a) {
        this.a = a;
        this.b = Boolean.parseBoolean(a);
        try {
            this.c = Integer.parseInt(a);
        }
        catch (NumberFormatException ex) {}
        try {
            this.d = Double.parseDouble(a);
        }
        catch (NumberFormatException ex2) {}
    }
    
    public String a() {
        return this.a;
    }
    
    public boolean b() {
        return this.b;
    }
}
