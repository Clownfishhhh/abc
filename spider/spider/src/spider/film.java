package spider;

public class film implements Comparable<film>{
/**
 * ӰƬ����
 */
	String title;
/**
* �����Ϣ 
*/
	String info;
/**
 * ����
 */
	double rating;
/**
 * ��������
 */
	int num;
/**
 * ����
 */
	int id;
/**
 * ����
 */
	String poster;
/**
 * ����
 */
	String quote;
	public String toCSV() {
		return String.format("%d,%s,%d,%.1f\n",
				id,
				title,
				num,
				rating);
	}
@Override
public String toString() {
	
	return "film [title=" + title + ", info=" + info + ", rating=" + rating + ", num=" + num + ", id=" + id
			+ ", poster=" + poster + ", quote=" + quote + "]";
}
@Override
public int compareTo(film o) {
	// TODO Auto-generated method stub
	return o.id -id;
}
}
