package jp.miyabilink;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class ToZenginCharacterTest {

    @Test
    void testToZenginChar0001() {
        final String str = "ァアィイゥウェエォオカガキギクグケゲコゴサザシジスズセゼソゾタダチヂッツヅテデトドナニヌネノハバパヒビピフブプヘベペホボポマミムメモャヤュユョヨラリルレロヮワヰヱヲンヴヵヶー";
        final String type = "all";
        assertEquals("ｱｱｲｲｳｳｴｴｵｵｶｶﾞｷｷﾞｸｸﾞｹｹﾞｺｺﾞｻｻﾞｼｼﾞｽｽﾞｾｾﾞｿｿﾞﾀﾀﾞﾁﾁﾞﾂﾂﾂﾞﾃﾃﾞﾄﾄﾞﾅﾆﾇﾈﾉﾊﾊﾞﾊﾟﾋﾋﾞﾋﾟﾌﾌﾞﾌﾟﾍﾍﾞﾍﾟﾎﾎﾞﾎﾟﾏﾐﾑﾒﾓﾔﾔﾕﾕﾖﾖﾗﾘﾙﾚﾛﾜﾜｲｴｦﾝｳﾞｶｹ-",jp.miyabilink.ToZenginChar.toZenginChar(str,type));
    }

    @Test
    void testToZenginChar0002() {
        final String str = "0123456789";
        final String type = "all";
        assertEquals("0123456789",jp.miyabilink.ToZenginChar.toZenginChar(str,type));
    }

    @Test
    void testToZenginChar0003() {
        final String str = "０１２３４５６７８９";
        final String type = "all";
        assertEquals("0123456789",jp.miyabilink.ToZenginChar.toZenginChar(str,type));
    }

    @Test
    void testToZenginChar0004() {
        final String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String type = "all";
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",jp.miyabilink.ToZenginChar.toZenginChar(str,type));
    }

    @Test
    void testToZenginChar0005() {
        final String str = "abcdefghijklmnopqrstuvwxyz";
        final String type = "all";
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",jp.miyabilink.ToZenginChar.toZenginChar(str,type));
    }

    @Test
    void testToZenginChar0006() {
        final String str = "ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺ";
        final String type = "all";
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",jp.miyabilink.ToZenginChar.toZenginChar(str,type));
    }

    @Test
    void testToZenginChar0007() {
        final String str = "ａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚ";
        final String type = "all";
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",jp.miyabilink.ToZenginChar.toZenginChar(str,type));
    }

    @Test
    void testToZenginChar0008() {
        final String str = "ａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚ";
        final String type = "all";
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",jp.miyabilink.ToZenginChar.toZenginChar(str,type));
    }

    @Test
    void testToZenginChar0009() {
        final String str = "　「」．（）＋￥−／，？：’";
        final String type = "all";
        assertEquals(" ｢｣.()+¥-/,?:'",jp.miyabilink.ToZenginChar.toZenginChar(str,type));
    }

    @Test
    void testToZenginChar0010() {
        final String str = " ｢｣.()+¥-/,?:'";
        final String type = "all";
        assertEquals(" ｢｣.()+¥-/,?:'",jp.miyabilink.ToZenginChar.toZenginChar(str,type));
    }

    @Test
    void testToZenginChar0901() {
        final String str = "アアあ";
        final String type = "all";
        IllegalArgumentException expected = 
            assertThrows(IllegalArgumentException.class, () -> jp.miyabilink.ToZenginChar.toZenginChar(str,type));
        assertEquals("全銀で使用できない文字が含まれている", expected.getMessage());
    }

    @Test
    void testToZenginChar0902() {
        final String str = "アアア";
        final String type = "abc";
        IllegalArgumentException expected = 
            assertThrows(IllegalArgumentException.class, () -> jp.miyabilink.ToZenginChar.toZenginChar(str,type));
        assertEquals("適用業務が正しくない", expected.getMessage());
    }

    @Test
    void testToZenginChar1001() {
        final String str = "ァアィイゥウェエォオカガキギクグケゲコゴサザシジスズセゼソゾタダチヂッツヅテデトドナニヌネノハバパヒビピフブプヘベペホボポマミムメモャヤュユョヨラリルレロヮワヰヱンヴヵヶー";
        final String type = "branchName";
        assertEquals("ｱｱｲｲｳｳｴｴｵｵｶｶﾞｷｷﾞｸｸﾞｹｹﾞｺｺﾞｻｻﾞｼｼﾞｽｽﾞｾｾﾞｿｿﾞﾀﾀﾞﾁﾁﾞﾂﾂﾂﾞﾃﾃﾞﾄﾄﾞﾅﾆﾇﾈﾉﾊﾊﾞﾊﾟﾋﾋﾞﾋﾟﾌﾌﾞﾌﾟﾍﾍﾞﾍﾟﾎﾎﾞﾎﾟﾏﾐﾑﾒﾓﾔﾔﾕﾕﾖﾖﾗﾘﾙﾚﾛﾜﾜｲｴﾝｳﾞｶｹ-",jp.miyabilink.ToZenginChar.toZenginChar(str,type));
    }

    @Test
    void testToZenginChar1002() {
        final String str = "0123456789";
        final String type = "all";
        assertEquals("0123456789",jp.miyabilink.ToZenginChar.toZenginChar(str,type));
    }

    @Test
    void testToZenginChar1003() {
        final String str = "０１２３４５６７８９";
        final String type = "branchName";
        assertEquals("0123456789",jp.miyabilink.ToZenginChar.toZenginChar(str,type));
    }

    @Test
    void testToZenginChar1004() {
        final String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String type = "branchName";
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",jp.miyabilink.ToZenginChar.toZenginChar(str,type));
    }

    @Test
    void testToZenginChar1005() {
        final String str = "abcdefghijklmnopqrstuvwxyz";
        final String type = "branchName";
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",jp.miyabilink.ToZenginChar.toZenginChar(str,type));
    }

    @Test
    void testToZenginChar1006() {
        final String str = "ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺ";
        final String type = "branchName";
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",jp.miyabilink.ToZenginChar.toZenginChar(str,type));
    }

    @Test
    void testToZenginChar1007() {
        final String str = "ａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚ";
        final String type = "branchName";
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",jp.miyabilink.ToZenginChar.toZenginChar(str,type));
    }

    @Test
    void testToZenginChar1008() {
        final String str = "ａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚ";
        final String type = "branchName";
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",jp.miyabilink.ToZenginChar.toZenginChar(str,type));
    }

    @Test
    void testToZenginChar1009() {
        final String str = "−";
        final String type = "branchName";
        assertEquals("-",jp.miyabilink.ToZenginChar.toZenginChar(str,type));
    }

    @Test
    void testToZenginChar1010() {
        final String str = "-";
        final String type = "branchName";
        assertEquals("-",jp.miyabilink.ToZenginChar.toZenginChar(str,type));
    }

    @Test
    void testToZenginChar1901() {
        final String str = "アヲア";
        final String type = "branchName";
        IllegalArgumentException expected = 
            assertThrows(IllegalArgumentException.class, () -> jp.miyabilink.ToZenginChar.toZenginChar(str,type));
        assertEquals("全銀で使用できない文字が含まれている", expected.getMessage());
    }

    @Test
    void testToZenginChar1902() {
        final String str = "ア　ア";
        final String type = "branchName";
        IllegalArgumentException expected = 
            assertThrows(IllegalArgumentException.class, () -> jp.miyabilink.ToZenginChar.toZenginChar(str,type));
        assertEquals("全銀で使用できない文字が含まれている", expected.getMessage());
    }

    @Test
    void testToZenginChar1903() {
        final String str = "ア（ア";
        final String type = "branchName";
        IllegalArgumentException expected = 
            assertThrows(IllegalArgumentException.class, () -> jp.miyabilink.ToZenginChar.toZenginChar(str,type));
        assertEquals("全銀で使用できない文字が含まれている", expected.getMessage());
    }
}
