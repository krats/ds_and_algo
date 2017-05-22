import org.junit.Test;
import static org.junit.Assert.*;

public class NoRepeatPlaylistTest {
	
	@Test(timeout=2000)
	public void test0() {
		int N = 1;
		int M = 0;
		int P = 3;
		assertEquals(1, new NoRepeatPlaylist().numPlaylists(N, M, P));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int N = 1;
		int M = 1;
		int P = 3;
		assertEquals(0, new NoRepeatPlaylist().numPlaylists(N, M, P));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int N = 2;
		int M = 0;
		int P = 3;
		assertEquals(6, new NoRepeatPlaylist().numPlaylists(N, M, P));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int N = 4;
		int M = 0;
		int P = 4;
		assertEquals(24, new NoRepeatPlaylist().numPlaylists(N, M, P));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int N = 2;
		int M = 1;
		int P = 4;
		assertEquals(2, new NoRepeatPlaylist().numPlaylists(N, M, P));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int N = 50;
		int M = 5;
		int P = 100;
		assertEquals(222288991, new NoRepeatPlaylist().numPlaylists(N, M, P));
	}
}
