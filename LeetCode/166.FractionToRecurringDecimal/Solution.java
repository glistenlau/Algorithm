public class Solution {
  public String fractionToDecimal(int numerator, int denominator) {
    StringBuilder result = new StringBuilder();
    boolean neg = false;
    if ((long)numerator * denominator < 0) {
      neg = true;
    }
    long numer = Math.abs((long)numerator);
    long denom = Math.abs((long)denominator);

    long num = numer / denom;
    long fac = numer % denom;

    if (fac == 0) {
      return neg? "-" + num: "" + num;
    }

    HashMap<Long, Integer> mod = new HashMap<>();
    mod.put(fac, 0);
    fac *=  10;
    int index = 1;

    while (!mod.containsKey(fac % denom)) {
      result.append(fac / denom);
      if (fac % denom == 0) {
        break;
      }
      mod.put(fac % denom, index++);
      fac = fac % denom * 10;
    }

    if (fac % denom != 0) {
      result.append(fac / denom);
      index = mod.get(fac % denom);
      result.insert(index, '(');
      result.append(')');
    }

    result.insert(0, '.');
    result.insert(0, num);
    if (neg) {
      result.insert(0, '-');
    }

    return result.toString();
  }
}