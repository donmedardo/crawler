/**
 * 
 */
package stackbuilders.crawler.entities;

/**
 * @author gsimba
 *
 */
public class News {
	
	private String title;
	private Integer numberOrder;
	private Integer amountComments;
	private Integer points;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getNumberOrder() {
		return numberOrder;
	}
	public void setNumberOrder(Integer numberOrder) {
		this.numberOrder = numberOrder;
	}
	public Integer getAmountComments() {
		return amountComments;
	}
	public void setAmountComments(Integer amountComments) {
		this.amountComments = amountComments;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}

}
