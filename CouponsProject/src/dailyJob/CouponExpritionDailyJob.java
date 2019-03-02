package dailyJob;

import java.util.Date;

import DBDAO.CouponDBDAO;

public class CouponExpritionDailyJob implements Runnable {
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		Date date=new Date();
		if(date.getHours()==18 && date.getMinutes()==00&&date.getSeconds()==00) {
			CouponDBDAO dbdao=new CouponDBDAO();
			try {
				dbdao.deleteExpCoupons();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		run();
	}
	
	
	
	

}
