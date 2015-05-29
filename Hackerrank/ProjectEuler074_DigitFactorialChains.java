import java.util.*;

/**
 * Created by yi on 4/13/15.
 */
public class ProjectEuler074_DigitFactorialChains {
    private int[] factorial = new int[10];
    private Map<Integer, Integer> cachestep = new HashMap<Integer, Integer>();
    private List<Integer> result = new ArrayList<Integer>();

    public ProjectEuler074_DigitFactorialChains() {
        factorial[0] = 1;
        factorial[1] = 1;
        factorial[2] = 2;
        factorial[3] = 6;
        factorial[4] = 24;
        factorial[5] = 120;
        factorial[6] = 720;
        factorial[7] = 5040;
        factorial[8] = 40320;
        factorial[9] = 362880;
        cachestep.put(169, 3);
        cachestep.put(145, 1);
        cachestep.put(871, 2);
        cachestep.put(1454, 3);
        cachestep.put(872, 2);
        cachestep.put(363601, 3);
        cachestep.put(45361, 2);
    }


    private Stack<Integer> split(int num) {
        Stack<Integer> results = new Stack<Integer>();
        if (num < 10) {
            results.push(num);
            return results;
        }
        while (num > 0) {
            results.push(num % 10);
            num /= 10;
        }
        return results;
    }


    private void ValidNumber(int num, int L) {
        Stack<Integer> op = split(num);
        List<Integer> chain = new ArrayList<Integer>();
        chain.add(num);
        for (int i = 0; i < L; i++) {
            int N = op.size();
            int temp = 0;
            for (int j = 0; j < N; j++) {
                temp += factorial[op.pop()];
            }
            if(chain.contains(temp)){
                int ind = chain.indexOf(temp) + 1;
                for(int ii = 0; i < ind; i++){
                    if(!cachestep.containsKey(chain.get(ii)))
                        cachestep.put(chain.get(ii), i - ii + 1);
                }
                if(i != L - 1){
                    return;
                } else{
                    result.add(num);
                    return;
                }
            } else{
                if(cachestep.containsKey(temp)){
                    if(cachestep.get(temp) + i == L - 1){
                        result.add(num);
                        return;
                    } else if(cachestep.get(temp) + i < L - 1){
                        return;
                    }
                }
                chain.add(temp);
                op = split(temp);
            }
        }
    }

    public List<Integer> getResult(int num, int L) {
        result.clear();
        for (int i = 0; i < num + 1; i++) {
            if (cachestep.containsKey(i)) {
                if (cachestep.get(i) == L) {
                    result.add(i);
                }
            } else {
                ValidNumber(i, L);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        ProjectEuler074_DigitFactorialChains test = new ProjectEuler074_DigitFactorialChains();
        Scanner in = new Scanner(System.in);
        int t, num, L;
        t = in.nextInt();
        for (int i = 0; i < t; i++) {
            List<Integer> out = new ArrayList<Integer>();
            String s = new String();
            num = in.nextInt();
            L = in.nextInt();
            out = test.getResult(num, L);
            int n = out.size();
            if (n == 0) {
                System.out.println("-1");
            } else {
                for (int j = 0; j < n; j++) {
                    int nn = out.get(j);
                    s += "" + nn + " ";
                }
                System.out.println(s);
            }
        }
    }
}
