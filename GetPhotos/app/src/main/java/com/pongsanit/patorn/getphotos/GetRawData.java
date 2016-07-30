package com.pongsanit.patorn.getphotos;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Patorn on 7/29/16.
 */
enum DownloadStatus { IDLE, PROCESSING, NOT_INITIALIZED, FAILED_OR_EMPTY, OK }
//states of the data download
public class GetRawData {
    private String LOG_TAG = GetRawData.class.getSimpleName(); //access output when using log statements
    private String mRawUrl; //url
    private String mData;
    private DownloadStatus mDownloadStatus;

    public GetRawData(String mRawUrl) {
        this.mRawUrl = mRawUrl;
        this.mDownloadStatus = DownloadStatus.IDLE;
    }

    public void reset() {
        this.mDownloadStatus = DownloadStatus.IDLE;
        this.mRawUrl = null;
        this.mData = null;
    }

    public String getmRawUrl() {
        return mRawUrl;
    }

    public String getmData() {
        return mData;
    }

    public DownloadStatus getmDownloadStatus() {
        return mDownloadStatus;
    }

    public void execute() {
        mDownloadStatus = DownloadStatus.PROCESSING;
        DownloadRawData downloadRawData = new DownloadRawData();
        downloadRawData.execute(mRawUrl);
    }

    public class DownloadRawData extends AsyncTask<String, Void, String> {

        protected void onPostExecute(String webData) {
            mData = webData;
            Log.v(LOG_TAG, "Data returned was: " + mData);
            if(mData == null) {
                if (mRawUrl == null) {
                    mDownloadStatus = DownloadStatus.NOT_INITIALIZED;
                } else {
                    mDownloadStatus = DownloadStatus.FAILED_OR_EMPTY;
                }
            } else {
                mDownloadStatus = DownloadStatus.OK;
            }
        }

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            StringBuffer stringBuffer = new StringBuffer();  //store appendedString

            if(params == null) {
                return null;
            }
            try {
                URL url = new URL(params[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                //opening connection and inputStream. BufferedReader reads from inputStream;
                InputStream inputStream = urlConnection.getInputStream();
                if(inputStream == null) {
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while((line = reader.readLine()) != null){   //while there's still a line to be read
                    stringBuffer.append(line + "\n");
                }

            } catch(IOException e){
                Log.e(LOG_TAG, "Error", e);
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if(reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e){
                        Log.e(LOG_TAG, "Error closing reader stream", e);

                    }
                }
            }
            return stringBuffer.toString();
        }
    }
}
