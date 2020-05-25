package Interfaces;

import java.util.ArrayList;

public interface iSaveable {

    ArrayList<Object> saveList();

    void load(ArrayList<Object> list);

}
