package Beat;
  
public interface ControllerInterface {
	void start();
	void stop();
	void increaseBPM();
	void decreaseBPM();
 	void setBPM(String bpm);
	int getnInst();
	void BeatView();
	void HeartView();
	void MusicalView();
}
