package jp.miyabilink;
import java.util.*;
/**
 * 文字列を全銀使用可能な半角文字列に変換する
 * <p>
 * 全銀で使用できる文字は半角で以下のとおり
 * <ul>
 * <li>数字0から9
 * <li>英大文字AからZ
 * <li>カタカナ(捨て仮名を除く)
 * <li>濁点、および半濁点
 * <li>空白
 * <li>記号 ｢｣ . () + ¥ - / , ? : ' 
 * </ul>
 * 
 * 入力の文字列に含まれる英小文字、捨て仮名(小書き文字)、長音記号、中点は、以下のとおり変換する
 * <ul>
 * <li>英小文字: 英大文字に変換
 * <li>捨て仮名(小書き文字): 並字(大文字)に変換
 * <li>長音記号: ハイフンに変換
 * <li>中点: ピリオドに変換
 * </ul>
 */
public class ToZenginChar {

    /* 使用可能文字正規表現 */
    private final static Map<String, String> VALID_CHAR_REGEX = new HashMap<String,String>() {
        {
            //カタカナ捨て文字(小書き文字)、英小文字、長音、中点は受け入れた上で変換する前提で正規表現を定義する
            put("all", "^[-0-9A-Za-z･-ﾟ０-９Ａ-Ｚａ-ｚァ-ヶー・　「」．（）＋￥−／，？：’ ｢｣.()+¥ｰ/,?:']+$");
            //店名
            put("branchName", "^[-0-9A-Za-zｧ-ﾟ０-９Ａ-Ｚａ-ｚァ-ヱン-ヶー−]+$");
            //口座名等
            put("accountHolder", "^[-0-9A-Za-z･ｧ-ﾟ０-９Ａ-Ｚａ-ｚァ-ヱン-ヶー・　．（）− .()ｰ]+$");

        }
    };

    /* 文字列を全銀使用可能半角文字に変換するためのMap */
    private final static Map<String, String> ZENGIN_CHAR_MAP = new HashMap<String,String>() {
        {
            //全角
            put("ァ","ｱ");      //並文字に変換
            put("ア","ｱ");
            put("ィ","ｲ");      //並文字に変換
            put("イ","ｲ");
            put("ゥ","ｳ");      //並文字に変換
            put("ウ","ｳ");
            put("ェ","ｴ");      //並文字に変換
            put("エ","ｴ");
            put("ォ","ｵ");      //並文字に変換
            put("オ","ｵ");
            put("カ","ｶ");
            put("ガ","ｶﾞ");
            put("キ","ｷ");
            put("ギ","ｷﾞ");
            put("ク","ｸ");
            put("グ","ｸﾞ");
            put("ケ","ｹ");
            put("ゲ","ｹﾞ");
            put("コ","ｺ");
            put("ゴ","ｺﾞ");
            put("サ","ｻ");
            put("ザ","ｻﾞ");
            put("シ","ｼ");
            put("ジ","ｼﾞ");
            put("ス","ｽ");
            put("ズ","ｽﾞ");
            put("セ","ｾ");
            put("ゼ","ｾﾞ");
            put("ソ","ｿ");
            put("ゾ","ｿﾞ");
            put("タ","ﾀ");
            put("ダ","ﾀﾞ");
            put("チ","ﾁ");
            put("ヂ","ﾁﾞ");
            put("ッ","ﾂ");      //並文字に変換
            put("ツ","ﾂ");
            put("ヅ","ﾂﾞ");
            put("テ","ﾃ");
            put("デ","ﾃﾞ");
            put("ト","ﾄ");
            put("ド","ﾄﾞ");
            put("ナ","ﾅ");
            put("ニ","ﾆ");
            put("ヌ","ﾇ");
            put("ネ","ﾈ");
            put("ノ","ﾉ");
            put("ハ","ﾊ");
            put("バ","ﾊﾞ");
            put("パ","ﾊﾟ");
            put("ヒ","ﾋ");
            put("ビ","ﾋﾞ");
            put("ピ","ﾋﾟ");
            put("フ","ﾌ");
            put("ブ","ﾌﾞ");
            put("プ","ﾌﾟ");
            put("ヘ","ﾍ");
            put("ベ","ﾍﾞ");
            put("ペ","ﾍﾟ");
            put("ホ","ﾎ");
            put("ボ","ﾎﾞ");
            put("ポ","ﾎﾟ");
            put("マ","ﾏ");
            put("ミ","ﾐ");
            put("ム","ﾑ");
            put("メ","ﾒ");
            put("モ","ﾓ");
            put("ャ","ﾔ");      //並文字に変換
            put("ヤ","ﾔ");
            put("ュ","ﾕ");      //並文字に変換
            put("ユ","ﾕ");
            put("ョ","ﾖ");      //並文字に変換
            put("ヨ","ﾖ");
            put("ラ","ﾗ");
            put("リ","ﾘ");
            put("ル","ﾙ");
            put("レ","ﾚ");
            put("ロ","ﾛ");
            put("ヮ","ﾜ");      //並文字に変換
            put("ワ","ﾜ");
            put("ヰ","ｲ");      //半角文字が存在しないためｲに変換
            put("ヱ","ｴ");      //半角文字が存在しないためｴに変換
            put("ヲ","ｦ");
            put("ン","ﾝ");
            put("ヴ","ｳﾞ");
            put("ヵ","ｶ");      //並文字に変換
            put("ヶ","ｹ");      //並文字に変換
            put("０","0");
            put("１","1");
            put("２","2");
            put("３","3");
            put("４","4");
            put("５","5");
            put("６","6");
            put("７","7");
            put("８","8");
            put("９","9");
            put("Ａ","A");
            put("Ｂ","B");
            put("Ｃ","C");
            put("Ｄ","D");
            put("Ｅ","E");
            put("Ｆ","F");
            put("Ｇ","G");
            put("Ｈ","H");
            put("Ｉ","I");
            put("Ｊ","J");
            put("Ｋ","K");
            put("Ｌ","L");
            put("Ｍ","M");
            put("Ｎ","N");
            put("Ｏ","O");
            put("Ｐ","P");
            put("Ｑ","Q");
            put("Ｒ","R");
            put("Ｓ","S");
            put("Ｔ","T");
            put("Ｕ","U");
            put("Ｖ","V");
            put("Ｗ","W");
            put("Ｘ","X");
            put("Ｙ","Y");
            put("Ｚ","Z");
            put("　"," ");
            put("「","｢");
            put("」","｣");
            put("．",".");
            put("（","(");
            put("）",")");
            put("＋","+");
            put("￥","¥");
            put("ー","-");      //長音はハイフンに変換
            put("−","-");
            put("／","/");
            put("，",",");
            put("？","?");
            put("：",":");
            put("’","'");
            put("・",".");      //ピリオドに変換
            //半角
            put("ｧ","ｱ");       //並文字に変換
            put("ｨ","ｲ");       //並文字に変換
            put("ｩ","ｳ");       //並文字に変換
            put("ｪ","ｴ");       //並文字に変換
            put("ｫ","ｵ");       //並文字に変換
            put("ｯ","ﾂ");       //並文字に変換
            put("ｬ","ﾔ");       //並文字に変換
            put("ｭ","ﾕ");       //並文字に変換
            put("ｮ","ﾖ");       //並文字に変換
            put("･",".");       //中点はピリオドに変換
            put("ｰ","-");       //長音はハイフンに変換
        }
    };
    /**
     * 半角の全銀使用可能文字列に変換する
     * @param str 文字列(全角、半角混在可)
     * @param applType 適用業務
     * @return 全銀使用可能半角文字列
     * @throws IllegalArgumentException 適用業務が正しくないとき
     * @throws IllegalArgumentException 文字列に全銀で使用できない文字が含まれているとき
     */
    public static String toZenginChar(String str, String applType) {
        String ret = ""; //戻り値
        String regex = VALID_CHAR_REGEX.get(applType);
        if (regex == null) {
            throw new IllegalArgumentException("適用業務が正しくない");
        } else {
            if(str.matches(regex)) {
                // 文字列はすべて全銀使用可能文字であった
                String src = "";    // 変換前文字
                String tgt = "";    // 変換後文字
                str = str.toUpperCase(); //英小文字を大文字に変換
                for (int i = 0; i < str.length(); i++) {
                    src = str.substring(i,i+1);     // 先頭から1文字ずつ切り出す
                    tgt = ZENGIN_CHAR_MAP.get(src); // 文字をMapを使って変換する
                    if (tgt == null) {
                        // 変換Mapに存在しない場合は変換せずに応答する
                        tgt = src;
                    } else {
                        //NOP (変換に成功した)
                    }
                    ret = ret + tgt;
                }
            } else {
                // 文字列に全銀で使用できない文字が含まれている
                throw new IllegalArgumentException("全銀で使用できない文字が含まれている");
            }
        }
            return ret;
    }
}
