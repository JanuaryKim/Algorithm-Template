package baekjoon.queue_큐.dequeue_덱;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/** 미완성, 20201008 **/
public class B10866_덱 {
    public static void main(String[] args) {
        MyDequeue myDequeue = new MyDequeue();

        Scanner scanner = new Scanner(System.in);

        int n = Integer.valueOf(scanner.nextLine());

        List<String> commandsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            commandsList.add(command);
        }

        for (String command : commandsList) {
            String[] splStr = command.split(" ");

            switch (splStr[0]) {
                case "push_front":
                    myDequeue.push_front(Integer.valueOf(splStr[1]));
                    break;
                case "push_back":
                    myDequeue.push_back(Integer.valueOf(splStr[1]));
                    break;
                case "pop_front":
                    myDequeue.pop_front();
                    break;
                case "pop_back":
                    myDequeue.pop_back();
                    break;
                case "size":
                    myDequeue.size();
                    break;
                case "empty":
                    myDequeue.empty();
                    break;
                case "front":
                    myDequeue.front();
                    break;
                case "back":
                    myDequeue.back();
                    break;

            }
        }
    }
}

class MyDequeue{

    int[] data; //실제 데이터가 저장될 공간
    int index = 0; //데이터가 뒤로 쌓일때 넣어야할 위치의 인덱스

    public MyDequeue() {
        this(10);
    }

    public MyDequeue(int size) {

        if(size <= 0) throw new RuntimeException("size exception");

        this.data = new int[size];
    }

    public void push_front(int value) {

        if (this.index == this.data.length - 1) { //만약 뒤쪽 넣을 인덱스가 마지막으로 들어갈 수 있는 상태라면 미리 공간 넓혀 놓음
           createNewArr(); //10만큼 더 커진 배열로 교체
        }

        moveElementsToNextPosition(); //배열의 요소들 한칸씩 뒤로 밀림

        this.data[0] = value; //제일 앞인 0번째에 데이터 넣음
        this.index++; //한칸씩 밀렸으므로, 끝에 들어갈때의 인덱스도 증가 시킴

    }

    private void moveElementsToNextPosition() {

        for (int i = this.index; i >= 0; i--) {
            data[i+1] = data[i];
        }
    }

    private void moveElementsToPreviousPosition() {
        this.data = Arrays.copyOfRange(this.data, 1, this.data.length);
    }

    private void createNewArr() {

        int[] newArr = Arrays.copyOf(this.data, this.data.length + 10);
        this.data = newArr;
    }

    public void push_back(int value) {

        if (this.index == this.data.length - 1) {
            createNewArr();
        }

        this.data[index] = value;
        this.index++;
    }

    public void pop_front() {
        if(this.index == 0)
        {
            System.out.println(-1);
            return;
        }

        int popValue = this.data[0];

        printElements(popValue);

        moveElementsToPreviousPosition();

        this.index--;
    }

    /** 가장 뒤에 요소 꺼내기 **/
    public void pop_back() {
        if(this.index == 0)
        {
            System.out.println(-1);
            return;
        }

        int popValue = this.data[index - 1];

        printElements(popValue);

        this.data[index - 1] = 0;
        this.index--;
    }

    /** 들어있는 요소의 사이즈 **/
    public void size() {
        printElements(this.index);
    }

    /** 들어있는 요소가 있는지 **/
    public void empty() {
        printElements(this.index == 0 ? 1 : 0);
    }

    public void front() {
        if (this.index == 0) {
            System.out.println(-1);
            return;
        }
        printElements(this.data[0]);
    }

    public void back() {
        if (this.index == 0) {
            System.out.println(-1);
            return;
        }
        printElements(this.data[index-1]);
    }


    public void print() {

        for (int i = 0; i <= this.index; i++) {
            if(i == this.index)
                System.out.println(this.data[i]);
            else
                System.out.print(this.data[i] + " , ");
        }
    }

    private void printElements(int value) {
        System.out.println(value);
    }



}
