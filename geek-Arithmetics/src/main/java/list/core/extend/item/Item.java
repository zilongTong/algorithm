package list.core.extend.item;
/**
 *
 * @author Smile.Wu
 * @version 2015-10-20
 */
public interface Item {
	
	public long ID();

	public int recommendCount();
	
	public int rejectCount();
	
	public int offerCount();
}
