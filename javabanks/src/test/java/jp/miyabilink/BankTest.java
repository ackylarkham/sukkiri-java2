package jp.miyabilink;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    /** 銀行名(漢字) */
    String nameJp = "ほげほげ銀行";
    /** 銀行名(カナ) */
    String nameKana = "ホゲホゲ";
    /** 銀行名(英語) */
    String nameEn = "Hoge-Hoge Bank, Ltd.";
    /** 金融機関コード */
    String code = "0999";

    Bank b = new Bank(nameJp,nameKana,nameEn,code);

    @Test
    void testGetBankCode() {
        assertEquals(code,b.getBankCode());
    }

    @Test
    void testGetBankNameEnglish() {
        assertEquals(nameEn, b.getBankNameEnglish());
    }

    @Test
    void testGetBankNameJapanese() {
        assertEquals(nameJp, b.getBankNameJapanese());
    }

    @Test
    void testGetBankNameKana() {
        assertEquals(nameKana,b.getBankNameKana());
    }

    @Test
    void testSetBankCode() {
        String newBankCode = "0777";
        b.setBankCode(newBankCode);
        assertEquals(newBankCode,b.getBankCode());
    }

    @Test
    void testSetBankCodeIsNotNumeric() {
        assertThrows(IllegalArgumentException.class, () -> {
            b.setBankCode("aaaa");
            }
        );
    }

    @Test
    void testSetBankCodeIsNot4Digit() {
        assertThrows(IllegalArgumentException.class, () -> {
            b.setBankCode("0");
            }
        );
    }

    @Test
    void testSetBankNameEnglish() {
        String newNameEn = "Nanchara Bank, 123.";
        b.setBankNameEnglish(newNameEn);
        assertEquals(newNameEn, b.getBankNameEnglish());
    }

    @Test
    void testSetBankNameEnglishInvalidChar() {
        String newNameEn = "あいうえお";
        assertThrows(IllegalArgumentException.class, () -> {
            b.setBankNameEnglish(newNameEn);
            }
        );
    }
    @Test
    void testSetBankNameJapanese() {
        String newNameJp = "なんちゃら銀行";
        b.setBankNameJapanese(newNameJp);
        assertEquals(newNameJp, b.getBankNameJapanese());
    }

    @Test
    void testSetBankNameJapaneseInvalidChar() {
        String newNameJp = "漢字a銀行"; // 半角文字が含まれている
        assertThrows(IllegalArgumentException.class, () -> {
            b.setBankNameJapanese(newNameJp);
            }
        );
    }

    @Test
    void testSetBankNameKana() {
        String newNameKana = "ナンチャラ";
        b.setBankNameKana(newNameKana);
        assertEquals(newNameKana, b.getBankNameKana());
    }

    @Test
    void testSetBankNameKanaLength() {
        String newNameKana = "アイウエオカキクケコサシスセソタ"; // 16文字
        assertThrows(IllegalArgumentException.class, () -> {
            b.setBankNameKana(newNameKana);
            }
        );        
    }

    @Test
    void testSetBankNameKanaInvalidChar() {
        String newNameKana = "アイウエオカキクケコサシスセ円"; // カタカナ以外が含まれている
        assertThrows(IllegalArgumentException.class, () -> {
            b.setBankNameKana(newNameKana);
            }
        );        
    }


}
