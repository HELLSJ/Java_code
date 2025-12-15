package Heap;

public class transformListIntoHeap {
    private int[] elem;
    public int usedSize;
    public transformListIntoHeap(){
        this.elem = new int[10];//记录当前堆当中有效的数据个数
    }

    public void initElem(int[] array){
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }
    }

    public void creatHeap(){
        //usedSize-1相当于最后一棵树孩子结点的下标i，再-1是为了求父结点
        for (int parent = (usedSize-1-1)/2; parent >= 0; parent--) {
            siftDown(parent, usedSize);
        }
    }
    
    //向下调整
    private void siftDown(int parent, int len){
        int child = 2 * parent + 1;  // 找到左孩子
        while(child < len){
            // 1. 找到左右孩子中更大的那个
            if (child + 1 < len && elem[child] < elem[child + 1]){
                child = child + 1;  // child 指向更大的孩子
            }

            // 2. 比较父节点和更大孩子节点
            if(elem[child] > elem[parent]){
                // 如果孩子比父亲大：交换，让更大的上去
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;

                // 更新 parent 和 child 继续往下走
                parent = child;
                child = parent * 2 + 1;
            }else{
                // 已经满足堆性质，退出
                break;
            }
        }
    }
}
