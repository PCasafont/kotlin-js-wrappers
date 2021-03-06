package samples.mention

import antd.mention.MentionComponent
import antd.mention.mention
import kotlinext.js.js
import kotlinext.js.jsObject
import kotlinx.html.id
import react.*
import react.dom.*

private fun handleChange(contentState: Any) {
    console.log(MentionComponent.toString(contentState, jsObject {  }))
}

private fun handleSelect(suggestion: String, data: Any?) {
    console.log("onSelect", suggestion)
}

fun RBuilder.placemenet() {
    div("mention-container") {
        attrs.id = "mention-placement"
        mention {
            attrs {
                style = js { width = "100%" }
                onChange = ::handleChange
                suggestions = arrayOf("afc163", "benjycui", "yiminghe", "RaoHai", "中文", "にほんご")
                onSelect = ::handleSelect
                placement = "top"
            }
        }
    }
}
