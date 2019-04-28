import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


import java.io.IOException;
import java.lang.reflect.Array;

public class WebScraper {

    // private Integer btcPrice;


    public static Coin[] coins = new Coin[100];
    public static int coinListed = 0;


    public static void main(String[] args) {

        Document doc;

        // String bitcoinUrl = "https://www.binance.com/it/trade/BTC_USDT";


        String url = "https://www.binance.com/it";

        String TableClass = "ReactVirtualized__Grid.ReactVirtualized__Table__Grid";

        String columnCoinName = ".ReactVirtualized__Table__rowColumn:nth-of-type(3)";
        String columnCoinPrice = ".ReactVirtualized__Table__rowColumn:nth-of-type(4)";
        String columnCoinDailyChange = ".ReactVirtualized__Table__rowColumn:nth-of-type(5)";
        String columnCoinDailyPriceMax = ".ReactVirtualized__Table__rowColumn:nth-of-type(6)";
        String columnCoinDailyPriceMin = ".ReactVirtualized__Table__rowColumn:nth-of-type(7)";
        String columnCoinMarketCap = ".ReactVirtualized__Table__rowColumn:nth-of-type(8)";

        //table or div
        String type = "div";

        //int btcPrice = bitcoinPrice(bitcoinUrl);

        // System.out.println("BTC Price: " + btcPrice);


        try {
            doc = Jsoup.connect(url).get();

            String title = doc.title();

            // System.out.println("Title = " + title);

            //Reading Coin Name

            for (Element row : doc.select(type + "." + TableClass)) {

                // System.out.println("Working");

                if (row.select(columnCoinName).text().equals("")) {

                    continue;
                } else {

                    //TODO Creazione di un array Coin[] e Funzione inserimento dati in Array

                    String coinName = row.select(columnCoinName).text();

                    String marketCap = row.select(columnCoinMarketCap).text();

                    String price = row.select(columnCoinPrice).text();

                    String dailyPriceMax = row.select(columnCoinDailyPriceMax).text();

                    String dailyPriceMin = row.select(columnCoinDailyPriceMin).text();

                    String dailyChange = row.select(columnCoinDailyChange).text();

                    //System.out.println("\nName: " + coinName + "\tMarketCap: " + marketCap + "\tPrice: " + price + "\tDaily Change: " + dailyChange);

                    System.out.println("\nName: " + coinName);

                    System.out.println("\nMarketCap: " + marketCap);

                    System.out.println("\nPrice: " + price);

                    System.out.println("\nDaily Price Max: " + dailyPriceMax);

                    System.out.println("\nDaily Price Min: " + dailyPriceMin);

                    System.out.println("\nDaily Change: " + dailyChange);

                    stringScroller(coinName, 0);
                }
            }
            // System.out.println(doc.outerHtml());







        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  public static Integer bitcoinPrice(String url) {

    //Integer btcPrice = 0;

//        try {
//           // Document doc = Jsoup.connect(url).get();
//
//           // String btcDoc = doc.select("div:nth-of-type(2)").text();
//
//            //Integer btcint =  Integer.parseInt(btcPrice.substring(3, 80));
//
//            //String btc = btcDoc.substring(366, 370); //DANILO E' UN GENIO
//
//            // btcPrice = Integer.parseInt(btc);
//
//           // System.out.println("Bitcoin Price: " + btcDoc);
//
//            //System.out.println("Bitcoin Price: " + btcPrice);
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return btcPrice;

    public void coinList (){

        int coinNumber = 14;

//        Coin[] coins = new Coin[coinNumber];

//        String BTC = "Bitcoin";
//        String ETH = "Ethereum";
//        String ZEC = "Zcash";
//        String LTC = "Litecoin";
//        String BNB = "Binance Coin";
//        String EOS = "EOS";
//        String XRP = "Ripple";
//        String XRM = "Moner";
//        String XLM = "Stellar";
//        String BTT = "BitTorrent";
//        String TRX = "TRON";
//        String BAT = "Basic Attention Token";
//        String ZRX = "0x";
//        String HOT = "Holo";

        coins[0].name = "Bitcoin";
        coins[1].name = "Ethereum";
        coins[2].name = "Zcash";
        coins[3].name = "Litecoin";
        coins[4].name = "Binance Coin";
        coins[5].name = "EOS";
        coins[6].name = "Ripple";
        coins[7].name = "Moner";
        coins[8].name = "Stellar";
        coins[9].name = "BitTorrent";
        coins[10].name = "TRON";
        coins[11].name = "Basic Attention Token";
        coins[12].name = "0x";
        coins[13].name = "Holo";

    }


    public static void stringScroller(String string, int startPosition){


        if (startPosition + 1 < string.length()) {

            if (string.substring(startPosition, startPosition + 1).equals(" ")) {

                stringScroller(string, startPosition + 1);

                System.out.println("skipping space");

            } else {

                int i = 1;

                String text = "";

                while (!string.substring(startPosition + i - 1, startPosition + i).equals(" ") && startPosition + i < string.length()) {

                    i++;
                }

                text = string.substring(startPosition, startPosition + i);

                System.out.println("\n" + text);

                // coins[coinListed].name = text;

                //System.out.println("Coin name: " + coins[coinListed].name);

                coinListed++;

                startPosition = startPosition + i;

                if (startPosition < string.length()) {
                    stringScroller(string, startPosition);

                }

            }


        }

    }

}




