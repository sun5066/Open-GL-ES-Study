package github.sun5066.camerarecord

import android.opengl.GLSurfaceView
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import github.sun5066.camerarecord.databinding.ActivityMainBinding
import github.sun5066.camerarecord.shapes.Triangle
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var triangle: Triangle

    private val glSurfaceViewRenderer = object : GLSurfaceView.Renderer {
        override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {}
        override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {
            triangle = Triangle()
        }
        override fun onDrawFrame(gl: GL10?) {
            triangle.draw()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        with(binding.surfaceView) {
            setEGLContextClientVersion(3)
            setRenderer(glSurfaceViewRenderer)
            renderMode = GLSurfaceView.RENDERMODE_WHEN_DIRTY
        }
    }
}