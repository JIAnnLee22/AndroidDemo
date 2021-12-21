package com.jiannlee22.audiotrackdemo;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaRecorder;

/**
 * Created by JIAnnLee22 on 2021/06/30 20:33
 * 说明:
 */
public class AudioRecordManager {

    /**
     * 采集频率
     */
    public static final int AUDIO_RATE_HZ = 16000;

    /**
     * 单例
     */
    public static AudioRecordManager instance = null;

    /**
     * 是否录制
     */
    public static boolean isRecording = false;

    private AudioTread mAudioTread;

    public static synchronized AudioRecordManager getInstance() {
        if (instance == null) {
            instance = new AudioRecordManager();
        }
        return instance;
    }

    public void start() {
        mAudioTread = new AudioTread();
        mAudioTread.start();
    }

    public void stop() {
        isRecording = false;
    }

    class AudioTread extends Thread {

        @Override
        public void run() {
            super.run();
            int minBufferSize = AudioRecord.getMinBufferSize(AUDIO_RATE_HZ,
                    AudioFormat.CHANNEL_IN_MONO,
                    AudioFormat.ENCODING_PCM_16BIT);
            AudioRecord audioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC,
                    AUDIO_RATE_HZ,
                    AudioFormat.CHANNEL_IN_MONO,
                    AudioFormat.ENCODING_PCM_16BIT,
                    minBufferSize);
            AudioTrack audioTrack = new AudioTrack(
                    AudioManager.STREAM_MUSIC,
                    AUDIO_RATE_HZ,
                    AudioFormat.CHANNEL_OUT_MONO,
                    AudioFormat.ENCODING_PCM_16BIT,
                    minBufferSize * 2,
                    AudioTrack.MODE_STREAM);
            audioRecord.startRecording();
            short[] tempData = new short[minBufferSize];
            isRecording = true;
            audioTrack.play();
            while (isRecording) {
                audioRecord.read(tempData, 0, minBufferSize);
                audioTrack.write(tempData, 0, minBufferSize);
            }
            audioTrack.stop();
        }
    }

}


