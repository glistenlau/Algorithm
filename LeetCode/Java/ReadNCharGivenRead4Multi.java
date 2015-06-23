/**
 * Created by yi on 4/20/15.
 */
public class ReadNCharGivenRead4Multi extends Reader4 {
    int offset = 0, bufsize = 0;
    int readBytes;
    private char[] buffer = new char[4];

    public int read(char[] buf, int n) {
        boolean eof = false;
        while (!eof && readBytes < n) {
            int sz = (bufsize > 0) ? bufsize : read4(buffer);
            if (bufsize == 0 && sz < 4) eof = true;
            int bytes = Math.min(sz, n - readBytes);
            System.arraycopy(buffer, offset, buf, readBytes, bytes);
            readBytes += bytes;
            offset = (offset);
        }
        return readBytes;
    }
}
