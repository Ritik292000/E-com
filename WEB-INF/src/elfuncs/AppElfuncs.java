package elfuncs;

import java.text.SimpleDateFormat;
import java.sql.Timestamp;

public class AppElfuncs{
	public static String formatDate(Timestamp startDate){
		return new SimpleDateFormat("dd, MMM yyyy").format(startDate);
	}
}