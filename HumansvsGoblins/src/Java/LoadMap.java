package Java;

import java.util.ArrayList;
import java.util.HashMap;



    public class LoadMap {
        ArrayList<Land> map;

        public LoadMap(){
            map = new ArrayList<>();
            map.add( new Land("MainMap" , 10 , 10, 10 ,10  ) );
            map.add( new Land("GameLand" , -1 , -1, -1 ,-1  ) );
            map.add ( new Land("RanndomLand" , -1 , 2, -1 , 0  ) );
            loadingMap();
        }

        public void loadingMap(){

            for(Land gameRoom : map){

                HashMap<String, Integer> nav = new HashMap<>();
                nav.put("north", gameRoom.getN());
                nav.put("south", gameRoom.getS());
                nav.put("east", gameRoom.getE());
                nav.put("west", gameRoom.getW());
                gameRoom.setNavTable(nav);
            }
        }

        public ArrayList<Land> getAllMaps() {
            return map;
        }
    }


