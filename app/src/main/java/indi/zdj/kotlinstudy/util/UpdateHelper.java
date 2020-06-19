package indi.zdj.kotlinstudy.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ProgressBar;

import androidx.appcompat.app.AlertDialog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UpdateHelper {

    private final String updateMsg = "亲，有新版本，快下载吧！";			//下载消息提示
    private Dialog noticeDialog;										//下载提示对话框
    private Dialog downloadDialog;										//下载进度对话框
    private ProgressBar mProgressBar;									//进度条
    private Boolean interceptFlag = false;								//标记用户是否在下载过程中取消下载
    private Thread downloadApkThread = null;							//下载线程
    private String apkUrl;		//apk的URL地址
    private String loadFilePath = Environment.getExternalStorageDirectory() + File.separator + "Android" +
            File.separator + "data" + File.separator + "com.karokj.machine"; //下载的apk存放的路径
    private final String saveFileName = loadFilePath + "/karokj.apk";	//下载的apk文件
    private int progress = 0;											//下载进度
    private final int DOWNLOAD_ING = 1;									//标记正在下载
    private final int DOWNLOAD_OVER = 2;								//标记下载完成
    private final String TAG="版本更新";									//日志打印标签
    private final Activity mActivity;

    public void setApkUrl(String apkUrl) {
        this.apkUrl = apkUrl;
    }

    @SuppressLint("HandlerLeak")
    private Handler mhandler = new Handler() {							//更新UI的handler

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case DOWNLOAD_ING:
                    // 更新进度条
//                    mProgressBar.setProgress(progress);
                    break;
                case DOWNLOAD_OVER:
//                    downloadDialog.dismiss();
                    installApk();
                    //安装
                    break;
                default:
                    break;
            }
        }

    };

    /*
     * 构造方法
     */
    public UpdateHelper(Activity activity) {
        mActivity = activity;
    }

    /*
     * 检查是否有需要更新，具体比较版本xml
     */
    public void checkUpdate() {
        // 到服务器检查软件是否有新版本
        //如果有则
        showNoticeDialog();
    }

    /*
     * 显示版本更新对话框
     */
    private void showNoticeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setTitle("版本更新");
        builder.setMessage(updateMsg);
        builder.setPositiveButton("更新", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                noticeDialog.dismiss();
                showDownloadDialog();
            }
        });
        builder.setNegativeButton("以后再说", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                noticeDialog.dismiss();

            }
        });
        noticeDialog = builder.create();
        noticeDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {

            }
        });
        noticeDialog.show();

    }

    /*
     * 弹出下载进度对话框
     */
    private void showDownloadDialog() {
        /*AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("软件更新");
        final LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.progress, null);
        mProgressBar = (ProgressBar) v.findViewById(R.id.updateProgress);
        builder.setView(v);
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                downloadDialog.dismiss();
                interceptFlag = true;
            }
        });
        downloadDialog = builder.create();
        downloadDialog.show();*/
        downloadLatestVersionApk();

    }

    /*
     * 下载最新的apk文件
     */
    private void downloadLatestVersionApk() {
        downloadApkThread = new Thread(downloadApkRunnable);
        downloadApkThread.start();
    }

    //匿名内部类，apk文件下载线程
    private Runnable downloadApkRunnable = new Runnable() {

        public void run() {
            try {
                URL url = new URL(apkUrl);
                HttpURLConnection conn = (HttpURLConnection) url
                        .openConnection();
                conn.connect();
                int length = conn.getContentLength();
                Log.e(TAG, "总字节数:"+length);
                InputStream is = conn.getInputStream();
                File file = new File(loadFilePath);
                if (!file.exists()) {
                    file.mkdir();
                }
                File apkFile = new File(saveFileName);
                FileOutputStream out = new FileOutputStream(apkFile);
                int count = 0;
                int readnum = 0;
                byte[] buffer = new byte[1024];
                do {
                    readnum = is.read(buffer);
                    count += readnum;
                    progress = (int) (((float) count / length) * 100);
                    Log.e(TAG, "下载进度"+progress);
                    mhandler.sendEmptyMessage(DOWNLOAD_ING);
                    if (readnum <= 0) {
                        // 下载结束
                        mhandler.sendEmptyMessage(DOWNLOAD_OVER);
                        break;
                    }
                    out.write(buffer,0,readnum);
                } while (!interceptFlag);
                is.close();
                out.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    };
    /*
     * 安装下载的apk文件
     */
    private void installApk() {
        Log.e("tag","安装完成");
        File file= new File(saveFileName);
        if(!file.exists()){
            return;
        }
        Intent intent= new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.parse("file://"+file.toString()), "application/vnd.android.package-archive");
        mActivity.startActivity(intent);
    }

}
