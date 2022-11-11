import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class BrowsingHistory {
    
    ObjStack BrowsingHistory;
    ObjStack search;

    public BrowsingHistory(int size){
        BrowsingHistory = new ObjStack(size);
        search = new ObjStack(size);
    }

    public void add(String url){
        int urlFrequency = 0;
    
        if(!BrowsingHistory.isEmpty()){
            while(!BrowsingHistory.isEmpty()){
                if(((Link) BrowsingHistory.top()).url.equals(url)){
                    urlFrequency = ((Link) BrowsingHistory.top()).frequency;
                    break;            
                }else{
                    search.push(BrowsingHistory.pop());
                }
            }
            while(!search.isEmpty()){
                BrowsingHistory.push(search.pop());
            }

            BrowsingHistory.push(new Link(url, ++urlFrequency));
        }
    }

    public void delete(){
        BrowsingHistory.pop();
    }

    public void delete(String date){
        while(!BrowsingHistory.isEmpty()){
            if(((Link) BrowsingHistory.top()).date.equals(date)){
                BrowsingHistory.pop();
            }else{
                search.push(BrowsingHistory.pop());
            }
        }

        while(!search.isEmpty()){
            BrowsingHistory.push(search.pop());
        }
    }
    public class Link{
        String url;
        String date;
        int frequency;

        public Link(String url){
            this.url = url;
            this.frequency = 0;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd", Locale.ENGLISH);
            LocalDateTime dateNow = LocalDateTime.now().plusDays(1);
            date = formatter.format(dateNow);
        }

        public Link(String url, int frequency){
            this.url = url;
            this.frequency = frequency;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd", Locale.ENGLISH);
            LocalDateTime dateNow = LocalDateTime.now().plusDays(1);
            date = formatter.format(dateNow);
        }
    }


}
