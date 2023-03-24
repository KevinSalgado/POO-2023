package mx.uv.fiee.iinf.poo.setimplementations;

import java.util.*;

public class Main {

    public static void main (String [] args) {

        var soccerTeams = new LinkedHashSet<String>();
        soccerTeams.add ("Liverpool");
        soccerTeams.add ("Manchester United");
        soccerTeams.add ("Barcelona");
        soccerTeams.add ("Real Madrid");
        soccerTeams.add ("Milan");
        soccerTeams.add ("Juventus");

        for (String team: soccerTeams) {
            System.out.println (team);
        }

    }

}
