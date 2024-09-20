package PriorityQueues;

public class Doll implements Comparable {
    int likeness;
    int goodness;

    public Doll(int likeness, int goodness){
        this.likeness = likeness;
        this.goodness = goodness;
    }

    @Override
    public int compareTo(Object o) {
        Doll x = (Doll) o;
        if(x.likeness == this.likeness){
            return x.goodness - this.goodness;
        }else{
            return x.likeness - this.likeness;
        }
    }

    public String toString(){
        return "likeness :" + likeness +", goodness: " + goodness;
    }

    public static void main(String[] args) {
        PriorityQueue Q = new PriorityQueue(3);
        Q.insert(new Doll(5,2));
        Q.insert(new Doll(1,3));
        Q.insert(new Doll(5,1));

        while(!Q.isEmpty()){
            System.out.println(Q.remove());
        }
    }
    
}
