package command.consrete;

import java.io.Serializable;

public class ActionCommand implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isFlag = false;
	private String url;

	public ActionCommand() {
	}

	public ActionCommand(boolean isFlag, String url) {
		this.isFlag = isFlag;
		this.url = url;
	}

	/**
	 * @return the isFlag
	 */
	public boolean isFlag() {
		return isFlag;
	}

	/**
	 * @param isFlag the isFlag to set
	 */
	public void setFlag(boolean isFlag) {
		this.isFlag = isFlag;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
