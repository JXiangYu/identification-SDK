package com.tobacco.identification;

/**
 * SDK入口
 *
 * @author LeeHaoyang
 */
public final class IODSYSDK {

	private static IODSYSDK iodsysdk;
	private String host;
	private String prefix;
	private final AuthInf auth;
	private final DataDefineInf dataDefine;
	private final BusinessDataInf businessData;
	private final HandleResolvInf handleResolv;

	private IODSYSDK() {
		this.auth = new Auth(this);
		this.dataDefine = new DataDefine(this);
		this.businessData = new BusinessData(this);
		this.handleResolv = new HandleResolv(this);
	}


	public static final IODSYSDK getInstance() {
		if (null == iodsysdk) {
			synchronized (IODSYSDK.class) {
				iodsysdk = new IODSYSDK();
			}
		}
		return iodsysdk;
	}

	public final AuthInf getAuthApi() {
		return auth;
	}

	public final BusinessDataInf getBusinessDataApi(){
		return businessData;
	}

	public final DataDefineInf getDataDefineApi(){
		return dataDefine;
	}

	public final HandleResolvInf getHandleResolvApi(){
		return handleResolv;
	}

	public final String getHost() {
		return host;
	}

	protected IODSYSDK setHost(String host) {
		this.host = host;
		return this;
	}

	public String getPrefix() {
		return prefix;
	}

	protected IODSYSDK setPrefix(String prefix) {
		this.prefix = prefix;
		return this;
	}

	public static void main(String[] args) {
		System.out.println("Digital Identification SDK");
	}
}
