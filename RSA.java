public class RSA {
private static int p = 123456789;
    public static void setP(int px){
        p = px;
    }

    public static int generateInverse(int n, int p){
        for(int i = 0; i < p; i++){
            if((n*i)%p == 1)
                return i;
        }
        return -1;
    }
    public static int getExponent(int M, int e){
        return (int)(Math.pow(M,e)%p);
    }
}

