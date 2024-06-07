package com.andcorns2.multiusertest

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.UserManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.andcorns2.multiusertest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val multiUserManager = this.getSystemService(Context.USER_SERVICE) as UserManager
        binding.tvIsManagedProfile.text = multiUserManager.isManagedProfile.toString()
        if (Build.VERSION.SDK_INT >= 34) {
            binding.tvIsAdminUser.text = multiUserManager.isAdminUser.toString()
        }
        binding.tvIsDemoUser.text = multiUserManager.isDemoUser.toString()
        binding.tvIsSystemUser.text = multiUserManager.isSystemUser.toString()
        binding.tvSupportsMultipleUsers.text = UserManager.supportsMultipleUsers().toString()
    }
}