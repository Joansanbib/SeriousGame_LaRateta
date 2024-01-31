package com.la_rateta.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Matrix4
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector3
import org.w3c.dom.Text
import java.security.Key
import kotlin.properties.Delegates


/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms.  */
class main_class () : ApplicationAdapter() {
    private var camera : OrthographicCamera = OrthographicCamera()
    private var batch: SpriteBatch? = null
    private var image: Texture? = null
    private final var touch : Vector3 = Vector3()
    private var form : Rectangle = Rectangle()





    override fun create() {
        batch = SpriteBatch()
        camera.setToOrtho(false, 800f, 400f)
        image = Texture("libgdx.png")
        form.x = 275f; form.y = 175f; form.width = 250f; form.height = 50f


    }

    override fun render() {
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        camera.update()

        batch!!.setProjectionMatrix(camera.combined);
        batch!!.begin()
        batch!!.draw(image, form.x, form.y, form.width, form.height)
        batch!!.end()

        if (Gdx.input.isTouched()){
            touching(100f, 100f)
        }

    }

    override fun dispose() {
        batch!!.dispose()
        image!!.dispose()
    }

    private fun touching(x : Float, y: Float){
        touch.set(Gdx.input.getX().toFloat(), Gdx.input.getY().toFloat(), 0f)
        camera.unproject(touch)

        if (form.contains(touch.x, touch.y)) {
            form.setPosition(x, y)

        }
    }

}
