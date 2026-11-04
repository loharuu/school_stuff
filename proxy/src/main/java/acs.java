import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class acs {
    private static acs acs;
    HashMap<Integer, List<String>> valid = new HashMap<>();

    public static acs getInstance(){
        if (acs == null){
            acs = new acs();
        }
        return acs;
    }
    public boolean isAllowed(String user, int dId){
        List<String> u = valid.get(dId);
        return u.contains(user);
    }

    public void addToValid(String user, int dId){
        List<String> u;
        if (valid.containsKey(dId)){
            u = valid.get(dId);
        }else{
            u = new ArrayList<>();

        }
        u.add(user);
        valid.put(dId, u);
    }


}
