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
        int thisPatient = this.severity;
        int otherPatient = ((Patient) o).severity;

        if(thisPatient > otherPatient){
            return 1;
        }else if(thisPatient < otherPatient){
            return -1;
        }

        return 0;
    }

    public class EmergencyRoom{
        PriorityQueue Q;
        int numberOfPatients;

        public EmergencyRoom(int numberOfPatients){
            this.numberOfPatients = numberOfPatients;
            Q = new PriorityQueue(numberOfPatients);
        }

        public void newPatient(String n, int p){           
            Patient newPatient = new Patient(n, p);
            Q.insert(newPatient);

        }


        
    }
}


