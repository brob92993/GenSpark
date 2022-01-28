import java.util.ArrayList;
import java.util.HashMap;

public class LoadMap {

    ArrayList<Land> map;

    public LoadMap(){
        map = new ArrayList<>();
        map.add( new Land("MiddleMap (Can go north, south, east, or west)", 4 , 5, 3 ,6  ) );
        map.add( new Land("Corner Map (Go east to go back to NorthMost)", -1, -1, 4, -1 ) );
        map.add( new Land("SouthEast Map (Can only go north)", 3, -1, -1, -1 ) );
        map.add( new Land("EastMap (Can only go west, or south)", -1, 2, -1, 0 ) );
        map.add( new Land("NorthMost Map (Can go east, or south)", -1, 0, 1, -1 ) );
        map.add( new Land("SouthMap (Can only go north)", 0, -1, -1, -1 ) );
        map.add( new Land("WestSide of the Map (Can only go east)", -1, -1, 0, -1 ) );

        loadingMap();
    }

    public void loadingMap(){

        for(Land gameArea : map){

            HashMap<String, Integer> nav = new HashMap<>();

            nav.put("north", gameArea.getN());
            nav.put("south", gameArea.getS());
            nav.put("east", gameArea.getE());
            nav.put("west", gameArea.getW());
            gameArea.setNavTable(nav);
        }
    }

    public ArrayList<Land> getAllMaps() {
        return map;
    }
}
