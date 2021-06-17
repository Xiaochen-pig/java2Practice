package practice;

import java.io.*;

public class AnalysisResult {
    public static void main(String args[]){
        File fRead=new File("D:\\\\score.txt");
        File fWrite=new File("scoreAnalysis.txt");
        try {
            Writer out = new FileWriter(fWrite, true);
            BufferedWriter bufferWrite=new BufferedWriter(out);
            Reader in =new FileReader(fRead);
            BufferedReader bufferRead=new BufferedReader(in);
            String str=null;
            while((str=bufferRead.readLine())!=null){
                double totalScore=Fenxi.getTotalScore(str);
                str = str+"总分:"+totalScore;
                System.out.println(str);
                bufferWrite.write(str);
                bufferWrite.newLine();
            }
            bufferRead.close();
            bufferWrite.close();
        }
        catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
