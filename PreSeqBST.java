/* Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree. */

public class PreSeqBST {
	public boolean verifyPreorder(int[] preorder) {
		return verify(0, preorder.length - 1, preorder);
	}
	
	public boolean verify(int start, int end, int[] preorder) {
		if (start > end)
			return true;
		int bound = preorder[start];
		int newEnd = -1;
		for (int i = start + 1; i <= end; i++) {
			if (newEnd == -1) {
				if (preorder[i] > bound) {
					newEnd = i - 1;
				} else if (preorder[i] == bound) {
					return false;
				}
			} else {
				if (preorder[i] <= bound) {
					return false;
				}
			}
		}
		if (newEnd == -1 || newEnd == start)
			return verify(start + 1, end, preorder);
		if (verify(start + 1, newEnd, preorder) && verify(newEnd + 1, end, preorder))
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		int[] preorder = new int[]{5,3,2,1,4,9,6,10};
		preorder = new int[]{1,2,3};
		preorder = new int[]{1,2,0};
		System.out.println(new PreSeqBST().verifyPreorder(preorder));
		System.out.println(new PreSeqBST().verifyPreorder2(preorder));
	}
	
    public boolean verifyPreorder2(int[] preorder) {
        int low = Integer.MIN_VALUE, index = -1;
        for(int i : preorder) {
            if(i < low)
                return false;
            while(index >= 0 && i > preorder[index])
                low = preorder[index--];
            preorder[++index] = i;
        }
        
        return true;
    }
}
