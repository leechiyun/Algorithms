import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<List> list = new ArrayList<>();
        int arrSize = 0;
        String resultArr[] = new String[75];

        for (int i = 0; i < 5; i++) {
            StringBuffer sb = new StringBuffer(br.readLine());
            List<Character> tempList = new ArrayList<>();
            for (int j = 0; j < sb.length(); j++) {
                resultArr[5*j + i] = String.valueOf(sb.charAt(j));
            }
        }
        String result = "";
        for(int i=0; i<resultArr.length; i++){
            if(resultArr[i] != null){
                result += resultArr[i];
            }
        }
        System.out.println(result);
    }
}