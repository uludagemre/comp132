package Q3;
import java.util.concurrent.ThreadLocalRandom;

public class SongGenerator {

	public static void main(String[] args) {
		String [] article = {"the", "a", "one", "some", "that"};
		String [] noun = {"boy", "girl", "love", "town", "street", "car", "cat", "table"};
		String [] verb = {"drove", "jumped", "ran", "walked", "skipped", "loved", "smiled", "waved", "hugged"};
		String [] preposition = {"to", "from", "over", "under","on"};
		String [] adverb = {"silently", "happily", "fast", "noisy", "foggy", "heavily"};
		
		StringBuilder song =  new StringBuilder();
		for (int i =0; i<20; i++) {
			StringBuilder line = new StringBuilder ();
			String firstWord = article[ThreadLocalRandom.current().nextInt(0,article.length)];
			StringBuffer buffer = new StringBuffer(firstWord);
            buffer.setCharAt(0, Character.toUpperCase(firstWord.charAt(0)));
			line.append(buffer);
			line.append(" ");
			line.append(noun[ThreadLocalRandom.current().nextInt(0,noun.length)]);
			line.append(" ");
			line.append(verb[ThreadLocalRandom.current().nextInt(0,verb.length)]);
			line.append(" ");
			line.append(preposition[ThreadLocalRandom.current().nextInt(0,preposition.length)]);
			line.append(" ");
			line.append(article[ThreadLocalRandom.current().nextInt(0,article.length)]);
			line.append(" ");
			line.append(noun[ThreadLocalRandom.current().nextInt(0,noun.length)]);
			line.append(" ");
			line.append(adverb[ThreadLocalRandom.current().nextInt(0,adverb.length)]);
			line.append("\n");
			song.append(line);
			if (i==8||i==18) {
				song.append(line);
				i++;}
			if (i==9) {song.append("\n");}
		}
		System.out.println(song);
	}

}
