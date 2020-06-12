## 数字的全排列

### 给定一个没有重复数字的序列，返回其所有可能的全排列。

### 示例:

## 输入: [1,2,3]
## 输出:
  1 2 3
  1 3 2
  2 1 3
  2 3 1
  3 1 2
  3 2 1

```java
public class Arrange {

//排列数组 k-m 的元素
    public void method(int[] array,int k,int m){

        if(k == m){
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        for (int i = k; i < m; i++) {
            int x = array[k];
            array[k] = array[i];
            array[i] = x;

            method(array,k+1,m);

            int y  = array[k];
            array[k] = array[i];
            array[i] = y;
        }
    }

    public static void main(String[] args) {
        Arrange arrange = new Arrange();
        int[] a = {1,2,3,4};
        arrange.method(a,0,4);
    }
}
```

