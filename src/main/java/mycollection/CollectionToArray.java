package mycollection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by shuai on 2017/2/9.
 */
public class CollectionToArray {
    private String name;
    CollectionToArray(){

    }
    CollectionToArray(String name){
        this.name = name;
    }
    private List<CollectionToArray> names = new LinkedList<>();
    public void setNames(List<CollectionToArray> nameList){
        this.names = nameList;
    }
    private static final CollectionToArray[] EMPTY_ARRAY = new CollectionToArray[0];
    public CollectionToArray[] getArrays(){
        return names.toArray(EMPTY_ARRAY);
    }
    public static void main(String []args){
        CollectionToArray cta = new CollectionToArray();
        System.out.println(cta.getArrays().length);
        List<CollectionToArray> names = new ArrayList<>();

        names.add(new CollectionToArray("tan"));
        names.add(new CollectionToArray("shuai"));
        cta.setNames(names);
        System.out.println(cta.getArrays().length);
    }

}
