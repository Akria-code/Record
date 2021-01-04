package com.example.record;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.FileUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private MediaRecorder mMediaRecorder;
    private Button mStartRecordBt,mPauseRecordBt,mStopRecordBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mStartRecordBt=findViewById(R.id.button_start_record);
        mPauseRecordBt=findViewById(R.id.button_pause_record);
        mStopRecordBt=findViewById(R.id.button_stop_record);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_start_record:
                startRecord();
            case R.id.button_pause_record:
                
            case R.id.button_stop_record:
                break;
        }
    }

    private void startRecord() {
        if (mMediaRecorder == null)
            mMediaRecorder = new MediaRecorder();
        try {
            /* ②setAudioSource/setVedioSource */
            mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);// 设置麦克风
            /*
             * ②设置输出文件的格式：THREE_GPP/MPEG-4/RAW_AMR/Default THREE_GPP(3gp格式
             * ，H263视频/ARM音频编码)、MPEG-4、RAW_AMR(只支持音频且音频编码要求为AMR_NB)
             */
            mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
            /* ②设置音频文件的编码：AAC/AMR_NB/AMR_MB/Default 声音的（波形）的采样 */
            mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
            fileName = DateFormat.format("yyyyMMdd_HHmmss", Calendar.getInstance(Locale.CHINA)) + ".m4a";
            if (!FileUtils.isFolderExist(FileUtils.getFolderName(audioSaveDir))) {
                FileUtils.makeFolders(audioSaveDir);
            }
            filePath = audioSaveDir + fileName;
            /* ③准备 */
            mMediaRecorder.setOutputFile(filePath);
            mMediaRecorder.prepare();
            /* ④开始 */
            mMediaRecorder.start();
        } catch (IllegalStateException e) {
            LogUtil.i("call startAmr(File mRecAudioFile) failed!" + e.getMessage());
        } catch (IOException e) {
            LogUtil.i("call startAmr(File mRecAudioFile) failed!" + e.getMessage());
        }
    }
}