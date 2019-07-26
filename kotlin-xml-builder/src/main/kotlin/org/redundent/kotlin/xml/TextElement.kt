package org.redundent.kotlin.xml

/**
 * An element type that has some text in it.
 * For example:
 * <loc>http://blog.redundent.org</loc>
 */
open class TextElement internal constructor(val text: String) : Element {
	internal fun isEmpty() = text.trim('\n', '\r').isBlank()

	override fun render(builder: Appendable, indent: String, printOptions: PrintOptions) {
		if (isEmpty()) {
			return
		}

		val lineEnding = getLineEnding(printOptions)

		builder.append("$indent${escapeValue(text, printOptions.xmlVersion)}$lineEnding")
	}

	internal fun renderSingleLine(builder: Appendable, printOptions: PrintOptions) {
		builder.append(escapeValue(text, printOptions.xmlVersion))
	}
}
