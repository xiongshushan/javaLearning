package DataStructure;

import java.awt.*;
import java.util.Scanner;

/**
 * @author xiong
 * @ClassName CircleArrayQueueDemo
 * @description 用数组的方式实现环形队列，相对于一般队列较难，习惯取模
 * @create 2020-08-18 15:05
 * @Version 1.1
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        System.out.println("测试数组模拟环形队列的案例");
        CircleArray queue = new CircleArray(4);
        char key = ' ';//用于存放用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出菜单
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("a(add):添加队列元素");
            System.out.println("g(get):获取队列元素");
            System.out.println("h(head):获取队列的头元素");
            System.out.println("e(exit):退出程序");
            key = scanner.next().charAt(0);

            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入需要添加的元素");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是：%d\n", res);
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
//循环队列定义
class CircleArray {
    private int maxSize;//数组的最大容量
    private int front;//front指向队列第一个元素 初始值front=0
    private int rear;//rear指向队列的倒数第二个元素，第一个预留
    private int[] arr;//用于存放数据

    //构造器
    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //判断是否为空
    public boolean isFull() {
        return (rear + 1) % maxSize == front;//因为是环形，所以必须总长度取模
    }

    //判断是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //给队列添加元素
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    //    从队列中获取元素
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能获取数据");
        }

        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //    遍历输出队列元素
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列是空，没有数据");
            return;
        }

        for (int i = front; i < front + size(); i++) //必须先知道有效个数，因为可能程序会随时取出元素
        {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //    判断队列的有效个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //    获取队列的头元素
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列是空的，没有数据");
        }
        return arr[front];
    }
}