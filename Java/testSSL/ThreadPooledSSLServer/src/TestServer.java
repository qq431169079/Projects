public class TestServer {

	public static void main(String[] args) {
		ThreadPooledSSLServer server = new ThreadPooledSSLServer(443);
		new Thread(server).start();

		/*try {
		    Thread.sleep(20 * 1000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		
		System.out.println("Stopping Server");
		server.stop();*/
	}
}
