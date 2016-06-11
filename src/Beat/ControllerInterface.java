package Beat;
  
public interface ControllerInterface {
	void on();
	void off();
	void start();
	void stop();
	void increaseBPM();
	void decreaseBPM();
 	void setBPM(String bpm);
	int getnInst();
}
