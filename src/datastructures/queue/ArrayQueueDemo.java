package datastructures.queue;

import java.util.Scanner;

/**
 * 数组实现队列
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/7/22 17:55
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试
        System.out.println("测试数组模拟队列的案例~~");
        //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        //接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        //输出一个菜单
        boolean loop = true;
        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取出数据");
            System.out.println("h(head)：查看队列头的数据");
            System.out.println("e(exit)：退出程序");
            //接收一个字符
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int result = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", result);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int result = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", result);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }
}

/**
 * 使用数组模拟队列-编写一个ArrayQueue类
 */
class ArrayQueue {
    /**
     * 表示数组的最大容量
     */
    private int maxSize;
    /**
     * 队列头
     */
    private int front;
    /**
     * 队列尾
     */
    private int rear;
    /**
     * 该数组用于存放数据，模拟队列
     */
    private int[] arr;

    /**
     * 创建队列的构造器
     */
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        //指向队列头部，分析出front是指向队列头的前一个位置
        front = -1;
        //指向队列尾部，指向队列尾的数据（即就是队列最后一个数据）
        rear = -1;
    }

    /**
     * 判断队列是否满
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据到队列
     */
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        rear++; //让rear 后移
        arr[rear] = n;
    }

    /**
     * 获取队列的数据，出队列
     */
    public int getQueue() {
        //判断队列是否空
        if (isEmpty()) {
            //通过抛出异常
            throw new RuntimeException("队列空，不能取出数据");
        }
        front++; //让front 后移
        return arr[front];
    }

    /**
     * 显示队列所有数据
     */
    public void showQueue() {
        //判断队列是否空
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~");
            return;
        }
        //遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    /**
     * 显示队列的头数据，注意不是取出数据
     */
    public int headQueue() {
        //判断队列是否空
        if (isEmpty()) {
            //通过抛出异常
            throw new RuntimeException("队列空的，没有数据~");
        }
        return arr[front + 1];
    }
}