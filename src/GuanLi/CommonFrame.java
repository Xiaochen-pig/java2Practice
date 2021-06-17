package GuanLi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommonFrame extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    JMenuBar bar;
    JMenu menu;
    JMenuItem scanItem,deleteItem,updateItem,insertItem,searchItem;
    Scan scan;//查看所有学生信息
    Delete delete;//删除学生信息
    Update update;//更新学生信息
    Insert insert;//插入学生信息
    Search search;//查找学生信息
    CardLayout card;
    JPanel pCenter;
    CommonFrame(){
        //容器尺寸变化时，组件的相对位置不变，大小变化
        setLayout(new GridLayout());
        //创建菜单项
        scanItem = new JMenuItem("浏览");
        deleteItem = new JMenuItem("删除");
        updateItem = new JMenuItem("修改");
        insertItem = new JMenuItem("添加");
        searchItem = new JMenuItem("查找");
        //菜单条
        bar = new JMenuBar();
        //菜单
        menu = new JMenu("菜单");
        menu.add(scanItem);
        menu.add(deleteItem);
        menu.add(updateItem);
        menu.add(insertItem);
        menu.add(searchItem);
        bar.add(menu);
        //将菜单添加到容器中
        setJMenuBar(bar);
        scanItem.addActionListener(this);
        deleteItem.addActionListener(this);
        updateItem.addActionListener(this);
        insertItem.addActionListener(this);
        searchItem.addActionListener(this);

        scan = new Scan();
        update = new Update();
        delete = new Delete();
        insert = new Insert();
        search = new Search();
        //实现多个组件在同一个容器区域内交替显示，一张卡片空间中只能显示一个组件
        card = new CardLayout();

        pCenter = new JPanel();
        //以卡片布局添加各组件
        pCenter.setLayout(card);
        pCenter.add("scanItem",scan);
        pCenter.add("deleteItem",delete);
        pCenter.add("updateItem",update);
        pCenter.add("insertItem",insert);
        pCenter.add("searchItem",search);
        add(pCenter,BorderLayout.SOUTH);
        //小图标
        ImageIcon tubiao = new ImageIcon("images/2.jpg");
        setIconImage(tubiao.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(400,150,1100,400);
        setTitle("学生信息管理系统");
        //验证布局使其有效
        validate();
    }

    public void actionPerformed(ActionEvent e){
        //菜单项按下后显示对应界面
        if(e.getSource() == scanItem){
            card.show(pCenter,"scanItem");
            //更新表格内容
            scan.updateTable();
        }
        else if (e.getSource() == deleteItem)
            card.show(pCenter,"deleteItem");
        else if (e.getSource() == updateItem)
            card.show(pCenter,"updateItem");
        else if (e.getSource() == insertItem)
            card.show(pCenter,"insertItem");
        else if(e.getSource() == searchItem)
            card.show(pCenter,"searchItem");
    }
}
