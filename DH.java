public class DH{
private int g = 123123;
private int p = 1234535;
    int getG(){
        return g;
    }
    int getP(){
        return p;
    }
    void setG(int gx){
        g = gx;
    }
    void setP(int px){
        p = px;
    }
    int getPower(){
        return (int)(Math.random() * p);
    }
    int getExponent(int a){
        return (int)(Math.pow(g,a) % p);
    }
}
