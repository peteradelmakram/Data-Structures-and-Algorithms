package PracticeAssignments;

import PriorityQueues.PriorityQueue;

public class Patient implements Comparable {
    String name;
    int severity;

    public Patient(String name, int severity){
        this.name = name;
        this.severity = severity;
    }

    @Override
    public int compareTo(Object o) {
        Patient other = (Patient) o;
        return other.severity - severity;
    }
}

class EmergencyRoom{
    PriorityQueue Q;

    public EmergencyRoom(int size){
        Q = new PriorityQueue(size);
    }

    public void addPatient(String n, int p){
        Patient addPatient = new Patient(n, p);
        if(Q.isFull()) return;
        Q.insert(addPatient);
    }

    public Patient nextPatient(){
        if(Q.isEmpty()) return null;
        return (Patient) Q.remove();
    }

    public static void main(String[] args) {
        EmergencyRoom r = new EmergencyRoom(5);
        r.addPatient("John",3);
        r.addPatient("Erick",5);
        r.addPatient("Jessica",1);
        r.addPatient("Michael",2);
        r.addPatient("Mona",4);

        for (Patient p=r.nextPatient(); p!=null; p=r.nextPatient())
            System.out.println (p.name);
    }
}


