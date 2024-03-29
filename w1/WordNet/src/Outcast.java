import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Outcast {
	private final WordNet net;
	
	// constructor takes a WordNet object
	public Outcast(WordNet wordnet) {
		net = wordnet;
	}

	// given an array of WordNet nouns, return an outcast
	public String outcast(String[] nouns) {
		int[] distance = new int[nouns.length];
		for (int i = 0; i < nouns.length; i++) {
			for (int j = 0; j < nouns.length; j++) {
				if (i == j) continue;
				int tempDist = net.distance(nouns[i], nouns[j]);
				distance[i] += tempDist;
				distance[j] += tempDist;
			}
		}
		int max = -1;
		int maxInd = -1;
		for (int k = 0; k < nouns.length; k++) {
			if (distance[k] > max) {
				max = distance[k];
				maxInd = k;
			}
		}
		return nouns[maxInd];
	}

	public static void main(String[] args) {
		WordNet wordnet = new WordNet(args[0], args[1]);
		Outcast outcast = new Outcast(wordnet);
		for (int t = 2; t < args.length; t++) {
			In in = new In(args[t]);
			String[] nouns = in.readAllStrings();
			StdOut.println(args[t] + ": " + outcast.outcast(nouns));
		}
	}
}
