package com.example.activityrecognition_v1;


import android.app.IntentService;
import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;

import java.util.List;




public class ActivityRecognizedService extends  IntentService {

    public ActivityRecognizedService() {
        super("ActivityRecognizedService");
    }

    public ActivityRecognizedService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if(ActivityRecognitionResult.hasResult(intent)){
            ActivityRecognitionResult result = ActivityRecognitionResult.extractResult(intent);
            handleDetectedActivities( result.getProbableActivities());
        }
    }

    private void handleDetectedActivities(List<DetectedActivity> probableActivities) {
//        textView = (TextView) textView.findViewById(R.id.textClass);

        for( DetectedActivity activity : probableActivities){
            switch ( activity.getType() ) {
                case DetectedActivity.IN_VEHICLE:{
                    Log.e("ActivityRecognition","in Vehicle" + activity.getConfidence());
                   // textView.setText("In Vehicle");
                  //  Toast.makeText(getApplicationContext(), "IN Vehicle", Toast.LENGTH_SHORT).show();
                    break;
                }
                case DetectedActivity.ON_BICYCLE: {
                    Log.e( "ActivityRecognition", "On Bicycle" + activity.getConfidence() );
                 //   Toast.makeText(getApplicationContext(), "On Bicycle", Toast.LENGTH_SHORT).show();
                   // textView.setText("On Bicycle");
                    break;
                }
                case DetectedActivity.ON_FOOT: {
                    Log.e( "ActivityRecognition", "On Foot: " + activity.getConfidence() );
                  //  Toast.makeText(getApplicationContext(), "On Foot:", Toast.LENGTH_SHORT).show();
                  // textView.setText("On Foot");
                    break;
                }
                case DetectedActivity.RUNNING: {
                    Log.e( "ActivityRecognition", "Running: " + activity.getConfidence() );
                  //  Toast.makeText(getApplicationContext(), "Running:", Toast.LENGTH_SHORT).show();
                  //  textView.setText("Running");
                    break;
                }
                case DetectedActivity.STILL: {
                    Log.e( "ActivityRecognition", "Still: " + activity.getConfidence() );
                 //   Toast.makeText(getApplicationContext(), "Still", Toast.LENGTH_SHORT).show();
                 //   textView.setText("Still");
                    break;
                }
                case DetectedActivity.TILTING: {
                    Log.e( "ActivityRecognition", "Tilting: " + activity.getConfidence() );
                   // Toast.makeText(getApplicationContext(), "Tilting:", Toast.LENGTH_SHORT).show();
                  //  textView.setText("Tilting");
                    break;
                }
                case DetectedActivity.WALKING: {
                    Log.e( "ActivityRecognition", "Walking: " + activity.getConfidence() );
                  //  Toast.makeText(getApplicationContext(), "Walking:", Toast.LENGTH_SHORT).show();
                  //  textView.setText("Walking");
                     if( activity.getConfidence() >= 75 ) {
                        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
                        builder.setContentText( "Are you walking?" );
                        builder.setSmallIcon( R.mipmap.ic_launcher );
                        builder.setContentTitle( getString( R.string.app_name ) );
                        NotificationManagerCompat.from(this).notify(0, builder.build());
                    }
                    break;
                }
                case DetectedActivity.UNKNOWN: {
                    Log.e( "ActivityRecognition", "Unknown: " + activity.getConfidence() );
                   //3 activityDetected.setText("Unknown");
                    break;
                }


            }
        }
    }
}
