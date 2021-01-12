public class Radix{
    public static int nth(int n, int col){
        return Math.abs(n / Math.pow(10,col)) % 10;
    }

    public static int length(int n){
        double a = 1.0 * Math.abs(n);
        return (int)(Math.log10(a)+1);
    }

    public static void merge(MyLinkedList original, MyLinkedList[]buckets){

    }
}
