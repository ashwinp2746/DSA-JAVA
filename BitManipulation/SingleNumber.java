/*


leetcode :- https://leetcode.com/problems/single-number/
*/

package BitManipulation;

public class SingleNumber {
    public static void main(String[] args) {
        int nums[] = {2,2,1,1,4};
        int result = 0;

        for(int i=0 ; i<nums.length ; i++){
            result = result ^ nums[i];
        }

        System.out.println(result);
    }
}
