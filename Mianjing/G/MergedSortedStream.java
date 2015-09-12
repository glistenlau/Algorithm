//import java.util.Queue;
//import java.util.stream.Stream;
//
///**
// * Created by YiLIU on 9/11/15.
// */
//public class MergedSortedStream {
//  private class SortedStreamWithPeek {
//    private Comparable next;
//    private SortedStream stream;
//    SortedStreamWithPeek(SortedStream stream) {
//      this.stream = stream;
//      if (this.stream.hasNext()) {
//        next = this.stream.next();
//      }
//    }
//    Comparable next() {
//      Comparable ans = next;
//      next = null;
//      if (stream.hasNext()) {
//        next = stream.next();
//      }
//
//      return ans;
//    }
//
//    Comparable peek() {
//      return peek();
//    }
//
//    boolean hasNext() {
//      return next != null;
//    }
//  }
//}
