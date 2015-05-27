package edu.fudan.langlab.gxt.client.widget;

import pl.rmalinowski.gwt2swf.client.ui.SWFWidget;
import bridge.FABridgeInstance;
import bridge.FABridgeWrapper;
import bridge.InitCallback;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.SimplePanel;

import flash.media.Sound;
import flash.media.SoundChannel;
import flash.net.URLRequest;

public class SoundWidget extends SimplePanel {
	private FABridgeInstance bridgeInstance;
	private SoundChannel channel;
	private Sound sound;
	private URLRequest soundReq;
	private String url;
	private String bridgeName;

	public SoundWidget(String url) {
		// TODO may have a better solution to initialize the bridge name
		this.bridgeName = String.valueOf(System.currentTimeMillis());
		this.url = url;
		String baseUrl = GWT.getModuleBaseURL();
		SWFWidget swf = new SWFWidget(baseUrl + "EmptyFABridgeSWF.swf", "1px",
				"1px");
		swf.addFlashVar("bridgeName", bridgeName);
		this.add(swf); // important to add swf to this widget
		FABridgeWrapper.get().addInitCallback(bridgeName, new InitCallback() {
			public void initComplete(FABridgeInstance inst) {
				bridgeInstance = inst;
			}
		});

	}
	
	public void start(){
		start(1000);
	}

	public void start(int repeat) {
		if (channel != null) {
			channel.stop();
			clearChannel();
			channel = null;
		}

		clearSoundReq();
		soundReq = URLRequest.createURLRequest(bridgeName);
		soundReq.setUrl(url);

		clearSound();
		sound = Sound.createSound(bridgeName);
		sound.load(soundReq);
		channel = sound.play(0, repeat);
	}

	public void stop() {
		if (channel != null) {
			channel.stop();
			clearChannel();
			channel = null;
		}
	}

	private void clearChannel() {
		if (channel != null) {
			bridgeInstance.releaseNamedASObject(channel);
		}
	}

	private void clearSoundReq() {
		if (soundReq != null) {
			bridgeInstance.releaseNamedASObject(soundReq);
		}
	}

	private void clearSound() {
		if (sound != null) {
			bridgeInstance.releaseNamedASObject(sound);
		}
	}

}
