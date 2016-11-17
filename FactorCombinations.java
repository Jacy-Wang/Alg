import java.util.ArrayList;

public class FactorCombinations {
	public ArrayList<ArrayList<Integer>> getFactors(int n) {
		return getFactorsHelper(n, 2);
	}
	
	public ArrayList<ArrayList<Integer>> getFactorsHelper(int n, int start) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		for (int i = start; i <= (int) Math.sqrt(n); i++) {
			if (n % i == 0) {
				ArrayList<Integer> cand = new ArrayList<>();
				cand.add(i);
				cand.add(n / i);
				res.add(cand);
				ArrayList<ArrayList<Integer>> tmp = getFactorsHelper(n / i, i);
				for (int j = 0; j < tmp.size(); j++) {
					cand = new ArrayList<>();
					cand.add(i);
					for (int k = 0; k < tmp.get(j).size(); k++) {
						cand.add(tmp.get(j).get(k));
					}
					res.add(cand);
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] n = new int[]{1, 37, 12, 32, 8};
		FactorCombinations fc = new FactorCombinations();
		
		for (int i = 0; i < n.length; i++) {
			ArrayList<ArrayList<Integer>> res = fc.getFactors(n[i]);
			System.out.println("num = " + n[i]);
			for (int j = 0; j < res.size(); j++) {
				for (int k = 0; k < res.get(j).size(); k++) {
					System.out.print(res.get(j).get(k) + " ");
				}
				System.out.print("\n");
			}
		}
	}
}
