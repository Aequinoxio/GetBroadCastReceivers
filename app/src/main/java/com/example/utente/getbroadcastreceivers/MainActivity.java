package com.example.utente.getbroadcastreceivers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> dataAdapterActions;

    List<String> broadCasts= Arrays.asList(
            "android.app.action.ACTION_PASSWORD_CHANGED",
            "android.app.action.ACTION_PASSWORD_EXPIRING",
            "android.app.action.ACTION_PASSWORD_FAILED",
            "android.app.action.ACTION_PASSWORD_SUCCEEDED",
            "android.app.action.DEVICE_ADMIN_DISABLED",
            "android.app.action.DEVICE_ADMIN_DISABLE_REQUESTED",
            "android.app.action.DEVICE_ADMIN_ENABLED",
            "android.app.action.DEVICE_OWNER_CHANGED",
            "android.app.action.INTERRUPTION_FILTER_CHANGED",
            "android.app.action.LOCK_TASK_ENTERING",
            "android.app.action.LOCK_TASK_EXITING",
            "android.app.action.NEXT_ALARM_CLOCK_CHANGED",
            "android.app.action.NOTIFICATION_POLICY_ACCESS_GRANTED_CHANGED",
            "android.app.action.NOTIFICATION_POLICY_CHANGED",
            "android.app.action.PROFILE_PROVISIONING_COMPLETE",
            "android.app.action.SYSTEM_UPDATE_POLICY_CHANGED",
            "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED",
            "android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED",
            "android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED",
            "android.bluetooth.adapter.action.DISCOVERY_FINISHED",
            "android.bluetooth.adapter.action.DISCOVERY_STARTED",
            "android.bluetooth.adapter.action.LOCAL_NAME_CHANGED",
            "android.bluetooth.adapter.action.SCAN_MODE_CHANGED",
            "android.bluetooth.adapter.action.STATE_CHANGED",
            "android.bluetooth.device.action.ACL_CONNECTED",
            "android.bluetooth.device.action.ACL_DISCONNECTED",
            "android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED",
            "android.bluetooth.device.action.BOND_STATE_CHANGED",
            "android.bluetooth.device.action.CLASS_CHANGED",
            "android.bluetooth.device.action.FOUND",
            "android.bluetooth.device.action.NAME_CHANGED",
            "android.bluetooth.device.action.PAIRING_REQUEST",
            "android.bluetooth.device.action.UUID",
            "android.bluetooth.devicepicker.action.DEVICE_SELECTED",
            "android.bluetooth.devicepicker.action.LAUNCH",
            "android.bluetooth.headset.action.VENDOR_SPECIFIC_HEADSET_EVENT",
            "android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED",
            "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED",
            "android.bluetooth.input.profile.action.CONNECTION_STATE_CHANGED",
            "android.bluetooth.pan.profile.action.CONNECTION_STATE_CHANGED",
            "android.hardware.action.NEW_PICTURE",
            "android.hardware.action.NEW_VIDEO",
            "android.hardware.hdmi.action.OSD_MESSAGE",
            "android.hardware.input.action.QUERY_KEYBOARD_LAYOUTS",
            "android.intent.action.ACTION_POWER_CONNECTED",
            "android.intent.action.ACTION_POWER_DISCONNECTED",
            "android.intent.action.ACTION_SHUTDOWN",
            "android.intent.action.AIRPLANE_MODE",
            "android.intent.action.APPLICATION_RESTRICTIONS_CHANGED",
            "android.intent.action.BATTERY_CHANGED",
            "android.intent.action.BATTERY_LOW",
            "android.intent.action.BATTERY_OKAY",
            "android.intent.action.BOOT_COMPLETED",
            "android.intent.action.CAMERA_BUTTON",
            "android.intent.action.CONFIGURATION_CHANGED",
            "android.intent.action.CONTENT_CHANGED",
            "android.intent.action.DATA_SMS_RECEIVED",
            "android.intent.action.DATE_CHANGED",
            "android.intent.action.DEVICE_STORAGE_LOW",
            "android.intent.action.DEVICE_STORAGE_OK",
            "android.intent.action.DOCK_EVENT",
            "android.intent.action.DOWNLOAD_COMPLETE",
            "android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED",
            "android.intent.action.DREAMING_STARTED",
            "android.intent.action.DREAMING_STOPPED",
            "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE",
            "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE",
            "android.intent.action.FETCH_VOICEMAIL",
            "android.intent.action.GTALK_CONNECTED",
            "android.intent.action.GTALK_DISCONNECTED",
            "android.intent.action.HEADSET_PLUG",
            "android.intent.action.HEADSET_PLUG",
            "android.intent.action.INPUT_METHOD_CHANGED",
            "android.intent.action.LOCALE_CHANGED",
            "android.intent.action.LOCKED_BOOT_COMPLETED",
            "android.intent.action.MANAGE_PACKAGE_STORAGE",
            "android.intent.action.MEDIA_BAD_REMOVAL",
            "android.intent.action.MEDIA_BUTTON",
            "android.intent.action.MEDIA_CHECKING",
            "android.intent.action.MEDIA_EJECT",
            "android.intent.action.MEDIA_MOUNTED",
            "android.intent.action.MEDIA_NOFS",
            "android.intent.action.MEDIA_REMOVED",
            "android.intent.action.MEDIA_SCANNER_FINISHED",
            "android.intent.action.MEDIA_SCANNER_SCAN_FILE",
            "android.intent.action.MEDIA_SCANNER_STARTED",
            "android.intent.action.MEDIA_SHARED",
            "android.intent.action.MEDIA_UNMOUNTABLE",
            "android.intent.action.MEDIA_UNMOUNTED",
            "android.intent.action.MY_PACKAGE_REPLACED",
            "android.intent.action.NEW_OUTGOING_CALL",
            "android.intent.action.NEW_VOICEMAIL",
            "android.intent.action.PACKAGES_SUSPENDED",
            "android.intent.action.PACKAGES_UNSUSPENDED",
            "android.intent.action.PACKAGE_ADDED",
            "android.intent.action.PACKAGE_CHANGED",
            "android.intent.action.PACKAGE_DATA_CLEARED",
            "android.intent.action.PACKAGE_FIRST_LAUNCH",
            "android.intent.action.PACKAGE_FULLY_REMOVED",
            "android.intent.action.PACKAGE_INSTALL",
            "android.intent.action.PACKAGE_NEEDS_VERIFICATION",
            "android.intent.action.PACKAGE_REMOVED",
            "android.intent.action.PACKAGE_REPLACED",
            "android.intent.action.PACKAGE_RESTARTED",
            "android.intent.action.PACKAGE_VERIFIED",
            "android.intent.action.PHONE_STATE",
            "android.intent.action.PROVIDER_CHANGED",
            "android.intent.action.PROXY_CHANGE",
            "android.intent.action.REBOOT",
            "android.intent.action.SCREEN_OFF",
            "android.intent.action.SCREEN_ON",
            "android.intent.action.TIMEZONE_CHANGED",
            "android.intent.action.TIME_SET",
            "android.intent.action.TIME_TICK",
            "android.intent.action.UID_REMOVED",
            "android.intent.action.USER_PRESENT",
            "android.intent.action.USER_UNLOCKED",
            "android.intent.action.WALLPAPER_CHANGED",
            "android.media.ACTION_SCO_AUDIO_STATE_UPDATED",
            "android.media.AUDIO_BECOMING_NOISY",
            "android.media.RINGER_MODE_CHANGED",
            "android.media.SCO_AUDIO_STATE_CHANGED",
            "android.media.VIBRATE_SETTING_CHANGED",
            "android.media.action.CLOSE_AUDIO_EFFECT_CONTROL_SESSION",
            "android.media.action.HDMI_AUDIO_PLUG",
            "android.media.action.OPEN_AUDIO_EFFECT_CONTROL_SESSION",
            "android.net.conn.BACKGROUND_DATA_SETTING_CHANGED",
            "android.net.conn.CONNECTIVITY_CHANGE",
            "android.net.conn.RESTRICT_BACKGROUND_CHANGED",
            "android.net.nsd.STATE_CHANGED",
            "android.net.scoring.SCORER_CHANGED",
            "android.net.scoring.SCORE_NETWORKS",
            "android.net.wifi.NETWORK_IDS_CHANGED",
            "android.net.wifi.RSSI_CHANGED",
            "android.net.wifi.SCAN_RESULTS",
            "android.net.wifi.STATE_CHANGE",
            "android.net.wifi.WIFI_STATE_CHANGED",
            "android.net.wifi.p2p.CONNECTION_STATE_CHANGE",
            "android.net.wifi.p2p.DISCOVERY_STATE_CHANGE",
            "android.net.wifi.p2p.PEERS_CHANGED",
            "android.net.wifi.p2p.STATE_CHANGED",
            "android.net.wifi.p2p.THIS_DEVICE_CHANGED",
            "android.net.wifi.supplicant.CONNECTION_CHANGE",
            "android.net.wifi.supplicant.STATE_CHANGE",
            "android.nfc.action.ADAPTER_STATE_CHANGED",
            "android.os.action.DEVICE_IDLE_MODE_CHANGED",
            "android.os.action.POWER_SAVE_MODE_CHANGED",
            "android.provider.Telephony.SIM_FULL",
            "android.provider.Telephony.SMS_CB_RECEIVED",
            "android.provider.Telephony.SMS_DELIVER",
            "android.provider.Telephony.SMS_RECEIVED",
            "android.provider.Telephony.SMS_REJECTED",
            "android.provider.Telephony.SMS_SERVICE_CATEGORY_PROGRAM_DATA_RECEIVED",
            "android.provider.Telephony.WAP_PUSH_DELIVER",
            "android.provider.Telephony.WAP_PUSH_RECEIVED",
            "android.provider.action.DEFAULT_SMS_PACKAGE_CHANGED",
            "android.provider.action.EXTERNAL_PROVIDER_CHANGE",
            "android.provider.action.SYNC_VOICEMAIL",
            "android.speech.tts.TTS_QUEUE_PROCESSING_COMPLETED",
            "android.speech.tts.engine.TTS_DATA_INSTALLED"
    );

    List<String> broadCastsSimple= Arrays.asList(
            "ACTION_PASSWORD_CHANGED",
            "ACTION_PASSWORD_EXPIRING",
            "ACTION_PASSWORD_FAILED",
            "ACTION_PASSWORD_SUCCEEDED",
            "DEVICE_ADMIN_DISABLED",
            "DEVICE_ADMIN_DISABLE_REQUESTED",
            "DEVICE_ADMIN_ENABLED",
            "DEVICE_OWNER_CHANGED",
            "INTERRUPTION_FILTER_CHANGED",
            "LOCK_TASK_ENTERING",
            "LOCK_TASK_EXITING",
            "NEXT_ALARM_CLOCK_CHANGED",
            "NOTIFICATION_POLICY_ACCESS_GRANTED_CHANGED",
            "NOTIFICATION_POLICY_CHANGED",
            "PROFILE_PROVISIONING_COMPLETE",
            "SYSTEM_UPDATE_POLICY_CHANGED",
            "CONNECTION_STATE_CHANGED",
            "PLAYING_STATE_CHANGED",
            "CONNECTION_STATE_CHANGED",
            "DISCOVERY_FINISHED",
            "DISCOVERY_STARTED",
            "LOCAL_NAME_CHANGED",
            "SCAN_MODE_CHANGED",
            "STATE_CHANGED",
            "ACL_CONNECTED",
            "ACL_DISCONNECTED",
            "ACL_DISCONNECT_REQUESTED",
            "BOND_STATE_CHANGED",
            "CLASS_CHANGED",
            "FOUND",
            "NAME_CHANGED",
            "PAIRING_REQUEST",
            "UUID",
            "DEVICE_SELECTED",
            "LAUNCH",
            "VENDOR_SPECIFIC_HEADSET_EVENT",
            "AUDIO_STATE_CHANGED",
            "CONNECTION_STATE_CHANGED",
            "CONNECTION_STATE_CHANGED",
            "CONNECTION_STATE_CHANGED",
            "NEW_PICTURE",
            "NEW_VIDEO",
            "OSD_MESSAGE",
            "QUERY_KEYBOARD_LAYOUTS",
            "ACTION_POWER_CONNECTED",
            "ACTION_POWER_DISCONNECTED",
            "ACTION_SHUTDOWN",
            "AIRPLANE_MODE",
            "APPLICATION_RESTRICTIONS_CHANGED",
            "BATTERY_CHANGED",
            "BATTERY_LOW",
            "BATTERY_OKAY",
            "BOOT_COMPLETED",
            "CAMERA_BUTTON",
            "CONFIGURATION_CHANGED",
            "CONTENT_CHANGED",
            "DATA_SMS_RECEIVED",
            "DATE_CHANGED",
            "DEVICE_STORAGE_LOW",
            "DEVICE_STORAGE_OK",
            "DOCK_EVENT",
            "DOWNLOAD_COMPLETE",
            "DOWNLOAD_NOTIFICATION_CLICKED",
            "DREAMING_STARTED",
            "DREAMING_STOPPED",
            "EXTERNAL_APPLICATIONS_AVAILABLE",
            "EXTERNAL_APPLICATIONS_UNAVAILABLE",
            "FETCH_VOICEMAIL",
            "GTALK_CONNECTED",
            "GTALK_DISCONNECTED",
            "HEADSET_PLUG",
            "HEADSET_PLUG",
            "INPUT_METHOD_CHANGED",
            "LOCALE_CHANGED",
            "LOCKED_BOOT_COMPLETED",
            "MANAGE_PACKAGE_STORAGE",
            "MEDIA_BAD_REMOVAL",
            "MEDIA_BUTTON",
            "MEDIA_CHECKING",
            "MEDIA_EJECT",
            "MEDIA_MOUNTED",
            "MEDIA_NOFS",
            "MEDIA_REMOVED",
            "MEDIA_SCANNER_FINISHED",
            "MEDIA_SCANNER_SCAN_FILE",
            "MEDIA_SCANNER_STARTED",
            "MEDIA_SHARED",
            "MEDIA_UNMOUNTABLE",
            "MEDIA_UNMOUNTED",
            "MY_PACKAGE_REPLACED",
            "NEW_OUTGOING_CALL",
            "NEW_VOICEMAIL",
            "PACKAGES_SUSPENDED",
            "PACKAGES_UNSUSPENDED",
            "PACKAGE_ADDED",
            "PACKAGE_CHANGED",
            "PACKAGE_DATA_CLEARED",
            "PACKAGE_FIRST_LAUNCH",
            "PACKAGE_FULLY_REMOVED",
            "PACKAGE_INSTALL",
            "PACKAGE_NEEDS_VERIFICATION",
            "PACKAGE_REMOVED",
            "PACKAGE_REPLACED",
            "PACKAGE_RESTARTED",
            "PACKAGE_VERIFIED",
            "PHONE_STATE",
            "PROVIDER_CHANGED",
            "PROXY_CHANGE",
            "REBOOT",
            "SCREEN_OFF",
            "SCREEN_ON",
            "TIMEZONE_CHANGED",
            "TIME_SET",
            "TIME_TICK",
            "UID_REMOVED",
            "USER_PRESENT",
            "USER_UNLOCKED",
            "WALLPAPER_CHANGED",
            "ACTION_SCO_AUDIO_STATE_UPDATED",
            "AUDIO_BECOMING_NOISY",
            "RINGER_MODE_CHANGED",
            "SCO_AUDIO_STATE_CHANGED",
            "VIBRATE_SETTING_CHANGED",
            "CLOSE_AUDIO_EFFECT_CONTROL_SESSION",
            "HDMI_AUDIO_PLUG",
            "OPEN_AUDIO_EFFECT_CONTROL_SESSION",
            "BACKGROUND_DATA_SETTING_CHANGED",
            "CONNECTIVITY_CHANGE",
            "RESTRICT_BACKGROUND_CHANGED",
            "STATE_CHANGED",
            "SCORER_CHANGED",
            "SCORE_NETWORKS",
            "NETWORK_IDS_CHANGED",
            "RSSI_CHANGED",
            "SCAN_RESULTS",
            "STATE_CHANGE",
            "WIFI_STATE_CHANGED",
            "CONNECTION_STATE_CHANGE",
            "DISCOVERY_STATE_CHANGE",
            "PEERS_CHANGED",
            "STATE_CHANGED",
            "THIS_DEVICE_CHANGED",
            "CONNECTION_CHANGE",
            "STATE_CHANGE",
            "ADAPTER_STATE_CHANGED",
            "DEVICE_IDLE_MODE_CHANGED",
            "POWER_SAVE_MODE_CHANGED",
            "SIM_FULL",
            "SMS_CB_RECEIVED",
            "SMS_DELIVER",
            "SMS_RECEIVED",
            "SMS_REJECTED",
            "SMS_SERVICE_CATEGORY_PROGRAM_DATA_RECEIVED",
            "WAP_PUSH_DELIVER",
            "WAP_PUSH_RECEIVED",
            "DEFAULT_SMS_PACKAGE_CHANGED",
            "EXTERNAL_PROVIDER_CHANGE",
            "SYNC_VOICEMAIL",
            "TTS_QUEUE_PROCESSING_COMPLETED",
            "TTS_DATA_INSTALLED"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        EditText editText = (EditText) findViewById(R.id.editTextSearch);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                dataAdapterActions.getFilter().filter(charSequence) ;
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        updateActionListView();
    }

    private void updateActionListView(){
        ListView broadCastsListView = (ListView )findViewById(R.id.broadCastsListView);
        dataAdapterActions = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, broadCastsSimple);

        dataAdapterActions.setDropDownViewResource(android.R.layout.simple_list_item_1);

//        ArrayAdapter<String> dataAdapterActionsComplete = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_2, broadCasts);
//        dataAdapterActionsComplete.setDropDownViewResource(android.R.layout.simple_list_item_2);
//
        broadCastsListView.setAdapter(dataAdapterActions);

        broadCastsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value= (String)adapterView.getItemAtPosition(i);
                int index= broadCastsSimple.lastIndexOf(value);
                updateDetailedListView(broadCasts.get(index));
            }
        });
    }

    private void updateDetailedListView(String action){
        PackageManager pm = getPackageManager();

        Intent intent= new Intent(action);

        List<ResolveInfo> listReceivers= pm.queryBroadcastReceivers(intent, PackageManager.MATCH_ALL);

        List<String> receivers = new ArrayList<String>();

        if (listReceivers.isEmpty()){
            receivers.add ("Non ho trovato nulla");
        } else {

            for (ResolveInfo resolveInfo : listReceivers) {
//            IntentFilter intentFilter= resolveInfo.filter;
//            if (intentFilter!=null) {
//                int actions = intentFilter.countActions();
//
//                for (int i = 0; i < actions; i++) {
//                    receivers.add(intentFilter.getAction(i));
//                }
//            }
                if (resolveInfo.activityInfo != null) {
                    receivers.add(resolveInfo.activityInfo.name);
                }
                if (resolveInfo.serviceInfo != null) {
                    receivers.add(resolveInfo.serviceInfo.name);
                }

                if (resolveInfo.providerInfo != null) {
                    receivers.add(resolveInfo.providerInfo.name);
                }
            }
        }

        ListView listView = (ListView)findViewById(R.id.listView);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, receivers);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        listView.setAdapter(dataAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        // About
        if (id == R.id.action_about) {
            String s = getString(R.string.app_name) +" - Ver. " + BuildConfig.VERSION_NAME ;
            s+="\nby "+ getString(R.string.Autore);
            s+="\n\n"+getString(R.string.descrizione);
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle(R.string.action_about)
                    .setMessage(s)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    }).show();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
