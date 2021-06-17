package practice;

import java.io.*;
import java.util.zip.*;
import java.awt.*;
import java .awt.event.*;
import javax .swing.*;
public class MyFrame extends JFrame implements ActionListener{ private static final long serialVersionUID=1L;
    private JFileChooser fileChooser = new JFileChooser(".");
    private JButton button =new JButton("打开想要解压文件");
    public MyFrame() {
        this. setTitle("解压");
        this.setPreferredSize(new Dimension(500, 400));
        this.getContentPane().add(button, BorderLayout.CENTER);
        button. addActionListener(this);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setIgnoreRepaint(true);}
    public void actionPerformed(ActionEvent e) {Object source =e.getSource();
        if (source instanceof JButton) {
            openFile();}}
    public void openFile() {
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser. setDialogTitle("打开Zip文件夹");
        int ret = fileChooser .showOpenDialog(null);
        if (ret == JFileChooser.APPROVE_OPTION) {
            System. out. println(fileChooser.getSelectedFile(). getAbsolutePath());
            File f=new File("D:\\Program Files (x86)\\Tencent\\QQ\\Bin\\book.zip");
            File dir=new File("mybook");
            byte b[]=new byte[100];
            dir.mkdir();
            try {ZipInputStream in=new ZipInputStream(new FileInputStream(f));
                ZipEntry zipEntry=null;
                while((zipEntry=in.getNextEntry())!=null);{
                    File file=new File(dir,zipEntry.getName());
                    FileOutputStream out=new FileOutputStream(file);
                    int n=-1;
                    System .out.println(file .getAbsolutePath()+"的内容：");
                    while((n=in.read(b,0,100))!=-1){
                        String str=new String(b,0,n);
                        System.out.println(str);
                        out. write(b,0,n);}
                    out.close();}
                in.close();}
            catch(IOException ee){System.out.println(ee);}}}
    public static void main(String[] args) {Frame frame = new MyFrame();frame.setVisible(true);}}
