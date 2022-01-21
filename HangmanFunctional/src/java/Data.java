import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Data {
    
    static List<String> words;
    static List<String> art;

    // grab a list of all the words from the word database text file
    static {
        try {
            words = Files.readAllLines( Paths.get("src/resources/words.txt"))
                    .stream()
                    .map( e -> Arrays.stream( e.split(",") )

                            .map(String::valueOf)
                            .collect( Collectors.joining() ) )
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDrawing(int num) {

        try {
            var text = Files.readAllLines( Paths.get("src/resources/hangmanart.txt") );

            return IntStream.range(0, text.size() / 5)
                    .mapToObj(x -> text.subList((x * 5), (x + 1) * 5))
                    .map(s -> s
                            .stream()
                            .collect(Collectors.joining(System.lineSeparator()))).toList()
                    .get(num);

        }catch (IOException e){

            return "Error: get Drawing failed";
        }
    }

    // get the drawing
    static {
        try {
            art = IntStream.range(0, Files.readAllLines( Paths.get("src/resources/hangmanart.txt") ).size() / 5 )
                    .mapToObj(x -> {
                        try {
                            return Files.readAllLines( Paths.get("src/resources/hangmamart.txt") )
                                    .subList( (x * 5), (x + 1) *5 );
                        } catch (IOException e) {
                            return new ArrayList<String>(){{ add("error"); }};
                        }
                    })
                    .map( s -> s
                            .stream()
                            .collect( Collectors.joining( System.lineSeparator() ) ) )
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {


    }
}

