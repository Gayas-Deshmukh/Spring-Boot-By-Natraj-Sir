package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("hotel")
public class Hotel {
	@Value("12365")
	private Integer hotelId;

	@Value("${hotel.name}")
	private String hotelName;

	@Value("${hotel.adds}")
	private String hotelAdds;

	@Value("${hotel.contact.no}")
	private String mobileNo;

	@Value("${customer.name}")
	private String customerName;

	@Value("#{menuIP.dhosaPrice + menuIP.pohaprice}") // SPEL for arithmetic operation (menuIP -beanid, pohaprice property name)
	private Float finalBillAmt;

	@Value("#{menuIP.upmaprice <= 0}")
	private boolean isUmpaFree;
	
	@Value("${os.name}") // os.name is fixed system property name
	private String osName;

	@Value("${user.name}") // user.name is fixed system property name
	private String windowsUser;

	@Value("${path}") // Path is fixed env variable name
	private String pathData;

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelAdds=" + hotelAdds + ", mobileNo="
				+ mobileNo + ", customerName=" + customerName + ", finalBillAmt=" + finalBillAmt + ", isUmpaFree="
				+ isUmpaFree + ", osName=" + osName + ", windowsUser=" + windowsUser + ", pathData=" + pathData + "]";
	}
}
