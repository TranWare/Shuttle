package com.tranware.cordova;

import IDTech.MSR.XMLManager.StructConfigParameters;
import IDTech.MSR.uniMag.uniMagReaderMsg;

/**
 * UniPayReaderMsg is the callback interface for UniPayReader.  This is a
 * standard abstract adapter to streamline client code.  I've copied the
 * Engrish documentation into doc comments for quick reference.  <b>My own
 * notes are in bold.</b>
 *
 * @author Kevin Krumwiede
 */
public class UniMagReaderMsgAdapter implements uniMagReaderMsg {
	/**
	 * To implement one interface such as pop up dialog to get the user grant.
	 * If user grant, then return true.  If user does not grant, return false.
	 * You can receive the grant type and message.  The Grant type as follows.
	 * <p>
	 * 1. typeToPowerupUniPay: When the UniPay or hearphone is plugged in at
	 * first time, the user should choose if they grant to power up the
	 * UniPay.
	 * <p>
	 * 2. typeToUpdateXML: If the XML configuration cannot support the mobile
	 * phone, get the user grant to download the XML from web server.  If
	 * cannot find the XML file and disable to loading the XML automatically
	 * when call loadingConfigurationXMLFile, get the user grant to download
	 * the XML from web server.
	 * <p>
	 * 3. typeToOverwriteXML: If the XML exist on local mobile phone storage,
	 * get the user grant to download the XML from web server.
	 * <p>
	 * 4. typeToReportToIdtech: To report the issue to ID Tech when the mobile
	 * phone is not supported, even download the last XML configuration
	 * file.
	 * <p>
	 * <b>5. typeToTryAutoConfig: Not documented, and apparently not used.</b>
	 * <p>
	 * <b>This implementation returns false.</b>
	 * 
	 * @param type the request type
	 * @param message the question it wants you to present to the user
	 * @return true to grant the request; otherwise false
	 */
	@Override
	public boolean getUserGrant(int type, String message) {
		return false;
	}

	/**
	 * To receive progress message reported by the running auto configuration
	 * session.
	 */
	@Override
	public void onReceiveMsgAutoConfigProgress(int progress) {}

	/**
	 * To receive progress message and result value reported by the running
	 * auto configuration session.
	 */
	@Override
	public void onReceiveMsgAutoConfigProgress(int progress, double value, String message) {}

	/**
	 * To Receive message when AutoConfig found a new profile for the device,
	 * and to pass a new profile to the application in the form of object,
	 * StructConfigParameters.
	 */
	@Override
	public void onReceiveMsgAutoConfigCompleted(StructConfigParameters params) {}

	/**
	 * To receive massages when the device is powered up.
	 * <p>
	 * <b>The actual meanings of {@link #onReceiveMsgConnected()} and
	 * {@link #onReceiveMsgToConnect()} are reversed from what the
	 * documentation says.</b>
	 */
	@Override
	public void onReceiveMsgToConnect() {}

	/**
	 * To receive massages when the UniPay device is connected to the phone.
	 * <p>
	 * <b>The actual meanings of {@link #onReceiveMsgConnected()} and
	 * {@link #onReceiveMsgToConnect()} are reversed from what the
	 * documentation says.</b>
	 */
	@Override
	public void onReceiveMsgConnected() {}

	/**
	 * To receive massages when the UniPay device is disconnected to the
	 * phone.
	 */
	@Override
	public void onReceiveMsgDisconnected() {}

	/**
	 * To receive massages when power up or card swipe mode is timed out.
	 * <p>
	 * <b>This is not actually called when swipe times out.  Instead, we get
	 * {@link #onReceiveMsgCardData(byte, byte[])} with a flags value of 2 and
	 * garbage data.</b>
	 */
	@Override
	public void onReceiveMsgTimeout(String message) {}

	/**
	 * To receive massages when you swipe the card.
	 */
	@Override
	public void onReceiveMsgToSwipeCard() {}

	/**
	 * To receive a message as soon as SDK detects a data coming from UniPay
	 * reader after startSwipeCard() API is called.
	 */
	@Override
	public void onReceiveMsgProcessingCardData() {}

	/**
	 * To receive the flag byte and the card data.  The flag byte shows the
	 * card data format as follows.
	 * <p>
	 * If b0: 0, it is card data<br/>
	 * If b0: 1, it is raw data<br/>
	 * If b1: 0, the encryption is using TDES<br/>
	 * If b1: 1, the encryption is using AES<br/>
	 * If b2: 0, it is non-encrypted data<br/>
	 * If b2: 1, it is encrypted data
	 * <p>
	 * The reader will response timeout error info if cannot get card data in
	 * 30 seconds.
	 */
	@Override
	public void onReceiveMsgCardData(byte flags, byte[] data) {}

	/**
	 * command: the command ID, response: received the byte data after send
	 * command.
	 */
	@Override
	public void onReceiveMsgCommandResult(int command, byte[] response) {}

	/**
	 * To receive the failure info and message when load the XML file.
	 */
	@Override
	public void onReceiveMsgFailureInfo(int failure, String message) {}

	/**
	 * The content: This message is deprecated from the UniPay SDK.  Here is
	 * reserved for the old version SDK.
	 */
	@Deprecated
	@Override
	public void onReceiveMsgSDCardDFailed(String message) {}

	@Override
	public void onReceiveMsgToCalibrateReader() {
		// TODO Auto-generated method stub
		
	}

}
