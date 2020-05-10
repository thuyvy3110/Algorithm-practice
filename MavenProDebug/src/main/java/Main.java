import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.eclipsesource.json.JsonArray;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    
    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println( "Type input ===" );
        String line;
        while ((line = in.readLine()) != null) {
            String[] words = stringToStringArray(line);
            String ret = new Solution().longestWord(words);
            String out = (ret);
            System.out.println(out);
        }
    }
    
}
