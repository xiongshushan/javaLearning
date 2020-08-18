package DataStructure;

import java.util.*;

/**
 * @author xiong
 * @ClassName SingleLinkedListDemo
 * @description TODO
 * @create 2020-08-18 15:42
 * @Version 1.0
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("java语言用单链表实现增删改查操作 ");
            System.out.println("***********按键输入说明***********");
            System.out.println("a:可以在指定位置插入数据");
            System.out.println("y:在链表尾部插入数据");
            System.out.println("d:在指定位置删除数据");
            System.out.println("u:在指定位置修改数据");
            System.out.println("g:获取指定位置数据");
            System.out.println("l:获取链表数据长度");
            System.out.println("s:显示链表中所有数据详情");
            System.out.println("e:退出程序");
            System.out.println("请输入相应字母操作：");
            key = scanner.next().charAt(0);
            switch (key){
                case 'a':
                    Node node = singleList.createNode(scanner);
                    System.out.println("请输入插入位置：");
                    int locationOK = singleList.locationOK(scanner, singleList);
                    singleList.addLocation(locationOK-1,node);
                    System.out.println("添加数据到第" + locationOK + "个位置成功");
                    break;
                case 'y':
                    Node node1 = singleList.createNode(scanner);
                    singleList.addtail(node1);
                    System.out.println("添加尾部成功");
                    break;
                case 'd':
                    System.out.println("请输入删除位置");
                    int locationOK2 = singleList.locationOK(scanner, singleList);
                    singleList.delete(locationOK2);
                    System.out.println("删除成功");
                    break;
                case 'u':
                    Node node2 = singleList.createNode(scanner);
                    System.out.println("请输入修改位置");
                    int locationOK3 = singleList.locationOK(scanner, singleList);
                    singleList.update(locationOK3,node2);
                    System.out.println("修改成功");
                    break;
                case 'g':
                    System.out.println("请输入获取位置");
                    int locationOK4 = singleList.locationOK(scanner, singleList);
                    Node node3 = singleList.getNode(locationOK4);
                    System.out.println(node3.toString());
                    System.out.println("获取成功");
                    break;
                case 'l':
                    System.out.println(singleList.length());
                    System.out.println("获取成功");
                    break;
                case 's':
                    singleList.ShowSingleList();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            };




            }
        System.out.println("程序退出");
    }

}
class SingleList{
    private Node node;
    private Node headNode = new Node("head",0,0);

    public void singleList(Node node) {
        this.node = node;
    }

    public void singleList() {

    }

    public int locationOK(Scanner scanner,SingleList singleList){
        int location1 = scanner.nextInt();
        if (location1 > singleList.length() || location1 < 0){
            System.out.print("输入长度不合法：请重新输入：");
            int newLocation = scanner.nextInt();
            return newLocation;
        }
        return location1;
    }

    public Node createNode(Scanner scanner){
        System.out.print("请输入姓名：");
        String name = scanner.next();
        System.out.print("请输入ID:");
        int id = scanner.nextInt();
        System.out.print("请输入成绩:");
        int score = scanner.nextInt();
        Node node = new Node(name, id, score);
        return node;
    }

    public void addtail(Node node){
        Node temp = headNode;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.numOrder = temp.numOrder + 1;
    }

    public void addLocation(int location,Node node){
        Node temp = lookLocationNode(location);
        node.next = temp.next;
        temp.next = node;
        node.numOrder = temp.numOrder + 1;
        while (true){
            if (node.next == null){
                break;
            }
            node = node.next;
            node.numOrder++;
        }

    }

    public void delete(int location){
        Node temp = lookLocationNode(location - 1);
        temp.next = temp.next.next;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
            temp.numOrder--;
        }

    }

    public Node lookLocationNode(int location){
        Node temp = headNode;
        while (true){
            if (temp.numOrder == location){
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    public void update(int location,Node node){
        Node node1 = lookLocationNode(location);
        node1.ID = node.ID;
        node1.name = node.name;
        node1.score = node.score;
    }

    public int length(){
        Node temp = headNode;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        return temp.numOrder;
    }

    public Node getNode(int numOrder){
        Node temp = headNode;
        if (this.length() < numOrder || numOrder < 0){
            System.out.println("输入长度不在范围内");
        }else {
            while (true){
                if (temp.numOrder == numOrder){
                    break;
                }
                temp = temp.next;
            }
        }
        return temp;
    }

    public void ShowSingleList(){
        Node temp = headNode;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
            System.out.println(temp.toString());
        }
    }
}

class Node{
    public int numOrder;
    public String name;
    public int ID;
    public double score;
    public Node next;

    public Node(int numOrder, String name, int ID, double score) {
        this.numOrder = numOrder;
        this.name = name;
        this.ID = ID;
        this.score = score;
    }

    public Node(String name, int ID, double score) {
        this.name = name;
        this.ID = ID;
        this.score = score;
    }

    public Node() {
    }

    public int getNumOrder() {
        return numOrder;
    }

    public void setNumOrder(int numOrder) {
        this.numOrder = numOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "numOrder=" + numOrder +
                ", name=" + name +
                ", ID=" + ID +
                ", score=" + score +
                '}';
    }
}