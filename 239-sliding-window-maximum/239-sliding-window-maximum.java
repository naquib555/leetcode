class Solution {
	ArrayDeque<Integer> deq = new ArrayDeque<>();

	public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		if (n * k == 0) return new int[0];
		if (n == 1) return nums;
		
		int max_id = 0;

		for (int i = 0; i < k; i++) {
            cleanDeque(i, k, nums);
            deq.addLast(i);

            if (nums[i] > nums[max_id])
                max_id = i;
        }

        int [] output = new int[n - k + 1];
        output[0] = nums[max_id];

        for (int i = k; i < n; i++) {
            cleanDeque(i, k, nums);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }

        return output;
    }

    void cleanDeque(int i, int k, int[] nums) {
        if (!deq.isEmpty() && deq.getFirst() == (i - k))
            deq.removeFirst();

        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
            deq.removeLast();
        }
    }
}
