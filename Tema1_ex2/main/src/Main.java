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
            if (semne.indexOf(text.charAt(i))!=-1) {
                text.deleteCharAt(i);
                i--;
            }
            else
            if (text.charAt(i)==' ')
            {
                i++;
                while(i<text.length() && text.charAt(i)==' ')
                    text.deleteCharAt(i);
            }
            else
            if (text.charAt(i)>='A' && text.charAt(i)<='Z')
            {
                text.setCharAt(i, (char) (text.charAt(i) + ('a' - 'A')));
            }
        }

        continut=text.toString();
        System.out.println(continut);
    }
}