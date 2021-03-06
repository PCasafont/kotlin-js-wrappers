package samples.timepicker

import antd.timepicker.timePicker
import kotlinx.html.id
import moment.Moment
import react.*
import react.dom.*

interface ValueDemoState : RState {
    var value: Moment?
}

class ValueDemo : RComponent<RProps, ValueDemoState>() {
    private val handleChange = fun (time: Moment, _: String) {
        console.log(time)

        setState {
            value = time
        }
    }

    override fun ValueDemoState.init() {
        value = null
    }

    override fun RBuilder.render() {
        timePicker {
            attrs {
                value = state.value
                onChange = handleChange
            }
        }
    }
}

fun RBuilder.valueDemo() = child(ValueDemo::class) {}

fun RBuilder.value() {
    div("time-picker-container") {
        attrs.id = "time-picker-value"
        valueDemo()
    }
}
