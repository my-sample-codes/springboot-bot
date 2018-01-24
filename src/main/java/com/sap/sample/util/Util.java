
package com.sap.sample.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("util")
@Deprecated
public class Util {
	@Value("${util.thirdPartyUrl}")
	private String thirdPartyUrl;

	public String getThirdPartyUrl() {
		return thirdPartyUrl;
	}

	public void setThirdPartyUrl(String thirdPartyUrl) {
		this.thirdPartyUrl = thirdPartyUrl;
	}

	@Override
	public String toString() {
		return "Util [thirdPartyUrl=" + thirdPartyUrl + "]";
	}

}
