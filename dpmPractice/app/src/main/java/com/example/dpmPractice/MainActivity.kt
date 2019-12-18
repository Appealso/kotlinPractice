package com.example.dpmPractice

import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.actionAdminActive).setOnClickListener { adminActive() }
        val actionCamera = findViewById<SwitchCompat>(R.id.actionCamera)
        actionCamera.visibility = View.INVISIBLE
    }

    /**
     * 관리자 권한 요청
     */
    private fun adminActive() {
        val componentName = ComponentName(this, AppDeviceAdminReceiver::class.java)
        val intent = Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN)
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName)
        startActivityForResult(intent, DEVICE_ADMIN_ADD_RESULT_ENABLE)
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) { // 관리자 권한 요청 응답
        if (requestCode == DEVICE_ADMIN_ADD_RESULT_ENABLE) {
            val devicePolicyManager =
                getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
            val componentName =
                ComponentName(this, AppDeviceAdminReceiver::class.java)
            // 권한 확인
            val adminActive = devicePolicyManager.isAdminActive(componentName)
            // 카메라 사용 상태
            val cameraDisabled =
                devicePolicyManager.getCameraDisabled(componentName)
            // UI 초기화
            val actionCamera = findViewById<SwitchCompat>(R.id.actionCamera)
            actionCamera.visibility = if (adminActive) View.VISIBLE else View.INVISIBLE
            actionCamera.isChecked = cameraDisabled
            actionCamera.setOnCheckedChangeListener { buttonView, isChecked ->
                setCameraDisabled(
                    isChecked
                )
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
    /**
     * 카메라 비활성화
     *
     * @param cameraDisabled
     */
    private fun setCameraDisabled(cameraDisabled: Boolean) {
        val devicePolicyManager =
            getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
        val componentName = ComponentName(this, AppDeviceAdminReceiver::class.java)
        devicePolicyManager.setCameraDisabled(componentName, cameraDisabled)
    }
    companion object {
        private const val DEVICE_ADMIN_ADD_RESULT_ENABLE = 123
    }
}