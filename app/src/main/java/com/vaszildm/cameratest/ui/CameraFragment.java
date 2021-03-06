package com.vaszildm.cameratest.ui;


import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import com.vaszildm.cameratest.R;

public class CameraFragment extends Fragment {

    private Camera mCamera;
    private CameraPreview mCameraPreview;
    private MainActivity mMainActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mMainActivity = (MainActivity) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_camera, container, false);

        mCamera = mMainActivity.getCameraInstance();

        SurfaceView surfaceView = (SurfaceView) view.findViewById(R.id.camera_preview);
        mCameraPreview = new CameraPreview(mMainActivity, mCamera, surfaceView);

        return view;
    }
}
