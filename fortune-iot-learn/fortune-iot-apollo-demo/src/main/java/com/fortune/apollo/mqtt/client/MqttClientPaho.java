package com.fortune.apollo.mqtt.client;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttClientPaho {

	private static String broker = "tcp://10.100.124.206:1883";
	private static String userName = "tuyou";
	private static String passWord = "tuyou";

	private static MqttClient connect(String clinetId, String userName, String password) throws MqttException {
		MemoryPersistence persistence = new MemoryPersistence();
		MqttConnectOptions options = new MqttConnectOptions();
		options.setCleanSession(true);
		options.setUserName(userName);
		options.setPassword(password.toCharArray());
		// options.setS
		MqttClient mqttClient = new MqttClient(broker, clinetId, persistence);
		mqttClient.setCallback(new MqttCallback() {
			
			@Override
			public void messageArrived(String topic, MqttMessage message) throws Exception {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void deliveryComplete(IMqttDeliveryToken token) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void connectionLost(Throwable cause) {
				// TODO Auto-generated method stub
			}
		});
		mqttClient.connect(options);
		return mqttClient;
	}

	private static void publish(String str, String clientId, String topic) throws MqttException {
		MqttClient mqttClient = connect(clientId, userName, passWord);
		if (mqttClient != null) {
			MqttMessage message = new MqttMessage("Helloworld".getBytes());
			message.setQos(2);
			message.setRetained(false);
			mqttClient.publish(topic, message);
			System.out.println("pub-->" + str);
		}
		if (mqttClient != null) {
			mqttClient.disconnect();
		}
	}
	
	public static void main(String[] args) throws MqttException {
		publish("message content","client-id-0","$share/edge/server/public/a");
	}

}
