package samples.drawer

import antd.MouseEventHandler
import antd.button.button
import antd.drawer.EventType
import antd.drawer.drawer
import kotlinx.html.id
import react.*
import react.dom.div
import react.dom.p

interface BasicRightAppState : RState {
    var visible: Boolean
}

class BasicRightApp : RComponent<RProps, BasicRightAppState>() {
    private val showDrawer: MouseEventHandler<Any> = {
        setState {
            visible = true
        }
    }

    private val handleClose: (e: EventType) -> Unit = {
        setState {
            visible = false
        }
    }

    override fun BasicRightAppState.init() {
        visible = false
    }

    override fun RBuilder.render() {
        div {
            button {
                attrs {
                    type = "primary"
                    onClick = showDrawer
                }
                +"Open"
            }
            drawer {
                attrs {
                    title = "Basic Drawer"
                    placement = "right"
                    closable = false
                    onClose = handleClose
                    visible = state.visible
                }
                p { +"Some contents..." }
                p { +"Some contents..." }
                p { +"Some contents..." }
            }
        }
    }
}

fun RBuilder.basicRightApp() = child(BasicRightApp::class) {}

fun RBuilder.basicRight() {
    div("drawer-container") {
        attrs.id = "drawer-basic-right"
        basicRightApp()
    }
}
