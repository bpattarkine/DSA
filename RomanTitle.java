import java.util.Collections;
import java.util.Vector;

public class RomanTitle implements Comparable<RomanTitle> {

  static String ranks =
      "I II III IV V VI VII VIII IX X" +
          "XI XII XIII XIV XV XVII XVIII XIX XX" +
          "XXI XXII XXIII XXIV XXV XXVI XXVII XXVIII XXIX XXX" +
          "XXXI XXXII XXXIII XXXIV XXXV XXXVI XXXVII XXXVIII XXXIX XXXX" +
          "XXXXI XXXIII XXXIIII XXXXIV XXXXV XXXXVI XXXXVII XXXXVIII XXXXIX XXXXX";
  String name;
  String rank;

  public RomanTitle(String romanTitle) {
    String[] splited = romanTitle.split("\\s");
    this.name = splited[0];
    this.rank = splited[1];
  }

  static String[] sortNames(String[] romanTitles) {
    Vector<RomanTitle> titles = new Vector<RomanTitle>();
    for (String title : romanTitles) {
      titles.add(new RomanTitle(title));
    }
    Collections.sort(titles);
    String[] results = new String[titles.size()];
    int i = 0;
    for (RomanTitle title : titles) {
      results[i++] = title + "";
    }
    return results;
  }

  public String toString() {
    return name + " " + rank;
  }

  @Override
  public int compareTo(RomanTitle o) {
    if (name.compareToIgnoreCase(o.name) != 0) {
      return name.compareToIgnoreCase(o.name);
    } else {
      int r1 = ranks.indexOf(rank);
      int r2 = ranks.indexOf(o.rank);
      return r1 - r2;
    }
  }

}