package com.btnpld.infstt

import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.btnpld.infstt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var mediaPlayer: MediaPlayer? = null
    var countDownTimer: CountDownTimer? = null

    private var array = arrayListOf(1, 2, 3)
    private var array22 = array.shuffled().last().toInt()
    var countTrue = 0
    var countFalse = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        when (array22) {
            1 -> {
                binding.ball1.visibility = View.VISIBLE
                binding.ball2.visibility = View.INVISIBLE
                binding.ball3.visibility = View.INVISIBLE
            }
            2 -> {
                binding.ball1.visibility = View.INVISIBLE
                binding.ball2.visibility = View.VISIBLE
                binding.ball3.visibility = View.INVISIBLE
            }
            else -> {
                binding.ball1.visibility = View.INVISIBLE
                binding.ball2.visibility = View.INVISIBLE
                binding.ball3.visibility = View.VISIBLE
            }
        }

        binding.exitButton.setOnClickListener {
            finish()
        }
        binding.cup1.isEnabled = false
        binding.cup2.isEnabled = false
        binding.cup3.isEnabled = false
        openBall()

        binding.startButton.setOnClickListener {

            binding.ball1.visibility = View.INVISIBLE
            binding.ball2.visibility = View.INVISIBLE
            binding.ball3.visibility = View.INVISIBLE

            mediaPlayer = MediaPlayer.create(this, R.raw.effekt)
            mediaPlayer!!.start()

            array22 = array.shuffled().last().toInt()

            binding.startButton.visibility = View.INVISIBLE
            binding.startButton.isEnabled = false
            openCup()
            rotation()
            countDownTimer = object : CountDownTimer(4000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                }

                override fun onFinish() {
                    binding.cup1.isEnabled = true
                    binding.cup2.isEnabled = true
                    binding.cup3.isEnabled = true
                }
            }.start()
        }
    }

    private fun openBall() {

        val rotationTop: Animation = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.translate4
        )
        rotationTop.isInitialized
        binding.cup1.startAnimation(rotationTop)
        binding.cup2.startAnimation(rotationTop)
        binding.cup3.startAnimation(rotationTop)
    }

    fun openCup() {
        binding.cup1.setOnClickListener {

            array22 = array.shuffled().last().toInt()

            if (array22 == 1) {

                binding.ball1.visibility = View.VISIBLE
                binding.ball2.visibility = View.INVISIBLE
                binding.ball3.visibility = View.INVISIBLE
                countTrue++
                binding.trueCount.text = "${countTrue} True"

                countDownTimer = object : CountDownTimer(800, 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                    }

                    override fun onFinish() {

                        binding.startButton.isEnabled = true
                        binding.startButton.visibility = View.VISIBLE
                    }
                }.start()

            } else {
                visibleTrue()
                countFalse++
                binding.falseCount.text = "${countFalse} False"
            }
            binding.cup2.isEnabled = false
            binding.cup3.isEnabled = false
            binding.cup1.isEnabled = false

            val rotationTop: Animation = AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.translate4
            )
            rotationTop.isInitialized
            binding.cup1.startAnimation(rotationTop)

        }
        binding.cup2.setOnClickListener {
            array22 = array.shuffled().last().toInt()

            if (array22 == 2) {

                binding.ball1.visibility = View.INVISIBLE
                binding.ball2.visibility = View.VISIBLE
                binding.ball3.visibility = View.INVISIBLE
                countTrue++
                binding.trueCount.text = "${countTrue} True"

                countDownTimer = object : CountDownTimer(800, 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                    }

                    override fun onFinish() {

                        binding.startButton.isEnabled = true
                        binding.startButton.visibility = View.VISIBLE
                    }
                }.start()

            } else {
                visibleTrue()
                countFalse++
                binding.falseCount.text = "${countFalse} False"
            }
            binding.cup1.isEnabled = false
            binding.cup3.isEnabled = false
            binding.cup2.isEnabled = false
            val rotationTop: Animation = AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.translate4
            )
            rotationTop.isInitialized
            binding.cup2.startAnimation(rotationTop)

        }
        binding.cup3.setOnClickListener {
            array22 = array.shuffled().last().toInt()

            if (array22 == 3) {

                binding.ball1.visibility = View.INVISIBLE
                binding.ball2.visibility = View.INVISIBLE
                binding.ball3.visibility = View.VISIBLE
                countTrue++
                binding.trueCount.text = "${countTrue} True"

                countDownTimer = object : CountDownTimer(800, 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                    }

                    override fun onFinish() {

                        binding.startButton.isEnabled = true
                        binding.startButton.visibility = View.VISIBLE
                    }
                }.start()

            } else {
                visibleTrue()
                countFalse++
                binding.falseCount.text = "${countFalse} False"
            }

            binding.cup1.isEnabled = false
            binding.cup2.isEnabled = false
            binding.cup3.isEnabled = false
            val rotationTop: Animation = AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.translate4
            )
            rotationTop.isInitialized
            binding.cup3.startAnimation(rotationTop)

        }
    }

    private fun rotation() {

        val rotation1: Animation = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.translate1
        )
        rotation1.isInitialized
        binding.cup1.startAnimation(rotation1)

        val rotation2: Animation = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.translate2
        )
        rotation2.isInitialized
        binding.cup2.startAnimation(rotation2)

        val rotation3: Animation = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.translate3
        )
        rotation3.isInitialized
        binding.cup3.startAnimation(rotation3)
    }


    private fun visibleTrue() {
        countDownTimer = object : CountDownTimer(1400, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {

                when (array22) {
                    1 -> {
                        binding.ball1.visibility = View.VISIBLE
                        binding.ball2.visibility = View.INVISIBLE
                        binding.ball3.visibility = View.INVISIBLE

                        val rotationTop: Animation = AnimationUtils.loadAnimation(
                            applicationContext,
                            R.anim.translate4
                        )
                        rotationTop.isInitialized
                        binding.cup1.startAnimation(rotationTop)

                        countDownTimer = object : CountDownTimer(800, 1000) {
                            override fun onTick(millisUntilFinished: Long) {
                            }

                            override fun onFinish() {

                                binding.startButton.isEnabled = true
                                binding.startButton.visibility = View.VISIBLE
                            }
                        }.start()
                    }
                    2 -> {
                        binding.ball1.visibility = View.INVISIBLE
                        binding.ball2.visibility = View.VISIBLE
                        binding.ball3.visibility = View.INVISIBLE

                        val rotationTop: Animation = AnimationUtils.loadAnimation(
                            applicationContext,
                            R.anim.translate4
                        )
                        rotationTop.isInitialized
                        binding.cup2.startAnimation(rotationTop)

                        countDownTimer = object : CountDownTimer(800, 1000) {
                            override fun onTick(millisUntilFinished: Long) {
                            }

                            override fun onFinish() {

                                binding.startButton.isEnabled = true
                                binding.startButton.visibility = View.VISIBLE
                            }
                        }.start()

                    }
                    else -> {
                        val rotationTop: Animation = AnimationUtils.loadAnimation(
                            applicationContext,
                            R.anim.translate4
                        )
                        rotationTop.isInitialized
                        binding.cup3.startAnimation(rotationTop)

                        binding.ball1.visibility = View.INVISIBLE
                        binding.ball2.visibility = View.INVISIBLE
                        binding.ball3.visibility = View.VISIBLE

                        countDownTimer = object : CountDownTimer(800, 1000) {
                            override fun onTick(millisUntilFinished: Long) {
                            }

                            override fun onFinish() {

                                binding.startButton.isEnabled = true
                                binding.startButton.visibility = View.VISIBLE
                            }
                        }.start()
                    }
                }

            }
        }.start()
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer?.stop()
    }
}