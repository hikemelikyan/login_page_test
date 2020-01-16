package com.handh.testapp.view

import android.os.Bundle
import android.text.TextUtils
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.handh.testapp.R
import com.handh.testapp.databinding.ActivityMainBinding
import com.handh.testapp.model.All
import com.handh.testapp.view.root.BaseActivity
import com.handh.testapp.viewmodel.MainViewModel
import java.util.regex.Pattern

class MainActivity : BaseActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mViewModel = getViewModel(MainViewModel::class.java)
        setLightStatusBar()
        observingToLiveData()
        initView()
    }

    private fun initView() {
        mBinding.toolbarBack.setOnClickListener {
            showSnackBar("Назад")
        }
        mBinding.createBtn.setOnClickListener {
            showSnackBar("Создать")
        }

        mBinding.btnLogin.setOnClickListener {
            if (checkIsEmailValid(mBinding.email.text.toString())) {
                if (mBinding.password.text.toString().length > 6 && checkIsPasswordValid(mBinding.password.text.toString())) {
                    mViewModel.getWeatherDetails(40.180561, 44.507016, "metric")
                } else {
                    showToast("Пороль должен обязательно содержать минимум 1 строчную букву, 1 заглавную, и 1 цифру")
                }
            } else {
                showSnackBar("Email is not valid")
            }
        }
    }

    private fun checkIsEmailValid(email: String): Boolean {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun checkIsPasswordValid(password: String): Boolean {
        val PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$"
        val pattern: Pattern = Pattern.compile(PASSWORD_PATTERN)
        val matcher = pattern.matcher(password)

        return matcher.matches()
    }

    private fun observingToLiveData() {
        mViewModel.weatherDetailsLiveData.observe(this, Observer {
            if (it is All)
                showSnackBar(it.main?.temp.toString())
            else {
                showSnackBar("Sorry something went wrong")
            }
        })
    }
}
