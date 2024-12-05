package Myclass;
import java.util.ArrayList;
import java.util.List;

public class Permutation {
	public static void main(String args[]) {
		int arr[]= {1,2,3};
		permute(arr);
	}

  public static void permute(int[] nums) {

    List<List<Integer>> resultList = new ArrayList<>();

    backtrack(resultList, new ArrayList<>(), nums);
    for(List<Integer> li:resultList) {
    	System.out.println(li);
    }
  }

  private static void backtrack(List<List<Integer>> resultList,
                         ArrayList<Integer> tempList, int[] nums) {
    // If we match the length, it is a permutation
    if (tempList.size() == nums.length) {
      resultList.add(new ArrayList<>(tempList));
      for(List<Integer> li:resultList) {
    	  System.out.println("list:"+li);
      }
      return;
    }
    for (int number : nums) {
      // Skip if we get same element
      if (tempList.contains(number))
        continue;

      // Add the new element
      tempList.add(number);
      System.out.println("After adding number to templist-"+number+" "+tempList);

      // Go back to try other element
      backtrack(resultList, tempList, nums);

      // Remove the element
      tempList.remove(tempList.size() - 1);
      System.out.println("After removing templist size-"+tempList);
    }
  }

}
