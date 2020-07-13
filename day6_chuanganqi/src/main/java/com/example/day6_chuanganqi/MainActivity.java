package com.example.day6_chuanganqi;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private SensorManager manager;
    private int[] musics = {R.raw.aa,R.raw.dd,R.raw.cc};
    int index = 0;
    private MediaPlayer mMp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (SensorManager)getSystemService(SENSOR_SERVICE);

//        getAllSensor();//获得手机中的所有传感器
        getAccele();//得到加速度传感器，实现甩歌功能
//        getLight();//光传感器的操作
//       userOrien();//方向传感器
    }

    private void getAccele() {
        //先播放音乐
        mMp = MediaPlayer.create(this, musics[index]);
        mMp.start();

        Sensor sensor = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //lis1监听器  sensor是感应器  SensorManager.SENSOR_DELAY_NORMAL感应器的灵敏度
        manager.registerListener(lis1,sensor,SensorManager.SENSOR_DELAY_NORMAL);//注册感应器的监听器
    }
    //第一个传感器监听器，为加速度使用
    private SensorEventListener lis1 = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){//加速度感应器发生变化
                float[] value = event.values;//得到xyz三个方向的数据的变化
                float x = value[0];//x轴的新值
                float y = value[1];//y轴的新值
                float z = value[2];//z轴的新值
                Log.i(TAG, "x="+x+",y="+y+",z="+z);
                if(z > 12){//甩动切歌
                    if(mMp != null){
                        mMp.stop();
                        mMp.release();
                    }
                    index++;//下标加1
                    index = index%musics.length;//防止越界

                    mMp = MediaPlayer.create(MainActivity.this,musics[index]);
                    mMp.start();
                }

            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
    private void getLight() {
        Sensor defaultSensor = manager.getDefaultSensor(Sensor.TYPE_LIGHT);
        manager.registerListener(lis2,defaultSensor,SensorManager.SENSOR_DELAY_NORMAL);
    }
    private SensorEventListener lis2=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            int type = event.sensor.getType();
            if (type==Sensor.TYPE_LIGHT){
                float[] values = event.values;
                float value = values[0];
                Log.e(TAG, "光线强度: "+value);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
    private void userOrien() {
        Sensor orien = manager.getDefaultSensor(Sensor.TYPE_ORIENTATION);//获得方向传感器
        manager.registerListener(new Lis1(),orien,SensorManager.SENSOR_DELAY_NORMAL);//注册
    }
    public class Lis1 implements SensorEventListener{

        @Override
        public void onSensorChanged(SensorEvent event) {
            float i = event.values[0];
            Log.i("111", "方向角度: "+i);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }

    private void getAllSensor() {
        List<Sensor> sensorList = manager.getSensorList(Sensor.TYPE_ALL);
        for (int i = 0; i < sensorList.size(); i++) {
            Sensor sensor = sensorList.get(i);
            String name = sensor.getName();
            String vendor = sensor.getVendor();
            int version = sensor.getVersion();
            Log.i(TAG, "onCreate: "+name+","+vendor+","+version);
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        //解除监听器的注册，节省开销，省电
        manager.unregisterListener(lis1);
        manager.unregisterListener(lis2);
    }
}
