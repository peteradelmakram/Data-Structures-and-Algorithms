package PriorityQueues;

public class Student implements Comparable{
    public String name;
    public long ID;

    public Student(String name, long ID) {
        this.name = name;
        this.ID = ID;
    }

    public String toString(){
        return this.name;
    }

    @Override
    public int compareTo(Object o) {
        Student other = (Student) o;
        char firstChar = other.name.charAt(0);
        char secondChar = this.name.charAt(0);
        if(secondChar > firstChar) return -1;
        else return 1;
    }
    
}
