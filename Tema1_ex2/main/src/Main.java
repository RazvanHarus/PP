import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main
{
    public void main(String[] Args) throws IOException {
        Path path = Path.of("fisier.txt");
        String continut = Files.readString(path);
        StringBuilder text=new StringBuilder(continut);
        String semne=",.!?;:";

        for (int i=0;i<text.length();i++)
        {
            if (semne.indexOf(text.charAt(i))!=-1)
                text.deleteCharAt(i);
        }

        continut=text.toString();
        System.out.println(continut);
    }
}