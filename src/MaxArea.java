/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
 */

public class MaxArea {
    public int maxArea2(int[] height) {
        int area=0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                if((j-i)*Math.min(height[i],height[j])>area)
                    area=(j-i)*Math.min(height[i],height[j]);
            }
        }
        return area;


    }
    public int maxArea(int[] height) {
        int i=0,j=height.length-1,area=0,max=0;
        while(i<j){
            if(height[i]<height[j]){
                area=(j-i)*height[i];
                //if we move j, the value of height[j] may not be used.
                //giving height[j] is higher. the higher one is useless if we move j.
                i++;
            }
            if(height[i]>height[j]){
                area=(j-i)*height[j];
                //as I analysed above.
                j--;
            }
            if (area>max)
                max=area;
        }
        return max;


    }
}
