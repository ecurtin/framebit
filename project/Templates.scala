import au.com.langdale.soapbox.Publisher._
import sbt._

object Templates extends Plugin {
  val XHTML = "http://www.w3.org/1999/xhtml"
  override def projectSettings = Seq(
    siteTemplates += Template("*.md",
      (title, content) => {
        <html xmlns={XHTML}>
          <head><title>{title}</title></head>
          <body>{content}</body>
        </html>
      }
    )
  )
}