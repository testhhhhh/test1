package UserPackage.src.Entity;

public class Novel {
	private int novelid;
	private int classifyid;
    private String novelname;
    private String novelmain;
    private String novelwriter;
    private String novelpicture;
    private float novelmony;
	public Novel() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Novel(int novelid,int classifyid,String novelname, String novelmain, String novelwriter, String novelpicture, float novelmony) {
		super();
		this.novelname = novelname;
		this.novelmain = novelmain;
		this.novelwriter = novelwriter;
		this.novelpicture = novelpicture;
		this.novelmony = novelmony;
	}
	public String getNovelname() {
		return novelname;
	}
	public void setNovelname(String novelname) {
		this.novelname = novelname;
	}
	public String getNovelmain() {
		return novelmain;
	}
	public void setNovelmain(String novelmain) {
		this.novelmain = novelmain;
	}
	public String getNovelwriter() {
		return novelwriter;
	}
	public void setNovelwriter(String novelwriter) {
		this.novelwriter = novelwriter;
	}
	public String getNovelpicture() {
		return novelpicture;
	}
	public void setNovelpicture(String novelpicture) {
		this.novelpicture = novelpicture;
	}
	public float getNovelmony() {
		return novelmony;
	}
	public void setNovelmony(float novelmony) {
		this.novelmony = novelmony;
	}
	public int getNovelid() {
		return novelid;
	}
	public void setNovelid(int novelid) {
		this.novelid = novelid;
	}
	public int getClassifyid() {
		return classifyid;
	}
	public void setClassifyid(int classifyid) {
		this.classifyid = classifyid;
	}
    
}
