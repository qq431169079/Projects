package applicationLayer;
import java.util.Timer;
import java.util.TimerTask;

public class InactivityTimer {
	private static InactivityTimer instance = null;
	private static final int defaultExpirationTime = 5*60;
	private int expirationTime;
	private Timer t;
	
	private InactivityTimer() {
		expirationTime = defaultExpirationTime;
		t = new Timer();
	}
	
	public static InactivityTimer getInstance() {
		if (instance == null)
			instance = new InactivityTimer();
		return instance;
	}
	
	private void logout(){
		
	}
	
}
