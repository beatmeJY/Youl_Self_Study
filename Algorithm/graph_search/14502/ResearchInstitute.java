import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ResearchInstitute {


    public static void main(String[] args) {
        
        inputValue();
    }




    private static int[][] inputValue() {
        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(in))
        {
            int[][] results = new int[0][];
            String line;
            int count = 0;
            while ((line = buffer.readLine()) != null && !line.equals(""))
            {
                String[] stringLine = line.split("\\s");
                for (int i = 0; i < stringLine.length; i++) {
                    results[count][i] = Integer.parseInt(stringLine[i]);
                }
            }
            return results;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
