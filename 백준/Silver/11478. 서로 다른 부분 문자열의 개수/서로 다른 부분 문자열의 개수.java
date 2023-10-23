import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static Set<String> set = new HashSet<>();
    static String input = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        dfs(0);

        System.out.println(set.size());
    }

    private static void dfs(int depth) {
        if(depth == input.length()){
            return;
        }

        for (int i = 0; i + depth < input.length(); i++) {
            set.add(input.substring(i, i + depth + 1));
        }
        dfs(depth+1);
    }

}

