package DataStructure;

import java.util.Scanner;

/**
 * @author xiong
 * @ClassName ArrayQueueDemo
 * @description 用数组存储方式实现队列
 * @create 2020-08-18 14:33
 * @Version 1.0
 *
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';//用于存放用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出菜单
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("a(add):添加队列元素");
            System.out.println("g(get):获取队列元素");
            System.out.println("h(head):获取队列的头元素");
            System.out.println("e(exit):退出程序");
            key = scanner.next().charAt(0);

            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入需要添加的元素");
                    arrayQueue.addQueue(scanner.nextInt());
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("队列头的数据是：%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    System.out.println("程序退出");
            }

        }
    }
}