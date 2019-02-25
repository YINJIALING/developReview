package easy;

public class 输入有序数组 {

	public static void main(String[] args) {
//		print(twoSum(new int[] {2,7,11,15},9));
//		print(twoSum(new int[] {2,3,4},6));
//		print(twoSum(new int[] {-1,0},-1));
		print(twoSum(new int[] {5,25,75},100));
	}
	
    public static int[] twoSum(int[] numbers, int target) {
    	int[] res=new int[2];
    	int length=0;
    	int max=0;
    	if(numbers[0]+numbers[numbers.length-1]==target) {
    		res[0]=1;
    		res[1]=numbers.length;
    		return res;
    	}
        for(int i=0;i<=numbers.length-2;i++) {
        	target-=numbers[i];
        	length=numbers.length-1;
        	max=numbers[length];
        	while(i<length&&max>target) {
        		max=numbers[length];
        		if(max==target) {
            		res[0]=i+1;
            		res[1]=length+1;
            		return res;
            	}else {
            		length--;
            	}
        		
        	}
        	if(max==target) {
        		res[0]=i+1;
        		res[1]=length+1;
        		return res;
        	}  
        	target
        }
        return res;
    }
    
    private static void print(int[] a) {
    	for(int i:a) {
    		System.out.print(i+" ");
    	}
    	System.out.println();
    }

}
