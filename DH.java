public class DH{
private static int g = 20;
private static int p = 1234535;
    static int getG(){
        return g;
    }
    static int getP(){
        return p;
    }
    static void setG(int gx){
        g = gx;
    }
    static void setP(int px){
        p = px;
    }
    static int getPower(){
        return (int)(Math.random() * p);
    }
    static int getExponent(int a){
        return (int)(Math.pow(g,a) % p);
    }
    static int getExponent(int a, int b){
        return (int)(Math.pow(a,b) % p);
    }
}
