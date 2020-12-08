package algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KmpTests {

    @Test
    public void givenStrsThenReturnMatchResults() {
        StrMatch strMatch = new StrMatch();
        int index = strMatch.match("ababababca", "abababca");
        Assertions.assertEquals(2, index);
    }

    @Test
    public void givenStrsWhenUseKmpThenReturnMatchResults() {
        KmpStrMatch strMatch = new KmpStrMatch("abababca");
        int index = strMatch.match("ababababca");
        Assertions.assertEquals(2, index);
    }

    @Test
    public void givenSubStrThenReturnNext() {
        KmpStrMatch strMatch = new KmpStrMatch("abababca");
        int next = strMatch.next("ababab", 6);
        Assertions.assertEquals(4, next);
    }

}

