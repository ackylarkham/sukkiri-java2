package jp.miyabilink;
/**
 * 銀行を表すクラス
 */

public class Bank {
    /** 
     * 銀行名(漢字)
     * 
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
     * 数字4桁でなくてはならない
     */
    private String bankCode;

    /**
     * デフォルトコンスタラクター
     * @param nameJp 銀行名(漢字)
     * @param nameKana 銀行名(カナ)
     * @param nameEn 銀行名(英語)
     * @param code 金融機関コード
     */
    public Bank(String nameJp, String nameKana,String nameEn, String code) {
        this.setBankNameJapanese(nameJp);
        this.setNameKana()
    }
}
