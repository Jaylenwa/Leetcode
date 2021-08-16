package Tencent精选;

/**
 * @author WJL
 * @date: 2021/08/12 14:20
 * <p>
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 **/

public class 盛最多水的容器 {

    public static void main(String[] args) {
        int[] height = {2,1};
        System.out.println(maxArea(height));
    }


    //如果长板向内移动，面积一定变小 可以直接忽略
    //如果短板向内移动，面积可能会小，但可能会大，只把短板向内移动 ，并记录最大值返回
    public static int maxArea(int[] height) {

        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            res = height[i] < height[j] ?
                    Math.max((j - i) * height[i++], res):
                    Math.max((j - i) * height[j++], res);
        }

//        while (i < j) {
//            if (height[i] < height[j]) {
//                int temp = (j - i) * height[i];
//                res = Math.max(temp, res);
//                i++;
//            } else {
//                int temp = (j - i) * height[j];
//                res = Math.max(temp, res);
//                j--;
//            }
//        }
        return res;
    }

}