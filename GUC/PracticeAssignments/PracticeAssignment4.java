package PracticeAssignments;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PracticeAssignment4 {
    //Exercise 4-1
    class Student{
        //private String name;
        private double GPA;

        public Student(String name, double GPA){
            //this.name = name;
            this.GPA = GPA;
        }
    }

    public static double findAverage(ObjStack s){
        int count = s.size();
        int sum  = 0;
        ObjStack temp = new ObjStack(s.size());
        
        while(!s.isEmpty()){
            Student tmp = (Student) s.pop();
            sum += tmp.GPA;
            temp.push(tmp);
        }

        while(!temp.isEmpty()){
            s.push(temp.pop());
        }

        return sum/count;
    }

    //Exercise 4-2:
    public static int precedence(char c){
        switch(c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    public static String infixToPostfix(String str){
        String res = "";
        char[] chars = str.toCharArray();
        ObjStack s = new ObjStack(chars.length);

        for(int i = 0; i < chars.length; i++){
            char c = chars[i];

            if(precedence(c) > 0){
                while(!s.isEmpty() && precedence((Character) s.top()) >= precedence(c)){
                    res += s.pop();
                }

                s.push(c);
            }else{
                res += c;
            }
        }

        while(!s.isEmpty()){
            res += s.pop();
        }

        return res;
    }

    //Exercise 4-3
    class Link {
        String url ;
        String date ; 
        int frequency ; 

        public Link ( String url ) {
            this.url = url ;
            this.frequency = 0;
            Calendar cal = Calendar.getInstance ();
            Date calDate = cal.getTime ();
            SimpleDateFormat format1 = new SimpleDateFormat (" yyyy -MM - dd " );
            try {
                date = format1.format(calDate);
            }catch (Exception e){
                e. printStackTrace ();
            }
        }

        public Link ( String url , int frequency ) {
            this (url);
            this.frequency = frequency;
        }

        public String toString (){
            return url +" " + date +" frequency "+ frequency ;
        }
    }
    public class BrowsingHistory{
        ObjStack history;
        ObjStack helper;

        public BrowsingHistory(int size){
            history = new ObjStack(size);
            helper = new ObjStack(size);
        }

        public void add(String url){
            int urlFrequency = 0;
            Link l = null;

            while(!history.isEmpty()){
                l = (Link) history.pop();
                if(l.url.equals(url)){
                    urlFrequency = l.frequency;
                    break;
                }
                helper.push(l);
            }

            while(!helper.isEmpty()) history.push(helper.pop());
            history.push(new Link(url, ++urlFrequency));

        }

        public Link remove(){
            Link res = (Link) history.pop();
            return res;
        }

        public void removeHistory(String date){
            Link l = null;

            while(!history.isEmpty()){
                l = (Link) history.pop();
                if(l.date.equals(date)){
                    break;
                }
                helper.push(l);
            }

            while(!helper.isEmpty()){
                history.push(helper.pop());
            }
        }

        public int getNumberofLinks(){
            return history.size();
        }


    }
        

    public static void main(String[] args) {
        String str = "A+B*C/D";
        System.out.println(infixToPostfix(str));
    }
}
