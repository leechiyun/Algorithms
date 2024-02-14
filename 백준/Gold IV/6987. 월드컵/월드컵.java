import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static List<Match> matches;
    static String[] teams = {"A", "B", "C", "D", "E", "F"};

    static class Game {
        int win, lose, draw;

        public Game(int win, int draw, int lose) {
            this.win = win;
            this.draw = draw;
            this.lose = lose;
        }
    }

    static class Match {
        String team1;
        String team2;

        public Match(String team1, String team2) {
            this.team1 = team1;
            this.team2 = team2;
        }

        @Override
        public String toString() {
            return "Match{" +
                    "team1='" + team1 + '\'' +
                    ", team2='" + team2 + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // match 만들기
        matches = new ArrayList<>();
        for (int i = 0; i < teams.length; i++) {
            for (int j = i + 1; j < teams.length; j++) {
                matches.add(new Match(teams[i], teams[j]));
            }
        }

        // 4번 경기 진행함
        start: for(int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            boolean isPossible = true;
            Map<String, Game> worldCup = new HashMap<>();
            for(int t = 0; t < teams.length; t++) {
                int win = Integer.parseInt(st.nextToken());
                int draw = Integer.parseInt(st.nextToken());
                int lose = Integer.parseInt(st.nextToken());

                if(win + draw + lose != 5) {
                    sb.append(0 + " ");
                    continue start;
                }

                worldCup.put(teams[t], new Game(win, draw, lose));
            }

            if(backTracking(worldCup, 0)) {
                sb.append(1 + " ");
            } else {
                sb.append(0 + " ");
            }
        }

        System.out.println(sb);
    }

    static boolean backTracking(Map<String, Game> worldCup, int count) {
        if(count == matches.size()){
            return true;
        }

        String team1 = matches.get(count).team1;
        String team2 = matches.get(count).team2;

        // 승 패
        if(worldCup.get(team1).win > 0 && worldCup.get(team2).lose > 0){
            worldCup.get(team1).win--;
            worldCup.get(team2).lose--;
            if(backTracking(worldCup, count + 1)) {
                return true;
            }
            worldCup.get(team1).win++;
            worldCup.get(team2).lose++;
        }
        
        // 무 무
        if(worldCup.get(team1).draw > 0 && worldCup.get(team2).draw > 0){
            worldCup.get(team1).draw--;
            worldCup.get(team2).draw--;
            if(backTracking(worldCup, count + 1)) {
                return true;
            }
            worldCup.get(team1).draw++;
            worldCup.get(team2).draw++;
        }

        // 패 승
        if(worldCup.get(team1).lose > 0 && worldCup.get(team2).win > 0){
            worldCup.get(team1).lose--;
            worldCup.get(team2).win--;
            if(backTracking(worldCup, count + 1)) {
                return true;
            }
            worldCup.get(team1).lose++;
            worldCup.get(team2).win++;
        }

        return false;
    }
}