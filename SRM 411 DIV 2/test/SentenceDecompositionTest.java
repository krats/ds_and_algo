import org.junit.Test;
import static org.junit.Assert.*;

public class SentenceDecompositionTest {
	
	@Test(timeout=2000)
	public void test0() {
		String sentence = "neotowheret";
		String[] validWords = new String[] {"one", "two", "three", "there"};
		assertEquals(8, new SentenceDecomposition().decompose(sentence, validWords));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String sentence = "abba";
		String[] validWords = new String[] {"ab", "ac", "ad"};
		assertEquals(2, new SentenceDecomposition().decompose(sentence, validWords));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String sentence = "thisismeaningless";
		String[] validWords = new String[] {"this", "is", "meaningful"};
		assertEquals(-1, new SentenceDecomposition().decompose(sentence, validWords));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String sentence = "ommwreehisymkiml";
		String[] validWords = new String[] {"we", "were", "here", "my", "is", "mom", "here", "si", "milk", "where", "si"};
		assertEquals(10, new SentenceDecomposition().decompose(sentence, validWords));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String sentence = "ogodtsneeencs";
		String[] validWords = new String[] {"go", "good", "do", "sentences", "tense", "scen"};
		assertEquals(8, new SentenceDecomposition().decompose(sentence, validWords));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String sentence = "sepawaterords";
		String[] validWords = new String[] {"separate","words"};
		assertEquals(-1, new SentenceDecomposition().decompose(sentence, validWords));
	}
}
