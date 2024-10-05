package jp.miyabilink;
/**
 * 銀行を表すクラス
 */

public class Bank {
    /** 
     * 銀行名(漢字)
     */
    private String bankNameJapanese;
    /** 
     * 銀行名(カナ)
     * 15文字以内であること 
     */
    private String bankNameKana;

    /** 
     * 銀行名(英語)
     */
    private String bankNameEnglish;
    /** 
     * 金融機関コード
     * 数字4桁であること
     */
    private String bankCode;

    /**
     * デフォルトコンスタラクター
     * @param bankNameJapanese 銀行名(漢字)
     * @param bankNameKana 銀行名(カナ)
     * @param bankNameEnglish 銀行名(英語)
     * @param bankCode 金融機関コード
     */
    public Bank(String bankNameJapanese, String bankNameKana, String bankNameEnglish, String bankCode) {
        this.setBankNameJapanese(bankNameJapanese);
        this.setBankNameKana(bankNameKana);
        this.setBankNameEnglish(bankNameEnglish);
        this.setBankCode(bankCode);
    }

    /**
     * 銀行名(漢字)を取得する
     * @return 銀行名(漢字)
     */
    public String getBankNameJapanese() {
        return this.bankNameJapanese;
    }

    /**
     * 銀行名(漢字)を設定する
     * @param bankNameJapanese 銀行名(漢字)
     */
    public void setBankNameJapanese(String bankNameJapanese) {
        if (bankNameJapanese.matches("^[^ -~｡-ﾟ]+$")) {
            //OK [^ -~｡-ﾟ]は「半角英数字」、「半角記号」、「半角カタカナ」以外、すなわち全角文字を表す正規表現
        } else {
            throw new IllegalArgumentException("銀行名はすべて全角文字でなければならない");
        }

        this.bankNameJapanese = bankNameJapanese;
    }

    /**
     * 銀行名(カナ)を取得する
     * @return 銀行名(カナ)
     */
    public String getBankNameKana() {
       return this.bankNameKana; 
    }

    /**
     * 銀行名(カナ)を設定する
     * @param bankNameKana 銀行名(カナ)
     */
    public void setBankNameKana(String bankNameKana) {
        if (bankNameKana.length() <= 15) {
            if (bankNameKana.matches("^[\\u30A0)-\\u30FF]+$")) {
                //OK 銀行名(カナ)は15文字以内ですべて全角カタカナである
            } else {
                throw new IllegalArgumentException("銀行名(カナ)はすべて全角カタカナでなければならない");
            }
        } else {
            throw new IllegalArgumentException("銀行名(カナ)は15文字以内でなければならない");
        }
        this.bankNameKana = bankNameKana;
    }
    /**
     * 銀行名(英語)を取得する
     * @return 銀行名(英語)
     */
    public String getBankNameEnglish () {
        return this.bankNameEnglish;
    }

    /**
     * 銀行名(英語)を設定する
     * @param bankNameEnglish 銀行名(英語)
     */
    public void setBankNameEnglish(String bankNameEnglish) {
        if (bankNameEnglish.matches("^[a-zA-Z0-9 ,-.]*$")) {
            //OK 半角の英数字、空白、カンマ、ハイフンおよびピリオド
        } else {
            throw new IllegalArgumentException("銀行名(英語は)半角英数字記号でなければならない");
        }
        this.bankNameEnglish = bankNameEnglish;
    }

    /**
     * 金融機関コードを取得する
     * @return 金融機関コード
     */
    public String getBankCode() {
        return this.bankCode;
    }

    /**
     * 金融機関コードを設定する
     * @param bankCode 金融機関コード
     */
    public void setBankCode(String bankCode) {
        if (bankCode.length() == 4) {
            if (bankCode.matches("^[0-9]+$")) {
                //OK 金融機関コードは半角数字4桁である
            } else {
                throw new IllegalArgumentException("金融機関コードは半角数字でなくてはならない");
            }
        } else {
            throw new IllegalArgumentException("金融機関コードは4桁でなくてはならない");
        }
        this.bankCode = bankCode;
    }
}
