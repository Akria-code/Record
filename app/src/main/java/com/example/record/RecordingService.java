package com.example.record;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.IBinder;

import java.io.File;

public class RecordingService extends Service {
    private String mFileName;
    private String mFilePath;

    private MediaRecorder mRecorder;

    private long mStartingTimeMillis;
    private long mElapsedMillis;
     /*
     * START_STICKY：如果service进程被kill掉，保留service的状态为开始状态，但不保留递送的intent对象。
     * 随后系统会尝试重新创建service，由于服务状态为开始状态，所以创建服务后一定会调用onStartCommand(Intent,int,int)方法。
     * 如果在此期间没有任何启动命令被传递到service，那么参数Intent将为null。
     *
     * */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startRecording();
        return START_STICKY;
    }

    private void startRecording() {
        setFileNameAndPath();
    }
    
    // 设置录音文件的名字和保存路径
    private void setFileNameAndPath() {
        File f;
        do {
            count
        }while ();
    }

    public RecordingService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
