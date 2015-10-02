import java.util.stream.Stream;

/**
 * Created by YiLIU on 9/29/15.
 */
public interface SortedStream {
  Comparable next();
  boolean hasNext();
}
