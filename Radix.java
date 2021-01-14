import java.util.*;

public class Radix{
    public static int nth(int n, int col){
        return Math.abs(n / bexp(10,col)) % 10;
    }

    public static int length(int n){
        if(n==0)return 1;
        double a = 1.0 * Math.abs(n);
        return (int)(Math.log10(a)+1);
    }

    public static void merge(SortableLinkedList original, SortableLinkedList[]buckets){
        for(int i=0;i<buckets.length;i++){
            original.extend(buckets[i]);
        }
    }

    public static void radixSortSimple(SortableLinkedList data){
        SortableLinkedList[] buckets = new SortableLinkedList[10];
        for(int i=0; i<buckets.length;i++){
            buckets[i] = new SortableLinkedList();
        }
        int maxLength = 1;
        for(int i=0;i<maxLength;i++){
            while(data.size()>0){
                int element = data.remove(0);
                if(i==0){
                    maxLength=Math.max(maxLength,length(element));
                }
                buckets[nth(element,i)].add(element);
            }
            merge(data,buckets);
        }
    }

    public static void radixSort(SortableLinkedList data){
        SortableLinkedList pos = new SortableLinkedList();
        SortableLinkedList neg = new SortableLinkedList();
        int n = data.size();
        for(int i=0;i<n;i++){
            if(data.get(0)<0){
                neg.add(data.remove(0)*-1);
            } else {
                pos.add(data.remove(0));
            }
        }
        radixSortSimple(pos);
        radixSortSimple(neg);
        while(neg.size()>0){
            data.add(-1 * neg.remove(neg.size()-1));
        }
        data.extend(pos);
    }

    private static int bexp(int a, int b){
        if(b==0)return 1;
        int res = bexp(a,b/2);
        if(b%2==1) return res*res*a;
        else return res*res;
    }

}
