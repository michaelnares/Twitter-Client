import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: michael
 * Date: 29/06/2013
 * Time: 19:21
 * To change this template use File | Settings | File Templates.
 */
public class TwitterClient {

    private static final String TWITTER_CONSUMER_KEY = "zE7iBvNSdLeHa032aMZqtA";
    private static final String TWITTER_SECRET_KEY = "p17OWoxtkfzOfg4Q37Bbv3EGq0ff7SJljOcORKY";
    private static final String TWITTER_ACCESS_TOKEN = "561089922-KrK6UmFMxQkv1QgCiYrWSVgITCFdZi03XXX2K1Of";
    private static final String TWITTER_ACCESS_TOKEN_SECRET = "cKmPSzMSeQ1dyQJexWbZyAECMPOHLThKdoPgEs3cZs";


       public void getTweets() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(TWITTER_CONSUMER_KEY)
                .setOAuthConsumerSecret(TWITTER_SECRET_KEY)
                .setOAuthAccessToken(TWITTER_ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(TWITTER_ACCESS_TOKEN_SECRET);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        try {
            Query query = new Query("Michael Schumacher");
            QueryResult result;


                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
            int count = 0;
                for (Iterator<Status> i = tweets.iterator(); i.hasNext();) {
                    Status tweet = i.next();
                    count++;
            System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());

                    System.out.println("Number of queries is now " + count);
                    if (count == 10) {
                       System.exit(0);
                   }
                }
            } catch (TwitterException e) {
            e.printStackTrace();
            System.out.println("Failed to search tweets: " + e.getMessage());
            System.exit(-1);
        }


        }


    public static void main(String[] arguments) {
        TwitterClient tc = new TwitterClient();
        tc.getTweets();
    }



}
