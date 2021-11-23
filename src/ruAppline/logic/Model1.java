package ruAppline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Model1 implements Serializable{
    private static final Model1 instance = new Model1();

    private final Map<Integer, User1> model;

    public static Model1 getInstance(){
        return instance;
    }
    private Model1(){
        model = new HashMap<>();
        model.put(1,new User1("Arina", "Perepelkina",50000));
        model.put(2,new User1("Vanya", "Popov", 70000));
        model.put(3,new User1("Artem", "Ivanov", 23800));
        model.put(4,new User1("Darya", "Magadeeva", 23800));

    }
    public void add (User1 user, int id){
        model.put(id,user);
    }

    public void delete(int id){model.remove(id);}

    public void put (User1 user1, int id){add(user1,id);}

    public Map<Integer, User1> getFromList(){
        return model;
    }


}
