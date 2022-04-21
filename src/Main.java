import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Main
{

    public static void main(String[] args)
    {

        String FileName="";
        int countW = 0;
        int countL = 0;
        int charC = 0;

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);


        if (returnValue == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
            FileName=selectedFile.getName();
            String s = selectedFile.getAbsolutePath();
            System.out.println(s);


            try
            {
                File file=new File(s);
                FileReader fr=new FileReader(file);
                BufferedReader br=new BufferedReader(fr);
                String line;
                while((line=br.readLine())!=null)
                {
                    countL+=1;
                    String[] arr=line.split(" ");
                    countW=countW+arr.length;
                    charC=charC+line.length();

                }
                fr.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }

        }

        System.out.println("Name of file = " +FileName);
        System.out.println("Number of line = " + countL);
        System.out.println("Total word count = " + countW);
        System.out.println("Total number of characters = " + charC);


    }

}
