package offer;

import org.junit.Assert;
import org.junit.Test;

public class N05_ReplaceSpace {
    @Test
    public void test() {
        String a_a = replaceSpace("a a");
        System.out.println(a_a);
        Assert.assertEquals(a_a, "a%20a");

        String b = replaceSpace("We are happy.");
        System.out.println(b);
        Assert.assertEquals(b, "We%20are%20happy.");
    }

    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder(s);
        int lastIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            lastIndex = builder.indexOf(" ", lastIndex);
            if (lastIndex < 0) {
                break;
            }
            builder.replace(lastIndex, lastIndex + 1, "%20");
        }
        return builder.toString();
    }
}
