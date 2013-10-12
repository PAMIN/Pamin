package br.ufpb.lavid.pamin.util;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TwitterUtil implements java.io.Serializable{
	
	public Twitter configura(){
		String consumerKey = "enqdbiwtihkoVFeC2AlhNg";
		String consumerSecret = "fKyasEZdFk9Daduay6gYEwXtaijDNk4Z2PXOCkW0";
		String acessToken = "715456652-LmN6mnWSyECSnoZkrP5mnRR8qDc2BKIyneMyxhRw";
		String acessTokenSecret = "Zv2IhOZvoKEsyFnRqseiAqVWabeE7hA1EmxZGQ16Kfw";
		
		TwitterFactory tf = new TwitterFactory();
		Twitter twitter = tf.getInstance();
		twitter.setOAuthConsumer(consumerKey, consumerSecret);
		AccessToken accessToken = new AccessToken(acessToken,acessTokenSecret);
		twitter.setOAuthAccessToken(accessToken);
		
		return twitter;
	}
	
	public void twitar(Twitter twitter, String msg){
		try {
			  Status status = twitter.updateStatus(msg);
		      System.out.println("Successfully updated the status to [" + status.getText() + "].");
		      System.out.println("Twitou");
			} catch (TwitterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Erro ao enviar o tweet");
			}

	}

}