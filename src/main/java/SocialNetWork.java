import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SocialNetWork<T> implements Iterable<T>{
    List<T> roster;

    public SocialNetWork() {
        roster = new ArrayList<>();
    }

    public void addPerson(T p){
        roster.add(p);
    }

    @Override
    public Iterator<T> iterator() {
        return roster.iterator();
    }
}
