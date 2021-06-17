package GuanLi;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Search extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    Box box1,box2,box3,baseBox;
    JButton button;
    JTextField field;
    DefaultTableModel update_table;
    JTable table;
    Query query;
    Object a[][];
    String b[];

    Search(){
        setLayout(new GridLayout());
        box1 = Box.createVerticalBox();
        box2 = Box.createVerticalBox();
        box1.add(new JLabel("学号"));
        box1.add(Box.createVerticalStrut(35));
        field = new JTextField(10);
        box2.add(field);
        box2.add(Box.createVerticalStrut(10));
        box1.add(new JLabel(""));
        button = new JButton("查找");
        button.addActionListener(this);
        box2.add(button);
        box3 = Box.createHorizontalBox();
        box3.add(box1);
        box3.add(Box.createHorizontalStrut(5));
        box3.add(box2);

        query = new Query();
        a = new Object[1][query.columnNum];
        b = query.getField();
        update_table = new DefaultTableModel(a,b);
        table = new JTable(update_table);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setPreferredSize(new Dimension(1100,50));

        baseBox = Box.createVerticalBox();
        baseBox.add(box3);
        baseBox.add(Box.createVerticalStrut(10));
        baseBox.add(scrollPane);
        add(baseBox);
        //验证表格布局使其有效
        table.revalidate();
    }

    public void actionPerformed(ActionEvent e){
        String id = field.getText();
        //学号文本框输入为空
        if(id.equals(""))
            JOptionPane.showMessageDialog(this,"请输入学号","消息对话框",JOptionPane.WARNING_MESSAGE);
        else{
            try{
                Class.forName("com.microsoft.sqlserver,jdbc.SQLServerDriver");
            }
            catch (ClassNotFoundException exp){
                System.out.println(exp);
            }
            try{
                String url,userName,userPwd;
                url = "jdbc:sqlserver://localhost:3044;DatabaseName=university";
                userName = "root";
                userPwd = "zyc20020222";
                Connection con = DriverManager.getConnection(url,userName,userPwd);
                Statement sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = sql.executeQuery("select*from student where 学号='"+id+"';");
                while (rs.next()){
                    //表格内容更新不会改变列数
                    for(int k =1;k<= query.columnNum;k++){
                        a[0][k-1] = rs.getString(k);
                    }
                }
                con.close();
                //更新表格内容
                update_table.setDataVector(a,b);
            }
            catch (SQLException ex){
                System.out.println(ex);
            }
        }
        //清空文本框，以便下一次输入
        field.setText(null);
    }
}
