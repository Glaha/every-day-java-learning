package algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KmpTests {

    @Test
    public void givenStrsThenReturnMatchResults() {
        StrMatch strMatch = new StrMatch();
        int index = strMatch.match("ababababca", "abababca");
        Assertions.assertEquals(2, index);

        index = strMatch.match("cpdacpdbcpdd", "cpdd");
        Assertions.assertEquals(8, index);
    }

    @Test
    public void givenStrsWhenUseKmpThenReturnMatchResults() {
        StrMatchKmp strMatch = new StrMatchKmp("abababca");
        int index = strMatch.match("ababababca");
        Assertions.assertEquals(2, index);

        strMatch = new StrMatchKmp("cpdd");
        index = strMatch.match("cpdacpdbcpdd");
        Assertions.assertEquals(8, index);
    }

    @Test
    public void givenSubStrThenReturnNext() {
        StrMatchKmp strMatch = new StrMatchKmp("abababca");
        int next = strMatch.next("ababab", 6);
        Assertions.assertEquals(4, next);
    }

}

