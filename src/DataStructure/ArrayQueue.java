package DataStructure;

import org.junit.Test;

/**
 * @author xiong
 * @ClassName ArrayQueue
 * @description TODO
 * @create 2020-08-18 14:14
 * @Version 1.0
 */
public class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;
    //构造函数，用于构建对象
    public ArrayQueue(int arrMaxSize){
        this.maxSize = arrMaxSize;
        this.arr = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }
    //判断队列是否满
    public boolean isFull(){
        return this.rear == this.maxSize - 1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return this.rear == this.front;
    }
    //向队列中添加数据
    public void addQueue(int n){
        if (this.isFull())
        {
            System.out.println("队列满了，不能加入数据");
        }else {
            ++this.rear;
            this.arr[this.rear] = n;
        }
    }
    //从队列中获取数据
    public int getQueue(){
        if (this.isEmpty())
        {
            throw new RuntimeException("队列为空，没有数据");
        }else {
            ++this.front;
            return  this.arr[this.front];     }
    }
    //遍历所有队列元素
    public void showQueue(){
        if (this.isEmpty())
        {
            System.out.println("队列为空，没有数据");
        }else {
            for (int i = 0; i < this.arr.length; ++i){
                System.out.printf("arr[%d]=%d\n",i,this.arr[i]);
            }
        }
    }
    //读取队列队头元素
    public int headQueue(){
        if (this.isEmpty())
        {
            throw new RuntimeException("队列是空的，没有数据");
        }else {
            return this.arr[this.front + 1];
        }
    }
}