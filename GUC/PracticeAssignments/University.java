package PracticeAssignments;
import PriorityQueues.PriorityQueue;

public class University implements Comparable{
    String name;
    int rank;

    public University(String name, int rank){
        this.name = name;
        this.rank = rank;
    }

    @Override
    public int compareTo(Object o) {
        University x = (University) o;
        Integer rank = x.rank;
        if(this.rank == rank)
            return this.name.compareTo(x.name);
        return rank - this.rank;
    }

    public String toString(){
        return name + " " + rank;
    }

    public static void main(String[] args) {
        PriorityQueue x = new PriorityQueue(5);
        x.insert(new University("FCIC",4));
        x.insert(new University("GUC",3));
        x.insert(new University("BUE",4));
        x.insert(new University("AUC",2));
        x.insert(new University("FCIS",1));

        while(!x.isEmpty()){
            System.out.println(x.remove());
        }
        
    }


    
}
