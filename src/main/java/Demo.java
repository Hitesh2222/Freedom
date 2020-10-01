import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
//        File file = new File("C:\\Users\\Hitesh\\Desktop\\PRAGRA\\Freedom\\src\\test\\resources\\framework.properties");
////        System.out.println(file.exists());
////        System.out.println(file.canRead());
//
//        try {
//            FileInputStream stream = new FileInputStream(file);
//            byte [] buf = new byte[1024];
//            stream.read(buf);
//            System.out.println(new String(buf));
////            int i;
////            while (( i = stream.read())!=-1){
////                System.out.println((char) i);
////            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //path use to get the file and read the file
        Path path = Paths.get("src","test","resources","framework.properties");
        System.out.println(path.toString());
        System.out.println(path.toAbsolutePath().toString());
        System.out.println(path.getFileName().toString());

        try {
            List<String> strings = Files.readAllLines(path);
//            List<String> names = Arrays.asList("Hitesh", "Ankit");
//
//            Files.write(path,"Hitesh".getBytes());

            for (String st: strings){
                System.out.println(st);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
